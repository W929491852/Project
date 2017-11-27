package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.domain.DataDict;
import com.domain.Temi;
import com.service.DataDictService;
import com.service.TemiService;

@Controller
public class TemiController {

	@Autowired
	private TemiService temiService;
	
	@Autowired
	private DataDictService dataDictService;
	
	@RequestMapping("basedata/addTemi")
	public void addTemi(Temi temi,String flag,HttpServletResponse response,HttpServletRequest request) throws Exception {
		if("1".equals(flag)) {
			request.setAttribute("dicts", dataDictService.selectAllDictByCategory("B"));
			request.getRequestDispatcher("temi_client_add.jsp").forward(request, response);;
		}else if("2".equals(flag)) {
			boolean insert = temiService.insert(temi);
			response.sendRedirect("selectTemi");
			
		}
	}
	
	@RequestMapping("basedata/selectTemi")
	public String selectTemi(Model model) {
		List<Temi> selectAll = temiService.selectAll();
		model.addAttribute("temis", selectAll);
		return "temi_client_crud.jsp";
	}
	@RequestMapping("flowcard/selectTemi")
	public String selectTemiSelect(Model model,int index) {
		List<Temi> selectAll = temiService.selectAll();
		model.addAttribute("temis", selectAll);
		model.addAttribute("index",index);
		return "aim_client_select.jsp";
	}
	@RequestMapping("basedata/updateTemi")
	public void updateTemi(Temi temi,String flag,HttpServletResponse response ,HttpServletRequest request) throws Exception {
		if("1".equals(flag)) {
			Temi select = temiService.select(temi.getTemiid());
			request.setAttribute("temi", select);
			request.setAttribute("dicts", dataDictService.selectAllDictByCategory("B"));
			request.getRequestDispatcher("temi_client_modify.jsp").forward(request, response);
		}else if("2".equals(flag)) {
			boolean update = temiService.update(temi);
			response.sendRedirect("selectTemi");
		}
		
	}
	@RequestMapping("basedata/deleteTemi")
	public void deleteTemi(String ids,HttpServletResponse response) throws Exception {
		temiService.delete(ids);
		response.sendRedirect("selectTemi");
	}
}
