package com.bot.common.auftraege;

import com.bot.guicontroller.MouseRobot;

public abstract class Auftrag implements AuftragInterface {

	private int priority;
	private long time;
	

	public Auftrag(int p) {

		this.priority = p;
		this.time = 0;

	}

	
	public abstract void run(MouseRobot robot);

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	public int compareTo(AuftragInterface ai){
		int prioDiff = ai.getPriority() - this.priority;
		if(prioDiff == 0){
			long tmp = (this.getTime() - ai.getTime());
			tmp = tmp << 32;
			tmp = tmp >> 32;
			return (int) tmp;
		}
		return  prioDiff;
	}
	public boolean check() {
		return true;
	}
	
	@Override
	public void setTime(long time) {
		this.time = time;
	}
	@Override
	public long getTime() {
		return time;
	}

}
