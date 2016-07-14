package com.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.database.dao.DorfDao;
import com.database.model.Dorf;

@Service("graphService")
@Transactional
public class DorfServiceImpl implements DorfService {

	@Autowired
	private DorfDao dao;

	@Override
	public List<Dorf> findByName(String name) {
		return dao.findbyName(name);
	}

	@Override
	public void saveDorf(Dorf dorf) {
		dao.saveDorf(dorf);
		
	}

	@Override
	public void updateDorf(Dorf dorf) {
		dao.updateDorf(dorf);
		
	}

}
