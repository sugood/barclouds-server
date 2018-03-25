<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1" width="90%" cellpadding="5" align="center">
	<tr >
		<th>序号</th>
		<th>用户名</th>
		<th>${map.title.fieldName0}</th>
		<th>${map.title.fieldName1}</th>
		<th>${map.title.fieldName2}</th>
		<th>${map.title.fieldName3}</th>
		<th>${map.title.fieldName4}</th>
		<th>${map.title.fieldName5}</th>
		<th>${map.title.fieldName6}</th>
		<th>${map.title.fieldName7}</th>
		<th>${map.title.fieldName8}</th>
		<th>${map.title.fieldName9}</th>
		<th>
			<a href="${ pageContext.request.contextPath }/deleteData.do?actionName=deleteDataAction&uid=${map.title.uid}&flag=1" onclick="return confirm('确定删除所有数据吗?')" >删除所有</a>
		</th>
	</tr>
	
	<c:forEach var="map" items="${ map.page.beanList }" varStatus="s">
		<tr align="center">
			<td>${ s.count }</td>
			<td>${ map.uid }</td>
			<td>${ map.field0 }</td>
			<td>${ map.field1 }</td>
			<td>${ map.field2 }</td>
			<td>${ map.field3 }</td>
			<td>${ map.field4 }</td>
			<td>${ map.field5 }</td>
			<td>${ map.field6 }</td>
			<td>${ map.field7 }</td>
			<td>${ map.field8 }</td>
			<td>${ map.field9 }</td>
			<td>
				<a href="${ pageContext.request.contextPath }/deleteData.do?actionName=deleteDataAction&id=${map.id}&flag=0" onclick="return confirm('确定删除吗?')" >删除</a>
			</td>
		</tr>
	</c:forEach>
</table>

<center>
	第${ map.page.pageCode }页/共${ map.page.totalPage }页
	<a href="${ pageContext.request.contextPath }/dataListByPage.do?actionName=dataListByPageAction&pc=1">首页</a>
	<c:if test="${ map.page.pageCode > 1 }">
		<a href="${ pageContext.request.contextPath }/dataListByPage.do?actionName=dataListByPageAction&pc=${map.page.pageCode - 1}">上一页</a>
	</c:if>
	
	<c:choose>
		<%--如果totalPage <= 10 --%>
		<c:when test="${ map.page.totalPage <= 10 }">
			<c:set var="begin" value="1"></c:set>
			<c:set var="end" value="${ map.page.totalPage }"></c:set>
		</c:when>
		<c:otherwise>
			<%--算法：begin=pageCode -5  end = pageCode +4 --%>
			<c:set var="begin" value="${ map.page.pageCode - 5 }"></c:set>
			<c:set var="end" value="${ map.page.pageCode + 4 }"></c:set>
			<%--头溢出  尾部溢出 --%>
			<c:if test="${ begin < 1 }">
				<c:set var="begin" value="1"></c:set>
				<c:set var="end" value="10"></c:set>
			</c:if>
			<c:if test="${ end > map.page.totalPage }">
				<c:set var="begin" value="${ map.page.totalPage - 9 }"></c:set>
				<c:set var="end" value="${ map.page.totalPage }"></c:set>
			</c:if>
		</c:otherwise>
	</c:choose>
	
	<%--目的：先1-10 for(int i=1;i<=10;i++) --%>
	<c:forEach var="i" begin="${ begin }" end="${ end }" step="1">
		<a href="${ pageContext.request.contextPath }/dataListByPage.do?actionName=dataListByPageAction&pc=${i}">[${ i }]</a>
	</c:forEach>
	
	<c:if test="${ map.page.pageCode < map.page.totalPage }">
		<a href="${ pageContext.request.contextPath }/dataListByPage.do?actionName=dataListByPageAction&pc=${map.page.pageCode + 1}">下一页</a>
	</c:if>
	<a href="${ pageContext.request.contextPath }/dataListByPage.do?actionName=dataListByPageAction&pc=${map.page.totalPage}">尾页</a>
</center>

</body>
</html>



