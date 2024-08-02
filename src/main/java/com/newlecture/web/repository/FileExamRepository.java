package com.newlecture.web.repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Component;

import com.newlecture.web.entity.Exam;

@Component("id") // <bean/> 빈 태그와 역할이 비슷해요. (id) 설정으로 따로 이름을 줄 수 있는데 기본값은 FileExamRepository 에요.
public class FileExamRepository implements Repository<Exam> {
	
//	public List<Exam> findAll(int page) throws IOException { // 목록 주세요.
//		return findAll(1);
//	}
//	
		public List<Exam> findAll() throws IOException {
		
//		int[] kors = new int[6];
//		Exam[] exams = new Exam[6];
		
		List<Exam> list = new ArrayList<>();
		
		int kor, eng, math;
		String name = "";
//		int total;
//		double avg;
//		String grade = "F";
		
		FileInputStream fis = new FileInputStream("C:/ProjectFile/academy/academyJava/src/res/menu.csv");
		Scanner scan = new Scanner(fis);
//		StringBuilder htmlBuilder = new StringBuilder(); // 문자열을 더하는 반복 작업을 시간 단축

		scan.nextLine(); // 컬럼명 버리기

		for (int i = 0; scan.hasNextLine() && i < 6; i++) {

			// -----------------------------
			String line = scan.nextLine();
			String[] tokens = line.split(",");
			// System.out.printf("tokens:", Arrays.toString(tokens));

			name = tokens[0];
			// 문자열 토큰 값을 숫자로 변경
			if (isNumeric(tokens[1]))
				kor = Integer.parseInt(tokens[1]);
			else
				kor = 0;

			// 유효성 검사
			if (!(0 <= kor && kor <= 100))
				kor = 0;

			// ----------------------------------

			// kor 성적 대입
			// tokens 값이 숫자 형식이 아니라면 초기값을 0으로 한다.
			if (!isNumeric(tokens[2]))
				eng = 0;
			else
				eng = Integer.parseInt(tokens[2]);

			// kor 값의 유효성 검사
			if (!(0 <= eng && eng <= 100))
				eng = 0;

			// eng 성적 대입
			// tokens 값이 숫자 형식이 아니라면 초기값을 0으로 한다.
			if (!isNumeric(tokens[3]))
				math = 0;
			else
				math = Integer.parseInt(tokens[3]);

			// eng 값의 유효성 검사
			if (!(0 <= math && math <= 100))
				math = 0;

			
//			kors[i] = kor;
//			exams[i] = new Exam(name, kor, eng, math);
			
			list.add(new Exam(name, kor, eng, math));
			

//		    out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\t%s\n"
//		                    ,name,kor,eng,math,total,avg,grade);
		} // for끝
		scan.close();
		fis.close();
		return list;
	}
	
	public static boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	@Override
	public int save() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update() {
		// TODO Auto-generated method stub
		return 0;
	}

	
}