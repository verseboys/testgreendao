package com.testgreendao.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testgreendao.test.pojo.Father;
import com.testgreendao.test.pojo.FatherDAOImpl;
import com.testgreendao.test.service.FatherService;

@Service
public class FatherServiceImpl implements FatherService{
	
	@Autowired
	private  FatherDAOImpl fatherDAOImpl; 
	

	@Override
	public Father findById(Integer id) {
		// TODO Auto-generated method stub
		return fatherDAOImpl.findById(id);
	}
	

}
