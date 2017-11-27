package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.domain.FlowCardDetail;
import com.domain.User;
import com.service.FlowCardDetailService;
import com.service.FlowCardMatserService;

@Controller
public class FlowCardMasterController {

	@Autowired 
	private FlowCardMatserService flowCardMatserService;
	
	@Autowired
	private FlowCardDetailService flowCardDetailService;
	@RequestMapping("flowcard/flowCardDetailAdd")
	public void flowCardMasterAdd(HttpSession session,HttpServletResponse response,int clientId,int[] itemNo,int[] aimId,int[] qty) throws Exception {
		User user=(User) session.getAttribute("user");
		if(user!=null) {
			flowCardMatserService.insert(clientId, itemNo, aimId, user.getUsername(),qty);
			response.getWriter().println("--------------------");
		}
	}
	@RequestMapping("flowcard/flowCardSelect")
	public String flowCardSelect(Model model) {
		
		model.addAttribute("flows",flowCardMatserService.select());
		return "flow_card_maint.jsp";
	}
	@RequestMapping("flowcard/selectDetail")
	public String selectDetail(int id,Model model) {
		
		List<FlowCardDetail> select = flowCardDetailService.select(id);
		System.out.println("流向详情:"+select);
		model.addAttribute("flowmaster", select.get(0).getFlowCardMaster());
		model.addAttribute("flows", select);
		return "flow_card_detail.jsp";
	}
}
