package com.newlecture.di;

import java.io.IOException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.newlecture.web.entity.Exam;
import com.newlecture.web.repository.Repository;
import com.newlecture.web.service.ExamService;

public class App {

	public static void main(String[] args) throws IOException {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-setting.xml");
		
		Object exam = context.getBean("exam");
		ExamService service = context.getBean(ExamService.class); // 객체를 구현하고 있는 객체가 여러 개일 경우 명확히 지정해줘야 함
		List<Exam> list =  service.getList();
		
		Repository<Exam> repository = context.getBean(Repository.class);
		List<Exam> list1 =  repository.findAll();

		System.out.println(exam);
		System.out.println(list);
		System.out.println(list1);

	}

}
