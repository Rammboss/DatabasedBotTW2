package com.bot.common.auftraege;

import com.bot.factories.BabaFarmFactory;
import com.bot.guicontroller.Buttons;
import com.bot.guicontroller.MouseRobot;
import com.database.model.EigenesDorf;

public class ChangeMyVillage extends EnterKoordinaten {

	public ChangeMyVillage(int p, EigenesDorf dorf) {
		super(p, dorf.getPosition());
	}

	public void run(MouseRobot robot) {
		super.run(robot);	
		if (Buttons.CHANGE_CURRENT_VILLAGE.IsActive(5000)) {
			robot.click(Buttons.CHANGE_CURRENT_VILLAGE);
		}
		
		BabaFarmFactory.sortFarms();

	}

}
