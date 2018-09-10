package com.cubic.SessionDemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		String name=req.getParameter("uname");
		Cookie ck=new Cookie("name",name);
		ck.setMaxAge(300);
		resp.addCookie(ck);
		out.println("Welcome "+name);
		out.println("You'r Logged in");
		out.println("<br><br><br>");
		RequestDispatcher rd=req.getRequestDispatcher("link.html");
		rd.include(req, resp);
	}
}
