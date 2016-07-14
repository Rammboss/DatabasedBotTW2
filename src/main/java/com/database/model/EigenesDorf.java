package com.database.model;

public class EigenesDorf extends Spielerdorf {
	
	private int farmHotkey;
	
	

	public EigenesDorf(int x, int y, String n) {
		super(x, y, n);
		// TODO Auto-generated constructor stub
	}

	public EigenesDorf(int hotkey, int x, int y, String name) {
		super(x, y, name);
		this.setFarmHotkey(hotkey);
	}

	public int getFarmHotkey() {
		return farmHotkey;
	}

	public void setFarmHotkey(int farmHotkey) {
		this.farmHotkey = farmHotkey;
	}

}
