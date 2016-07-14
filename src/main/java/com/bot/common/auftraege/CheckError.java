package com.bot.common.auftraege;

import java.awt.Point;

import com.bot.guicontroller.Buttons;
import com.bot.guicontroller.MouseRobot;
import com.bot.settings.Utils;



public class CheckError extends EnterKoordinaten {

	public CheckError(int p, int x, int y) {
		super(p, x,y);
	}

	public void run(MouseRobot robot) {
		
		super.run(robot);

		if (Buttons.ERROR.check()) {

			if (Utils.ITER.hasNext()) {
				Utils.CURRENT = Utils.ITER.next();

				new ChangeMyVillage(1, Utils.CURRENT).run(robot);

			} else {
				Utils.ITER = Utils.CURRENT_ACCOUNT.getListe().iterator();
				Utils.CURRENT = Utils.ITER.next();
			}

		}

	}

}
