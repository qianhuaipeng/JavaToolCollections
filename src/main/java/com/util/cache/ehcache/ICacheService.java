package com.util.cache.ehcache;

import java.util.List;


/**
 * @title ICacheService
 * @description 缓存接口
 * @author ziQi
 * @version 下午8:24:06
 * @create_date 2016年1月27日下午8:24:06
 * @copyright (c) jacky
 */
public interface ICacheService{
    
    /**
     * @Description
     * <b>(获取缓存的对象)</b></br>
     * @param key
     * @return Object
     * @since 2016-2-23    
    */
    public Object get( Object key );
    /**
     * @Description
     * <b>(缓存对象,如果缓存内有相同的key,会进行替换)</b></br>
     * @param key
     * @param value 
     * void 
     * @since 2016-2-23    
    */
    public void put( Object key, Object value );
    
    /**
     * @Description
     * <b>缓存对象，对应的key的缓存下面是Queue，value对象会缓存到该Queue中)</b></br>
     * @param key
     * @param value 
     * void 
     * @since 2016-2-23    
    */
    public void addQueue( Object key, Object value );
    /**
     * @Description
     * <b>获取缓存的Queue所有的元素出列，返回list</b></br>
     * @param key
     * @param value 
     * void 
     * @since 2016-2-23    
    */
    public List<Object> pollQueue( Object key );

    /**
     * @Description
     * <b>(清除对象)</b></br>
     * @param key 
     * void 
     * @since 2016-2-23    
    */
    public void remove( Object key );

    /**
     * @Description
     * <b>(有多少缓存对象)</b></br>
     * @return 
     * int 
     * @since 2016-2-23    
    */
    public int size();

}
