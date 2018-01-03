package com.util.data.properties;

import java.util.List;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

/**
 * 读取配置文件
 * @author alan
 *
 * 2017-3-30 下午9:21:10
 */
public class PropertiesUtil {
	private static PropertiesConfiguration config;
	static{
		try {
			config = new PropertiesConfiguration("app.properties");
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 如果没有找到配置则返回空字符串
	 * @param key
	 * @return
	 */
	public static String getString(String key){
		if (config.getString(key)==null){
			return "";
		}
		return config.getString(key);
	}
	
	/**
	 * 如果没有找到配置则返回默认字符串
	 * @param key
	 * @return
	 */
	public static String getString(String key, String defaultValue){
		if (config.getString(key)==null){
			return defaultValue;
		}
		return config.getString(key);
	}
	
	/**
	 * ,分隔获取为List<String>
	 * @param key
	 * @return
	 */
	public static List<String> getList(String key){
		if (config.getString(key)==null){
			return null;
		}
		return config.getList(key);
	}
}
