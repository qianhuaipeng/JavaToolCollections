/**    
 * 文件名：MessageResourceUtils.java    
 *
 * 版本信息：    
 * 日期：2016年2月2日    
 * create by ziQi       
 * 2016年2月2日
 */
package com.xiaoi.dev.utils;

import java.text.MessageFormat;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.eastrobot.robotface.RobotMessageResource;
import com.eastrobot.robotface.RobotMessageResourceProxy;

public class MessageResourceUtils{

    private static RobotMessageResource robotMessageResource = new RobotMessageResourceProxy();
    
    private static final Logger logger = LoggerFactory.getLogger( MessageResourceUtils.class );

    /**
     * @Description <b>(获取服务参数)</b></br>
     * @param key
     *            标识
     * @param platform
     * @param location
     * @return String
     * @since 2016年2月2日
     */
    public static String getString( String key, String platform, String location ){
        String value = robotMessageResource.get( key, platform, location );
        if( StringUtils.isEmpty( value ) ){
            value = robotMessageResource.get( key, platform );
        }
        if( StringUtils.isEmpty( value ) ){
            value = robotMessageResource.get( key, "ALL" );
        }
        return value;
    }
    
    /**
     * @Description <b>(获取服务参数)</b></br>
     * @param key 标识
     * @param platform 渠道
     * @return String
     * @since 2016年2月2日
     */
    public static String getString( String key, String platform ){
        String value = robotMessageResource.get( key, platform );
        logger.info( "MessageResourceUtils:key={},platform={},value={}" , key, platform, value  );
        if( StringUtils.isEmpty( value ) ){
            value = robotMessageResource.get( key, "ALL" );
        }
        return value;
    }

    /**
     * @Description <b>(MessageFormat格式化消息资源)</b></br>
     * 根据key,platform,location获取消息资源，用parmas格式化
     * @param key 标识
     * @param platform 平台
     * @param location location维度
     * @param params
     * @return String
     * @since 2016年2月3日
     */
    public static String getString( String key, String platform, String location, Object[] params ){
        return MessageFormat.format( getString( key, platform, location ), params );
    }
    
    /**
     * @Description <b>(MessageFormat格式化消息资源)</b></br>
     * 根据key,platform,location获取消息资源，用parmas格式化
     * @param key 标识
     * @param platform 平台
     * @param params
     * @return String
     * @since 2016年2月3日
     */
    public static String getString( String key, String platform, Object[] params ){
        return MessageFormat.format( getString( key, platform ), params );
    }
    
    
    public static String getValue( String key, String platform, String _default ){
        String str = getString( key, platform );
        if( StringUtils.isEmpty( str ) ){
            str = _default;
        }
        return str;
    }

    /**
     * @Description <b>(获取消息资源，返回整型)</b></br>
     * @param key 标识
     * @param platform 平台
     * @return Integer
     * @since 2016年2月2日
     */
    public static Integer getInteger( String key, String platform ){
        String value = getString( key, platform );
        Integer num = 0;
        if( StringUtils.isAlphanumeric( value ) ){
            num = Integer.parseInt( value );
        }
        return num;
    }
    
    /**
     * @Description <b>(获取消息资源，返回Long类型)</b></br>
     * @param key 标识
     * @param platform 平台
     * @return Integer
     * @since 2016年2月2日
     */
    public static Long getLong( String key, String platform ){
        String value = getString( key, platform );
        Long num = 0l;
        if( StringUtils.isAlphanumeric( value ) ){
            num = Long.parseLong( value );
        }
        return num;
    }
    
    /**
     * @Description <b>(获取消息资源，返回整型)</b></br>
     * @param key 标识
     * @param platform 平台
     * @param location location维度
     * @return Integer
     * @since 2016年2月2日
     */
    public static Integer getInteger( String key, String platform, String location ){
        String value = getString( key, platform, location );
        Integer num = 0;
        if( StringUtils.isAlphanumeric( value ) ){
            num = Integer.parseInt( value );
        }
        return num;
    }

}
