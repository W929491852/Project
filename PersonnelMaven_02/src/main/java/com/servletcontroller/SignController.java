package com.servletcontroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.domain.Sign;
import com.service.SignService;
import com.utils.PageUtils;

@Controller
public class SignController {

	@Autowired
	private SignService signService;
	@RequestMapping("/jsp/sign/addSign")
	public void addSign(String flag,String user_id,HttpServletResponse response) throws IOException {
		Sign selectSign = signService.selectSign(user_id);
		if("1".equals(flag)) {
			if(selectSign!=null) {
				response.getWriter().print("1");
			}
		}else if("2".equals(flag)) {
			if(selectSign==null) {
				boolean addSign = signService.addSign(user_id);
				if(addSign) {
					response.getWriter().print("1");
				}else {
					response.getWriter().print("-1");
				}
			}else {
				response.getWriter().print("0");
			}
		}
	}
	@RequestMapping("/jsp/sign/selectSign")
	public String selectSign(String startDate,String endDate,String pageIndex,Model model) {
		if(pageIndex==null) {
			pageIndex="1";
		}
		List<Sign> selectAllSign = signService.selectAllSign(startDate, endDate,pageIndex);
		int size = signService.selectAllSign(startDate, endDate,"").size();
		model.addAttribute("pageModel", PageUtils.getPage(Integer.parseInt(pageIndex), size));
		model.addAttribute("signs", selectAllSign);
		return "/jsp/sign/sign.jsp";
	}
}
