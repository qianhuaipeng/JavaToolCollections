/*
 * Power by www.xiaoi.com
 */
package com.hibernate.util;
/**
 * @author <a href="mailto:eko.z@outlook.com">eko.zhan</a>
 * @date Nov 12, 2015 9:53:54 AM
 * @version 1.0
 */
public class DBUtils {

	public static String driver = PropertiesUtil.getString("jdbc.driver");
	
	/**
	 * 是否为 DB2 数据库
	 * @return
	 */
	public static boolean isDB2(){
		if (driver.indexOf("db2") != -1) {
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 是否为 Mysql 数据库
	 * @return
	 */
	public static boolean isMysql(){
		if (driver.indexOf("mysql") != -1) {
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 是否为 SQL Server 数据库
	 * @return
	 */
	public static boolean isSqlServer(){
		if (driver.indexOf("sqlserver") != -1 || driver.indexOf("jtds") != -1) {
			return true;
		}else{
			return false;
		}
	}
	/**
	 * 是否为 Oracle 数据库
	 * @return
	 */
	public static boolean isOracle(){
		if (driver.indexOf("oracle") != -1 || driver.indexOf("nds") != -1) {
			return true;
		}else{
			return false;
		}
	}
}
