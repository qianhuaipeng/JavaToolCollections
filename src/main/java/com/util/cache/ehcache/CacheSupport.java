/**    
 * 文件名：CacheSupport.java    
 *
 * 版本信息：    
 * 日期：2016年1月27日    
 * create by ziQi       
 * 2016年1月27日
 */
package com.util.cache.ehcache;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

import net.sf.ehcache.Cache;

/** 
 * @title CacheSupport
 * @description 使用EhCache的缓存
 * @author ziQi 
 * @version 上午10:27:59 
 * @create_date 2016-2-26上午10:27:59
 * @copyright (c) jacky
 */  
public class CacheSupport implements ICacheService{
    
    private String cacheName ;
    private Cache cache;
    
    public CacheSupport( String cacheName ){
        this.cacheName = cacheName;
        cache = EhCacheHelper.getCache( cacheName );
    }
    
    @Override
    public Object get( Object key ){
        return EhCacheHelper.get( cacheName, key );
    }

    @Override
    public void put( Object key, Object value ){
        EhCacheHelper.put( this.cacheName, key, value );
    }

    @Override
    public void remove( Object key ){
        EhCacheHelper.remove( this.cacheName, key );
    }

    @Override
    public int size(){
        return this.cache.getSize();
    }

    @SuppressWarnings( "unchecked" )
    @Override
    public void addQueue( Object key, Object value ){
        ConcurrentLinkedQueue<Object> concurrentLinkedQueue = (ConcurrentLinkedQueue<Object>) this.get( key );
        if( concurrentLinkedQueue == null ){
            concurrentLinkedQueue = new ConcurrentLinkedQueue<Object>();
            concurrentLinkedQueue.add( value );
            this.put( key, concurrentLinkedQueue );
        }
    }

    @SuppressWarnings( "unchecked" )
    @Override
    public List<Object> pollQueue( Object key ){
        ConcurrentLinkedQueue<Object> concurrentLinkedQueue = (ConcurrentLinkedQueue<Object>) this.get( key );
        List<Object> list = new ArrayList<Object>();
        if( concurrentLinkedQueue != null ){
            while( concurrentLinkedQueue.size() > 0 ){
                list.add( concurrentLinkedQueue.poll() );
            }
        }
        return list;
    }
    
}
