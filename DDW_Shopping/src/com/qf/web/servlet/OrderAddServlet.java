package com.qf.web.servlet;

import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.event.MenuDragMouseEvent;

import com.qf.domain.Order;
import com.qf.domain.User;
import com.qf.domain.Cart;
import com.qf.service.CartService;
import com.qf.service.OrderService;
import com.qf.service.imple.CartServiceImple;
import com.qf.service.imple.OrderServiceImple;
import com.qf.utils.RandomUtils;
import com.qf.utils.StringUtils;

/**
 * Servlet implementation class OrderAddServlet
 */
//添加订单
@WebServlet("/orderadd")
public class OrderAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		    User user=(User)request.getSession().getAttribute("user");
		    boolean res=false;
		    if(user!=null){
		    	String money=request.getParameter("money");
		    	String aid=request.getParameter("aid");
		    	if(StringUtils.checkEmpty(money,aid)&& aid.matches("[0-9]{1,}") && money.matches("[0-9]{1,}")){
		    		OrderService orderService=new OrderServiceImple();
		    		CartService cartService=new CartServiceImple();
		    		List<Cart> list=cartService.queryAll(user.getId());
		    		Order order=new Order();
		    		order.setAid(Integer.parseInt(aid));
		    		order.setId(RandomUtils.createOrderId());
		    		order.setUid(user.getId());
		    		order.setMoney(Integer.parseInt(money));
		    		System.out.println("添加属性到数据库了");
		    		if(orderService.save(order, list)){
		    			res=true;
		    			response.sendRedirect("pay.jsp");
		    		}
		    		
		    		
		    	}
		    }else {
				response.sendRedirect("login.jsp");
			}
			if(!res) {
				response.sendRedirect("index.jsp");
			}
		
	}

}
