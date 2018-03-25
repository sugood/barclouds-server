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

<form action="${ pageContext.request.contextPath }/listByWhere" method="post">
	<table align="center" cellpadding="5">
		<tr>
			<td>
				客户姓名：<input type="text" name="username" value="${ username }"/>
			</td>
			<td>
				客户类型：<select name="type">
						<option value="">--请选择--</option>
						<option value="青铜会员" <c:if test="${ type eq '青铜会员' }">selected</c:if>>青铜会员</option>
						<option value="白银会员" <c:if test="${ type eq '白银会员' }">selected</c:if>>白银会员</option>
						<option value="黄金会员" <c:if test="${ type eq '黄金会员' }">selected</c:if>>黄金会员</option>
						<option value="钻石会员" <c:if test="${ type eq '钻石会员' }">selected</c:if>>钻石会员</option>
					</select>
			</td>
			<td>
				<input type="submit" value="查询" />
			</td>
		</tr>
	</table>
</form>


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
		<th>操作</th>
	</tr>
	<c:forEach var="customer" items="${ cList }" varStatus="s">
		<tr align="center">
			<td>${ s.count }</td>
			<td>${ customer.username }</td>
			<td>${ customer.gender }</td>
			<td>${ customer.birthday }</td>
			<td>${ customer.cellphone }</td>
			<td>${ customer.email }</td>
			<td>${ customer.love }</td>
			<td>${ customer.type }</td>
			<td>
				<a href="${ pageContext.request.contextPath }/initUpdate?id=${customer.id}">修改</a>
				|
				<a href="${ pageContext.request.contextPath }/delete?id=${customer.id}" onclick="return confirm('确定删除吗?')" >删除</a>
			</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>



