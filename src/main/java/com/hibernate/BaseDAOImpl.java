/*
 * Power by www.xiaoi.com
 */
package com.hibernate;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;


/**
 * 当前类只实现注入功能，如需用到一些底层方法，请写入抽象类 AbstractHibernateDAO.class
 * @author <a href="mailto:eko.z@outlook.com">eko.zhan</a>
 * @date May 13, 2015 12:16:43 PM
 * @version 1.0
 */
public class BaseDAOImpl<T> extends AbstractHibernateDAO<T>{
	
	@Resource
	public void setSuperHibernateTemplate(HibernateTemplate hibernateTemplate){
		super.setHibernateTemplate(hibernateTemplate);
	}
	
}
