<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'dataManage.jsp' starting page</title>
    
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
    <form action="dataCollect.do?actionName=dataCollectAction" method="post">
	<table width="50%" border="1" align="center" cellpadding="0"
		cellspacing="0" bordercolor="#CCCCCC">
		<caption><span class="style1"> 数据管理 </span><br>
		</caption>
		<tr align="left">
			<th width="40%" height="35" align="center" scope="row">条 码:</th>
			<td width="60%"><input name="field0" type="text" id="field0" maxlength="20"></td>
			<td style="font-size:12px;color:red;">${uidError}</td>
		</tr>
		<tr align="left">
			<th height="35" align="center" scope="row">密&nbsp;&nbsp;码:</th>
			<td><input name="password" type="password" id="password"
				maxlength="30"></td>
			<td style="font-size:12px;color:red;">${passwordError}</td>
		</tr>
		<tr align="center">
			<th height="35" colspan="2" scope="row">
				<input type="submit" name="submit" value="确认"> 
				<!--  
				<input type="submit" name="submit" value="返回">
				-->
				<input type="button" name="Submit2"
				value="返回" onclick="javascript:window.location='system/userRegister.jsp'">
			</th>
		</tr>
	</table>
	</form>
  </body>
</html>
