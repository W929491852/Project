package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.domain.User;

public interface UserMapper {
	
	@Delete("delete from t_user where userid = #{userid,jdbcType=INTEGER}")
    int deleteByPrimaryKey(Integer id);
    
	@Insert("insert into t_user (username, password,contactTel, email, createdate) values (#{username,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, #{contacttel,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR}, #{createdate,jdbcType=DATE})")
    int insert(User record);
    
    @Select(" select u.userid,u.username,u.password,u.contacttel,u.email,u.createdate,dd.name,dd.category,c.clientid,c.clientname,c.clientlevel,c.bankacctno,c.contacttel ccontacttel,c.address,c.zipcode from t_user u left join t_client c on u.userid=c.uid left join t_data_dict dd on c.clientlevel=dd.id where u.username=#{arg0} and u.password=#{arg1}")
    @Results(id="brm1",value= {
    		@Result(id=true,column="userid",property="userid"),
    		@Result(column="username",property="username"),
    		@Result(column="password",property="password"),
    		@Result(column="contactTel",property="contacttel"),
    		@Result(column="email",property="email"),
    		@Result(column="createdate",property="createdate"),
    		@Result(column="clientId",property="client.clientid"),
    		@Result(column="clientName",property="client.clientname"),
    		@Result(column="bankAcctNo",property="client.bankacctno"),
    		@Result(column="ccontacttel",property="client.contacttel"),
    		@Result(column="address",property="client.address"),
    		@Result(column="zipcode",property="client.zipcode"),
    		@Result(column="ccontacttel",property="client.dataDict.id"),
    		@Result(column="name",property="client.dataDict.name"),
    		@Result(column="category",property="client.dataDict.category")
    		
    		
    })
    User selectByPrimaryKey(String username,String password);
    
    @Update("update t_user set username = #{username,jdbcType=VARCHAR},password = #{password,jdbcType=VARCHAR},contactTel = #{contacttel,jdbcType=VARCHAR}, email = #{email,jdbcType=VARCHAR} where userid = #{userid,jdbcType=INTEGER}")
    int updateByPrimaryKeySelective(User record);
    
    @Select("select * from t_user limit #{arg0},#{arg1}")
    List<User> selectAllUser(int page,int count);
    
    @Select("select u.*,c.* from t_user u left join t_client c on u.userid=c.uid where u.userId=#{id}")
    User selectUserById(Integer id);
  
}