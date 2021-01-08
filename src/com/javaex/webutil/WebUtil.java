package com.javaex.webutil;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebUtil {
	//필드
	//생성자
	//메소드 g/s
	//메소드 일반
	
	public static void forward(HttpServletRequest request, HttpServletResponse response,String path) throws ServletException, IOException {
		RequestDispatcher rs = request.getRequestDispatcher(path);
		rs.forward(request, response);
	}
	public static void redirect(HttpServletRequest request, HttpServletResponse response,String url) throws IOException {
		response.sendRedirect(url);
	}
}
