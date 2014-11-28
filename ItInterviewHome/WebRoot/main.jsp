<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
	<head>
		   <base href="<%=basePath%>"><link rel="shortcut icon" href="webfront/images/logo.png">

		<title>超级大薯条后台管理系统</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<title>main</title>
	<base target="_self">

	<link rel="stylesheet" type="text/css" href="skin/css/base.css" />
	<link rel="stylesheet" type="text/css" href="skin/css/main.css" />

	</head>
	<body leftmargin="8" topmargin='8'>
		<table width="98%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td>
					<div style='float: left'>
						<img height="14" src="skin/images/frame/book1.gif" width="20" />
						&nbsp;欢迎使用超级大薯条后台管理系统！
					</div>
					<div style='float: right; padding-right: 8px;'>
						<!--  //保留接口  -->
					</div>
				</td>
			</tr>
			<tr>
				<td height="1" background="skin/images/frame/sp_bg.gif"
					style='padding: 0px'></td>
			</tr>
		</table>
		<div class="login_main_white">
			<div class="login_main_announce">
				<ol>
					<li>
						<!-- 	<img alt="" src="images/welcome_new1.jpg" style="width:80%;height: 550px;margin-left:10%;margin-top:1%;"> -->

					</li>
				</ol>
			</div>
			<div class="clearfix"></div>
		</div>



	</body>
</html>