/**    
 * 文件名：AttachmentUtils.java    
 *
 * 版本信息：    
 * 日期：2016年2月19日    
 * create by ziQi       
 * 2016年2月19日
 */
package com.xiaoi.dev.utils;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.eastrobot.robotface.domain.RobotCommand;
import com.xiaoi.dev.entity.RobotRequest;
import com.xiaoi.dev.entity.RobotResponse;

/**
 * @title AttachmentUtils
 * @description 处理各种答案，返回自定义的类型
 * @author ziQi
 * @version 上午8:13:24
 * @create_date 2016年2月19日上午8:13:24
 * @copyright (c) jacky
 */
public class AttachmentUtils{

    /**
     * @Description <b>(自定义答案类型消息)</b></br>
     * @param robotResponse
     * @return RobotResponse
     * @since 2016年2月19日
     */
    public static RobotResponse rebuild( RobotRequest robotRequest, RobotResponse robotResponse ){
        RobotCommand[] commands = robotResponse.getCommands();
        
        //默认为空
        robotResponse.setAttachment( new HashMap<String, String>() );
        if( commands != null ){
            for( int i = 0; i < commands.length; i++ ){
                RobotCommand command = commands[i];
                if( "imgtxtmsg".equals( command.getName() ) ){// 图文消息
                    // 图文type=201
                    robotResponse.setType( 201 );
                    String commandArgs[] = command.getArgs();
                    if( commandArgs != null && commandArgs.length >= 4 ){
                        robotResponse.setAttachment( getImgtxtmsg( commandArgs[3], robotRequest ) );
                    }
                }else if( "imgmsg".equals( command.getName() ) ){// 图片消息
                    // 图片type=202
                    robotResponse.setType( 202 );
                    String commandArgs[] = command.getArgs();
                    String resouceUrl = MessageResourceUtils.getString( "x.attachment.resource.url", robotRequest.getPlatform() );
                    if( commandArgs.length >= 3 ){
                        Map<String, String> map = new HashMap<String, String>();
                        map.put( "name", "imgmsg" );//图片标识
                        map.put( "title", commandArgs[0] );//标题
                        map.put( "description", commandArgs[1] );//描述
                        String url = commandArgs[2];
                        if( !StringUtils.startsWith( commandArgs[2], "http" ) ){
                            url = resouceUrl + commandArgs[2];
                        }
                        map.put( "url", url );//图片资源地址
                        robotResponse.setAttachment( map );
                    }
                }else if( "musicmsg".equals( command.getName() ) ){// 音频消息
                    //音频type=203
                    robotResponse.setType( 203 );
                    String commandArgs[] = command.getArgs();
                    String resouceUrl = MessageResourceUtils.getString( "x.attachment.resource.url", robotRequest.getPlatform() );
                    if( commandArgs.length > 3 ){
                        Map<String, String> map = new HashMap<String, String>();
                        map.put( "name", "musicmsg" );//标识
                        map.put( "title", commandArgs[0] );//标题
                        map.put( "description", commandArgs[1] );//描述
                        String url = commandArgs[2];//音频资源地址
                        String imageUrl = commandArgs[3];//缩略图地址
                        if( !StringUtils.startsWith( url, "http" ) ){
                            url = resouceUrl + commandArgs[2];
                        }
                        if( !StringUtils.startsWith( imageUrl, "http" ) ){
                            imageUrl = resouceUrl + commandArgs[3];
                        }
                        map.put( "imageUrl" , imageUrl );//缩略图地址
                        map.put( "url", url );//音频资源地址
                        robotResponse.setAttachment( map );
                    }
                }else if( "videomsg".equals( command.getName() ) ){//视频消息
                    //视频type=204
                    robotResponse.setType( 204 );
                    String commandArgs[] = command.getArgs();
                    String resouceUrl = MessageResourceUtils.getString( "x.attachment.resource.url", robotRequest.getPlatform() );
                    if( commandArgs.length > 3 ){
                        Map<String, String> map = new HashMap<String, String>();
                        map.put( "name", "videomsg" );//标识
                        map.put( "title", commandArgs[0] );//标题
                        map.put( "description", commandArgs[1] );//描述
                        String url = commandArgs[2];//视频资源地址
                        String imageUrl = commandArgs[3];//缩略图地址
                        if( !StringUtils.startsWith( url, "http" ) ){
                            url = resouceUrl + commandArgs[2];
                        }
                        if( !StringUtils.startsWith( imageUrl, "http" ) ){
                            imageUrl = resouceUrl + commandArgs[3];
                        }
                        map.put( "url", url );//视频资源地址
                        map.put( "imageUrl" , imageUrl );//缩略图地址
                        robotResponse.setAttachment( map );
                    }
                }
            }
        }

        return robotResponse;
    }

    /**
     * @Description <b>(自定义图文描述格式)</b></br>
     * @param str
     *            产品的图文消息内容
     * @param platform
     *            渠道
     * @return List<Map<String,String>>
     * @since 2016年2月19日
     */
    public static List<Map<String, String>> getImgtxtmsg( String str, RobotRequest robotRequest ){
        //userId,platform,location
        Object[] params = new Object[]{ robotRequest.getUserId(),robotRequest.getPlatform(),robotRequest.getLocation() };
        String tmp = null;
        List<Map<String, String>> txImgs = new ArrayList<Map<String, String>>();
        try{
            // tmp
            if( str != null ){
                tmp = str.trim();
                if( tmp.startsWith( "<![CDATA[" ) ){
                    int end = tmp.lastIndexOf( "]]>" );
                    tmp = tmp.substring( 9, end );
                }
            }

            Document doc = null;
            // 将字符串转为XML
            doc = DocumentHelper.parseText( tmp );
            // 获取根节点
            Element root = doc.getRootElement();
            List itemList = root.elements( "item" );
            if( itemList != null ){
                int size = itemList.size();
                for( int i = 0; i < size; i++ ){
                    Element item = (Element) itemList.get( i );
                    Map<String, String> map = new HashMap<String, String>();
                    // 标题Title
                    Element title = item.element( "Title" );
                    if( title != null ){
                        System.out.println( title.getTextTrim() );
                        map.put( "title", title.getTextTrim() );
                    }

                    // 描述Description
                    Element description = item.element( "Description" );
                    if( description != null ){
                        System.out.println( description.getTextTrim() );
                        map.put( "description", description.getTextTrim() );
                    }
                    // 图片PicUrl
                    Element image = item.element( "PicUrl" );
                    String domainUrl = MessageResourceUtils.getString( "x.attachment.domain.url", robotRequest.getPlatform() );
                    if( image != null ){
                        String imageUrl = image.getTextTrim();
                        System.out.println( image.getTextTrim() );
                        if( StringUtils.isNotEmpty( imageUrl ) ){
                            if( !StringUtils.startsWith( imageUrl, "http" ) ){
                                if( StringUtils.isNotEmpty( domainUrl ) ){
                                    imageUrl = domainUrl + imageUrl;
                                }
                            }else{
                                if( StringUtils.isNotEmpty( domainUrl ) ){
                                    if( StringUtils.equals( domainUrl, imageUrl ) ){
                                        imageUrl = "";
                                    }
                                }
                            }
                        }
                        map.put( "image", imageUrl );
                    }
                    // 正文地址
                    Element url = item.element( "Url" );
                    if( url != null ){
                        String urlStr = url.getTextTrim();
                        System.out.println( url.getTextTrim() );
                        if( !StringUtils.startsWith( urlStr, "http" ) ){
                            if( StringUtils.isNotEmpty( domainUrl ) ){
                                urlStr = domainUrl + urlStr;
                            }
                        }
                        map.put( "url", MessageFormat.format( urlStr, params ) );
                    }
                    txImgs.add( map );
                }
            }
        }catch( DocumentException e ){
            e.printStackTrace();
        }
        return txImgs;
    }

}
