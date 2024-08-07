package com.newlecture.web.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Dispatcher 직접 구현 > tomcat에게 Spring Dispatcher를 관여하도록 설정하기 > xml or @?
//@WebServlet(urlPatterns = "/", loadOnStartup = 1, initParams = {
//		@WebInitParam(name="path", value="/WEB-INF/app.properties"),
//		@WebInitParam(name="spring", value="/WEB-INF/spring-dispatcher.xml")
//})
public class DispatcherServlet extends HttpServlet implements Controller {
	
	//	Properties is a Map
//	private Properties props;
//	private Map<Class, String> map;
	private ApplicationContext context;
	
	// 생명주기 : 요청과 관계없이 객체가 생성될때 실행되는 init()
//	@Override
//	public void init(ServletConfig config) throws ServletException {
//		props = new Properties();
//		String path = config.getInitParameter("path");
//		try {
//			String realPath = config.getServletContext().getRealPath(path);
//			System.out.println(realPath);
//			InputStream is = new FileInputStream(realPath);
//			props.load(is);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	@Override
	public void init(ServletConfig config) throws ServletException {
		
		String path = config.getInitParameter("spring");
		String realPath = config.getServletContext().getRealPath(path);
		
		// https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/support/ClassPathXmlApplicationContext.html
//		context = new ClassPathXmlApplicationContext("xml", "xml");
		
		// https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/support/FileSystemXmlApplicationContext.html
//		context = new FileSystemXmlApplicationContext(realPath);
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uri = req.getRequestURI();
//		Object controller = context.getBean(uri);
//		Controller controller = (Controller)context.getBean(uri);
//		if(controller == null) {
//			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
//			return;
//		}
		try { // Spring 3.0 이하 어노테이션 지원X, MVC 라이브러리를 이용한 구현
//			Object bean = context.getBean(uri);
			Controller controller = (Controller)context.getBean(uri);

			// request를 통해 return한 mv를 꺼내는 작업
			ModelAndView mv = controller.handleRequest(req, resp); 

			for(Map.Entry<String, Object> en : mv.getModel().entrySet()) {
				req.setAttribute(en.getKey(), en.getValue());
				System.out.println(en.getKey());
				System.out.println(en.getValue());
			}
			
			System.out.println(mv.getViewName());
			req.getRequestDispatcher(mv.getViewName()).forward(req, resp);
			
		}catch (Exception e) {
			// TODO: handle exception
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		

//		String uri = req.getRequestURI();
//		System.out.println(uri); // 브라우저가 필요한 데이터를 문자열로 요청하는 대로 여러 번 출력함
////		System.out.println(req.getRequestURL());
////		Class clazz = map.get(uri);
//		
//		String className = props.getProperty(uri);
//		System.out.println(className);
//		if(className == null)
//			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
//		
//		System.out.println("dis");

	}
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
