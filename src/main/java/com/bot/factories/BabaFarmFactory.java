package com.bot.factories;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

import org.joda.time.LocalDateTime;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.bot.common.AuftragslisteInterface;
import com.bot.common.auftraege.AngriffDorf;
import com.bot.model.Babarendorf;
import com.bot.model.Dorf;
import com.bot.model.Gegnerdorf;
import com.bot.settings.Utils;
import com.database.configuration.AppConfig;
import com.database.service.DorfService;

public class BabaFarmFactory {

	private AuftragslisteInterface liste;

	private ArrayList<Babarendorf> babaliste;

	private static BabaFarmFactory singelton;

	public static BabaFarmFactory getBabafactory(AuftragslisteInterface liste) {
		if (singelton == null) {
			return new BabaFarmFactory(liste);
		} else
			return singelton;
	}

	private BabaFarmFactory(AuftragslisteInterface liste) {
		singelton = this;
		this.liste = liste;
		this.babaliste = new ArrayList<Babarendorf>();
		updateList();
		BabaFarmFactory.sortFarms();
	}

	private void updateList() {
		babaliste.clear();
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		DorfService service = (DorfService) context.getBean("dorfService");

		// Dörfer aus der Datenbank imwandeln in Dörfer von Bot
		for (com.database.model.Dorf a : service.findByName("Babarendorf")) {
			Babarendorf b = new Babarendorf(a.getId(),a.getX(), a.getY(), a.getTime());

			if (a.getTime().plusMinutes(30).isBefore(new LocalDateTime()) && !babaliste.contains(b)) {
				babaliste.add(b);
			}

//			for (Babarendorf c : babaliste) {
//				System.out.println(c);
//			}

		}
		context.close();

	}

	public static void sortFarms() {
		singelton.babaliste.sort(new Comparator<Dorf>() {

			@Override
			public int compare(Dorf o1, Dorf o2) {
				return (int) (Utils.CURRENT.getDistance() * 1000 - o2.getDistance() * 1000);
			}
		});
	}

	public void check() {
		if (liste.countsAuftraege("Angriffdorf") < 5) {
			updateList();
			
			for(int i = 0; i < babaliste.size(); i++){
				if(babaliste.get(i)!= null){
					liste.add(new AngriffDorf(babaliste.get(i)));
					babaliste.remove(babaliste.get(i));
				}
				
			}

		}
	}

}
