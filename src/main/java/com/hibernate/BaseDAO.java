/*
 * Power by www.xiaoi.com
 */
package com.hibernate;

import java.util.List;
import java.util.Map;

import org.springframework.orm.hibernate3.HibernateCallback;


/**
 * @author <a href="mailto:eko.z@outlook.com">eko.zhan</a>
 * @date May 14, 2015 10:25:42 AM
 * @version 1.0
 */
public interface BaseDAO<T> {

	public List<T> find(String queryString) throws DAORuntimeException;
	
	public List<T> find(String queryString, Object... values) throws DAORuntimeException;
	
	public List<T> findByNamedParam(String queryString, String paramName, Object value) throws DAORuntimeException;
	
	public List<T> findByNamedParam(String queryString, String[] paramNames, Object[] values) throws DAORuntimeException;
	
	public Pager<T> find(String queryString, boolean enableCount, Pager<T> pager) throws DAORuntimeException;
	
	public Pager<T> find(String queryString, boolean enableCount, Pager<T> pager, Object... values) throws DAORuntimeException;
	
	public Pager<T> findByNamedParam(String queryString, boolean enableCount, Pager<T> pager, String paramName, Object value) throws DAORuntimeException;
	
	public Pager<T> findByNamedParam(String queryString, boolean enableCount, Pager<T> pager, String[] paramNames, Object[] values) throws DAORuntimeException;
	
	public void save(T entity) throws DAORuntimeException;
	
	public void update(T entity) throws DAORuntimeException;
	
	public void delete(T entity) throws DAORuntimeException;
	
	public void saveOrUpdate(T entity) throws DAORuntimeException;
	
	public T findById(Class<T> entityClass, String primarykey) throws DAORuntimeException;
	
	public T findById(String primarykey) throws DAORuntimeException;
	
	public T execute(HibernateCallback<T> action) throws DAORuntimeException;
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * 通过 sql 判断表是否存在
	 */
	public boolean exist(String tableName) throws DAORuntimeException;
	
	public List<Map<String, Object>> queryForList(String queryString) throws DAORuntimeException;
	
	public List<Map<String, Object>> queryForList(String queryString, Object... values) throws DAORuntimeException;
	
	public Pager<Map<String, Object>> queryForPager(String queryString, boolean enableCount, Pager<Map<String,Object>> pager) throws DAORuntimeException;
	
	public Pager<Map<String, Object>> queryForPager(String queryString, boolean enableCount, Pager<Map<String,Object>> finalPager, Object... values) throws DAORuntimeException;
	
	public void executeSQL(String queryString) throws DAORuntimeException;
	
	public void executeSQL(String queryString, Object... values) throws DAORuntimeException;
}
