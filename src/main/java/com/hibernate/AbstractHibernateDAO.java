/*
 * Power by www.xiaoi.com
 */
package com.hibernate;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.hibernate.util.DBUtils;
import com.hibernate.util.PropertiesUtil;

/**
 * @author <a href="mailto:eko.z@outlook.com">eko.zhan</a>
 * @date May 15, 2015 1:26:10 PM
 * @version 1.0
 */
public abstract class AbstractHibernateDAO<T> extends HibernateDaoSupport implements BaseDAO<T>{
	
	private final static Log LOGGER = LogFactory.getLog(AbstractHibernateDAO.class);

	public List<T> find(String queryString) {
		return (List<T>) getHibernateTemplate().find(queryString, null);
	}

	public List<T> find(String queryString, Object... values) {
		return (List<T>) getHibernateTemplate().find(queryString, values);
	}
	
	public List<T> findByNamedParam(String queryString, String paramName, Object value) {
		return (List<T>) getHibernateTemplate().findByNamedParam(queryString, paramName, value);
	}
	
	public List<T> findByNamedParam(String queryString, String[] paramNames, Object[] values) {
		return (List<T>) getHibernateTemplate().findByNamedParam(queryString, paramNames, values);
	}

	public void save(T entity) throws DAORuntimeException {
		getHibernateTemplate().save(entity);
	}

	public void update(T entity) throws DAORuntimeException {
		getHibernateTemplate().update(entity);
	}

	public void delete(T entity) throws DAORuntimeException {
		getHibernateTemplate().delete(entity);
	}

	public void saveOrUpdate(T entity) throws DAORuntimeException {
		getHibernateTemplate().saveOrUpdate(entity);
	}

	public T findById(Class<T> entityClass, String primarykey) throws DAORuntimeException {
		return getHibernateTemplate().get(entityClass, primarykey);
	}
	
	public T findById(String primarykey) throws DAORuntimeException {
		return findById(getSuperClassGenricType(this.getClass(), 0), primarykey);
	}
	
	public T execute(HibernateCallback<T> action){
		return getHibernateTemplate().execute(action);
	}
	
	public Pager<T> find(final String queryString, final boolean enableCount, final Pager<T> finalPager) {
		return getHibernateTemplate().execute(new HibernateCallback<Pager<T>>(){
			@Override
			public Pager<T> doInHibernate(Session session) throws HibernateException, SQLException {
				Pager<T> pager = finalPager;
				Query query = session.createQuery(queryString);
				
				if (enableCount){
					//pager.setTotal(query.list().size());
					String tmp = queryString;
					if (tmp.indexOf("order by")!=-1){
						tmp = tmp.substring(0, tmp.indexOf("order by"));
					}
					Query countQuery = session.createQuery("select count(*) " + tmp);
					int total = ((Long)countQuery.uniqueResult()).intValue();
					pager.setTotal(total);
				}
				
				query.setFirstResult(pager.getOffset());
				query.setMaxResults(pager.getSize());
				pager.setDatas((List<T>)query.list());
				return pager;
			}
		});
	}

	public Pager<T> find(final String queryString, final boolean enableCount, final Pager<T> finalPager, final Object... values) {
		return getHibernateTemplate().execute(new HibernateCallback<Pager<T>>(){
			@Override
			public Pager<T> doInHibernate(Session session) throws HibernateException, SQLException {
				Pager<T> pager = finalPager;
				Query query = session.createQuery(queryString);
				if (values!=null){
					for (int i=0; i<values.length; i++){
						query.setParameter(i, values[i]);
					}
				}
				
				if (enableCount){
					//pager.setTotal(query.list().size());
					String tmp = queryString;
					if (tmp.indexOf("order by")!=-1){
						tmp = tmp.substring(0, tmp.indexOf("order by"));
					}
					Query countQuery = session.createQuery("select count(*) " + tmp);
					if (values!=null){
						for (int i=0; i<values.length; i++){
							countQuery.setParameter(i, values[i]);
						}
					}
					int total = ((Long)countQuery.uniqueResult()).intValue();
					pager.setTotal(total);
				}
				
				query.setFirstResult(pager.getOffset());
				query.setMaxResults(pager.getSize());
				pager.setDatas((List<T>)query.list());
				return pager;
			}
		});
	}
	
	public Pager<T> findByNamedParam(final String queryString, final boolean enableCount, final Pager<T> finalPager, final String paramName, final Object value) {
		return getHibernateTemplate().execute(new HibernateCallback<Pager<T>>(){
			@Override
			public Pager<T> doInHibernate(Session session) throws HibernateException, SQLException {
				Pager<T> pager = finalPager;
				Query query = session.createQuery(queryString);
				query.setParameter(paramName, value);

				if (enableCount){
					//pager.setTotal(query.list().size());
					String tmp = queryString;
					if (tmp.indexOf("order by")!=-1){
						tmp = tmp.substring(0, tmp.indexOf("order by"));
					}
					Query countQuery = session.createQuery("select count(*) " + tmp);
					countQuery.setParameter(paramName, value);
					int total = ((Long)countQuery.uniqueResult()).intValue();
					pager.setTotal(total);
				}
				
				query.setFirstResult(pager.getOffset());
				query.setMaxResults(pager.getSize());
				pager.setDatas((List<T>)query.list());
				return pager;
			}
		});
	}
	
	public Pager<T> findByNamedParam(final String queryString, final boolean enableCount, final Pager<T> finalPager, final String[] paramNames, final Object[] values) {
		return getHibernateTemplate().execute(new HibernateCallback<Pager<T>>(){
			@Override
			public Pager<T> doInHibernate(Session session) throws HibernateException, SQLException {
				Pager<T> pager = finalPager;
				Query query = session.createQuery(queryString);
				
				if (values != null) {
					for (int i = 0; i < values.length; i++) {
						applyNamedParameterToQuery(query, paramNames[i], values[i]);
					}
				}

				if (enableCount){
					//pager.setTotal(query.list().size());
					String tmp = queryString;
					if (tmp.indexOf("order by")!=-1){
						tmp = tmp.substring(0, tmp.indexOf("order by"));
					}
					Query countQuery = session.createQuery("select count(*) " + tmp);
					if (values!=null){
						for (int i = 0; i < values.length; i++) {
							applyNamedParameterToQuery(countQuery, paramNames[i], values[i]);
						}
					}
					int total = ((Long)countQuery.uniqueResult()).intValue();
					pager.setTotal(total);
				}
				
				query.setFirstResult(pager.getOffset());
				query.setMaxResults(pager.getSize());
				pager.setDatas((List<T>)query.list());
				return pager;
			}
		});
	}
	
	/**
	 * Apply the given name parameter to the given Query object.
	 * @param queryObject the Query object
	 * @param paramName the name of the parameter
	 * @param value the value of the parameter
	 * @throws HibernateException if thrown by the Query object
	 */
	protected void applyNamedParameterToQuery(Query queryObject, String paramName, Object value)
			throws HibernateException {

		if (value instanceof Collection) {
			queryObject.setParameterList(paramName, (Collection) value);
		}
		else if (value instanceof Object[]) {
			queryObject.setParameterList(paramName, (Object[]) value);
		}
		else {
			queryObject.setParameter(paramName, value);
		}
	}
	
	/**
	 * 获取泛型的类型
	 * @param clazz
	 * @param index
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private Class getSuperClassGenricType(final Class clazz, final int index) {

		Type genType = clazz.getGenericSuperclass();

		if (!(genType instanceof ParameterizedType)) {
			LOGGER.warn(clazz.getSimpleName() + "'s superclass not ParameterizedType");
			return Object.class;
		}

		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

		if (index >= params.length || index < 0) {
			LOGGER.warn("Index: " + index + ", Size of " + clazz.getSimpleName() + "'s Parameterized Type: " + params.length);
			return Object.class;
		}
		if (!(params[index] instanceof Class)) {
			LOGGER.warn(clazz.getSimpleName() + " not set the actual class on superclass generic parameter");
			return Object.class;
		}

		return (Class) params[index];
	}
	
	////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * @modifier eko.zhan at 2015-11-23 如果需要用到DBUtils判断数据库类型，为什么不直接将数据库类型判断的方法写进底层DAO中？
	 * 判断表是否存在
	 * @date 2015-11-19 下午3:13:06
	 * @param tableName
	 * @return
	 */
	public boolean exist(String tableName) {
		String queryString = "";
		if (DBUtils.isOracle()){
			//add by eko.zhan at 2016-01-08 10:29 Oracle 校验表是否存在需要用到Owner
			String owner = PropertiesUtil.getString("jdbc.username").toUpperCase();
			queryString = "select count(1) as NUM_ from all_tables where TABLE_NAME='" + tableName + "' and OWNER='" + owner + "'";
		} else if (DBUtils.isMysql()){
			String jdbcUrl = PropertiesUtil.getString("jdbc.url").toUpperCase();
			String dbName = jdbcUrl.substring(jdbcUrl.lastIndexOf("/") + 1, jdbcUrl.indexOf("?"));
			queryString = "select count(1) as NUM_ from information_schema.tables where table_name='" + tableName + "' " + "and table_schema='" + dbName + "' ";
		} else if (DBUtils.isSqlServer()){
			queryString = "select count(1) as NUM_ from sysobjects where xtype='u' and name='" + tableName + "'";
		}
		List<Map<String, Object>> list = queryForList(queryString);
		String num = list.get(0).get("NUM_").toString();
		if (Integer.valueOf(num)>0){
			return true;
		}
		return false;
	}

	public List<Map<String, Object>> queryForList(String queryString) {
		return queryForList(queryString, null);
	}

	public List<Map<String, Object>> queryForList(final String queryString, final Object... values) {
		return getHibernateTemplate().execute(new HibernateCallback<List<Map<String, Object>>>(){
			@Override
			public List<Map<String, Object>> doInHibernate(Session session) throws HibernateException, SQLException {
				SQLQuery query = session.createSQLQuery(queryString);
				if (values!=null){
					for (int i=0; i<values.length; i++){
						query.setParameter(i, values[i]);
					}
				}
				return query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
			}
		});
	}
	
	public Pager<Map<String, Object>> queryForPager(String queryString, boolean enableCount, Pager<Map<String,Object>> pager) {
		return queryForPager(queryString, enableCount, pager, null);
	}

	public Pager<Map<String, Object>> queryForPager(final String queryString, final boolean enableCount, 
			final Pager<Map<String,Object>> finalPager, final Object... values) {
		return getHibernateTemplate().execute(new HibernateCallback<Pager<Map<String, Object>>>(){
			@Override
			public Pager<Map<String, Object>> doInHibernate(Session session) throws HibernateException, SQLException {
				Pager<Map<String,Object>> pager = finalPager;
				SQLQuery query = session.createSQLQuery(queryString);
				if (values!=null){
					for (int i=0; i<values.length; i++){
						query.setParameter(i, values[i]);
					}
				}
				if (enableCount){
					String tmp = queryString;
					if (tmp.indexOf("order by")!=-1){
						tmp = tmp.substring(0, tmp.indexOf("order by"));
					}
					SQLQuery countQuery = session.createSQLQuery("select count(*) from (" + tmp + ") c");
					if (values!=null){
						for (int i=0; i<values.length; i++){
							countQuery.setParameter(i, values[i]);
						}
					}
					int total = Integer.parseInt(countQuery.uniqueResult().toString());
					//不行?
					//int total = ((Long)countQuery.uniqueResult()).intValue();
					pager.setTotal(total);
				}
				query.setFirstResult(pager.getOffset());
				query.setMaxResults(pager.getSize());
				pager.setDatas(query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list());
				return pager;
			}
		});
	}

	public void executeSQL(final String queryString){
		getHibernateTemplate().execute(new HibernateCallback<T>(){
			@Override
			public T doInHibernate(Session session) throws HibernateException, SQLException {
				SQLQuery query = session.createSQLQuery(queryString);
				query.executeUpdate();
				return null;
			}
			
		});
	}
	
	public void executeSQL(final String queryString,  final Object... values){
		getHibernateTemplate().execute(new HibernateCallback<T>(){
			@Override
			public T doInHibernate(Session session) throws HibernateException, SQLException {
				SQLQuery query = session.createSQLQuery(queryString);
				if (values!=null){
					for (int i=0; i<values.length; i++){
						query.setParameter(i, values[i]);
					}
				}
				try{
					query.executeUpdate();
				}catch (DuplicateKeyException e){
					//TODO eko.zhan at 2016-09-06 09:20 到底是否应该在底层捕获异常呢？
					LOGGER.debug("SQL语句 [" + query.getQueryString() + "] 主键重复，忽略此异常");
				}
				
				return null;
			}
			
		});
	}
}
