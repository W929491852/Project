package com.qf.web.servlet;

import java.io.IOException;
import java.nio.channels.ScatteringByteChannel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qf.domain.User;
import com.qf.domain.Cart;
import com.qf.service.CartService;
import com.qf.service.imple.CartServiceImple;
import com.qf.utils.StringUtils;

/**
 * Servlet implementation class UpdateCartNum
 */
@WebServlet("/updatecartnum")
//改变购物车物品的数量，，需要参数type:1加1,2：减1,3：删除
public class UpdateCartNum extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCartNum() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user=(User)request.getSession().getAttribute("user");
		System.out.println("我是购物车数量加一的");
		int res=0;
		if(user!=null){
			String t=request.getParameter("type");
	        String pid=request.getParameter("pid");
	        String price=request.getParameter("price");
	        String num=request.getParameter("num");
	        if(StringUtils.checkEmpty(t,pid,price,num)){
	        	CartService cartService=new CartServiceImple();
	        	Cart cart=new Cart();
	        	cart.setId(user.getId());
	            cart.setPid(Integer.parseInt(pid));
	        	cart.setNum(Integer.parseInt(num));
	        	cart.setPrice(Integer.parseInt(price));
	        	cart.setMoney(cart.getNum()*cart.getPrice());	
	        	System.out.println("我进入购物车数量的servlet了");
	        	if(cartService.changeNum(cart, Integer.parseInt(t))){
	        		res=cart.getNum()==0?1:cart.getNum();	
	        	}
	        	
	        }
	        
		}else {
			res=-1;
		}
	response.getWriter().print(res);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
