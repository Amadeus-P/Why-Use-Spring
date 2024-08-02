package com.newlecture.web.controller;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.newlecture.web.entity.Exam;
import com.newlecture.web.repository.jdbc.JDBCExamRepository;
import com.newlecture.web.service.ExamService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/exam/list") // Context 경로
@MultipartConfig(maxFileSize = 100*1024*1024, maxRequestSize = 200*1024*1024)
// fileSizeThreshold 설정한 크기를 넘어갈 때 메모리가 아닌 디스크에 저장함
// maxFileSize 각 파일의 크기 byte
// maxRequestSize 보내는 모든 파일의 총 크기
public class ListController extends HttpServlet {
	
//	@Autowired > 어떻게 DI를 할지 고민. Servlet은 Tomcat 영역이라 Spring의 영역과 분리되어 DI가 불가능하다.
//	 리스너에게 톰캣이 로드 후나 시작한 후에 설정파일을 넘겨주는
	private ExamService service;
	
	public ListController() {
		service = new ExamService(new JDBCExamRepository());
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter(); // 웹에 출력

		// csv , 잘라서 저장 > 반복문으로 테이블안에 넣음 > 웹으로 출력

//		String color = request.getParameter("c");
		
		String[] colors = request.getParameterValues("c");
//		System.out.println(colors[0]);
//		System.out.println(colors[1]);
		
		int page = 1;
		String page_str  = request.getParameter("p");
		
		if(page_str != null)
			page = Integer.parseInt(page_str);
		
		
//		Exam[] exams = service.getList();
//		List<Exam> list = service.getList();
		List<Exam> list = service.getList(page);
		String name = "";
		
//		request.setAttribute("name", name);
//		request.setAttribute("exam", list);
		request.setAttribute("list", list);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/WEB-INF/view/list.jsp").forward(request, response); // 실제jsp 경로


	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		long startTime = System.currentTimeMillis(); // UTC 1970/1/1 기준으로 측정 > 프로그램, 시스템 시간에 영향을 받음
		long startTime = System.nanoTime(); // JVM 기준으로 측정 > 다른 서버일 경우 다를 수 있음
		// http에서 읽은 파일을
		Part imgPart = req.getPart("img");
//		String imgName = imgPart.getName();
		String imgName = imgPart.getSubmittedFileName(); // 파일명
		InputStream is = imgPart.getInputStream(); // 읽기 위해 버퍼 생성
		
		
		// 웹 홈 디렉토리와 관계없는 주소에 저장함
		String path = "C:/ProjectFile/img/" + imgName;
		
		// 배포하기 위한 홈 디렉토리 + 가상 디렉토리를 지정함 > 고정된 경로가 아니라 실행 중에 경로를 찾아야 함 req.getServletContext()
		String realPath = req.getServletContext().getRealPath("/notice/upload"); // jasper > application, realpath > 절대경로(시스템경로), upload > 가상경로 
		System.out.println(realPath);
		
		String path2 = realPath + File.separator +  imgName; // File.separator  > Windows의 // 이거를 Unix 계열의 \로 바꿈 
		
		// 경로에 폴더가 없으면 만들어야 해용.
	      File file = new File(realPath);
	        if (!file.exists())
	            file.mkdirs(); // mkdirs() 폴더 여러 개 만들때  
	        
		FileOutputStream fos = new FileOutputStream(path2); // 출력버퍼

		// read()는 1byte 씩 처리함.. 큰 용량을 처리할 때 너무 느령.
//		for(int size=0;(size = is.read()) != -1;)
//			fos.write(size);
//		System.out.println(imgName);
		
		byte[] buf = new byte[1024]; // 1KB
		for(int size=0;(size = is.read(buf)) != -1;)
			fos.write(buf,0,size);
		System.out.println(imgName);
		
		long endTime = System.nanoTime();
		double runtimeNano = (endTime - startTime);
		double runtimeMilli = (endTime - startTime)/1_000_000.0;
		double runtimeSec = (endTime - startTime)/1_000_000_000.0;
		System.out.println(runtimeNano + "ns");
		System.out.println(runtimeMilli + "ms");
		System.out.println(runtimeSec + "s");
		
//		근데 서버 바꾸거나 지우면 배포경로에 업로드한 데이터 다 날라감
		is.close();
		fos.close();

	}
}
