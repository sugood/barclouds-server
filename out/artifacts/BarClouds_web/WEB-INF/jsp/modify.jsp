<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>First page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/calendar.js"></script>
  </head>
  
  <body>
		<form action="userModify.do?actionName=userUpdateAction&userId=${user.userId}" method="post">
			<table style="text-align: center; width: 400px;">
				<tr>
					<td width="100">
						用户名
					</td>
					<td width="150">
						<input type="text" name="userName" value="${user.userName}" />
					</td>
					<td style="font-size:12px;color:red;">${userNameError}</td>
				</tr>
				<tr>
					<td>
						生日
					</td>
					<td>
						<input type="text" name="birthday" onclick="MyCalendar.SetDate(this)" value="<fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd"/>" />
					</td>
					<td style="font-size:12px;color:red;">${birthdayError}</td>
				</tr>
				<tr>
					<td>
						是否是会员
					</td>
					<td>
					
						<select name="isVip">
							<option value="no" <c:if test="${user.isVip==false}">selected="selected"</c:if>>否</option>
							<option value="yes" <c:if test="${user.isVip==true}">selected="selected"</c:if>>是</option>
						</select>
					</td>
					<td></td>
				</tr>
				<tr>
					<td colspan="3">
						<input type="submit" value="确认修改"/>
					</td>
				</tr>
			</table>
		</form>
		&nbsp;&nbsp;<a href="userList.do?actionName=userListAction">显示所有人的信息</a>
	</body>
</html>
