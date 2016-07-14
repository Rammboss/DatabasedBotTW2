package com.bot.common;

import com.bot.common.auftraege.AuftragInterface;

public interface AuftragslisteInterface {
	public boolean isFull();

	public void add(AuftragInterface a);

	public AuftragInterface next();
	
	public int size();
	
	public void clear();
	
	public int countsAuftraege(Class c);
}
