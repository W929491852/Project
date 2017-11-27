package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.domain.FlowCardMaster;

public interface FlowCardMasterMapper {

	@Insert("insert into t_flow_card_master (opt_type,clientid,recorder_id,opt_date) values(#{optType},#{client.clientid},#{recorderId},#{optDate})")
	@Options(useGeneratedKeys=true,keyProperty="id")
	int insert(FlowCardMaster record);

	@Select("select * from t_flow_card_master f left join t_client c on f.clientid=c.clientId")
	@Results(id="br1",value= {
			@Result(id=true,column="id",property="id"),
			@Result(column="clientid",property="client.clientid"),
			@Result(column="clientname",property="client.clientname"),
			@Result(column="recorder_id",property="recorderId"),
			@Result(column="opt_date",property="optDate")
			
	})
    List<FlowCardMaster> select();

    int update(FlowCardMaster record);
}