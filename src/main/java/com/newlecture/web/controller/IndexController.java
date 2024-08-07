package com.newlecture.web.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.newlecture.web.entity.Exam;
import com.newlecture.web.service.ExamService;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet("/index")
public class IndexController extends HttpServlet implements Controller {
	
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

//	https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/servlet/ModelAndView.html
	// Controller가 Model하고 View를 Return하기 위해 만들어진 Interface
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("/WEB-INF/view/index.jsp");
		mv.addObject("test", "Hello"); //  Add an attribute to the model.
		System.out.println(mv.toString());
		// mv를 return하면 request를 통해 공유해서 DispatcherServlet에서 꺼냄
		return mv;
	}
}
