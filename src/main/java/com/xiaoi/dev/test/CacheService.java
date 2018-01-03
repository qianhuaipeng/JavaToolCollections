package com.xiaoi.dev.test;


public interface CacheService {
	
	void put(String key, String value);
	
	String get(String key);
	
	void remove(String key);
}
