package com.newlecture.web.repository.jdbc;

import java.util.ArrayList;
import java.util.List;

import com.newlecture.web.entity.Exam;
import com.newlecture.web.repository.Repository;

public class JDBCExamRepository implements Repository<Exam>{

	@Override
	public List<Exam> findAll() {
		List<Exam> list = new ArrayList<>();
		return list;
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
