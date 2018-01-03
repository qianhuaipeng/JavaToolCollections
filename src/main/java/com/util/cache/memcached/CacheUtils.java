/*
 * Power by www.xiaoi.com
 */
package com.util.cache.memcached;

import java.util.Collection;
import java.util.concurrent.TimeoutException;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.code.ssm.Cache;
import com.google.code.ssm.api.format.SerializationType;
import com.google.code.ssm.providers.CacheException;
import com.util.data.properties.PropertiesUtil;
import com.util.spring.ServiceFinder;

/**
 * Memcached 缓存工具类
 * @author <a href="mailto:eko.z@outlook.com">eko.zhan</a>
 * @date Aug 25, 2015 4:11:49 PM
 * @version 1.0
 */
public class CacheUtils {
	
	private static Log LOGGER = LogFactory.getLog(CacheUtils.class);

	private static Cache defaultMemcachedClient = null;
	
	private static final SerializationType DEFAULT_TYPE = SerializationType.JAVA;
	
	private static final int DEFAULT_LIMIT = 60*10;
	
	static{
		if (isUsable()){
			LOGGER.debug("(========= 初始化 memcached 成功 =========)");
			defaultMemcachedClient = (Cache) ServiceFinder.getBean("defaultMemcachedClient");
		}
	}
	
	/**
	 * 添加 key
	 * @param name
	 * @param value
	 */
	public static void add(String key, Object value){
		add(key, value, DEFAULT_LIMIT);
	}
	
	/**
	 * 
	 * @param key
	 * @param value
	 * @param limit
	 * @return 
	 */
	public static void add(String key, Object value, int limit){
		add(key, value, limit, DEFAULT_TYPE);
	}
	
	/**
	 * 添加 key
	 * @param key
	 * @param limit
	 * @param value
	 * @param type
	 */
	public static void add(String key, Object value, int limit, SerializationType type){
		if (!isUsable()) return;
		try {
			defaultMemcachedClient.add(key, limit, value, type);
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (CacheException e) {
			e.printStackTrace();
		} finally{
			//shutdown 会导致如下报错：
			//com.google.code.ssm.providers.CacheException: net.rubyeye.xmemcached.exception.MemcachedException: Xmemcached is stopped
//			defaultMemcachedClient.shutdown();
		}
		return;
	}
	
	/**
	 * 根据 key 获取值
	 * @return
	 */
	public static <T>T get(String key){
		return get(key, DEFAULT_TYPE);
	}
	
	/**
	 * 根据 key 获取值，不推荐使用
	 * @param key
	 * @param type
	 * @return
	 */
	public static <T>T get(String key, SerializationType type){
		if (!isUsable()) return null;
		try {
			if (defaultMemcachedClient.get(key, type)!=null){
				return (T) defaultMemcachedClient.get(key, type);
			}
			return null;
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (CacheException e) {
			e.printStackTrace();
		} finally{
//			defaultMemcachedClient.shutdown();
		}
		return null;
	}
	
	/**
	 * 修改 key/value
	 * @param name
	 * @param value
	 */
	public static void set(String key, Object value){
		set(key, value, DEFAULT_LIMIT);
	}
	
	/**
	 * 修改 key/value
	 * @param key
	 * @param value
	 * @param limit
	 * @return 
	 */
	public static void set(String key, Object value, int limit){
		set(key, value, limit, DEFAULT_TYPE);
	}
	
	/**
	 * 修改 key/value
	 * @param key
	 * @param value
	 * @param limit
	 * @param type
	 */
	public static void set(String key, Object value, int limit, SerializationType type){
		if (!isUsable()) return;
		try {
			defaultMemcachedClient.set(key, limit, value, type);
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (CacheException e) {
			e.printStackTrace();
		} finally{
//			defaultMemcachedClient.shutdown();
		}
	}
	
	/**
	 * 删除 key
	 * @param key
	 */
	public static void delete(String key){
		if (!isUsable()) return;
		try {
			defaultMemcachedClient.delete(key);
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (CacheException e) {
			e.printStackTrace();
		} finally{
//			defaultMemcachedClient.shutdown();
		}
	}
	
	/**
	 * 批量删除 key
	 * @param keys
	 */
	public static void batchDelete(Collection<String> keys){
		if (!isUsable()) return;
		try {
			defaultMemcachedClient.delete(keys);
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (CacheException e) {
			e.printStackTrace();
		} finally{
//			defaultMemcachedClient.shutdown();
		}
	}
	
	/**
	 * 清空所有，慎用
	 */
	public static void flush(){
		if (!isUsable()) return;
		try {
			defaultMemcachedClient.flush();
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (CacheException e) {
			e.printStackTrace();
		} finally{
//			defaultMemcachedClient.shutdown();
		}
	}
	
	/**
	 * 是否启用 memcached
	 * @return
	 */
	private static boolean isUsable(){
		if (StringUtils.isBlank(getAddress())){
			return false;
		}
		return true;
	}
	
	/**
	 * 获取 memcached 地址
	 * @return
	 */
	private static String getAddress(){
		String workflowPath = PropertiesUtil.getString("memcached.addr");
		return workflowPath;
	}
}
