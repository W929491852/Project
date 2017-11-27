package com.qf.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qf.utils.StringUtils;
import com.qf.domain.Address;
import com.qf.domain.User;
import com.qf.service.AddressService;
import com.qf.service.imple.AddressServiceImple;

/**
 * Servlet implementation class AddAddressServlet
 */
@WebServlet("/addaddress")
//添加地址
public class AddAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAddressServlet() {
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
		// TODO Auto-generated method stub
		User user=(User)request.getSession().getAttribute("user");
		String res="1";
		if(user!=null){
			String n=request.getParameter("name");
			String p=request.getParameter("pred");
			String d=request.getParameter("detail");
			String phone=request.getParameter("phone");
			if(StringUtils.checkEmpty(n,p,d,phone)){
				AddressService addressService=new AddressServiceImple();
				Address address=new Address();
				address.setDetail(p+d);
				address.setLevel(10);
				address.setName(n);
				address.setPhone(phone);
				address.setUid(user.getId());
				if(addressService.save(address)){
					res="0";
				}
			}
			
		}else {
			res="2";
		}
		response.getWriter().print(res);
	}

}
