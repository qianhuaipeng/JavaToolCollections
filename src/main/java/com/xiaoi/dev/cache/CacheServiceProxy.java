package com.xiaoi.dev.cache;

import com.eastrobot.robotface.util.MethodDefinition;
import com.eastrobot.robotface.util.ServiceProxy;



/**
 * @author Andy.zuo
 * 
 */

public class CacheServiceProxy extends ServiceProxy implements CacheService {

	private static final MethodDefinition METHOD_GET = new MethodDefinition("get", new String[] { Object.class.getName()});
	private static final MethodDefinition METHOD_INIT = new MethodDefinition("init", new String[] { Integer.class.getName()});
	private static final MethodDefinition METHOD_PRINT_DETAIL = new MethodDefinition("printDetail", new String[] {});
	private static final MethodDefinition METHOD_PUT = new MethodDefinition("put", new String[] { Object.class.getName(),Object.class.getName()});
	private static final MethodDefinition METHOD_REMOVE = new MethodDefinition("remove", new String[] { Object.class.getName()});
	private static final MethodDefinition METHOD_SIZE = new MethodDefinition("size", new String[] {});

	@Override
	public Object get(Object key) {
		
		return this.invokeTarget(METHOD_GET, new Object[] {key});
	}


	@Override
	public String printDetail() {
		return (String) this.invokeTarget(METHOD_PRINT_DETAIL,new Object[]{});
	}

	@Override
	public void put(Object key, Object value) {
		this.invokeTarget(METHOD_PUT, new Object[]{key,value});
	}

	@Override
	public void remove(Object key) {
		this.invokeTarget(METHOD_REMOVE,new Object[]{key});
	}

	@Override
	public int size() {
		return (Integer) this.invokeTarget(METHOD_SIZE, new Object[]{});
	}

	@Override
	public void init(int size) {
		this.invokeTarget(METHOD_INIT, new Object[] {size});
	}

}
