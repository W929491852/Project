package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.domain.Inventory;

public interface InventoryMapper {
    
	@Delete("")
	int delete(Integer id);

	@Insert("insert into t_inventory (clientid,itemno,init_qty,in_qty,out_qty) values (#{client.clientid},#{item.itemno},#{initqty},#{inqty},#{outqty})")
    int insert(Inventory record);

	@Select("select id,init_qty from t_inventory where clientid=#{arg0} and itemno=#{arg1}")
	@Results(id="br2",value= {
			@Result(id=true,column="id",property="id"),
			@Result(column="init_qty",property="initqty")
	})
    Inventory select(int clientId,int itemno);

	@Update("update t_inventory set in_qty=#{inqty} where itemno=#{itemno} and clientid=#{clientid}")
    int update(@Param("inqty") int inqty,@Param("itemno") int id,@Param("clientid")int clientid);
	
	@Update("update t_inventory set init_qty=init_qty-#{arg0} where id=#{arg1}")
	int updateCount(int initqty,int id);
	
	@Select("select i.id,c.clientId,c.clientName,it.itemNo,it.itemName,it.spec,it.pattern,d.name,i.init_qty from t_inventory i left join t_client c on i.clientid=c.clientId left join t_item it on i.itemno=it.itemNo left join t_data_dict d on it.unit=d.id")
	@Results(id="br1",value= {
			@Result(id=true,column="id",property="id"),
			@Result(column="clientid",property="client.clientid"),
			@Result(column="clientname",property="client.clientname"),
			@Result(column="itemno",property="item.itemno"),
			@Result(column="itemname",property="item.itemname"),
			@Result(column="spec",property="item.spec"),
			@Result(column="pattern",property="item.pattern"),
			@Result(column="name",property="item.unit.name"),
			@Result(column="init_qty",property="initqty")
	})
	List<Inventory> selectInventory();
}