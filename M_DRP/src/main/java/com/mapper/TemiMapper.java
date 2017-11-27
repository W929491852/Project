package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.domain.Temi;

public interface TemiMapper {
	
	@Delete("delete from t_temi where temiid=#{temiid}")
    int delete(Integer temiid);

	@Insert("insert into t_temi(teminame,temitype,contactor,contacttel,address,zipcode)"
			+ "values (#{teminame},#{dataDict.id},#{contactor},#{contacttel},#{address},#{zipcode})")
    int insert(Temi record);

	@Select("select * from t_temi t left join t_data_dict d on t.temitype=d.id where temiid=#{temiid}")
    @Results(id="br1",value= {
    		@Result(column="temiid",property="temiid"),
    		@Result(column="teminame",property="teminame"),
    		@Result(column="contactor",property="contactor"),
    		@Result(column="contacttel",property="contacttel"),
    		@Result(column="address",property="address"),
    		@Result(column="zipcode",property="zipcode"),
    		@Result(column="id",property="dataDict.id"),
    		@Result(column="name",property="dataDict.name"),
    		@Result(column="category",property="dataDict.category")
    })
	Temi select(Integer temiid);
	@Select("select * from t_temi t left join t_data_dict d on t.temitype=d.id")
    @Results(id="br2",value= {
    		@Result(column="temiid",property="temiid"),
    		@Result(column="teminame",property="teminame"),
    		@Result(column="contactor",property="contactor"),
    		@Result(column="contacttel",property="contacttel"),
    		@Result(column="address",property="address"),
    		@Result(column="zipcode",property="zipcode"),
    		@Result(column="id",property="dataDict.id"),
    		@Result(column="name",property="dataDict.name"),
    		@Result(column="category",property="dataDict.category")
    })
	List<Temi> selectAll();
	@Update("update t_temi set teminame=#{teminame},temitype=#{dataDict.id},contactor=#{contactor},contacttel=#{contacttel},address=#{address},zipcode=#{zipcode} where temiid=#{temiid}")
    int update(Temi record);

}