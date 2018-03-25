<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    <link rel="icon" href="<%=basePath%>/favicon.ico" type="image/x-icon">
	<link rel="shortcut icon" href="<%=basePath%>/favicon.ico" type="image/x-icon">
	
    <title>码云扫描</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="images/index.css">

	<script type="text/javascript" src="js/calendar.js"></script>
  </head>
  
  <body>
	<div id="header">
		<div id="top_logo">
			<img src="images/barclouds_logo.png"/>
		</div>
		<div id="top_login">
			<a href="pages/login.jsp">登陆/注册</a>
			<!--  
			<form>
				<input type="submit" value="登陆"/>
			</form>
			-->
		</div>
		<div id="top_nav" class="nav">
			<ul>
				<li><a href="#">首页</a></li>
				<li><a href="downAndroid.do?actionName=downAndroidAction">下载</a></li>
				<li><a href="#">功能介绍</a></li>
				<li><a href="#">关于</a></li>
			</ul>
		</div>
	
	</div>

	<div class="bannerbox">
        <div class="banner">
            <img src="images/poster.jpg">
        </div>
    </div> 
    <!--	<div style="background:#08a7e9; color:#08a7e9" id="poster">
			<img src="images/poster.jpg"/>
	</div>  -->

	
	<div class="wy-platform-download" id="_download_cnt">
	    <ul class="wy-platform-wrap">
	        <li class="wy-platform wy-android">
	            <a href="downAndroid.do?actionName=downAndroidAction" class="wy-platform-item">
	                <img src="images/download_android_ico.jpg"/>
	            </a>
	            <span class="wy-platform-txt">Android版</span>
	        </li>
	        <li class="wy-platform wy-iphone">
	            <a href="javascript:void(0)" class="wy-platform-item">
	                <img src="images/download_iphone_ico.jpg"/>
	            </a>
	            <span class="wy-platform-txt">iPhone版</span>
	        </li>
	        <li class="wy-platform wy-ipad">
	            <a href="javascript:void(0)" class="wy-platform-item">
	                <img src="images/download_ipad_ico.jpg"/>
	            </a>
	            <span class="wy-platform-txt">iPad版</span>
	        </li>
	        <li class="wy-platform wy-win">
	            <a href="javascript:void(0)" class="wy-platform-item">
	                <img src="images/download_windows_ico.jpg"/>
	            </a>
	            <span class="wy-platform-txt">Windows版</span>
	        </li>
	    </ul>
	</div>
	</body>
</html>
