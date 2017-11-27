package com.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.domain.User;
import com.mapper.UserMapper;
import com.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	@RequestMapping("login.do")
	public void login(User user,HttpServletRequest request,HttpServletResponse response) throws Exception {
		System.out.println("suername"+user.getUsername()+"--->"+user.getPassword());
		User selectUser = userService.selectUser(user.getUsername(), user.getPassword());
		if(selectUser!=null) {
			System.out.println("登陆成功用户的信息"+selectUser);
			request.getSession().setAttribute("user", selectUser);
			response.sendRedirect("main.jsp");
		}else {
			response.sendRedirect("login.jsp");
		}
	}
	@RequestMapping("user/addUser")
	public void addUser(User user,HttpServletResponse response) throws Exception {
		user.setCreatedate(new Date());
		int insertUser = userService.insertUser(user);
		if(insertUser>0) {
			response.sendRedirect("selectUser");
		}
	}
	@RequestMapping("user/selectUser")
	public String selectUser(Model model,Integer page) {
		if(page==null) {
			page=1;
		}
		List<User> users=userService.selectAllUser(page,2);
		List<User> userAll=userService.selectAllUser(1, 1000);
		int totlepage=userAll.size()/2;
		if(userAll.size()%2!=0) {
			totlepage++;
		}
		System.out.println("--------->"+users);
		model.addAttribute("users",users);
		model.addAttribute("page",page);
		model.addAttribute("totlepage",totlepage);
		return "user_maint.jsp";
		
	}
	@RequestMapping("user/updateUser")
	public void updateUser(String flag,User user,HttpServletRequest request,HttpServletResponse response) throws Exception {
		if("1".equals(flag)) {
			User selectUserById = userService.selectUserById(user.getUserid());
			request.setAttribute("user", selectUserById);
			request.getRequestDispatcher("user_modify.jsp").forward(request, response);
		}else if("2".equals(flag)){
			int updateUser = userService.updateUser(user);
			response.sendRedirect("selectUser");
		}
	}
	@RequestMapping("user/deleteUser")
	public void deleteUser(String ids,HttpServletResponse response) throws Exception {
		userService.deleteUser(ids);
		response.sendRedirect("selectUser");
	}
}
