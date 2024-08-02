package com.newlecture.web.repository;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.newlecture.web.entity.Exam;

// 접점을 가진 추상화된 자료형
// 구현체(클래스) 없이 기능을 구현하겠다는 약속을 가짐
// 구현을 참조하기 위한 형식 정의

// 추상클래스와 같이 공통 자료형을 만들 수 있다.
// 하지만 클래스(구현체)가 아니라서 기능을 만들기 위해 참조할 수 있는 형식만 제공함

// 클래스의 타입과 관계없이 공통 기능에 집중함
@Component("ㅁ")
public interface Repository<T> {
	public static final int x = 0;
	List<T> findAll() throws IOException;
	int save();
	int update();
	
	
//	List<Exam> findAll();


}
