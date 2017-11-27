package com.qf.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qf.utils.StringUtils;
import com.google.gson.Gson;
import com.qf.domain.Goods;
import com.qf.domain.PageBean;
import com.qf.service.GoodsService;
import com.qf.service.imple.GoodsServiceImple;

/**
 * Servlet implementation class getgoodsServlet
 */
@WebServlet("/getgoods")
//商品分页
public class getgoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public getgoodsServlet() {
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
		GoodsService goodsService = new GoodsServiceImple();
		StringBuffer sBuffer = new StringBuffer();
		// 页数
		String p = request.getParameter("page");
		// 每页显示的条数
		String c = request.getParameter("count");
		
		int page = 1, count = 20;
		if (StringUtils.checkEmpty(p, c)) {
			page = Integer.parseInt(p);
			count = Integer.parseInt(c);
		}
		String t = request.getParameter("typeid");
		if (StringUtils.checkEmpty(t)) {
			sBuffer.append("and g.typeid=" + t);
		}
		String name = request.getParameter("name");
		if (StringUtils.checkEmpty(name)) {
			sBuffer.append("and g.name like '%" + name + "%'");
		}
		if (sBuffer.indexOf("and") < 2) {
			sBuffer.delete(0, sBuffer.indexOf("and") + 3);
		}
		PageBean<Goods> pBean = new PageBean<>();

		pBean.setList(goodsService.queryAll(page, count, sBuffer.toString()));

		int ct = goodsService.queryCount(sBuffer.toString());
		pBean.setTotalPage(ct % count == 0 ? ct / count : ct / count + 1);
		pBean.setCount(count);
        pBean.setCurrPage(page);
        System.out.println(new Gson().toJson(pBean));
        System.out.println("------------");
        request.setAttribute("pb", pBean);
        request.getRequestDispatcher("product.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
