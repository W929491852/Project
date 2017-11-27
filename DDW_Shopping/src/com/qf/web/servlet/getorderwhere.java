package com.qf.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qf.service.OrderService;
import com.qf.service.imple.OrderServiceImple;
import com.qf.utils.StringUtils;

/**
 * Servlet implementation class getorderwhere
 */
@WebServlet("/getorderwhere")
public class getorderwhere extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getorderwhere() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String s=request.getParameter("stime");
		String e=request.getParameter("etime");
		String w=request.getParameter("where");
		StringBuffer buffer=new StringBuffer();
		if(StringUtils.checkEmpty(s)) {
			buffer.append(" and time >='"+s+" 00:00:00'");
		}
		if(StringUtils.checkEmpty(e)) {
			buffer.append(" and time <='"+e+" 23:59:59'");
		}
		if(buffer.indexOf("and")==1) {
			buffer.delete(0,buffer.indexOf("and")+3);
		}
		OrderService service=new OrderServiceImple();
		request.setAttribute("orders", service.queryAll(buffer.toString()));
		request.getRequestDispatcher("admin/orderlist.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
