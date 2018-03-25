<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
 <base href="<%=basePath%>">
 <link rel="icon" href="<%=basePath%>/favicon.ico" type="image/x-icon">
<link rel="shortcut icon" href="<%=basePath%>/favicon.ico" type="image/x-icon">

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户登陆</title>
<meta http-equiv="expires" content="0">
<style type="text/css">
<!--
.style1 {color: #0000CC;font-size: 16px;font-weight: bold;}
-->
    </style>
</head>
<body>

<form action="userlogin.do?actionName=userLoginAction" method="post">
<table width="50%" border="1" align="center" cellpadding="0"
	cellspacing="0" bordercolor="#CCCCCC">
	<caption><span class="style1"> 登 录 </span><br>
	</caption>
	<tr align="left">
		<th width="40%" height="35" align="center" scope="row">用户名:</th>
		<td width="60%"><input name="uid" type="text" id="uid" maxlength="20"></td>
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
			<input type="submit" name="submit" value="登录"> 
			<!--  
			<input type="submit" name="submit" value="注册">
			-->
			<input type="button" name="Submit2"
			value="注册" onclick="javascript:window.location='userRegister.jsp'">
		</th>
	</tr>
</table>
</form>
</body>
</html>
