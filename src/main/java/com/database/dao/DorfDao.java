package com.database.dao;

import java.util.List;

import com.database.model.Dorf;

public interface DorfDao {

	void saveDorf(Dorf dorf);

	List<Dorf> findbyName(String name);

	void updateDorf(Dorf dorf);

}
