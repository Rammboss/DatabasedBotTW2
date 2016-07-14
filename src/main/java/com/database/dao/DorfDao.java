package com.database.dao;

import java.util.List;

import com.database.model.Dorf;


public interface DorfDao {

	void saveDorf(Dorf dorf);

	List<Dorf> findByName(String name);
	
	Dorf findById(int id);

	void updateDorf(Dorf dorf);

}
