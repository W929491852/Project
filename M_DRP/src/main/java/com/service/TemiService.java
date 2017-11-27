package com.service;

import java.util.List;

import com.domain.Temi;

public interface TemiService {

	boolean delete(String ids);

	boolean insert(Temi record);

	Temi select(Integer temiid);

	boolean update(Temi record);
	
	List<Temi> selectAll();
}
