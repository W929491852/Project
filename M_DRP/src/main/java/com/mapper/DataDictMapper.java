package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.domain.DataDict;

public interface DataDictMapper {
  
	@Select("select * from t_data_dict where id=#{id}")
    DataDict select(String id);

	@Select("select * from t_data_dict where category=#{category}")
	List<DataDict> selectAllDictByCategory(String category);
}