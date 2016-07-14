package com.bot.model;

import java.util.Date;

import org.joda.time.LocalDateTime;

public class Gegnerdorf extends Dorf {
	private LocalDateTime letzterAngriff;

	public Gegnerdorf(int id, int x,  int y ,String n) {
		super(id, x, y, n);
		this.letzterAngriff = new LocalDateTime();
	}

	public LocalDateTime getLetzterAngriff() {
		return letzterAngriff;
	}

	public void setLetzterAngriff(LocalDateTime letzterAngriff) {
		this.letzterAngriff = letzterAngriff;
	}

}
