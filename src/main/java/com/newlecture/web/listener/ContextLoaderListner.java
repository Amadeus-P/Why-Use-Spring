package com.newlecture.web.listener;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.newlecture.web.entity.Exam;
import com.newlecture.web.service.ExamService;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;


//@WebListener // tomcat > 직접 리스너를 구현하지않고  스프링 리스너를 사용하기 위해 주석
public class ContextLoaderListner implements ServletContextListener {
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		// 설정파일을 유동적으로 바꾸기 위해
		String xml = "spring-setting2.xml";
		Object location = sce.getServletContext().getInitParameter("location");
		if(location != null)
			xml = String.valueOf(location);
		
		System.out.println("c");
		ApplicationContext context = new ClassPathXmlApplicationContext(xml);
		
		sce.getServletContext().setAttribute("context", context);
		

		
		System.out.println("c");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("xc");
	}

}
