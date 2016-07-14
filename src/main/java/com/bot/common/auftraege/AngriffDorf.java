package com.bot.common.auftraege;

import java.util.Date;

import org.joda.time.LocalDateTime;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.bot.guicontroller.Buttons;
import com.bot.guicontroller.MouseRobot;
import com.bot.model.Babarendorf;
import com.bot.model.Gegnerdorf;
import com.database.configuration.AppConfig;
import com.database.model.Dorf;
import com.database.service.DorfService;

public class AngriffDorf extends CheckError {

	private Gegnerdorf farm;

	public static final int PRIO_ANGRIFFDORF = 5;

	public AngriffDorf(Gegnerdorf farm) {
		super(PRIO_ANGRIFFDORF, farm.getX(), farm.getY());
		this.farm = farm;
	}

	public void run(MouseRobot robot) {
		super.run(robot);
		if (checkDorf()) {
			robot.enterKoordinate(getHotkey());

			update(farm); // Updatet den Zeitpunkt des gefarmten Dorfes in der
							// Datenbank
		}
	}

	private void update(Gegnerdorf farm) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		DorfService service = (DorfService) context.getBean("dorfService");
		//if (!service.findById(farm.getId()).isEmpty()) {
			Dorf b = (Dorf) service.findById(farm.getId());
			b.setId(farm.getId());
			b.setName(farm.getName());
			b.setX(farm.getX());
			b.setY(farm.getY());
			b.setTime(new LocalDateTime());
			service.updateDorf(b);
		//}

		context.close();

	}

	private int getHotkey() {
		if (!Buttons.SPEER_0.check()) {
			System.out.println("SPEER Verfügbar");
			return 1;
		} else if (!Buttons.SCHWERT_0.check()) {
			System.out.println("SCHWERT Verfügbar");
			return 2;
		} else if (!Buttons.AXT_0.check()) {
			System.out.println("AXT Verfügbar");
			return 3;
		} else if (!Buttons.BOGEN_0.check()) {
			System.out.println("BOGEN Verfügbar");
			return 4;
		} else if (!Buttons.LKAV_0.check()) {
			System.out.println("LKAV Verfügbar");
			return 5;
		} else if (!Buttons.BERITTENE_BOGEN_0.check()) {
			System.out.println("Berittene Bogen Verfügbar");
			return 6;
		} else if (!Buttons.SKAV_0.check()) {
			System.out.println("SKAV Verfügbar");
			return 7;
		} else {
			System.out.println("Keine Einheiten Verfügbar");
			return 7;
		}
	}

	public boolean check() {
		return true;
	}

	private boolean checkDorf() {
		if (farm instanceof Babarendorf) {
			System.out.println(Buttons.CHECKBARBARENDORF.check());
			return Buttons.CHECKBARBARENDORF.check();

		} else if (farm instanceof Gegnerdorf) {
			// Muss noch implementiert werden für Spieler
			return false;
		}
		return false;

	}

}
