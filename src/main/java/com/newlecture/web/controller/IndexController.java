package com.newlecture.web.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.newlecture.web.entity.Exam;
import com.newlecture.web.service.ExamService;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/index")
public class IndexController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		ServletContext application = req.getServletContext();
//		ApplicationContext context = (ApplicationContext) application.getAttribute("context");
		
		this.getServletContext();
		ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		
		ExamService service = context.getBean(ExamService.class); // 객체를 구현하고 있는 객체가 여러 개일 경우 명확히 지정해줘야 함
		List<Exam> list;
		try {
			list = service.getList();
			System.out.println(list);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
