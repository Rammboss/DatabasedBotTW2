package com.bot.common.auftraege;

import java.awt.Point;

import com.bot.guicontroller.Buttons;
import com.bot.guicontroller.MouseRobot;


public class EigenesDorfSelecten extends EnterKoordinaten{

	public EigenesDorfSelecten(int p, int x, int y) {
		super(p, x,y);
	}
	
	public void run(MouseRobot mr){
		super.run(mr);
		if(Buttons.IS_MY_DORF.check()){
			mr.click(Buttons.IS_MY_DORF);
		}else{
			System.out.println("Dorf Wasnt Selected");
			System.out.println("at EigenesDorfSelecten: 16");
		}
	}
	public boolean check() {
		return true;
	}

}
