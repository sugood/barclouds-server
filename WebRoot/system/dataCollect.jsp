<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'data_collect.jsp' starting page</title>
    
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
	<form action="dataCollect.do?actionName=dataCollectAction&state=1" method="post">
	<table width="50%" border="1" align="center" cellpadding="0"
		cellspacing="0" bordercolor="#CCCCCC">
		<caption><span class="style1"> 数据采集 </span><br>
		</caption>
		<tr align="left">
			<th width="40%" height="35" align="center" scope="row">${map.title.fieldName0}:</th>
			<td width="60%"><input name="field0" value="${map.page.field0}" type="text" id="field0" maxlength="60" style="width: 256px; "></td>
		</tr>
		<tr align="left">
			<th height="35" align="center" scope="row">${map.title.fieldName1}:</th>
			<td><input name="field1" type="text"  readonly="readonly" value="${map.page.field1}" id="field1" maxlength="60" style="width: 255px; "></td>
		</tr>
		<tr align="left">
			<th height="35" align="center" scope="row">${map.title.fieldName2}:</th>
			<td><input name="field2" type="text"  readonly="readonly" value="${map.page.field2}" id="field2" maxlength="60" style="width: 255px; "></td>
		</tr>
		<tr align="left">
			<th height="35" align="center" scope="row">${map.title.fieldName3}:</th>
			<td><input name="field3" type="text" readonly="readonly" value="${map.page.field3}" id="field3" maxlength="60" style="width: 255px; "></td>
		</tr>
		<tr align="left">
			<th height="35" align="center" scope="row">${map.title.fieldName4}:</th>
			<td><input name="field4" type="text" readonly="readonly" value="${map.page.field4}" id="field4" maxlength="60" style="width: 255px; "></td>
		</tr>
		<tr align="left">
			<th height="35" align="center" scope="row">${map.title.fieldName5}:</th>
			<td><input name="field5" type="text" readonly="readonly" value="${map.page.field5}" id="field5" maxlength="60" style="width: 255px; "></td>
		</tr>
		<tr align="left">
			<th height="35" align="center" scope="row">${map.title.fieldName6}:</th>
			<td><input name="field6" type="text" readonly="readonly" value="${map.page.field6}" id="field6" maxlength="60" style="width: 255px; "></td>
		</tr>
		<tr align="left">
			<th height="35" align="center" scope="row">${map.title.fieldName7}:</th>
			<td><input name="field7" type="text" readonly="readonly" value="${map.page.field7}" id="field7" maxlength="60" style="width: 255px; "></td>
		</tr>
		<tr align="left">
			<th height="35" align="center" scope="row">${map.title.fieldName8}:</th>
			<td><input name="field8" type="text" readonly="readonly" value="${map.page.field8}" id="field8" maxlength="60" style="width: 255px; "></td>
		</tr>
		<tr align="left">
			<th height="35" align="center" scope="row">${map.title.fieldName9}:</th>
			<td><input name="field9" type="text" readonly="readonly" value="${map.page.field9}" id="field9" maxlength="60" style="width: 255px; "></td>
		</tr>
		<tr align="center">
			<th height="35" colspan="2" scope="row">
				<input type="submit" name="submit" value="确认"> 
			</th>
		</tr>
	</table>
	</form>
  </body>
</html>
