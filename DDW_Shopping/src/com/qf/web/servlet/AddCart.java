package com.qf.web.servlet;

import java.io.IOException;

import javax.management.relation.RelationSupportMBean;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qf.domain.Goods;
import com.qf.domain.User;
import com.qf.domain.Cart;
import com.qf.service.CartService;
import com.qf.service.GoodsService;
import com.qf.service.imple.CartServiceImple;
import com.qf.service.imple.GoodsServiceImple;
import com.qf.utils.StringUtils;

/**
 * Servlet implementation class AddCart
 */
@WebServlet("/addcart")
//添加商品到购物车
public class AddCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddCart() {
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
		     request.setCharacterEncoding("utf-8");
		User user = (User) request.getSession().getAttribute("user");
		// 0添加成功 1是没有登录
		int res = 1;
		if (user != null) {
			String id = request.getParameter("id");
			
			String price = request.getParameter("price");
			if (StringUtils.checkEmpty(id, price)) {
				CartService cartService = new CartServiceImple();
				GoodsService gs=new GoodsServiceImple();
			   Goods gs1=gs.queryById(Integer.parseInt(id));
				
				Cart cart = new Cart();
				cart.setId(user.getId());
				cart.setMoney(Integer.parseInt(price));
				cart.setPrice(Integer.parseInt(price));
				cart.setPname(gs1.getName());
				cart.setNum(1);
				cart.setPid(Integer.parseInt(id));
				System.out.println(cart);
				cartService.save(cart);
				res = 0;
				System.out.println("----sadas------");
				response.sendRedirect("cartsucess.jsp");
			}
			System.out.println("----sadas---sadad---");
		} else {
			System.out.println("----sadas-----");
			response.sendRedirect("login.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		

	}

}
