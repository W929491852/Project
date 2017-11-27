package com.controller;

import java.io.IOException;
import java.security.cert.CertPathValidatorException.Reason;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.domain.Client;
import com.domain.Data;
import com.domain.DataDict;
import com.domain.User;
import com.service.ClientService;
import com.service.DataDictService;

@Controller
public class ClientController {

	@Autowired
	private ClientService clientService;
	
	@Autowired
	private DataDictService dataDictService;

	
	@RequestMapping("basedata/addClient")
	public void addClient(String flag,Client client,HttpServletRequest request,HttpServletResponse response) throws Exception {
		if("1".equals(flag)) {
			List<DataDict> selectAllDictByCategory = dataDictService.selectAllDictByCategory("A");
			request.setAttribute("dicts", selectAllDictByCategory);
			request.getRequestDispatcher("client_add.jsp").forward(request, response);
		}else if("2".equals(flag)) {
			//获取用户
			User user = (User)request.getSession().getAttribute("user");
			client.setUser(user);
			//执行插入操作
			boolean insert = clientService.insert(client);
			//获取数据字典
			DataDict dataDict = dataDictService.select(client.getDataDict().getId());
			//修改分销商的数据字典
			client.setDataDict(dataDict);
			//向用户中设置修改后的分销商
			user.setClient(client);
			request.getSession().setAttribute("user", user);
			response.sendRedirect("client_crud.jsp");
			
		}
	}
	
	@RequestMapping("basedata/selectClient")
	public void selectClient(Client client,HttpServletRequest request,HttpServletResponse response) throws Exception {
		Client select = clientService.select(client.getClientid());
		System.out.println("----------->"+select);
		List<DataDict> selectAllDictByCategory = dataDictService.selectAllDictByCategory("A");
		request.setAttribute("dicts", selectAllDictByCategory);
		request.setAttribute("client", select);
		request.getRequestDispatcher("client_modify.jsp").forward(request, response);
		
	}
	//在添加库存时查询所有的分销商
	@RequestMapping("flowcard/selectClientSelect")
	public String selectClientSelect(Model model) {
		List<Client> selectAllClient = clientService.selectAllClient();
		System.out.println(selectAllClient);
		model.addAttribute("clients",selectAllClient);
		return "client_select.jsp";
	}
	//在添加库存是查询该分销商
	@RequestMapping("flowcard/selectClientChecked")
	public void selectClientChecked(int clientid,HttpServletResponse response) throws Exception {
		Client select = clientService.select(clientid);
		String jsonString = JSON.toJSONString(select);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(jsonString);
	}
	@RequestMapping("basedata/updateClient")
	public void updateClient(Client client,HttpServletRequest request,HttpServletResponse response) throws IOException {
		//更新分销商
		boolean updateClient = clientService.updateClient(client);
		//获取用户
		User user = (User)request.getSession().getAttribute("user");
		//获取数据字典
		DataDict dataDict = dataDictService.select(client.getDataDict().getId());
		//修改分销商的数据字典
		client.setDataDict(dataDict);
		//向用户中设置修改后的分销商
		user.setClient(client);
		request.getSession().setAttribute("user",user);
		response.sendRedirect("client_crud.jsp");
		
	}
	@RequestMapping("basedata/deleteClient")
	public void deleteClient(Client client,HttpServletResponse response,HttpServletRequest request) throws Exception{
		clientService.delete(client.getClientid());
		User user = (User)request.getSession().getAttribute("user");
		user.setClient(null);
		request.getSession().setAttribute("user",user);
		response.sendRedirect("client_crud.jsp");
	}
	

	@RequestMapping("statreport/client_level_concrete_chart")
	public void showCart(HttpServletResponse response) throws Exception {
		List<Data> clList=clientService.selectData();
		System.out.println(clList);
		String jsonString = JSON.toJSONString(clList);
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().print(jsonString);
	}
}
