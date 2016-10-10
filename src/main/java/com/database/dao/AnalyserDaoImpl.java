package com.database.dao;

import org.springframework.stereotype.Repository;

import com.database.model.Analyser;

@Repository("AnalyserDao")
public class AnalyserDaoImpl extends AbstractDao implements AnalyserDao {

	@Override
	public void saveAnalyser(Analyser a) {
		persist(a);

	}

	@Override
	public Analyser findbyId(int id) {
		return (Analyser) getSession().get(Analyser.class, id);
	}

	@Override
	public void update(Analyser a) {
		getSession().update(a);

	}

}
