package com.database.model;

import javax.persistence.Column;

public class Gegnerdorf extends Dorf {
	@Column(name = "LASTANGRIFF", nullable = true)
	private long letzterAngriff;

	public Gegnerdorf(int x, int y, String n) {
		super(x, y, n);
	}

	public long getLetzterAngriff() {
		return letzterAngriff;
	}

	public void setLetzterAngriff(long letzterAngriff) {
		this.letzterAngriff = letzterAngriff;
	}

}
