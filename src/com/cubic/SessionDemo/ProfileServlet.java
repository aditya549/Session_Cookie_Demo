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
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=resp.getWriter();
		Cookie ck[]=req.getCookies();
		if(ck.length!=0) {
				String name=ck[0].getValue();
				out.println("Welcome To Profile" +name);
				out.println("Profile View");
				
		}else {
		out.println("Please Login First To view Profile");
		RequestDispatcher rd1=req.getRequestDispatcher("Login.html");
		rd1.include(req, resp);
		}
	}
}
