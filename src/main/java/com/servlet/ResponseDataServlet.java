package com.servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

public class ResponseDataServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//设置返回的字符串编码格式
		response.setCharacterEncoding("utf-8");
		//设置返回的数据类型为json字符串
		response.setContentType("application/json;charset=utf-8");
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("datatype", "json");
		jsonObject.put("message", "helloworld");
		
		PrintWriter out = response.getWriter();
		out.append(jsonObject.toJSONString());
		out.flush();
		out.close();
	}
}
