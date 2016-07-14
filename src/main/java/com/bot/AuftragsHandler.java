package com.bot;

import com.bot.common.Auftragsliste;
import com.bot.common.AuftragslisteInterface;
import com.bot.common.auftraege.ChangeMyVillage;
import com.bot.factories.BabaFarmFactory;
import com.bot.factories.RostofflagerFactory;
import com.bot.guicontroller.GUIController;
import com.bot.guicontroller.MouseRobot;
import com.bot.settings.Utils;

public class AuftragsHandler implements Runnable{

	@Override
	public void run() {
		Auftragsliste liste = Auftragsliste.getAuftragsliste();
		liste.add(new ChangeMyVillage(100, Utils.CURRENT));
		BabaFarmFactory bff = BabaFarmFactory.getBabafactory(liste);
		RostofflagerFactory rlf = RostofflagerFactory.getRohstofflagerFactory(liste);
		
		while(Utils.RUNNING){
			rlf.check();
			bff.check();
			MouseRobot.wait(15000);
		}
		
	}
	
	public static void main(String[] args) {
		AuftragslisteInterface list = Auftragsliste.getAuftragsliste();
		MouseRobot robot = new MouseRobot(Utils.HWND);
		GUIController gc = new GUIController(list, robot);
		AuftragsHandler ah = new AuftragsHandler();

		new Thread(ah).start();
		new Thread(gc).start();
	}

}
