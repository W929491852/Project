package com.service.imple;

import java.io.File;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.multipart.MultipartFile;

import com.dao.DocumentDao;
import com.domain.Document;
import com.domain.User;
import com.service.DocumentService;
import com.sun.org.apache.regexp.internal.recompile;
import com.utils.FileUtil;
import com.utils.StringCheckEmpty;

@Service
@Transactional
public class DocumentServiceImple implements DocumentService {

	@Autowired
	private DocumentDao documentDao;

	@Override
	public boolean saveDocument(Document document,MultipartFile uFile,User user,HttpSession session) {
		// TODO Auto-generated method stub
		try {
			if (!uFile.isEmpty()) {
				String fileName = uFile.getOriginalFilename();
				String path = session.getServletContext().getRealPath("/");
				File file = FileUtil.getFile(path);
				File f1 = FileUtil.getPath(file, fileName);
				uFile.transferTo(f1);
				document.setFileName(f1.getAbsolutePath());
				document.setCreateDate(new Date());
				document.setUser(user);
				boolean saveDocument = documentDao.saveDocument(document);
				return saveDocument;
			}
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Document> selectDocument(String title,String pageIndex) {
		// TODO Auto-generated method stub
		String sql = "select * from tb_document where 1=1";
		if (StringCheckEmpty.checked(title)) {
			sql += " and title like '%" + title + "%'";
		}
		if(StringCheckEmpty.checked(pageIndex)) {
			sql+=" limit "+(Integer.parseInt(pageIndex)-1)*3+",3";
		}
		return documentDao.selectAllDocument(sql);
	}

	@Override
	public boolean deleteDocument(String ids) {
		// TODO Auto-generated method stub
		if (StringCheckEmpty.checked(ids)) {
			String[] id = ids.split(",");
			for (int i = 0; i < id.length; i++) {
				documentDao.deleteDocument(new Document(Integer.parseInt(id[i])));
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean updateDocument(Document document,MultipartFile uFile,HttpSession session) {
		// TODO Auto-generated method stub
		try {
			if (!uFile.isEmpty()) {
				FileUtil.deleteFile(document.getFileName());
				String fileName = uFile.getOriginalFilename();
				String path = session.getServletContext().getRealPath("/");
				File file = FileUtil.getFile(path);
				File f1 = FileUtil.getPath(file, fileName);
				uFile.transferTo(f1);
				document.setFileName(f1.getAbsolutePath());
			}
			boolean saveDocument = documentDao.updateDocument(document);
			return saveDocument;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Document selectSingleDocument(String id) {
		// TODO Auto-generated method stub
		return documentDao.selectSingleDocument(Integer.parseInt(id));
	}
}
