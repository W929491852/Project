package com.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.domain.Document;
import com.domain.User;

public interface DocumentService {

	//保存上传文档
	boolean saveDocument(Document document,MultipartFile uFile,User user,HttpSession session);
	
	//查询上传文档
	List<Document> selectDocument(String title,String pageIndex);
	
	//删除文档
	boolean deleteDocument(String ids);
	
	//修改文档
	boolean updateDocument(Document document,MultipartFile uFile,HttpSession session);
	
	//由id获取文档
	Document selectSingleDocument(String id);
}
