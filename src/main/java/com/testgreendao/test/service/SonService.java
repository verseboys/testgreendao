package com.testgreendao.test.service;

import com.testgreendao.test.pojo.Son;

public interface SonService {

	
	public Son findById(Integer id);
	
	public void save(Son transientInstance);
}
