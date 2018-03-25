package com.barclouds.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * LoginFilter  在web.xml中配置说明 <br>
 *   <filter>
 *        <filter-name>LoginFilter</filter-name>
 *        <filter-class>com.homer.LoginFilter</filter-class>  
 *   </filter>
 * 
 * 配置需要经过userlogin.html登陆过才能访问的区域 <br>
 * 目前配置方式仅仅是在用户访问page222.jsp的时候才走过滤器，可以配置/*, /user/*等目录进行批量网页过滤<br>
 *    <filter-mapping>
 *        <filter-name>LoginFilter</filter-name>
 *        <url-pattern>/page222.jsp</url-pattern>
 *    </filter-mapping>
 * 
 */
public class LoginFilter implements Filter {
	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		
		HttpSession session = request.getSession();
		if(session.getAttribute("userinfo") == null) {
			response.setCharacterEncoding("GBK");
			response.setContentType("text/html;charset=gbk");
//			response.setContentType("charset=gb2312");
			PrintWriter out = response.getWriter();
			out.print("<script>alert('您还没有登录，请登录...'); window.location='/BarClouds/pages/login.jsp' </script>");
			out.flush();
			out.close();

//			request.setAttribute("loginError", "您还没有登录，请登录...");
//			request.getRequestDispatcher("userlogin.html").forward(request, response);
		} else {
			arg2.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
	}
}
