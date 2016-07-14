package com.database.service;

import java.util.List;

import com.database.model.Dorf;

public interface DorfService {

	void saveDorf(Dorf dorf);

	List<Dorf> findByName(String name);

	void updateDorf(Dorf dorf);

}
