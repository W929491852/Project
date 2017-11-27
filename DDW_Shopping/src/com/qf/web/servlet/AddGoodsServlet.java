package com.qf.web.servlet;

import java.util.*;


import java.io.File;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;

import com.mchange.v2.async.StrandedTaskReporting;
import com.qf.domain.Goods;
import com.qf.service.GoodsService;
import com.qf.service.imple.GoodsServiceImple;
import com.qf.utils.FileHelper;
import com.qf.utils.Fileutils;


/**
 * Servlet implementation class AddGoodsServlet
 */
@WebServlet("/addgoods")
//往页面添加商品
public class AddGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddGoodsServlet() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String msg = "添加商品失败，请稍后重试";
		if (ServletFileUpload.isMultipartContent(request)) {

			DiskFileItemFactory factory = new DiskFileItemFactory();

			factory.setRepository(new File("/"));
			ServletFileUpload fileUpload = new ServletFileUpload(factory);
			fileUpload.setFileSizeMax(1024 * 1024);
			fileUpload.setSizeMax(10 * 1024 * 1024);

			try {
				List<FileItem> list = fileUpload.parseRequest(request);
				Goods gds = new Goods();
				// 当前文件上传 获取普通标签的内容
				System.out.println(list.size());
//				System.out.println(f.isInMemory()+"---"+f.getSize());
				for (FileItem f : list) {
					if (f.isFormField()) {// 非file标签
						switch (f.getFieldName()) {
						case "name":
							gds.setName(f.getString("UTF-8"));
							break;
						case "price":
							gds.setPrice((int) Math.floor((Double.parseDouble(f.getString("UTF-8")))) * 100);
							break;
						case "gtime":
							gds.setPubdate(f.getString("UTF-8"));
							break;
						case "typeid":
							gds.setTypeid(Integer.parseInt(f.getString("UTF-8")));
							break;
						case "gstar":
							gds.setStar(Integer.parseInt(f.getString("UTF-8")));
							break;
						case "intro":
							gds.setIntro(f.getString("UTF-8"));
							break;
						}

					} else {
						File dir = new File(new File(request.getServletContext().getRealPath("/")).getParent(),
								"upload");
						if (!dir.exists()) {
							dir.mkdirs();
						}
						File file = new File(dir,
								System.currentTimeMillis() + "-" + new Random().nextInt(1000) + "-" + f.getName());
						f.write(file);
						gds.setPicture(file.getName());
					}
				}
				GoodsService goodsService = new GoodsServiceImple();
				if (goodsService.save(gds)) {
					msg = "";
				}

			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		if (msg.length() == 0) {
			response.sendRedirect("getgoodsadmin");
		} else {
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("admin/addP.jsp").forward(request, response);
		}
	}
}
