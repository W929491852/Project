package com.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.domain.Document;
import com.service.DocumentService;

public class MyTest1 {
	public static void main(String[] args) throws Exception {
//		System.out.println("-----------------------------------");
//		ApplicationContext app=new ClassPathXmlApplicationContext("application.xml");
//		DocumentService documentService=(DocumentService) app.getBean("documentServiceImple");
//		Document selectDocument = documentService.selectSingleDocument("1");
//		
//		System.out.println(selectDocument);
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sf.parse("2017-10-1 00:00:00"));
	}
}
