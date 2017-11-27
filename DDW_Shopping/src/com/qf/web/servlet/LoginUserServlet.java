package com.qf.web.servlet;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.If;

import com.qf.dao.*;

import com.qf.domain.*;
import com.qf.utils.*;

/**
 * Servlet implementation class LoginUserServlet
 */
@WebServlet("/login")
public class LoginUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// TODO Auto-generated method stub
		String n = request.getParameter("email");
	
		String p1=request.getParameter("password");
		String p = MD5Utils.md5(request.getParameter("password"));
	
		String ccode = request.getParameter("ccode");

		String auto = request.getParameter("auto");
		String msg = "用户名或者密码错误，请重新输入";
		if (StringUtils.checkEmpty(n, p)) {
			User user = DbHelp.querySingle("select * from tb_user where email=?", User.class, n);
		
			if (user != null) {
				
				if (p.equals(user.getPassword())) {
					
					request.getSession().setAttribute("user", user);
					if (auto != null && auto.equals("1")) {
						Cookie cookie = new Cookie("user", n + "##" + p1);
						cookie.setPath("/");
						cookie.setMaxAge(14 * 24 * 60 * 60);
						response.addCookie(cookie);
					}
					msg = "";
					System.out.println("这个应该是对了");
				}
			}

		}
		if (msg.length() > 0) {

			request.setAttribute("msg", msg);
			request.getRequestDispatcher("login.jsp").forward(request, response);
			System.out.println(msg);
		} else {
			response.sendRedirect("index.jsp");
		}

	}
}