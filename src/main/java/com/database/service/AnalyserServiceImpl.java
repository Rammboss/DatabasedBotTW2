package com.database.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.database.dao.AnalyserDao;
import com.database.model.Analyser;

@Service("analyserService")
@Transactional
public class AnalyserServiceImpl implements AnalyserService {

	@Autowired
	private AnalyserDao dao;

	@Override
	public void saveAnalyser(Analyser a) {
		dao.saveAnalyser(a);

	}

	@Override
	public void updateAnalyser(Analyser a) {
		dao.update(a);

	}

	@Override
	public Analyser findById(int id) {

		return dao.findbyId(id);
	}

}
