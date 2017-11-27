package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.domain.Client;
import com.domain.Data;

public interface ClientMapper {
	
	@Delete("delete from t_client where clientid=#{clientid}")
    int delete(Integer clientid);

	@Insert("insert into t_client (clientName, clientLevel, bankAcctNo, contactTel, address,  zipCode,uid)values "
			+ "(#{clientname,jdbcType=VARCHAR}, #{dataDict.id,jdbcType=VARCHAR}, #{bankacctno,jdbcType=VARCHAR}, #{contacttel,jdbcType=VARCHAR}, #{address,jdbcType=VARCHAR}, #{zipcode,jdbcType=INTEGER},#{user.userid})")
	@Options(keyProperty="clientid",useGeneratedKeys=true)
	int insert(Client record);

	@Select("select c.clientid,c.clientname,c.bankacctno,c.contacttel,c.address,c.zipcode,t.id tid,t.name tname,t.category tcategory from t_client c left join t_data_dict t  on c.clientlevel=t.id where c.clientid=#{clientid}")
	@Results(id="br1",value= {
			@Result(id=true,column="clientid",property="clientid"),
			@Result(column="clientname",property="clientname"),
			@Result(column="bankacctno",property="bankacctno"),
			@Result(column="contacttel",property="contacttel"),
			@Result(column="address",property="address"),
			@Result(column="zipcode",property="zipcode"),
			@Result(column="tid",property="dataDict.id"),
			@Result(column="tname",property="dataDict.name"),
			@Result(column="tcategory",property="dataDict.category")
			
	})
    Client select(Integer clientid);
	
	@Select("select * from t_client c left join t_data_dict t  on c.clientlevel=t.id")
	@Results(id="br2",value= {
			@Result(id=true,column="clientid",property="clientid"),
			@Result(column="clientname",property="clientname"),
			@Result(column="bankacctno",property="bankacctno"),
			@Result(column="contacttel",property="contacttel"),
			@Result(column="address",property="address"),
			@Result(column="zipcode",property="zipcode"),
			@Result(column="id",property="dataDict.id"),
			@Result(column="name",property="dataDict.name"),
			@Result(column="category",property="dataDict.category")
			
	})
	List<Client> selectAllClient();

	@Update("update t_client set clientName = #{clientname,jdbcType=VARCHAR}, clientLevel = #{dataDict.id,jdbcType=VARCHAR},bankAcctNo = #{bankacctno,jdbcType=VARCHAR},contactTel = #{contacttel,jdbcType=VARCHAR},address = #{address,jdbcType=VARCHAR},zipCode = #{zipcode,jdbcType=INTEGER} "
			+ "where clientId = #{clientid,jdbcType=INTEGER}")
    int update(Client record);
	
	@Select("select count(1) value,dd.name  from t_client c left join t_data_dict dd on c.clientLevel=dd.id  group by c.clientLevel")
	@ResultType(Data.class)
	List<Data> selectData();
}