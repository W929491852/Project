package com.qf.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//自定义注解
@Target(value=ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface JdbcField {

	//sql语句查询的字段名称
	String value();
}
