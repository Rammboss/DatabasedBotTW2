package com.database.dao;

import java.util.List;

import com.database.model.Analyser;
import com.database.model.Dorf;

public interface AnalyserDao {
	void saveAnalyser(Analyser a);

	Analyser findbyId(int id);

	void update(Analyser a);

}
