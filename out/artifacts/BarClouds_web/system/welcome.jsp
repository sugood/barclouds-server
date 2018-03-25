<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    <link rel="icon" href="<%=basePath%>/favicon.ico" type="image/x-icon">
	<link rel="shortcut icon" href="<%=basePath%>/favicon.ico" type="image/x-icon">

    <title>欢迎登陆码云扫描系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	body{font-size:12px;}
	#header{
	width:1024px;
	height:90px;
	margin:0 auto;
	}
	#top_logo{
		float:left;
		margin: 0 auto;
		width:186;
		padding:15px 0 0 10px;
	}
	#header1{
		float:right;
	}
	#top_user{
		float:left;
		padding: 40px 0 0 10px;
	}
	#top_logout{
		float:right;
		padding: 40px 0 0 10px;
		/*margin:40px 0 10px 10px ;*/
	}
	ul,li,h2{margin:0;padding:0;}
	ul{list-style:none;}
	#top{width:1024px;height:40px;margin:0 auto;background-color:#CCCCCC}
	#top h2{width:150px;height:40px;background-color:#08a7e9;float:left;font-size:14px;text-align:center;line-height:40px;}
	#topTags{width:750px;height:40px;margin:0 auto;background-color:#CCCCCC;float:left}
	#topTags ul li{float:left;width:100px;height:25px;margin-right:5px;display:block;text-align:center;cursor:pointer;padding-top:15px;}
	#main{width:1024px;height:500px;margin:0 auto;background-color:#efefef;}
	#leftMenu{width:150px;height:500px;background-color:#08a7e9;float:left}
	#leftMenu ul{margin:10px;}
	#leftMenu ul li{width:130px;height:30px;display:block;background:#ffffff;cursor:pointer;line-height:30px;text-align:center;margin-bottom:5px;}
	#leftMenu ul li a{color:#000000;text-decoration:none;display:block;height:100%;/*将a填满整个li，要不不点击到a无法加载页面*/}
	#content{width:850px;height:500px;float:left}
	.content{width:840px;height:490px;display:none;padding:5px;overflow-y:auto;line-height:30px;}
	.content iframe{width:100%;height:100%}
	#footer{width:1024px;height:30px;margin:0 auto;background-color:#ccc;line-height:30px;text-align:center;}
	.content1 {width:840px;height:490px;display:block;padding:5px;overflow-y:auto;line-height:30px;}
	</style>
	
	<script type="text/javascript">
    window.onload = function () {
        function $(id) { return document.getElementById(id) }
        var menu = $("topTags").getElementsByTagName("ul")[0]; //顶部菜单容器
        var tags = menu.getElementsByTagName("li"); //顶部菜单
        var ck = $("leftMenu").getElementsByTagName("ul")[0].getElementsByTagName("li"); //左侧菜单
        var j;
        //点击左侧菜单增加新标签
        for (i = 0; i < ck.length; i++) {
            ck[i].onclick = function () {
                $("welcome").style.display = "none"//欢迎内容隐藏
                //循环取得当前索引
                for (j = 0; j < 7; j++) {
                    if (this == ck[j]) {
                        if ($("p" + j) == null) {
                            openNew(j, this.innerHTML); //设置标签显示文字
                        }
                        clearStyle();
                        $("p" + j).style.backgroundColor = "yellow";
                        clearContent();
                        $("c" + j).style.display = "block";
                    }
                }
               // return false;
            }
        }
        //增加或删除标签
        function openNew(id, name) {
            var tagMenu = document.createElement("li");
            tagMenu.id = "p" + id;
            tagMenu.innerHTML = name + "   " + "<img src='images/off.png' style='vertical-align:middle'/>";
            //标签点击事件
            tagMenu.onclick = function (evt) {
                clearStyle();
                tagMenu.style.backgroundColor = "yellow";
                clearContent();
                $("c" + id).style.display = "block";
            }
            //标签内关闭图片点击事件
            tagMenu.getElementsByTagName("img")[0].onclick = function (evt) {
                evt = (evt) ? evt : ((window.event) ? window.event : null);
                if (evt.stopPropagation) { evt.stopPropagation() } //取消opera和Safari冒泡行为;
                this.parentNode.parentNode.removeChild(tagMenu); //删除当前标签
                var color = tagMenu.style.backgroundColor;
                //设置如果关闭一个标签时，让最后一个标签得到焦点
                if (color == "#ffff00" || color == "yellow") {//区别浏览器对颜色解释
                    if (tags.length - 1 >= 0) {
                        clearStyle();
                        tags[tags.length - 1].style.backgroundColor = "yellow";
                        clearContent();
                        var cc = tags[tags.length - 1].id.split("p");
                        $("c" + cc[1]).style.display = "block";
                    }
                    else {
                        clearContent();
                        $("welcome").style.display = "block"
                    }
                }
            }
            menu.appendChild(tagMenu);
        }
        //清除标签样式
        function clearStyle() {
            for (i = 0; i < tags.length; i++) {
                menu.getElementsByTagName("li")[i].style.backgroundColor = "#FFCC00";
            }
        }
        //清除内容
        function clearContent() {
            for (i = 0; i < 6; i++) {
                $("c" + i).style.display = "none";
            }
        }
    }
	</script>
  </head>
  
  <body>
  		<div id="header">
			<div id="top_logo">
				<img src="images/barclouds_logo.png"/>
			</div>
			<div id="header1">
				<div id="top_user">
					 用户名：${sessionScope.userinfo}
				</div>
				<div id="top_logout">
					<a href="pages/logout.jsp">退出</a>
				</div>
			</div>
		</div>
		<div id="top">
		<h2>管理菜单</h2>
		<div id="topTags">
		<ul>
		</ul>
		</div>
		</div>
		<div id="main"> 
		<div id="leftMenu">
		<ul>
		<li><a href="dataCollect.do?actionName=dataCollectAction&state=0" target="content1">数据采集</a></li>
		<li><a href="dataListByPage.do?actionName=dataListByPageAction" target="content2">数据管理</a></li>
		<li><a href="infoListByPage.do?actionName=infoListByPageAction" target="content3">资料管理</a></li>
		<li><a href="system/ioManage.jsp" target="content4">导入导出</a></li>
		<li><a href="about.jsp" target="content5">信息反馈</a></li>
		<li><a href="about.jsp" target="content6">帮助信息</a></li>
		</ul>
		</div>
		<div id="content">
		<div id="welcome" class="content" style="display:block;">
		  <div align="center">
		    <p> </p>
		    <p><strong>欢迎使用云码扫描系统！</strong></p>
		    <p> </p>
		    </div>
		</div>
		<div id="c0" class="content"><iframe name="content1" frameborder="0" marginheight="0" marginwidth="0" scrolling="auto"></iframe></div>
		<div id="c1" class="content"><iframe name="content2" frameborder="0" marginheight="0" marginwidth="0" scrolling="auto"></iframe></div>
		<div id="c2" class="content"><iframe name="content3" frameborder="0" marginheight="0" marginwidth="0" scrolling="auto"></iframe></div>
		<div id="c3" class="content"><iframe name="content4" frameborder="0" marginheight="0" marginwidth="0" scrolling="auto"></iframe></div>
		<div id="c4" class="content"><iframe name="content5" frameborder="0" marginheight="0" marginwidth="0" scrolling="auto"></iframe></div>
		<div id="c5" class="content"><iframe name="content6" frameborder="0" marginheight="0" marginwidth="0" scrolling="auto"></iframe></div>
		</div>
		</div>
		<div id="footer">copyright for sugood </div>
  </body>
</html>
