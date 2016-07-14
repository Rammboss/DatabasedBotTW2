package com.bot.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.joda.time.LocalDateTime;

/**
 * Diese Klasse repräsentiert Ein Barbarendorf
 * 
 * @author Effi
 *
 */

public class Babarendorf extends Gegnerdorf {

//	public Babarendorf(int x, int y, long time,int id) {
//		super(x, y, "Barbarendorf", id);
//	}
	

	public Babarendorf(int id, int x, int y, LocalDateTime gefarmed) {
		super(id,x, y, "Babarendorf" );
		this.setLetzterAngriff(gefarmed);
	}

}
