package com.qf.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qf.domain.User;
import com.qf.service.UserService;
import com.qf.service.imple.UserServiceImple;
import com.qf.utils.EmailUtils;
import com.qf.utils.ParamUtils;
import com.qf.utils.RandomUtils;
import com.qf.utils.StringUtils;

/**
 * Servlet implementation class RegisterUserServlet
 * 实现用户的注册
 */
@WebServlet("/register")
public class RegisterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setStatus(403);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//request.getParameterMap()
		//User user=ParamUtils.parseParam(request.getParameterMap(), User.class);
		request.setCharacterEncoding("UTF-8");
		String n=request.getParameter("username");
		String p=request.getParameter("password");
		String e=request.getParameter("email");
		String g=request.getParameter("sex");
		String msg="注册失败，重新再来";
		if(StringUtils.checkEmpty(n,p,e,g)){
			String code=RandomUtils.createActiveCode();
			User u=new User(n,p,e,g);
			UserService service=new UserServiceImple();
			if(service.add(u)){
				//发送邮件
				EmailUtils.sendEmail(u);
				//防止再次发送
				request.getSession().setAttribute("ruser", u);
				msg="";
			}
		}
		if(msg.length()>0){
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}else{
			response.sendRedirect("registersuccess.jsp");
		}
		
		
	}

}
