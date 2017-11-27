package com.qf.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qf.domain.User;
import com.qf.utils.*;
import com.qf.utils.MD5Utils;

/**
 * Servlet implementation class BackLoginServlet
 */
@WebServlet("/loginadmin")
//后台登录
public class BackLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BackLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String name=request.getParameter("name");
		  String pw=MD5Utils.md5(request.getParameter("psw"));
		  String msg="信息有误";
		  
		  if(StringUtils.checkEmpty(name,pw)){
			  User user=DbHelp.querySingle("select * from tb_user where email=?", User.class, name);
			  if(user!=null){
				  if(user.getPassword().equals(pw)){
					  request.getSession().setAttribute("user",user);
					  msg="";
				  }
			  }
		  }
		  if(msg.length()>0){
			  request.setAttribute("msg", msg);
			
			  request.getRequestDispatcher("admin/login.jsp").forward(request, response);
		  }else {
			response.sendRedirect("admin/main.jsp");
		}
	}

}