package com.bot;

import com.bot.common.Auftragsliste;
import com.bot.common.AuftragslisteInterface;
import com.bot.common.auftraege.ChangeMyVillage;
import com.bot.factories.AnalyseMapFactory;
import com.bot.factories.BabaFarmFactory;
import com.bot.factories.RostofflagerFactory;
import com.bot.guicontroller.GUIController;
import com.bot.guicontroller.MouseRobot;
import com.bot.settings.Utils;

public class AuftragsHandler implements Runnable{
	private AuftragslisteInterface liste;
	public AuftragsHandler(AuftragslisteInterface list) {
		this.liste = list;
	}

	@Override
	public void run() {
		
		liste.add(new ChangeMyVillage(100, Utils.CURRENT));
		BabaFarmFactory bff = BabaFarmFactory.getBabafactory(liste);
		RostofflagerFactory rlf = RostofflagerFactory.getRohstofflagerFactory(liste);
		AnalyseMapFactory amf = AnalyseMapFactory.getAnalyseMapFactory(liste);
		
		
		while(Utils.RUNNING){
			rlf.check();
			bff.check();
			amf.check();
			MouseRobot.wait(5000);
		}
		
	}
	
	public static void main(String[] args) {
		AuftragslisteInterface list = Auftragsliste.getAuftragsliste();
		MouseRobot robot = new MouseRobot(Utils.HWND);
		GUIController gc = new GUIController(list, robot);
		AuftragsHandler ah = new AuftragsHandler(list);

		new Thread(ah).start();
		new Thread(gc).start();
	}

}
