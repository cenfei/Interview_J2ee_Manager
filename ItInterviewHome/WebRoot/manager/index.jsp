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
		  <link rel="shortcut icon" href="images/favicon.ico">

		<title>猿面试后台</title>
	

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	</head>

	<link rel="stylesheet" href="managerstyle/css/index.css"
		type="text/css" media="screen" />

	<script type="text/javascript" src="managerstyle/js/jquery.min.js"></script>
	<script type="text/javascript" src="managerstyle/js/tendina.min.js"></script>
	<script type="text/javascript" src="managerstyle/js/common.js"></script>

	</head>
	<body>
		<!--顶部-->
		<div class="layout_top_header">

<!-- 			<div style="float: left ;padding-left: 20px;padding-top: 2px;text-align:center;" > -->
<!-- 			<img alt="" src="images/logo_interview.png" style="width: 40px;height: 40px;"> -->
<!-- 			<span style="font-size: 20px; color: #8d8d8d;text-align:center;"> -->
<!-- 			猿面试后台</span> -->
					
			<h1  style="float: left ;padding-left: 20px;"><img alt="" src="images/logo_interview.png" style="width: 40px;height: 40px;vertical-align:middle;"> 
         <span style="font-size: 20px; color: #8d8d8d;">猿面试后台管理</span>
        </h1>
<!-- 			</div> -->
			<div id="ad_setting" class="ad_setting">
				<a class="ad_setting_a" href="javascript:; "> <i
					class="icon-user glyph-icon" style="font-size: 20px"></i> <span>管理员</span>
					<i class="icon-chevron-down glyph-icon"></i> </a>
				<ul class="dropdown-menu-uu" style="display: none"
					id="ad_setting_ul">
					<li class="ad_setting_ul_li">
						<a href="javascript:;"><i class="icon-user glyph-icon"></i>
							个人中心 </a>
					</li>
					<li class="ad_setting_ul_li">
						<a href="javascript:;"><i class="icon-cog glyph-icon"></i> 设置
						</a>
					</li>
					<li class="ad_setting_ul_li">
						<a href="javascript:;"><i class="icon-signout glyph-icon"></i>
							<span class="font-bold">退出</span> </a>
					</li>
				</ul>
			</div>
		</div>
		<!--顶部结束-->
		<!--菜单-->
		<div class="layout_left_menu">
			<ul id="menu">
				<li class="childUlLi">
					<a href="main.jsp" target="menuFrame"><i
						class="glyph-icon icon-home"></i>首页</a>
					<ul>
						<li>
							<a href="user_add.html" target="menuFrame"><i
								class="glyph-icon icon-chevron-right"></i>用户添加</a>
						</li>
					</ul>
				</li>
				<li class="childUlLi">
					<a href="user.html" target="menuFrame"> <i
						class="glyph-icon icon-reorder"></i>题库管理</a>
					<ul>
						<li>
							<a href="#"><i class="glyph-icon icon-chevron-right"></i>面试题库列表</a>
						</li>
						<li>
							<a href="manager/addquestion.jsp"><i class="glyph-icon icon-chevron-right"></i>发布面试题</a>
						</li>

					</ul>
				</li>
				<li class="childUlLi">
					<a href="role.html" target="menuFrame"> <i
						class="glyph-icon icon-reorder"></i>类别管理</a>
					<ul>
						<li>
							<a href="#"><i class="glyph-icon icon-chevron-right"></i>类别列表</a>
						</li>

					</ul>
				</li>
				<li class="childUlLi">
					<a href="#"> <i class="glyph-icon  icon-location-arrow"></i>菜单管理</a>
					<ul>
						<li>
							<a href="meunbox.html" target="menuFrame"><i
								class="glyph-icon icon-chevron-right"></i>扩展菜单</a>
						</li>
						<li>
							<a href="meunbox_add.html" target="menuFrame"><i
								class="glyph-icon icon-chevron-right"></i>扩展</a>
						</li>
						<li>
							<a href="#" target="menuFrame"><i
								class="glyph-icon icon-chevron-right"></i>扩展</a>
						</li>
						<li>
							<a href="#" target="menuFrame"><i
								class="glyph-icon icon-chevron-right"></i>扩展</a>
						</li>
					</ul>
				</li>
			</ul>
		</div>
		<!--菜单-->
		<div id="layout_right_content" class="layout_right_content">

			<div class="route_bg">
				
				<a href="#">欢迎使用</a>
			</div>
			<div class="mian_content">
				<div id="page_content">
					<iframe id="menuFrame" name="menuFrame" src="manager/addquestion.jsp"
						style="overflow: visible;" scrolling="yes" frameborder="no"
						width="100%" height="100%"></iframe>
				</div>
			</div>
		</div>
		<div class="layout_footer">
			<p>
				Copyright © 2014 - 靖飞科技股份有限公司
			</p>
		</div>
	</body>
</html>