package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.domain.Accounts;

public interface AccountsMapper {
   
	@Delete("delete from t_accounts where id=#{id}")
	int delete(Integer id);

	@Insert("insert into t_accounts(fiscalyear,fiscalperiod,begindate,enddate,periodsts,uid) values(#{fiscalyear},#{fiscalperiod},#{begindate},#{enddate},#{periodsts},#{user.userid})")
    int insert(Accounts record);
	
	@Select("select * from t_accounts a left join t_user u on a.uid=u.userid where id=#{id}")
	@Results(id="br1",value= {
			@Result(id=true,column="id",property="id"),
			@Result(column="fiscalyear",property="fiscalyear"),
			@Result(column="fiscalperiod",property="fiscalperiod"),
			@Result(column="begindate",property="begindate"),
			@Result(column="enddate",property="enddate"),
			@Result(column="periodsts",property="periodsts"),
			@Result(column="uid",property="user.userid")
	})
    Accounts select(Integer id);

	@Select("select * from t_accounts a left join t_user u on a.uid=u.userid")
	@Results(id="br2",value= {
			@Result(id=true,column="id",property="id"),
			@Result(column="fiscalyear",property="fiscalyear"),
			@Result(column="fiscalperiod",property="fiscalperiod"),
			@Result(column="begindate",property="begindate"),
			@Result(column="enddate",property="enddate"),
			@Result(column="periodsts",property="periodsts"),
			@Result(column="uid",property="user.userid")
	})
	List<Accounts> selectAll();
	
	@Update("update t_accounts set periodsts=#{arg0} where id=#{arg1}")
    int update(String periodsts,int id);
}