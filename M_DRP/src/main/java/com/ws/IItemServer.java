package com.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.domain.Item;



@WebService
public interface IItemServer {

	
	@WebMethod
	@WebResult
	List<Item> getAllItem();
}
