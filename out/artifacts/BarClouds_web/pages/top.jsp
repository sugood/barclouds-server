<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h2 align="center">客户管理平台</h2>
	<h4 align="center">
		<a href="${ pageContext.request.contextPath }/pages/add.jsp" target="main">添加客户</a> 
		| 
		<a href="${ pageContext.request.contextPath }/listCustomer" target="main">查询所有客户</a>
		| 
		<a href="${ pageContext.request.contextPath }/listByPage" target="main">查询所有客户(分页)</a>
	</h4>
</body>
</html>