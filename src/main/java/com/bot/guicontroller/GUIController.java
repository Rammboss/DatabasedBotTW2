package com.bot.guicontroller;

import com.bot.common.AuftragslisteInterface;
import com.bot.common.auftraege.Auftrag;
import com.bot.common.auftraege.AuftragInterface;
import com.bot.settings.Utils;

public class GUIController implements Runnable {

	private AuftragslisteInterface list;
	private MouseRobot mouseRobot;

	public GUIController(AuftragslisteInterface list, MouseRobot mouseRobot) {
		this.list = list;
		this.mouseRobot = mouseRobot;
	}

	@Override
	public void run() {
		while (Utils.RUNNING) {
			AuftragInterface a = list.next();

			if (a != null) {
				a.run(mouseRobot);
				if (!a.check()) { // falls Aufrtag nicht erfüllt wurde
					a.setPriority(a.getPriority() + 1);
					list.add(a);
				}

			}
			System.out.println( "Anzahl Aufträge: " + list.size());
			
			
			MouseRobot.wait(1000);
		}
	}

}
