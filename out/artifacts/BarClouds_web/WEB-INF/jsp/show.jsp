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
    
    <title>User Show</title>
    
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
  <c:if test="${not empty userList}">
	<table style="width: 600px; text-align: center;" cellpadding="0"
		cellspacing="0" border="1">
		<tr>
			<th>
				用户名
			</th>
			<th>
				年龄
			</th>
			<th>
				生日
			</th>
			<th>
				是否是会员
			</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${userList}" var="user">
			<tr>
				<td>
					${user.userName }
				</td>
				<td>
					${user.age }
				</td>
				<td>
					<fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd" />
				</td>
				<td>
					<c:choose>
						<c:when test="${user.isVip}">是</c:when>
						<c:otherwise>不是</c:otherwise>
					</c:choose>
				</td>
				<td>
					<a href="modify.do?actionName=userModifyAction&userId=${user.userId}">修改</a>
					<a href="delete.do?actionName=userDeleteAction&userId=${user.userId}">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	&nbsp;&nbsp;<a href="index.jsp">增加用户</a>
  </c:if>
  <c:if test="${empty userList}">
  	<h2>暂时还没有任何数据，点击<a href="index.jsp">此处</a>进行增添数据</h2>
  </c:if>
  </body>
</html>
