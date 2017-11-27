package com.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.domain.Item;
import com.service.DataDictService;
import com.service.ItemService;
import com.utils.FileUtil;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	@Autowired
	private DataDictService dataDictService;
	
	@RequestMapping("basedata/addItem")
	public void addItem(Item item,HttpServletRequest request,HttpServletResponse response,String flag) throws Exception {
		if("1".equals(flag)) {
			request.setAttribute("dicte", dataDictService.selectAllDictByCategory("C"));
			request.setAttribute("dictu", dataDictService.selectAllDictByCategory("D"));
			request.getRequestDispatcher("item_add.jsp").forward(request, response);
		}else if("2".equals(flag)) {
			boolean insert = itemService.insert(item);
			response.sendRedirect("selectItem");
		}
	}
	@RequestMapping("basedata/deleteItem")
	public void deleteItem(String ids,HttpServletResponse response) throws Exception {
		boolean delete = itemService.delete(ids);
		response.sendRedirect("selectItem");
	}
	@RequestMapping("basedata/selectItem")
	public void selectItem(Item item,HttpServletResponse response,HttpServletRequest request) throws Exception {
		request.setAttribute("items", itemService.selectAll());
		request.getRequestDispatcher("item_maint.jsp").forward(request, response);
	}
	@RequestMapping("flowcard/selectItemChecked")
	public void selectItemChecked(int itemno,HttpServletResponse response,HttpSession session) throws Exception {
		Item select = itemService.select(itemno);
		String jsonString = JSON.toJSONString(select);
		System.out.println(jsonString);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(jsonString);
	}
	@RequestMapping("flowcard/selectItemSelect")
	public void selectItemSelect(HttpServletRequest request,HttpServletResponse response,String indexItemNo,String clientId) throws Exception {
		if(clientId==null||clientId.equals("")) {
			request.setAttribute("items", itemService.selectAll());
		}else {
			request.setAttribute("items", itemService.selectAllByClientId(Integer.parseInt(clientId)));
		}
		System.out.println("当前请求的index:"+indexItemNo);
		request.setAttribute("indexItemNo", indexItemNo);
		
		request.getRequestDispatcher("item_select.jsp").forward(request, response);
	}
	@RequestMapping("basedata/updateItem")
	public void updateItem(String flag,Item item,HttpServletRequest request,HttpServletResponse  response) throws Exception {
		if("1".equals(flag)) {
			request.setAttribute("dicte", dataDictService.selectAllDictByCategory("C"));
			request.setAttribute("dictu",dataDictService.selectAllDictByCategory("D"));
			request.setAttribute("item", itemService.select(item.getItemno()));
			request.getRequestDispatcher("item_modify.jsp").forward(request, response);
		}else if("2".equals(flag)) {
			itemService.update(item);
			response.sendRedirect("selectItem");
		}
	}
	@RequestMapping("basedata/upLoadImg")
	public void  upLoadImg(@RequestParam("fn") MultipartFile uFile,Item item,HttpServletRequest request,HttpServletResponse response) throws Exception {
		if(!uFile.isEmpty()) {
			String name=uFile.getOriginalFilename();
			File file = FileUtil.getFile(request.getServletContext().getRealPath("/"));
			File path = FileUtil.getPath(file, name);
			uFile.transferTo(path);
			itemService.updateImage(path.getAbsolutePath(),item.getItemno());
			response.sendRedirect("selectItem");
		}else {
			response.sendRedirect("upLoadItem");
		}
	}
	@RequestMapping("basedata/upLoadItem")
	public void upLoadItem(Item item,HttpServletRequest request,HttpServletResponse response) throws Exception {
		Item select = itemService.select(item.getItemno());
		request.setAttribute("item",select);
		request.getRequestDispatcher("item_upload.jsp").forward(request, response);
	}
	@RequestMapping("basedata/detailItem")
	public void detailItem(int itemno,HttpServletRequest request,HttpServletResponse response) throws Exception {
		Item select = itemService.select(itemno);
		request.setAttribute("item", select);
		request.getRequestDispatcher("item_detail.jsp").forward(request, response);
	}
	@RequestMapping("basedata/getimg")
	public void getImg(String path,HttpServletResponse  response) throws Exception{
		FileInputStream in=new FileInputStream(path);
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
		byte[] buffer=new byte[1024];
		int len=0;
		while((len=in.read(buffer))!=-1){
			bos.write(buffer, 0, len);
		}
		bos.flush();
		in.close();
		System.out.println(path);
		response.getOutputStream().write(bos.toByteArray());
		bos.close();
	}
	@RequestMapping("basedata/selectAllByName")
	public void selectAllByName(String name,HttpServletRequest request,HttpServletResponse response) throws Exception {
		List<Item> selectAllByName = itemService.selectAllByName(name);
		request.setAttribute("items", selectAllByName);
		request.getRequestDispatcher("item_maint.jsp").forward(request, response);
	}
}
