package com.qf.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qf.domain.User;
import com.qf.utils.DbHelp;
import com.qf.utils.MD5Utils;

/**
 * Servlet Filter implementation class AutologinFilter
 */

@WebFilter(value="/login.jsp")
public class AutologinFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AutologinFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		//转换成http的请求和响应
             HttpServletRequest  req=(HttpServletRequest)request;
             HttpServletResponse rep=(HttpServletResponse)response;
            System.out.println("进入filter了。。。。。。");
             if(req.getSession().getAttribute("user")==null){
            	 //从cookie中获取之前保存的email和password
            	 Cookie[] cookies=req.getCookies();
            	 //user对象
            	 User user=null;
            	 //遍历cookie获取里面的元素
            	 for(Cookie c:cookies){
            		 //比较cookie对象中的名字和user中的名字是不是一样
            		 if(c.getName().equals("user")){
            			 String[] str=c.getValue().split("##");
            			 user=new User();
            			 user.setEmail(str[0]);
            			 user.setPassword(str[1]);
            			 break;
            		 }
            	 }
            	 if(user!=null){
            		 //自动登录的校验
            		 User user1=DbHelp.querySingle("select * from tb_user where email=?", User.class, user.getEmail());
            		 if(user1!=null){
            			 user.setPassword(MD5Utils.md5(user.getPassword()));
            			 if(user1.getPassword().equals(user.getPassword())){
            				 req.getSession().setAttribute("user",user1);
            				 System.out.println(user1);
            				 rep.sendRedirect("index.jsp");
            				 return;
            			 }
            		 }
            	 }
            		 chain.doFilter(request, response);

             }
             else{//如果已经登陆就直接放行
            	 rep.sendRedirect("index.jsp");
             }
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
