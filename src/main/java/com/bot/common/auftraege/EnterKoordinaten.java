package com.bot.common.auftraege;

import java.awt.Point;

import com.bot.guicontroller.Buttons;
import com.bot.guicontroller.MouseRobot;
import com.bot.settings.Utils;


public class EnterKoordinaten extends OpenSeachOnMap {

	private Point farm;

	public EnterKoordinaten(int p, Point farm) {
		super(p);
		this.farm = farm;
	}

	@Override
	public void run(MouseRobot robot) {
		super.run(robot);

		if (Buttons.ENTER_X.check()) {
			robot.doubleClick(Buttons.ENTER_X);
			robot.enterKoordinate(farm.x);

		}
		MouseRobot.wait(Utils.DELAY_TASTENDRUCK);

		if (Buttons.ENTER_Y.check()) {
			robot.doubleClick(Buttons.ENTER_Y);
			robot.enterKoordinate(farm.y);
		}
		MouseRobot.wait(Utils.DELAY_TASTENDRUCK);
		robot.click(Buttons.SEARCH_VIllAGE);

		MouseRobot.wait(2000); // **********Warte auf GUI***********
	}

	@Override
	public boolean check() {
		return Buttons.IS_SELECTED.check();
	}

}
