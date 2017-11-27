package com.servletcontroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.domain.Dept;
import com.domain.User;
import com.service.DeptService;
import com.utils.PageUtils;

@Controller
public class DeptController {
	
	@Autowired
	private DeptService deptService;
	@RequestMapping("/jsp/dept/addDept")
	public void addDept(String flag,HttpServletResponse response,String name,String remark) throws IOException {
		if("1".equals(flag)) {
			response.sendRedirect("showAddDept.jsp");			
		}else if("2".equals(flag)) {
			boolean saveDept = deptService.saveDept(name, remark);
			if(saveDept) {
				response.sendRedirect("selectDept");
			}
		}
	}
	@RequestMapping("/jsp/dept/removeDept")
	public void deleteDept(String ids,HttpServletResponse response) throws IOException {
		boolean deleteDept = deptService.deleteDept(ids);
		if(deleteDept) {
			response.sendRedirect("selectDept");
		}
	}
	@RequestMapping("/jsp/dept/selectDept")
	public String selectDept(Model model,String  name,String pageIndex) {
		if(pageIndex==null) {
			pageIndex="1";
		}
		List<Dept> selectAllDept = deptService.selectAllDept(name,pageIndex);
		int size=deptService.selectAllDept(name,"").size();
		model.addAttribute("pageModel", PageUtils.getPage(Integer.parseInt(pageIndex), size));
		model.addAttribute("depts", selectAllDept);
		return "/jsp/dept/dept.jsp";
	}
	@RequestMapping("/jsp/dept/updateDept")
	public void updateDept(String flag,Dept dept,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		if("1".equals(flag)) {
			Dept selectSingleDept = deptService.selectSingleDept(dept.getId());
			request.setAttribute("dept", selectSingleDept);
			request.getRequestDispatcher("showUpdateDept.jsp").forward(request, response);
		}else if("2".equals(flag)) {
			String name=request.getParameter("name");
			String remark=request.getParameter("remark");
			deptService.updateDept(dept.getId(), dept.getName(), dept.getRemark());
			response.sendRedirect("selectDept");
		}
	}
}
