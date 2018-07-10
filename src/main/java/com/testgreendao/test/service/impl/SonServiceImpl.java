package com.testgreendao.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testgreendao.test.pojo.Son;
import com.testgreendao.test.pojo.SonDAO;
import com.testgreendao.test.service.SonService;

@Service
public class SonServiceImpl implements SonService{
	
	@Autowired
	private  SonDAO sonDAO; 
	

	@Override
	public Son findById(Integer id) {
		// TODO Auto-generated method stub
		return sonDAO.findById(id);
	}


	@Override
	public void save(Son transientInstance) {
		sonDAO.save(transientInstance);
	}
	

}
