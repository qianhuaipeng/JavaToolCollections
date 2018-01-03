package com.util.cache.ehcache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheException;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.springframework.cache.ehcache.EhCacheCacheManager;

import com.spring.ApplicationContextHelper;

public class EhCacheHelper{
    
    public static CacheManager cacheManager = null;
    
    /**
     * @Description
     * <b>(初始化CacheManager)</b></br>
     * @return 
     * CacheManager 
     * @since 2016-7-7    
    */
    public static CacheManager getCacheManager(){
        /*InputStream is = EhCacheHelper.class.getClassLoader().getResourceAsStream("ehcache.xml");
        try{
            if( cacheManager == null ){
                cacheManager = CacheManager.newInstance( is );
            }
        }finally {
            if (is != null) {
                try{ is.close(); }catch( IOException e ){ e.printStackTrace(); }
            }
        }*/
        
        //从spring容器里面拿出
        EhCacheCacheManager ehCacheCacheManager = (EhCacheCacheManager) ApplicationContextHelper.getBean( "cacheManager" );
        return ehCacheCacheManager.getCacheManager();
    }
    
    /**
     * 取Cache对象
     * @param name
     * @param autoCreate
     * @return
     */
    public static Cache getCache( String name, boolean autoCreate ){
        Cache cache = getCacheManager().getCache( name );
        if( cache == null && autoCreate ){
            getCacheManager().addCache( name );
            cache = getCacheManager().getCache( name );
        }
        return cache;
    }
    
    /**
     * 取Cache对象
     * @param name
     * @param autoCreate
     * @return
     */
    public static Cache getCache( String name ){
        return getCache( name, true );
    }
    
    /**
     * 
     * @param cacheName cache名字
     * @param key       key值
     * @param value     value值
     * @throws CacheException
     */
    public static void put( String cacheName, Object key, Object value) {
        Element element = new Element( key, value );
        getCache( cacheName, true ).put( element );
    }
    
    /**
     * 根据key值取value值
     * @param key
     * @return
     * @throws CacheException
     */
    public static Object get( String cacheName, Object key) {
        if ( key == null ) {
            return null;
        }else {
            Element element = getCache( cacheName, true ).get( key );
            if ( element != null ){
                return element.getObjectValue();  
            }
        }
        return null;
    }
    
    /**
     * 移除缓存 
     * @param key
     * @throws CacheException
     */
    public static void remove( String cacheName,  Object key ) {
        getCache( cacheName, true ).remove( key );
    }
    
    /**
     * 清理Cache内的所有缓存对象
     * @throws CacheException
     */
    public void clear( String cacheName ) {
        getCache( cacheName, true ).removeAll();
    }
    
    /**
     * 移除Cache对象
     * @throws CacheException
     */
    public void destroy( String cacheName ) {
        Cache cache = getCache( cacheName, false );
        if( cache != null ){
            cache.getCacheManager().removeCache( cache.getName() );
        }
    }

}
