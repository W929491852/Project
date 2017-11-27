package com.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.domain.DataDict;
import com.mapper.DataDictMapper;
import com.service.DataDictService;

@Service
@Transactional
public class DataDictServiceImple implements DataDictService{

	@Autowired
	private DataDictMapper dataDictMapper;
	@Override
	public DataDict select(String id) {
		// TODO Auto-generated method stub
		return dataDictMapper.select(id);
	}

	@Override
	public List<DataDict> selectAllDictByCategory(String category) {
		// TODO Auto-generated method stub
		return dataDictMapper.selectAllDictByCategory(category);
	}

}
