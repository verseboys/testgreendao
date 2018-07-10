package com.testgreendao.test.pojo;

public interface FatherDAO {
	
	public Father findById(java.lang.Integer id);
	public void save(Father transientInstance);

}
