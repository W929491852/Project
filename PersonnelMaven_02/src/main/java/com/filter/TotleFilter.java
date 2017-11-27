package com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class TotleFilter
 */
@WebFilter("/*")
public class TotleFilter implements Filter {

    /**
     * Default constructor. 
     */
    public TotleFilter() {
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
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse rep=(HttpServletResponse) response;
		req.setCharacterEncoding("UTF-8");
		String path=req.getServletPath();
		/*System.out.println(path);
		if(!(path.equals("/jsp/loginForm.jsp")||path.equals("/jsp/login")||path.startsWith("/js/")||path.startsWith("/css/"))) {
			if(req.getSession().getAttribute("user_session")==null) {
				rep.sendRedirect(req.getContextPath()+"/jsp/loginForm.jsp");
				return;
			}
		}*/
		chain.doFilter(request, response);
		rep.setCharacterEncoding("UTF-8");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
