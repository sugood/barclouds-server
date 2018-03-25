<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage=""%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
 <base href="<%=basePath%>">
<link rel="icon" href="<%=basePath%>/favicon.ico" type="image/x-icon">
<link rel="shortcut icon" href="<%=basePath%>/favicon.ico" type="image/x-icon">
<meta http-equiv="Content-Type" content="text/html; charset=ut-8">
<title>用户注册</title>
</head>
<body>
<form form action="userRegister.do?actionName=userRegisterAction" method="post"
	onsubmit="return checkForm(this)">
<table width="80%" border="0" align="center" cellpadding="2"
	cellspacing="0">
	<caption><font color="blue" style="font-size: 20px">用户注册</font><br>
	</caption>
	<tr bgcolor="#EFEFEF">
		<td width="25%" align="right">用户名:</td>
		<td width="30%" valign="bottom"><input name="uid" type="text" id="uid"
			size="20" maxlength="50"></td>
		<td style="font-size:12px;color:red;">${userNameError}</td>
	</tr>
	<tr bgcolor="#EFEFEF">
		<td colspan="3">*(用户名由a～z的英文字母(不区分大小写)、0～9的数字、点、减号或下划线组成，长度为3～18个字符)</td>
	</tr>
	<tr>
		<td>密 码:</td>
		<td><input name="password" type="password" id="password" size="20"
			maxlength="50"></td>
		<td>*(密码长度为6～16位，区分字母大小写。登录密码可以由字母、数字、特殊字符组成。)</td>
	</tr>
	<tr bgcolor="#EFEFEF">
		<td height="40" valign="middle">密码确认:</td>
		<td><input name="confirmPassword" type="password" id="confirmPassword"
			size="20" maxlength="50"></td>
		<td>*(请再输一遍，以便确认！)</td>
	</tr>
	<tr>
		<td valign="middle">电子邮件:</td>
		<td><input name="email" type="text" size="20" maxlength="50"></td>
		<td>*(请您输入正确的E-mail地址！<FONT color=#cc0000>方便您的密码查询</FONT>！)</td>
	</tr>
	<tr bgcolor="#EFEFEF">
		<td align="right">性 别:</td>
		<td>
		<p><label><input type="radio" name="gender" value="1" checked>酷哥</label>
		<label><input type="radio" name="gender" value="0">靓女</label><br>
		</p>
		</td>
		<td>&nbsp</td>
	</tr>
	<tr>
		<td align="right" valign="middle">
		<div align="right">密码提示问题:</div>
		</td>
		<td><input name="question" type="text" size="20" maxlength="50"></td>
		<td>*(帐号验证以及用于帮你找回密码！)</td>
	</tr>
	<tr bgcolor="#EFEFEF">
		<td valign="middle">
		<div align="right">提示问题答案:</div>
		</td>
		<td><input name="answer" type="text" size="20" maxlength="50"></td>
		<td bgcolor="#EFEFEF">*(找回密码的答案！)</td>
	</tr>
	<tr>
		<td align="right">真实姓名:</td>
		<td><input name="realName" type="text" id="realName" size="20"
			maxlength="50"></td>
		<td>&nbsp;</td>
	</tr>
	<tr bgcolor="#EFEFEF">
		<td align="right">联系电话:</td>
		<td><input name="tel" type="text" id="telphone" size="20"
			maxlength="50"></td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td colspan="3" align="center"><input type="submit" name="Submit"
			value="提交"></td>
	</tr>
</table>
</form>
</body>
</html>
<script language="javascript">
	function checkForm(form){
		if(isEmpty(form.uid.value) || isEmpty(form.password.value) || isEmpty(form.confirmPassword.value) || isEmpty(form.email.value) || isEmpty(form.question.value) || isEmpty(form.answer.value) ){
			alert("请将必填项填写完整!");
			return false;
		}
		if(form.password.value!=form.confirmPassword.value){
			alert("两次密码不匹配!");
			return false;
		}
		if(form.password.value.length<6 || form.password.value.length>16){
			alert("密码长度不得少于6个字符，不得多于16个字符！");
			return false;
		}
		return true;
	}
	function isEmpty(str){
		if(str==null || str.length==0)
			return true;
		else 
			return false;
	}
	function checkUid(){
		var name=document.userRegisterForm.uid.value;
		if(name.length>0){
			window.open("checkUid.jsp?uid=" +name ,"检查用户名","toolbar=no, location=no,status=no,menubar=no, scrollbars=no,resizable=no,width=300,height=200");
		}
	}
</script>

