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
import com.qf.utils.Base64Utils;
import com.qf.utils.StringUtils;


/**
 * Servlet implementation class ActiveServlet
 */
@WebServlet("/active")
//激活码
public class ActiveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActiveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	   String email=request.getParameter("email");
	   String code=request.getParameter("code");
	   UserService userService=new UserServiceImple();
	   User user=null;
	   System.out.println(email+"-------"+code);
	   String msg="你这个不太对啊好像";
	   if(StringUtils.checkEmpty(email,code)){
		   code=Base64Utils.decoder(code);
		   email=Base64Utils.decoder(email);
		   user=userService.selectByemailcode(email, code);
		
		  if(user!=null){
               		  boolean updatarole = userService.updatarole(email);
               		  System.out.println("打印role:"+updatarole);
               		  userService.updataflag(email);
               		  request.getSession().setAttribute("user",user);
               		  
               		  System.out.println("成功激活");
               		  request.getRequestDispatcher("index.jsp").forward(request, response);
		  }else {
			System.out.println("未成功激活");
			response.sendRedirect("register.jsp");
		}
	   }
	   
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
