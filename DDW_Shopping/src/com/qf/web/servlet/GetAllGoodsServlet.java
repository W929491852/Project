package com.qf.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qf.utils.StringUtils;
import com.qf.domain.Goods;
import com.qf.domain.PageBean;
import com.qf.service.GoodsService;
import com.qf.service.imple.GoodsServiceImple;

/**
 * Servlet implementation class GetAllGoodsServlet
 */
@WebServlet("/getgoodsadmin")
//后台查看商品
public class GetAllGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetAllGoodsServlet() {
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
		// 获取商品
		GoodsService goodsService = new GoodsServiceImple();
		StringBuffer buffer = new StringBuffer();
		String id = request.getParameter("id");
		if (StringUtils.checkEmpty(id)) {
			buffer.append("and g.id like '%" + id + "%'");
		}
		String t = request.getParameter("type");
		if (StringUtils.checkEmpty(t)) {
			buffer.append("and g.typeid=" + t);
		}
		String name = request.getParameter("name");
		if (StringUtils.checkEmpty(name)) {
			buffer.append("and g.name like '%" + name + "%'");
		}
		String maxp = request.getParameter("maxprice");
		if (StringUtils.checkEmpty(maxp)) {
			buffer.append("and g.price <= " + Double.parseDouble(maxp) * 100);
		}
		String minp = request.getParameter("minprice");
		if (StringUtils.checkEmpty(minp)) {
			buffer.append("and g.price >= " + Double.parseDouble(minp) * 100);
		}
		if (buffer.indexOf("and") < 2) {
			buffer.delete(0, buffer.indexOf("and") + 3);
		}
		System.out.println("-------"+buffer.toString());
		PageBean<Goods> pb = new PageBean<>();
		pb.setList(goodsService.queryAll(0, 0, buffer.toString()));
		request.setAttribute("pb", pb);
		request.getRequestDispatcher("admin/listP.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);

	}
}
