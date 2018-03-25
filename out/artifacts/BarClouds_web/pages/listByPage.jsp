<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1" width="90%" cellpadding="5" align="center">
	<tr>
		<th>序号</th>
		<th>姓名</th>
		<th>性别</th>
		<th>生日</th>
		<th>电话</th>
		<th>邮箱</th>
		<th>爱好</th>
		<th>类型</th>
	</tr>
	<c:forEach var="customer" items="${ page.beanList }" varStatus="s">
		<tr align="center">
			<td>${ s.count }</td>
			<td>${ customer.username }</td>
			<td>${ customer.gender }</td>
			<td>${ customer.birthday }</td>
			<td>${ customer.cellphone }</td>
			<td>${ customer.email }</td>
			<td>${ customer.love }</td>
			<td>${ customer.type }</td>
		</tr>
	</c:forEach>
</table>

<center>
	第${ page.pageCode }页/共${ page.totalPage }页
	<a href="${ pageContext.request.contextPath }/listByPage.do?actionName=listByPageAction&pc=1">首页</a>
	<c:if test="${ page.pageCode > 1 }">
		<a href="${ pageContext.request.contextPath }/listByPage.do?actionName=listByPageAction&pc=${page.pageCode - 1}">上一页</a>
	</c:if>
	
	<c:choose>
		<%--如果totalPage <= 10 --%>
		<c:when test="${ page.totalPage <= 10 }">
			<c:set var="begin" value="1"></c:set>
			<c:set var="end" value="${ page.totalPage }"></c:set>
		</c:when>
		<c:otherwise>
			<%--算法：begin=pageCode -5  end = pageCode +4 --%>
			<c:set var="begin" value="${ page.pageCode - 5 }"></c:set>
			<c:set var="end" value="${ page.pageCode + 4 }"></c:set>
			<%--头溢出  尾部溢出 --%>
			<c:if test="${ begin < 1 }">
				<c:set var="begin" value="1"></c:set>
				<c:set var="end" value="10"></c:set>
			</c:if>
			<c:if test="${ end > page.totalPage }">
				<c:set var="begin" value="${ page.totalPage - 9 }"></c:set>
				<c:set var="end" value="${ page.totalPage }"></c:set>
			</c:if>
		</c:otherwise>
	</c:choose>
	
	<%--目的：先1-10 for(int i=1;i<=10;i++) --%>
	<c:forEach var="i" begin="${ begin }" end="${ end }" step="1">
		<a href="${ pageContext.request.contextPath }/listByPage.do?actionName=listByPageAction&pc=${i}">[${ i }]</a>
	</c:forEach>
	
	<c:if test="${ page.pageCode < page.totalPage }">
		<a href="${ pageContext.request.contextPath }/listByPage.do?actionName=listByPageAction&pc=${page.pageCode + 1}">下一页</a>
	</c:if>
	<a href="${ pageContext.request.contextPath }/listByPage.do?actionName=listByPageAction&pc=${page.totalPage}">尾页</a>
</center>

</body>
</html>



