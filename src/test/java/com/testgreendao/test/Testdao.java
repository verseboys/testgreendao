package com.testgreendao.test;

import org.hibernate.Session;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.testgreendao.test.pojo.Father;
import com.testgreendao.test.pojo.Son;
import com.testgreendao.test.service.FatherService;
import com.testgreendao.test.service.SonService;

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

	@Test
	@Transactional
	public void testinsert() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		SonService sonService =  context.getBean(SonService.class);
		FatherService fatherService =  context.getBean(FatherService.class);
		Son son = new Son();



		Father father = new Father();
		father.setFatherAge(39);
		father.setFatherName("sdf");
		father.setFatherPic("asfsad.jpg");
	

		son.setSonAge(23);
		son.setSonName("pite");
		son.setSonPic("hkjhjk.jpg");
		
		son.setFather(father);
		sonService.save(son);

		
		
		
		System.out.println(son);
	}
	
	
	@Test
	@Transactional
	public void testinsert1() {
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		Son son = new Son();



		Father father = new Father();
		father.setFatherAge(39);
		father.setFatherName("刘德华");
		father.setFatherPic("asfsad.jpg");
		

		son.setSonAge(23);
		son.setSonName("刘德华儿子1号");
		son.setSonPic("hkjhjk.jpg");
		
		son.setFather(father);
		
		Son son1 = new Son();
		son1.setSonAge(23);
		son1.setSonName("刘德华儿子2号");
		son1.setSonPic("hkjhjk.jpg");
		
		son1.setFather(father);
		
		
		father.getSons().add(son);
		father.getSons().add(son1);
		
		
        session.save(father);
        session.save(son);
        session.save(son1);
		
		session.getTransaction().commit();
		
		System.out.println(son);
	}
}
