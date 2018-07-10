package com.testgreendao.test.pojo;

import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * A data access object (DAO) providing persistence and search support for
 * Father entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.testgreendao.test.pojo.Father
 * @author MyEclipse Persistence Tools
 */
@Repository
public class FatherDAOImpl extends HibernateDaoSupport implements FatherDAO {
	private static final Logger log = LoggerFactory.getLogger(FatherDAOImpl.class);
	// property constants
	public static final String FATHER_NAME = "fatherName";
	public static final String FATHER_AGE = "fatherAge";
	public static final String FATHER_PIC = "fatherPic";

	protected void initDao() {
		// do nothing
	}
	
	/**
	 * 必须增加这一配置
	 * @param sessionFactory
	 */
	 @Autowired 
	    public void setSessionFactoryOverride(SessionFactory sessionFactory)
	    {   
	      super.setSessionFactory(sessionFactory);   
	    } 
	
	

	public void save(Father transientInstance) {
		log.debug("saving Father instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Father persistentInstance) {
		log.debug("deleting Father instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Father findById(java.lang.Integer id) {
		log.debug("getting Father instance with id: " + id);
		try {
			Father instance = (Father) getHibernateTemplate().get("com.testgreendao.test.pojo.Father", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Father instance) {
		log.debug("finding Father instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Father instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Father as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByFatherName(Object fatherName) {
		return findByProperty(FATHER_NAME, fatherName);
	}

	public List findByFatherAge(Object fatherAge) {
		return findByProperty(FATHER_AGE, fatherAge);
	}

	public List findByFatherPic(Object fatherPic) {
		return findByProperty(FATHER_PIC, fatherPic);
	}

	public List findAll() {
		log.debug("finding all Father instances");
		try {
			String queryString = "from Father";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Father merge(Father detachedInstance) {
		log.debug("merging Father instance");
		try {
			Father result = (Father) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Father instance) {
		log.debug("attaching dirty Father instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
		
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Father instance) {
		log.debug("attaching clean Father instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static FatherDAOImpl getFromApplicationContext(ApplicationContext ctx) {
		return (FatherDAOImpl) ctx.getBean("FatherDAO");
	}
}