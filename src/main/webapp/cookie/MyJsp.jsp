<!-- 同一页面在同一浏览器里面只能打开一个 -->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'MyJsp.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script language="javascript" type="text/javascript">
	window.onload = function() {
		if (GetCookie("IsOpen") == "") {
			SetCookie("IsOpen", "1");
			//StartService();
		} else {
			window.onunload = null;
			window.opener = null;
			window.open("", "_self");
			window.close();
			alert('当前已经打开了一个页面了！');
		}
	}
	window.onunload = function() {
		if (GetCookie("IsOpen") != "")
			DeleteCookie("IsOpen");
	}
	function GetCookieVal(offset) {
		/// <summary> 
		/// //取得项名称为offset的cookie值 
		/// </summary> 
		/// <param name="name">Cookie名称</param> 
		var endstr = document.cookie.indexOf(";", offset);
		if (endstr == -1)
			endstr = document.cookie.length;
		return unescape(document.cookie.substring(offset, endstr));
	}
	function GetCookie(name) {
		/// <summary> 
		/// 根据名称获得Cookie值 
		/// </summary> 
		/// <param name="name">Cookie名称</param> 
		var arg = name + "=";
		var alen = arg.length;
		var clen = document.cookie.length;
		var i = 0;
		while (i < clen) {
			var j = i + alen;
			if (document.cookie.substring(i, j) == arg)
				return GetCookieVal(j);
			i = document.cookie.indexOf(" ", i) + 1;
			if (i == 0)
				break;
		}
		return "";
	}
	function SetCookie(name, value) {
		/// <summary> 
		/// 设置Cookie 
		/// </summary> 
		/// <param name="name">Cookie名称</param> 
		/// <param name="value">Cookie值</param> 
		var argc = SetCookie.arguments.length;
		var argv = SetCookie.arguments;
		var path = (argc > 3) ? argv[3] : null;
		var domain = (argc > 4) ? argv[4] : null;
		var secure = (argc > 5) ? argv[5] : false;
		document.cookie = name + "=" + value
				+ ((path == null) ? "" : ("; path=" + path))
				+ ((domain == null) ? "" : ("; domain=" + domain))
				+ ((secure == true) ? "; secure" : "");
	}
	function DeleteCookie(name) {
		/// <summary> 
		/// 删除Cookie 
		/// </summary> 
		/// <param name="name">Cookie名称</param> 
		var exp = new Date();
		exp.setTime(exp.getTime() - 1);
		var cval = GetCookie(name);
		document.cookie = name + "=" + cval + "; expires=" + exp.toGMTString();
	}
</script>
</head>

<body>
	This is my JSP page.
	<br>
</body>
</html>
