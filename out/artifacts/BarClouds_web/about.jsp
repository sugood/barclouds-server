<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <link rel="icon" href="<%=basePath%>/favicon.ico" type="image/x-icon">
	<link rel="shortcut icon" href="<%=basePath%>/favicon.ico" type="image/x-icon">
	
    <title>My JSP 'about.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
		<div id="about" class="content" style="display:block;">
		  <div align="center">
		    <p> </p>
		    <p><strong>云码扫描系统（WWW.BARCLOUDS.COM）</strong></p>
		    <p><strong>版本号:V1.0.0</strong></p>
		    <p> </p>
		    </div>
		</div>
  </body>
</html>
