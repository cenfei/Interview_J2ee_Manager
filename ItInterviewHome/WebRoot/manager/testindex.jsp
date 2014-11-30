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
		<base href="<%=basePath%>">
		<link rel="shortcut icon" href="images/logo_interview.png">

		<title>猿面试管理后台</title>


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


		<div class="weiduduan clearfix">

			<div class="top">
				<h1>
					全国城市三级联动
				</h1>
			</div>
			<div class="info">
				<select id="s_language_type" name="s_language_type"  onchange="change(1)"></select>
				&nbsp;&nbsp;
				<select id="s_contentfirst_type" name="s_contentfirst_type" onchange="change(2)"></select>
				&nbsp;&nbsp;
				<select id="s_contentsecond_type" name="s_contentsecond_type"></select>
				<script type="text/javascript"
					src="managerstyle/js/interviewtype.js"></script>
				<script type="text/javascript">
	_init_area();
</script>
			</div>
		</div>
		<!-- weiduduan End -->



	</body>
</html>