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

		<title>猿面试后台</title>
		     <link rel="shortcut icon" href="images/favicon.ico">
		
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!-- Libraries -->
		<link type="text/css" href="managerstyle/css/login.css" rel="stylesheet" />	
	
		<!-- End of Libraries -->	
	</head>

	<script language="javascript" type="text/javascript">
	function loginFunc() {
		var userName = document.getElementById("userNameId").value;
		var passWord = document.getElementById("passwordId").value;
		if (userName != null && passWord != null && userName != ""
				&& passWord != "") {

			document.loginForm.submit();
		} else {

			document.getElementById("document").innerHtml = "用户名密码不能为空!!!";
		}
		return false;
	}
</script>

	

	
	</head>
	<body>
	<div id="container">
		<div class="logo">
			<a href="#"><img src="managerstyle/assets/logo.png" alt="" /></a>
		</div>
		<div id="box">
			<form action="loginManger.action" name="loginForm" method="post"
			enctype="multipart/form-data">
			<p class="main">
				<label>用户名: </label>
				<input  id="userNameId" name="userName" /> 
				<label>密码: </label>
				<input type="password" name="passWord" id="passwordId">	
			</p>

			<p class="space">
<!-- 				<span><input type="checkbox" />Remember me</span> -->
				<input type="button" value="Login" onclick="loginFunc()" class="login" />
			</p>
			</form>
		</div>
	</div>

	</body>
</html>