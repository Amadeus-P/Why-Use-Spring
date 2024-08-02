package com.newlecture.di;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.newlecture.web.entity.Exam;
import com.newlecture.web.repository.FileExamRepository;
import com.newlecture.web.repository.Repository;

public class App2 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		// Context 데이터를 이어주는 데이터 객체, ApplicationContext >  앱 전체를 이어주는 데이터 객체
		ApplicationContext context;
		
		// 앱 전체에서 어노테이션 설정한 범위를 지정해서, 지정한 패키지 안에서 찾게함 
		context = new AnnotationConfigApplicationContext("com.newlecture.web");
		
//		getBean의 호출 방식
//		Repository<Exam> repository = context.getBean(Repository.class);
//		Repository<Exam> repository =(Repository)context.getBean("id"); // return : Object
		Repository<Exam> repository = context.getBean(FileExamRepository.class);
		
		// @Component("id") > 다형성
		// xml <bean>
		// getBean(ClassName.class);
		
		List<Exam> list1 =  repository.findAll();
		
		System.out.println(list1);
		
		String realPath;
		{ // 상대경로
			String pak ="com.newlecture.web.repository";
			String path = pak.replace(".", "/");
			
			System.out.println(path);

			ClassLoader classLoader = App2.class.getClassLoader();
//			Class clazz = classLoader.loadClass(path);
			
			realPath = classLoader.getResource(path).getFile().toString(); // getFile() file: 제거
			realPath = realPath.substring(1, realPath.length()); // /제거
			System.out.println("real-path > " + realPath);
			
//			Exam exam = new Exma();
//			exam.getClass();
//			Exam.class;
//			Class.forName("com.newlecture.web.entity.Exam");
//			App2.class.getClassLoader().loadClass("");
			
		}
		
		
		{ // 절대경로
//			String path = "C:\\ProjectFile\\javaprj\\src\\main\\java\\com\\newlecture";
			
			File directory = new File(realPath);
			String[] names = directory.list();
			for(String name : names) 
					System.out.println(name);
			
//			File[] files = directory.listFiles();
//			for(File f : files) {				
//				String type ="";
//				if(f.isDirectory())
//					type = "dir";
//				else
//					type = "file";
//				System.out.printf("%s > %s\n",type, f.getName());
//			}
			
		}
		
		
		
		
	}

}
