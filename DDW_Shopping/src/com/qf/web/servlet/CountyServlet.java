package com.qf.web.servlet;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.qf.service.CommonService;
import com.qf.service.imple.CommonServiceImple;
import com.qf.utils.StringUtils;

/**
 * Servlet implementation class CountyServlet
 */
@WebServlet("/getcounty")
public class CountyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CountyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type=request.getParameter("type");
		String param=request.getParameter("param");
		response.setContentType("text/html;charset=UTF-8");
		List<String> list=null;
		if(StringUtils.checkEmpty(type)){
			CommonService cs=new CommonServiceImple();
			switch (type) {
			case "1":
				list=cs.getprovince();
				break;
				case "2":
					if(StringUtils.checkEmpty(param)){
						list=cs.getcity(param);
					}
					break;
				case "3":
					if(StringUtils.checkEmpty(param)){
						list=cs.getcounty(param);
					}
					break;
			default:
				break;
			}
		}
		if(list==null) {
			list=new ArrayList<>();
		}
		response.getWriter().print(new Gson().toJson(list));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
