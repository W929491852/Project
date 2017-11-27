package com.qf.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qf.domain.User;
import com.qf.service.OrderService;
import com.qf.service.imple.OrderServiceImple;
import com.qf.utils.StringUtils;

/**
 * Servlet implementation class OrderDetailServlet
 */
//用户的订单详情哦哦哦哦
@WebServlet("/orderdetail")
public class OrderDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	     User user=(User)request.getSession().getAttribute("user");
	     if(user!=null){
	    	 
	    	 String oid=request.getParameter("id");
	    	 if(StringUtils.checkEmpty(oid)){
	    		 OrderService orderService=new OrderServiceImple();
	    		 request.setAttribute("od", orderService.queryById(oid, user.getId()));
	    		 System.out.println("订单详情");
	    		 request.getRequestDispatcher("orderdetail.jsp").forward(request, response);
                 
	    	 }else {
				response.sendRedirect("index.jsp");
			}
	     }else {
				response.sendRedirect("login.jsp");
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
