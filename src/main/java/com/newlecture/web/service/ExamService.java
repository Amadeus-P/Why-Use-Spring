package com.newlecture.web.service;


import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.newlecture.web.entity.Exam;
import com.newlecture.web.repository.Repository;
import com.newlecture.web.repository.FileExamRepository;

@Component
public class ExamService {
	
	@Autowired
	private Repository<Exam> repository; // null
	
	public ExamService() {

	}
	
//	@Autowired
	public void setRepository(Repository<Exam> repository) {
		this.repository = repository;
	}

//	@Autowired
	public ExamService(Repository<Exam> repository) { // 서버 시작할 때마다 한 번
		this.repository = repository;
//		this.repository = new FileExamRepository(); // 객체 넣어줌
	}
	
	
	public List<Exam> getList() throws IOException {
		return getList(1);
	}
	
	public List<Exam> getList(int page) throws IOException { // 목록 주세요.
		
		List<Exam> list = repository.findAll();
		
		return list;
	}


}
