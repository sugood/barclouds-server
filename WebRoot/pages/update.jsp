<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${ pageContext.request.contextPath }/js/My97DatePicker/WdatePicker.js"></script>
<title>Insert title here</title>
</head>
<body>

<form action="${ pageContext.request.contextPath }/update" method="post">
	
	<!-- 添加隐藏域 -->
	<input type="hidden" name="id" value="${ c.id }" />
	
	<table border="1" width="50%" cellpadding="5" align="center"> 
		<tr>
			<td>客户姓名</td>
			<td>
				<input type="text" name="username" value="${ c.username }"/>
			</td>
		</tr>
		<tr>
			<td>客户性别</td>
			<td>
				<input type="radio" name="gender" value="男" <c:if test="${ c.gender eq '男' }">checked</c:if> />男
				<input type="radio" name="gender" value="女" <c:if test="${ c.gender eq '女' }">checked</c:if> />女
			</td>
		</tr>
		<tr>
			<td>客户生日</td>
			<td>
				<input type="text" name="birthday" value="${ c.birthday }" readonly="readonly" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
			</td>
		</tr>
		<tr>
			<td>客户电话</td>
			<td>
				<input type="text" name="cellphone" value="${ c.cellphone }"/>
			</td>
		</tr>
		<tr>
			<td>客户邮箱</td>
			<td>
				<input type="text" name="email" value="${ c.email }"/>
			</td>
		</tr>
		<tr>
			<td>客户爱好</td>
			<td>
				<input type="checkbox" name="love" value="敲代码" <c:if test="${ fn:contains(c.love,'敲代码') }">checked</c:if>/>敲代码
				<input type="checkbox" name="love" value="大宝剑" <c:if test="${ fn:contains(c.love,'大宝剑') }">checked</c:if>/>大宝剑
				<input type="checkbox" name="love" value="电影" <c:if test="${ fn:contains(c.love,'电影') }">checked</c:if>/>电影
				<input type="checkbox" name="love" value="吃饭" <c:if test="${ fn:contains(c.love,'吃饭') }">checked</c:if>/>吃饭
			</td>
		</tr>
		<tr>
			<td>客户类型</td>
			<td>
				<select name="type">
					<option value="青铜会员" <c:if test="${ c.type eq '青铜会员' }">selected</c:if>>青铜会员</option>
					<option value="白银会员" <c:if test="${ c.type eq '白银会员' }">selected</c:if>>白银会员</option>
					<option value="黄金会员" <c:if test="${ c.type eq '黄金会员' }">selected</c:if>>黄金会员</option>
					<option value="钻石会员" <c:if test="${ c.type eq '钻石会员' }">selected</c:if>>钻石会员</option>
				</select>
			</td>
		</tr>
		<tr align="center">
			<td colspan="2">
				<input type="submit" value="确认修改" />
			</td>
		</tr>
	</table>
</form>

</body>
</html>