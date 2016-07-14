package com.database.model;

import java.util.Date;

/**
 * Diese Klasse repräsentiert Ein Barbarendorf
 * 
 * @author Effi
 *
 */
public class Babarendorf extends Gegnerdorf {

	public Babarendorf(int x, int y) {
		super(x, y, "Barbarendorf");
	}

	public Babarendorf(int x, int y, long gefarmed) {
		super(x, y, "Babarendorf");
		this.setLetzterAngriff(gefarmed);
	}

	public boolean farmable() {

		if (this.getLetzterAngriff() + (60 * 60 * 1000) < new Date().getTime())
			return true;
		return false;
	}

}
