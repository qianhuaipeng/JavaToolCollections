/**    
 * 文件名：CommonUtils.java    
 *
 * 版本信息：    
 * 日期：2016年2月4日    
 * create by ziQi       
 * 2016年2月4日
 */
package com.util.data;


/**
 * @title CommonUtils
 * @description TODO
 * @author ziQi
 * @version 上午1:44:20
 * @create_date 2016年2月4日上午1:44:20
 * @copyright (c) jacky
 */
public class CommonUtils{

    // 将数字转换成字母
    public static String ascii2String( String value ){
        StringBuffer sbu = new StringBuffer();
        String[] chars = value.split( "," );
        for( int i = 0; i < chars.length; i++ ){
            sbu.append( (char) Integer.parseInt( chars[i] ) );
        }
        return sbu.toString();
    }

    public static void main( String[] args ){
        System.out.println( ascii2String( "27" ) );
    }

}
