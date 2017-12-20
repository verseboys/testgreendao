package com.testgreendao.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.testgreendao.test.pojo.Father;
import com.testgreendao.test.service.FatherService;

public class Testdao {
	
	
	
	
	
	@Test
	//@Transactional
	public void testFindById() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		FatherService fatherService =  context.getBean(FatherService.class);
		Father news = new Father();
		Integer fateherId=1;
		news.setFateherId(fateherId);;
		
		Father newsw=fatherService.findById(fateherId);
		 
		 System.out.println(newsw);
	}

}
