package com.servletcontroller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;

import com.domain.User;
import com.service.UserService;
import com.utils.PageUtils;
import com.utils.StringCheckEmpty;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/jsp/user/addUser")
	public void addUser(String flag,User user,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		if("1".equals(flag)) {
			request.getRequestDispatcher("showAddUser.jsp").forward(request, response);					
		}else if("2".equals(flag)) {
			if(StringCheckEmpty.checked(user.getUsername(),user.getStatus()+"",user.getLoginname(),user.getPassword())) {
				user.setCreatedate(new Date());
				boolean saveUser = userService.saveUser(user);
				if(saveUser) {
					response.sendRedirect("selectUser");
				}
			}
		}
	}
	@RequestMapping("/jsp/login")
	public String loginUser(User user,HttpSession session,Model model) {
		User selectUser = userService.selectUser(user.getLoginname(), user.getPassword());
		if(selectUser!=null) {
			session.setAttribute("user_session",selectUser );
			return "/jsp/main.jsp";
		}else {
			model.addAttribute("message", "用户名或密码不正确");
			return "/jsp/loginForm.jsp";
		}
	}
	@RequestMapping("/jsp/user/logout.action")
	public void logoutUser(HttpSession session,HttpServletResponse response) throws IOException {
		session.removeAttribute("user_session");
		response.sendRedirect("../loginForm.jsp");
	}
	@RequestMapping("/jsp/user/removeUser")
	public String removeUser(String ids) {
		userService.deleteUser(ids);
		return "/jsp/user/selectUser";
	}
	@RequestMapping("/jsp/user/selectUser")
	public String selectUser(ModelMap modelMap,HttpServletRequest request,String username,String status,String pageIndex,Model model) {
		if(pageIndex==null) {
			pageIndex="1";
		}
		List<User> selectAllUser = userService.selectAllUser(username,status,pageIndex);
		int size = userService.selectAllUser(username, status,"").size();
		model.addAttribute("pageModel", PageUtils.getPage(Integer.parseInt(pageIndex), size));
		System.out.println(selectAllUser);
		model.addAttribute("users", selectAllUser);
		return "/jsp/user/user.jsp";
	}
	@RequestMapping("/jsp/user/updateUser")
	public void updateUser(String flag,User user,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		if("1".equals(flag)) {
			User selectSingleUser = userService.selectSingleUser(user.getId()+"");
			request.setAttribute("user", selectSingleUser);
			request.getRequestDispatcher("/jsp/user/showUpdateUser.jsp").forward(request, response);
		}else if("2".equals(flag)) {
			if(StringCheckEmpty.checked(user.getId()+"",user.getUsername(),user.getStatus()+"",user.getLoginname(),user.getPassword())) {
				userService.updateUser(user);
				response.sendRedirect("selectUser");
			}
		}
	}
}
