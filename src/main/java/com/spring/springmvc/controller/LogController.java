package com.spring.springmvc.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 日志查看控制器
 * 
 * @author Mike.Peng
 * @time Apr 5, 2016  4:08:45 PM
 */
@Controller
@RequestMapping(value="/log/")
public class LogController {

	/**
	 * 写出日志查看的页面
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="view.do")
	public String viewPage(){
		String str = "<!DOCTYPE html><html><head><title>日志查看</title><meta http-equiv='content-type' content='text/html; charset=UTF-8'><script type='text/javascript'>var status = 1;var path = null;function sendRequest(path) {var xmlHttp = window.XMLHttpRequest ? new XMLHttpRequest() : new ActiveXObject('Microsoft.XMLHTTP');xmlHttp.open('post', 'log/refresh.do?path=' + path, true);xmlHttp.onreadystatechange = function() {if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {var newLog = xmlHttp.responseText;var oldLog = document.getElementById('log').innerHTML;document.getElementById('log').innerHTML = oldLog + newLog;}};xmlHttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');xmlHttp.send('value=1');};function reFresh(){status = 1;path = document.getElementById('path').value;fresh();};function fresh(){sendRequest(path);if(status == 1){window.setTimeout('fresh()',2000);}};function endFresh(){status = 0;}</script></head><body><div align='center' style='width:100%'><input id='path' type='text'/><button onclick='reFresh()'>刷新日志</button><button onclick='endFresh()'>停止刷新</button></div><div id='log'></div></body></html>";
		return str;
	}
	
	/**
	 * 获取需要返回的数据
	 * @param path
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="refresh.do")
	public String refresh(String path){
		return "success<br/>";
	}
}
