package com.qf.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qf.service.GoodsService;
import com.qf.service.imple.GoodsServiceImple;
import com.qf.utils.StringUtils;

/**
 * Servlet implementation class goodsdetailServlet
 */
@WebServlet("/getgoodsbyid")
//通过id查询商品 返回到商品详情页面
public class goodsdetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public goodsdetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		        String id=request.getParameter("id");
		        if(StringUtils.checkEmpty(id)&&id.matches("[0-9]{1,}")){
		        	GoodsService service=new GoodsServiceImple();
		        	request.setAttribute("goods", service.queryById(Integer.parseInt(id)));
		        	request.getRequestDispatcher("productdetail.jsp").forward(request, response);
		        }else {
					response.sendRedirect("getgoods");
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
