<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ioManage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		body,div,ul,ol,li,dl,dt,dd,h1,h2,h3,h4,h5,h6,from,input,textarea,p{
			margin:0px;
			padding:0px;
			font-size:13px
			}
		#id{
			width:1024px;
			height:90px;
			margin:0 auto;
			}
		#upload{
			float:left;
			margin: 0 auto;
			width:400px;
			height:100px;
			padding:15px 0 0 10px;
			background-color:#FFFFFF
		}
		#download{
			width:400px;
			height:100px;
			float:right;
			padding:15px 0 0 10px;
			background-color:#FFFFFF
		}
	</style>
  </head>
  
  <body>
	  <div id="io">
	  	<div id="upload">
		    <form name="myform" action="ioManage.do?actionName=ioManageAction" method="post"
		       enctype="multipart/form-data">
		       <p align="center"><strong>导入资料文件EXCEL格式<br /></strong></p>
		       	请选择文件:<br>
		       <input type="file" name="myfile"><br>
		       <br>
		       <input type="submit" name="submit" value="导入数据">
		    </form>
	    </div>
	    <div id="download">
		    <form name="myform" action="download.do?actionName=downLoadAction" method="post"
		       enctype="multipart/form-data">
		       <p align="center"><strong>导出数据文件EXCEL格式<br /></strong></p>
		       	请选择格式:<br>
		       <input type="submit" name="submit" value="导出excel2007">
		       <br/>
		       <br/>
		       <input type="submit" name="submit" value="导出excel2003">
		    </form>
	    </div>
	</div>
  </body>
</html>
