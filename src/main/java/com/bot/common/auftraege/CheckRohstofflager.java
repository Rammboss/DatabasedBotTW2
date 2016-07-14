package com.bot.common.auftraege;

import java.util.Date;

import com.bot.account.Rohstofflager;
import com.bot.guicontroller.Buttons;
import com.bot.guicontroller.MouseRobot;



public class CheckRohstofflager extends EnterKoordinaten {

	private Rohstofflager rohstofflager;
	private boolean item;
	
	public static final int PRIO_CHECKROHSTOFFLAGER = 6;

	public CheckRohstofflager(Rohstofflager lager, boolean item) {
		super(PRIO_CHECKROHSTOFFLAGER, lager.getPosition());
		rohstofflager = lager;
		this.item = item;
	}

	@Override
	public void run(MouseRobot robot) {
		super.run(robot);

		if (item) {
			robot.click(510, 416);
			MouseRobot.wait(1000);// Mitte des Bildschirms
			robot.click(510, 416);

			while (true) {
				MouseRobot.wait(1000);
				robot.click(Buttons.ROHSTOFFLAGER_COLLECT);
				MouseRobot.wait(1000);
				if (!Buttons.ROHSTOFFLAGER_START.check()) {

					robot.click(Buttons.USEITEM);
					MouseRobot.wait(2000);

					robot.click(Buttons.USEGEGENSTAND);
					MouseRobot.wait(2000);

				} else {
					robot.click(Buttons.ROHSTOFFLAGER_START);
				}
				MouseRobot.wait(10000);
			}

		} else {
			robot.click(510, 416);
			MouseRobot.wait(2000);
			robot.click(510, 416);// Mitte des Bildschirms

			MouseRobot.wait(1000);
			robot.click(Buttons.ROHSTOFFLAGER_COLLECT);
			MouseRobot.wait(1000);
			robot.click(Buttons.ROHSTOFFLAGER_START);
			MouseRobot.wait(1000);
			robot.click(Buttons.CLOSE);
		}

	}

	public boolean check() {
		return true;
	}

	public Rohstofflager getRohstofflager() {
		return rohstofflager;
	}

	public void setRohstofflager(Rohstofflager rohstofflager) {
		this.rohstofflager = rohstofflager;
	}

}
