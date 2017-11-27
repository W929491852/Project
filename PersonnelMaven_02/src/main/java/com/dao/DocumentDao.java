package com.dao;

import java.util.List;

import com.domain.Document;

public interface DocumentDao {

	//保存上传文档
	boolean saveDocument(Document document);
	
	//查询上传文档
	List<Document> selectAllDocument(String sql);
	
	//删除文档
	boolean deleteDocument(Document document);
	
	//修改文档
	boolean updateDocument(Document document);
	
	//由id获取文档
	Document selectSingleDocument(int id);
}
