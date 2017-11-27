package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.domain.Item;

public interface ItemMapper {

	@Insert("insert into t_item(itemname,spec,pattern,category,unit) values(#{itemname},#{spec},#{pattern},#{category.id},#{unit.id})")
    int insert(Item record);

	@Select("select i.*,d1.id id1,d1.name name1,d1.category category1,d2.id id2,d2.name name2,d2.category category2  from t_item i left join t_data_dict d1 on i.category=d1.id left join t_data_dict d2  on unit=d2.id where itemNo=#{ietmno}")
    @Results(id="br1",value= {
    		@Result(id=true,column="itemNo",property="itemno"),
    		@Result(column="itemname",property="itemname"),
    		@Result(column="spec",property="spec"),
    		@Result(column="pattern",property="pattern"),
    		@Result(column="id1",property="category.id"),
    		@Result(column="name1",property="category.name"),
    		@Result(column="category1",property="category.category"),
    		@Result(column="id2",property="unit.id"),
    		@Result(column="name2",property="unit.name"),
    		@Result(column="category2",property="unit.category")
    })
	Item select(Integer itemno);

	@Select("select i.*,d1.id id1,d1.name name1,d1.category category1,d2.id id2,d2.name name2,d2.category category2  from t_item i left join t_data_dict d1 on i.category=d1.id left join t_data_dict d2  on unit=d2.id")
	@Results(id="br2",value= {
	    		@Result(id=true,column="itemNo",property="itemno"),
	    		@Result(column="itemname",property="itemname"),
	    		@Result(column="spec",property="spec"),
	    		@Result(column="pattern",property="pattern"),
	    		@Result(column="path",property="path"),
	    		@Result(column="id1",property="category.id"),
	    		@Result(column="name1",property="category.name"),
	    		@Result(column="category1",property="category.category"),
	    		@Result(column="id2",property="unit.id"),
	    		@Result(column="name2",property="unit.name"),
	    		@Result(column="category2",property="unit.category")
	    })
	List<Item> selectAll();
	@Select("select i.*,d1.id id1,d1.name name1,d1.category category1,d2.id id2,d2.name name2,d2.category category2  from t_item i left join t_data_dict d1 on i.category=d1.id left join t_data_dict d2  on unit=d2.id where itemname like #{name}")
	@Results(id="br3",value= {
	    		@Result(id=true,column="itemNo",property="itemno"),
	    		@Result(column="itemname",property="itemname"),
	    		@Result(column="spec",property="spec"),
	    		@Result(column="pattern",property="pattern"),
	    		@Result(column="path",property="path"),
	    		@Result(column="id1",property="category.id"),
	    		@Result(column="name1",property="category.name"),
	    		@Result(column="category1",property="category.category"),
	    		@Result(column="id2",property="unit.id"),
	    		@Result(column="name2",property="unit.name"),
	    		@Result(column="category2",property="unit.category")
	    })
	List<Item> selectAllByName(String name);
	@Select("SELECT i.*,d1.name d1name,d2.name d2name FROM (select * from t_item where itemNo in (select itemNo  from t_inventory where clientid=#{clientId})" + 
			") i LEFT JOIN t_data_dict d1 on i.category=d1.id left join t_data_dict d2 on d2.id=i.unit")
	@Results(id="br4",value= {
			@Result(id=true,column="itemNo",property="itemno"),
			@Result(column="itemname",property="itemname"),
			@Result(column="spec",property="spec"),
			@Result(column="pattern",property="pattern"),
			@Result(column="path",property="path"),
			@Result(column="d1name",property="category.name"),
			@Result(column="d2name",property="unit.name")
	})
	List<Item> selectAllByClientId(int clientId);
	@Update("update t_item set itemname=#{itemname},spec=#{spec},pattern=#{pattern},category=#{category.id},unit=#{unit.id}"
			+ "where itemNo=#{itemno}")
    int update(Item record);

	@Update("update t_item set path=#{arg0} where itemno=#{arg1}")
	int updateImage(String path,int itemno);
	@Delete("delete from t_item where itemNo=#{id}")
    int delete(Integer id);
}