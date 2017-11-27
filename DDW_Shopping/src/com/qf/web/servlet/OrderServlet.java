package com.qf.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qf.domain.User;
import com.qf.service.AddressService;
import com.qf.service.CartService;
import com.qf.service.imple.AddressServiceImple;
import com.qf.service.imple.CartServiceImple;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/getorderview")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
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
			CartService cartService=new CartServiceImple();
			request.setAttribute("list",cartService.queryAll(user.getId()) );
			AddressService addressService=new AddressServiceImple();
			request.setAttribute("as", addressService.queryAll(user.getId()));
			System.out.println("把购物车啥的都放进订单里");
			request.getRequestDispatcher("order.jsp").forward(request, response);
             
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
