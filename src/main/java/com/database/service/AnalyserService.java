package com.database.service;

import com.database.model.Analyser;

public interface AnalyserService {
	void saveAnalyser(Analyser a);

	void updateAnalyser(Analyser a);

	Analyser findById(int id);

}
