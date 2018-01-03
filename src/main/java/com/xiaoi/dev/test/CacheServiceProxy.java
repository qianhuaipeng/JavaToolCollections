package com.xiaoi.dev.test;


import com.eastrobot.robotface.util.MethodDefinition;
import com.eastrobot.robotface.util.ServiceProxy;

public class CacheServiceProxy extends ServiceProxy implements CacheService{
	
	private static final MethodDefinition METHOD_GET = new MethodDefinition("get", new String[]{String.class.getName()});
	private static final MethodDefinition METHOD_PUT = new MethodDefinition("put", new String[]{String.class.getName(),String.class.getName()});
	private static final MethodDefinition METHOD_REMOVE = new MethodDefinition("remove", new String[]{String.class.getName()});
	
	@Override
	public void put(String key, String value) {
		this.invokeTarget(METHOD_PUT, new Object[]{key,value});
	}

	@Override
	public String get(String key) {
		return (String)this.invokeTarget(METHOD_GET, new Object[]{key});
	}

	@Override
	public void remove(String key) {
		this.invokeTarget(METHOD_REMOVE, new Object[]{key});
	}
	
}
