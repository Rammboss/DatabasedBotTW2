package com.bot.common.auftraege;


import com.bot.guicontroller.Buttons;
import com.bot.guicontroller.MouseRobot;
import com.bot.settings.Utils;


public class EnterKoordinaten extends OpenSeachOnMap {

	private int  x;
	private int y;

	public EnterKoordinaten(int p, int x ,int y) {
		super(p);
		this.x = x;
		this.y = y;
	}

	@Override
	public void run(MouseRobot robot) {
		super.run(robot);

		if (Buttons.ENTER_X.check()) {
			robot.doubleClick(Buttons.ENTER_X);
			robot.enterKoordinate(x);

		}
		MouseRobot.wait(Utils.DELAY_TASTENDRUCK);

		if (Buttons.ENTER_Y.check()) {
			robot.doubleClick(Buttons.ENTER_Y);
			robot.enterKoordinate(y);
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
