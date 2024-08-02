package com.newlecture.di;

import java.io.IOException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.newlecture.web.entity.Exam;
import com.newlecture.web.service.ExamService;

public class App3 {
	
	int x =3;
	
	public App3() {
		System.out.println(x); // 생성자가 먼저 실행되면 0, 필드 변수가 먼저 실행되면 3
		x =4;
		System.out.println(x);
	}

	public static void main(String[] args) throws IOException {
		new App3();
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-setting2.xml");
		
		ExamService service = context.getBean(ExamService.class); // 객체를 구현하고 있는 객체가 여러 개일 경우 명확히 지정해줘야 함
		List<Exam> list =  service.getList();
		
		System.out.println(list);
	}

}
