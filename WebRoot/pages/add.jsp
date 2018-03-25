<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${ pageContext.request.contextPath }/js/My97DatePicker/WdatePicker.js"></script>
<title>Insert title here</title>
</head>
<body>


<form action="${ pageContext.request.contextPath }/add" method="post">
	<table border="1" width="50%" cellpadding="5" align="center"> 
		<tr>
			<td>客户姓名</td>
			<td>
				<input type="text" name="username" />
			</td>
		</tr>
		<tr>
			<td>客户性别</td>
			<td>
				<input type="radio" name="gender" value="男" checked/>男
				<input type="radio" name="gender" value="女"/>女
			</td>
		</tr>
		<tr>
			<td>客户生日</td>
			<td>
				<input type="text" name="birthday" readonly="readonly" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})"/>
			</td>
		</tr>
		<tr>
			<td>客户电话</td>
			<td>
				<input type="text" name="cellphone" />
			</td>
		</tr>
		<tr>
			<td>客户邮箱</td>
			<td>
				<input type="text" name="email" />
			</td>
		</tr>
		<tr>
			<td>客户爱好</td>
			<td>
				<input type="checkbox" name="love" value="敲代码"/>敲代码
				<input type="checkbox" name="love" value="大宝剑" checked/>大宝剑
				<input type="checkbox" name="love" value="电影"/>电影
				<input type="checkbox" name="love" value="吃饭"/>吃饭
			</td>
		</tr>
		<tr>
			<td>客户类型</td>
			<td>
				<select name="type">
					<option value="青铜会员">青铜会员</option>
					<option value="白银会员">白银会员</option>
					<option value="黄金会员">黄金会员</option>
					<option value="钻石会员">钻石会员</option>
				</select>
			</td>
		</tr>
		<tr align="center">
			<td colspan="2">
				<input type="submit" value="添加" />
			</td>
		</tr>
	</table>
</form>


</body>
</html>