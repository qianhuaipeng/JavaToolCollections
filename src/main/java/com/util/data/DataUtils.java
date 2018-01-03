/**    
 * 文件名：DataUtils.java    
 *
 * 版本信息：    
 * 日期：2016-2-23    
 * create by ziQi       
 * 2016-2-23
 */
package com.util.data;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @title DataUtils
 * @description 常用工具方法集合
 * @author ziQi
 * @version 下午9:25:40
 * @create_date 2016-2-23下午9:25:40
 * @copyright (c) jacky
 */
public class DataUtils{

    /**
     * @Description
     * <b>(SHA1加密)</b></br>
     * @param inStr
     * @return 
     * String 
     * @since 2016-2-23    
    */
    public static String sha1( String inStr ){
        MessageDigest md = null;
        String outStr = null;
        try{
            md = MessageDigest.getInstance( "SHA-1" ); // 选择SHA-1，也可以选择MD5
            byte[] digest = md.digest( inStr.getBytes() ); // 返回的是byet[]，要转化为String存储比较方便
            outStr = byte2String( digest );
        }catch( NoSuchAlgorithmException e ){
            e.printStackTrace();
        }
        return outStr;
    }
    
    /**
     * @Description
     * <b>(MD5加密)</b></br>
     * @param inStr
     * @return 
     * String 
     * @since 2016-2-23    
    */
    public static String md5( String inStr ){
        MessageDigest md = null;
        String outStr = null;
        try{
            md = MessageDigest.getInstance( "MD5" ); // MD5
            byte[] digest = md.digest( inStr.getBytes() ); // 返回的是byet[]，要转化为String存储比较方便
            outStr = byte2String( digest );
        }catch( NoSuchAlgorithmException e ){
            e.printStackTrace();
        }
        return outStr;
    }

    /**
     * @Description
     * <b>(byte数组转字符串)</b></br>
     * @param digest
     * @return 
     * String 
     * @since 2016-3-6    
    */
    public static String byte2String( byte[] digest ){
        String str = "";
        String tempStr = "";
        for( int i = 1; i < digest.length; i++ ){
            tempStr = (Integer.toHexString( digest[i] & 0xff ));
            if( tempStr.length() == 1 ){
                str = str + "0" + tempStr;
            }else{
                str = str + tempStr;
            }
        }
        return str.toLowerCase();
    }

}
