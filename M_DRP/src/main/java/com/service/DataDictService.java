package com.service;

import java.util.List;

import com.domain.DataDict;

public interface DataDictService {

	 DataDict select(String id);
	 
	 List<DataDict> selectAllDictByCategory(String category);
	
}
