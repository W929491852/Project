package com.servletcontroller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.domain.Document;
import com.domain.User;
import com.service.DocumentService;
import com.utils.FileUtil;
import com.utils.PageUtils;

@Controller
public class DocumentController {

	@Autowired
	private DocumentService documentService;

	@RequestMapping("/jsp/document/addDocument")
	public void addDocument(HttpServletResponse response) throws IOException {
		response.sendRedirect("showAddDocument.jsp");
	}

	@RequestMapping("/jsp/document/addDocumentUpLoad")
	public void addDocumentUpLoad(@RequestParam(name = "file") MultipartFile uFile, Document document,
			HttpSession session, HttpServletResponse response) throws Exception {
		User user = (User) session.getAttribute("user_session");
		boolean saveDocument = documentService.saveDocument(document, uFile, user, session);
		if (saveDocument) {
			response.sendRedirect("selectDocument");
		}
	}

	@RequestMapping("/jsp/document/removeDocument")
	public void deleteDocument(String ids, HttpServletResponse response) throws IOException {
		boolean deleteDocument = documentService.deleteDocument(ids);
		if (deleteDocument) {
			response.sendRedirect("selectDocument");
		}
	}

	@RequestMapping("/jsp/document/downLoad")
	public ResponseEntity<byte[]> downLoadDocument(String id, HttpServletResponse response) throws IOException {
		Document selectSingleDocument = documentService.selectSingleDocument(id);
		String fileName = selectSingleDocument.getFileName();
		File ff = new File(fileName);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentDispositionFormData("attachment", fileName);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(ff), headers, HttpStatus.OK);
	}

	@RequestMapping("/jsp/document/selectDocument")
	public String selectDoucemnt(String title, String pageIndex, Model model) {
		if (pageIndex == null) {
			pageIndex = "1";
		}
		List<Document> selectDocument = documentService.selectDocument(title, pageIndex);
		int size = documentService.selectDocument(title, "").size();
		model.addAttribute("pageModel", PageUtils.getPage(Integer.parseInt(pageIndex), size));
		model.addAttribute("documents", selectDocument);
		return "/jsp/document/document.jsp";
	}

	@RequestMapping("/jsp/document/updateDocument")
	public void updateDocument(String id, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Document selectSingleDocument = documentService.selectSingleDocument(id);
		request.setAttribute("document", selectSingleDocument);
		request.getRequestDispatcher("showUpdateDocument.jsp").forward(request, response);
	}

	@RequestMapping("/jsp/document/updateDocumentUpLoad")
	public void updateDocumentUpLoad(@RequestParam("file") MultipartFile uFile, HttpSession session,
			HttpServletResponse response, Document document) throws IOException {
		documentService.updateDocument(document, uFile, session);
		response.sendRedirect("selectDocument");
	}
}
