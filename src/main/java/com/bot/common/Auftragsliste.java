package com.bot.common;

import java.util.Date;
import java.util.PriorityQueue;

import com.bot.common.auftraege.Auftrag;
import com.bot.common.auftraege.AuftragInterface;
import com.bot.guicontroller.MouseRobot;
import com.bot.settings.Utils;



public class Auftragsliste implements AuftragslisteInterface {

	private PriorityQueue<AuftragInterface> liste;

	private int MAX_AUFTRAEGE;
	
	private static Auftragsliste singelton;

	private Auftragsliste() {
		singelton = this;
		liste = new PriorityQueue<AuftragInterface>();
		MAX_AUFTRAEGE = Utils.PRIO_QUEUE_SIZE;
	}
	
	public static Auftragsliste getAuftragsliste(){
		if(singelton == null){
			return new Auftragsliste();
		}else return singelton;
	}

	@Override
	public synchronized boolean isFull() {
		return liste.size() > MAX_AUFTRAEGE - 1;
	}

	@Override
	public synchronized void add(AuftragInterface a) {
		if (!isFull()) {
			MouseRobot.wait(5);
			a.setTime(new Date().getTime());
			liste.add(a);
		}

	}

	@Override
	public synchronized AuftragInterface next() {
		return liste.poll();
	}

	@Override
	public synchronized void clear() {
		liste.clear();
	}

	@Override
	public int size() {
		return liste.size();
	}

	@Override
	/**
	 * Geht
	 * 
	 */
	public int countsAuftraege(String c) {
		int counter = 0;
		for(AuftragInterface a : liste){
			if(a.getClass().getSimpleName().equals(c.getClass()))
				counter++;
		}
		return counter;
	}
}
