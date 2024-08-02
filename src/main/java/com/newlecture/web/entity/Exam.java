package com.newlecture.web.entity;

import com.newlecture.annotations.Num;
import com.newlecture.annotations.Precision;

//import java.beans.Transient;

import com.newlecture.annotations.Transient;

@Precision
public class Exam { // 속성 get set 생성자 toString 오버로드생성자
	String name;
	int kor;
	int eng;
	int math;
	
	
	public Exam() {
		this("",0,0,0); // 생성자는 이름이 없어서 부를 수 있는 방법이 없음
		
//		매개변수가 가장 많은 것만 구현, 매개변수가 적은 생성자는 값만 전달함
		
//		name = "";
//		kor = 0;
//		eng = 0;
//		math = 0;
	}
	public Exam(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	@Num
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	
	public int getTotal() {
		return kor + eng + math;
	}
	@Precision()
	public double getAvg() {
		return getTotal()/3.0;
	}

	@Transient
	public String getGrade() {
		String grade = "F";
		double avg = getAvg();		

		if (90 <= avg)
			grade = "A";
		else if (80 <= avg)
			grade = "B";
		else if (70 <= avg)
			grade = "C";
		else if (60 <= avg)
			grade = "D";
		else if (50 <= avg)
			grade = "E";
		 else
			 grade = "F";
		return grade;
	}
	@Override
	public String toString() {
		return "Exam [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + "]";
	}
	
	
	

}
