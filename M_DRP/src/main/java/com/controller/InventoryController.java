package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;import com.alibaba.fastjson.serializer.ArraySerializer;
import com.domain.Inventory;
import com.service.InventoryService;

@Controller
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;
	
	@RequestMapping("flowcard/addInventory")
	public void insert(String flag,Inventory inventory,HttpServletRequest request,HttpServletResponse response) throws Exception {
		if("1".equals(flag)) {
			response.sendRedirect("inv_init_qty_add.jsp");
		}else if("2".equals(flag)) {
			boolean insert = inventoryService.insert(inventory);
			response.getWriter().println("添加成功");
		}
	}
	@RequestMapping("flowcard/selectInventory")
	public String selectInventory(Model model) {
		List<Inventory> selectInventory = inventoryService.selectInventory();
		model.addAttribute("inventorys",selectInventory);
		return "inv_init_qty_confirm.jsp";
	}
	@RequestMapping("flowcard/updateInventory")
	public void update(int[] itemNo,int[] qty,int clientid,HttpServletResponse response) throws Exception {
		System.out.println("itemNo"+Arrays.toString(itemNo));
		System.out.println("qty:"+Arrays.toString(qty));
		inventoryService.updade(qty, itemNo,clientid);
		response.getWriter().print("-------------");
	} 
}
