package com.testgreendao.test.pojo;

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * A data access object (DAO) providing persistence and search support for Son
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.testgreendao.test.pojo.Son
 * @author MyEclipse Persistence Tools
 */
@Repository
public class SonDAOImpl extends HibernateDaoSupport implements SonDAO{
	private static final Logger log = LoggerFactory.getLogger(SonDAOImpl.class);
	// property constants
	public static final String SON_NAME = "sonName";
	public static final String SON_AGE = "sonAge";
	public static final String SON_PIC = "sonPic";

	protected void initDao() {
		// do nothing
	}

	public void save(Son transientInstance) {
		log.debug("saving Son instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Son persistentInstance) {
		log.debug("deleting Son instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Son findById(java.lang.Integer id) {
		log.debug("getting Son instance with id: " + id);
		try {
			Son instance = (Son) getHibernateTemplate().get("com.testgreendao.test.pojo.Son", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Son instance) {
		log.debug("finding Son instance by example");
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
		log.debug("finding Son instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Son as model where model." + propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findBySonName(Object sonName) {
		return findByProperty(SON_NAME, sonName);
	}

	public List findBySonAge(Object sonAge) {
		return findByProperty(SON_AGE, sonAge);
	}

	public List findBySonPic(Object sonPic) {
		return findByProperty(SON_PIC, sonPic);
	}

	public List findAll() {
		log.debug("finding all Son instances");
		try {
			String queryString = "from Son";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Son merge(Son detachedInstance) {
		log.debug("merging Son instance");
		try {
			Son result = (Son) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Son instance) {
		log.debug("attaching dirty Son instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Son instance) {
		log.debug("attaching clean Son instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static SonDAOImpl getFromApplicationContext(ApplicationContext ctx) {
		return (SonDAOImpl) ctx.getBean("SonDAO");
	}
}