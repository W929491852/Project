package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.domain.FlowCardDetail;

public interface FlowCardDetailMapper {

	@Insert("insert into t_flow_card_detail (aimid,itemno,fid,opt_qty,adjust_qty) values(#{temi.temiid},#{item.itemno},#{flowCardMaster.id},#{optQty},#{adjustQty})")
    int insert(FlowCardDetail record);
	
	@Select("select fd.id,fd.fid,f.recorder_id,c.clientid,c.clientname,fd.adjust_qty,t.temiId,t.temiName,i.itemNo,i.itemName,i.spec,i.pattern,dd.name" + 
			" from (select * from t_flow_card_detail where fid=#{id}) fd " + 
			"	left join t_flow_card_master f on f.id=fd.fid left join t_client c on c.clientid=f.clientid" + 
			" left join t_temi t on fd.aimid=t.temiId" + 
			"	left join t_item i on fd.itemno=i.itemNo " + 
			"	left join t_data_dict dd on i.unit=dd.id")
	@Results(id="br1",value= {
			@Result(id=true,column="id",property="id"),
			@Result(column="adjust_qty",property="adjustQty"),
			@Result(column="temiId",property="temi.temiid"),
			@Result(column="temiName",property="temi.teminame"),
			@Result(column="itemNo",property="item.itemno"),
			@Result(column="itemName",property="item.itemname"),
			@Result(column="name",property="item.unit.name"),
			@Result(column="spec",property="item.spec"),
			@Result(column="pattern",property="item.pattern"),
			@Result(column="fid",property="flowCardMaster.id"),
			@Result(column="recorder_id",property="flowCardMaster.recorderId"),
			@Result(column="clientid",property="flowCardMaster.client.clientid"),
			@Result(column="clientname",property="flowCardMaster.client.clientname"),
	})
    List<FlowCardDetail> select(int id);


    int update(FlowCardDetail record);
}