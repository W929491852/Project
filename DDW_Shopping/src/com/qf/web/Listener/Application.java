package com.qf.web.Listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.qf.service.GoodsTypeService;
import com.qf.service.imple.GoodsTypeServiceImple;

/**
 * Application Lifecycle Listener implementation class Application
 *
 */
@WebListener
public class Application implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public Application() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
        GoodsTypeService goodsTypeService=new GoodsTypeServiceImple();
       System.out.println("--------------------"+goodsTypeService.queryAll().size());
        sce.getServletContext().setAttribute("types", goodsTypeService.queryAll());
    }
	
}
