package com.test;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.domain.Document;
import com.domain.User;
import com.service.DocumentService;
import com.service.UserService;

public class MyTest {

	@Test
	public void publi() {
		// TODO Auto-generated method stub
		ApplicationContext app=new ClassPathXmlApplicationContext("application.xml");
		UserService userService=(UserService) app.getBean("userServiceImple");
//		//List<User> selectAllUser = userService.selectAllUser("","");
//		System.out.println(selectAllUser);
	}
	@Test
	public void test1() {
		
		
	//	List<Notice> selectAllUser = noticeService.selectAllNotice("");
		//System.out.println(selectAllUser);
//		File file = FileUtils.getFile("E:\\test");
//		FileUtils.getPath(file, "1.txt");
	}
	@Test
	public void test2() {
		
		String str=new SimpleDateFormat("yyyy-MM-mm HH:mm:ss s").format(new Date());
		System.out.println(str);
	}
	public static void main(String[] args) {
		ApplicationContext app=new ClassPathXmlApplicationContext("application.xml");
		DocumentService documentService=(DocumentService) app.getBean("documentServiceImple");
		Document selectDocument = documentService.selectSingleDocument("1");
		System.out.println(selectDocument);
	}
}
