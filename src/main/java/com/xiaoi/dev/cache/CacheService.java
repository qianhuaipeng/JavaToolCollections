package com.xiaoi.dev.cache;



/**
 * @author Andy.zuo
 * 
 */

public interface CacheService {

	public void init(int size);
	public Object get(Object key);

	public void put(Object key, Object value);

	public void remove(Object key);

	public int size();

	public String printDetail();

}
