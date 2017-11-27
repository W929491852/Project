package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.domain.Accounts;
import com.domain.User;
import com.service.AccountsService;

@Controller
public class AccountsController {

	@Autowired
	private AccountsService accountsService;
	
	@RequestMapping("basedata/addAccounts")
	public void addAccounts(String flag,Accounts accounts ,HttpServletRequest request,HttpServletResponse response) throws Exception {
		if("1".equals(flag)) {
			response.sendRedirect("fiscal_year_period_add.jsp");
		}else if("2".equals(flag)) {
			User user=(User)request.getSession().getAttribute("user");
			System.out.println("添加是否可用"+accounts.getPeriodsts());
			if(accounts.getPeriodsts()==null) {
				accounts.setPeriodsts("不是");
			}else {
				accounts.setPeriodsts("是");
			}
			accounts.setUser(user);
			accountsService.insert(accounts);
			response.sendRedirect("selectAccounts");
		}
	}
	@RequestMapping("basedata/selectAccounts")
	public void selectAll(HttpServletRequest request,HttpServletResponse response) throws Exception {
		request.setAttribute("accounts",accountsService.selectAll());
		request.getRequestDispatcher("fiscal_year_period_maint.jsp").forward(request, response);
	}
	@RequestMapping("basedata/updateAccounts")
	public void update(String flag,Accounts accounts,HttpServletRequest request,HttpServletResponse response) throws Exception {
		if("1".equals(flag)) {
			request.setAttribute("account",accountsService.select(accounts.getId()));
			request.getRequestDispatcher("fiscal_year_period_modify.jsp").forward(request, response);
		}else if("2".equals(flag)) {
			System.out.println("xiugai是否可用"+accounts.getPeriodsts());
			if(accounts.getPeriodsts()==null) {
				accounts.setPeriodsts("不是");
			}else {
				accounts.setPeriodsts("是");
			}
			accountsService.update(accounts.getPeriodsts(), accounts.getId());
			response.sendRedirect("selectAccounts");
		}
	}
	@RequestMapping("basedata/deleteAccounts")
	public void delete(String ids,HttpServletResponse response) throws Exception {
		accountsService.delete(ids);
		response.sendRedirect("selectAccounts");
	}
}
