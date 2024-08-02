package com.newlecture;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
//import java.beans.Transient;
import java.lang.reflect.Method;
import java.math.BigDecimal;

import com.newlecture.annotations.Num;
import com.newlecture.annotations.Precision;
import com.newlecture.annotations.Transient;
import com.newlecture.web.entity.Exam;

public class CSVParser { // 객체의 제네릭 위치

	// exam을 CSV로 바꿔주세요.
	public static <T> String toCSV(T entity) throws IllegalAccessException, InvocationTargetException {
		StringBuilder builder = new StringBuilder();
		
		Class clazz = entity.getClass();
		
		{
			Field[] fields = clazz.getDeclaredFields();
			
			for(Field f : fields) {
				if(f.isAnnotationPresent(Transient.class)) {
					f.setAccessible(true); // private일 경우 접근가능하게
					Object value = f.get(entity);
					builder.append(value);
				}
			}
		}
		
		{
	//		Method[] methods = clazz.getMethods();
			Method[] methods = clazz.getDeclaredMethods(); // 메서드를 가져옴
			
			for(Method m : methods) {
				String name = m.getName(); // 모든 exam 메서드 중에서
				if(name.startsWith("get")) // get으로 시작하는 것만
	//			if(m.getAnnotation(Transient.class) == null)
				if(!m.isAnnotationPresent(Transient.class)) { // Transient 클래스 제외하고
					Object value = m.invoke(entity, null); // exam 속성에 null을 추가(name, kor, eng, math, avg, total) > 나중에 추가하면 됨
				if(m.isAnnotationPresent(Precision.class)) {
					Precision precision = m.getAnnotation(Precision.class); // Precision타입으로 가져와서
					int v = precision.value(); // @ 설정한 속성 변수에 저장하고
					value = String.format("%." + v + "f",value);
				}
				builder.append(value); // Object를 String으로 바꾸고 value, value, 형식으로 추가
				builder.append(",");
				}
			}
			return builder.toString();
		} // toCSV end
	}
//	public static <T> int setNum(T entity) {
//
//		Class clazz = entity.getClass();
//
//		Method[] methods = clazz.getDeclaredMethods();
//		
//		for(Method m : methods) {
//			if(m.isAnnotationPresent(Num.class))
//				entity.setEng(10);
//		}
//		return entity.getEng();
//	} // serNum end

} // CSVParser end
