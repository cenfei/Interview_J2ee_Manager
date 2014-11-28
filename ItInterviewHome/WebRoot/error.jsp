<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

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
</head>
<title>错误页面</title>
<link href="css/auto.css" rel="stylesheet" type="text/css" />
<script language="javascript" type="text/javascript">
setTimeout("javascript:window.parent.location.href='login.jsp'", 2000);
</script>
<style>
.textClass {
	width: 200px;
	height: 20px;
}
</style>

</head>

<body>
	
	<!-- 清除浮动 -->

	<div class="wrap">

		<div class="login_main_white">
			<div class="login_main_announce">
				<ol>
					<li></li>
				</ol>
			</div>
			<div class="clearfix"></div>
		</div>
		<div align="center">
			<img alt="" src="images/error.png" width="600px" height="350px">
		</div>
 <input type="button" name="Submit2" value="返回" onclick="javascript:history.go(-1)"
						class="Btn" />
	</div>






</body>
</html>