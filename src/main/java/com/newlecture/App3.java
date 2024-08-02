package com.newlecture;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.newlecture.web.entity.Exam;

public class App3 {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {

		{
		Exam exam = new Exam();
		
		exam.setName("sssss");
		exam.setKor(10);
		exam.setEng(25);
		exam.setMath(30);
		
		String csv = CSVParser.toCSV(exam);
//		int csv1 = CSVParser.setNum(exam);
		
		System.out.println(csv); // 직렬화 필요
//		System.out.println(csv1);
		}
		
		{
			
		}
		

//		String className = "com.newlecture.web.entity.Exam";
//		String callMethodName = "setName";
//		String value = "newlec";
//		
//		// 객체 생성 방법
//		Exam exam = new Exam();
//		
//		// 이름만 아는 외부 파일을 입력받을 때 > 코드를 수정하지 않기 위해 직접 생성하지 않고 이름을 가져옴 > 라이브러리의 작동방식
//		Object obj = Class.forName(className).getDeclaredConstructor().newInstance();
//		
//		System.out.println(obj);
//		
//		Class clazz = exam.getClass();
//		Class clazz2 = Exam.class;
//		
//		Method[] methods = clazz.getDeclaredMethods();
//		
//		for(Method m : methods) {
////			System.out.println(m.getName());
//			if(m.getName().equals(callMethodName))
//				m.invoke(obj, value);
//		}
//		
////		exam2.setKor(30);
//		System.out.println(obj);
	}

}
