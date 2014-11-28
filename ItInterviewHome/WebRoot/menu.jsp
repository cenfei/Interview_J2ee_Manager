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
	</head>
	<title>menu</title>
	<link rel="stylesheet" href="skin/css/base.css" type="text/css" />
	<link rel="stylesheet" href="skin/css/menu.css" type="text/css" />
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
	<script language='javascript'>
	
</script>
	<script language="javascript" type="text/javascript"
		src="skin/js/frame/menu.js">
	
</script>

	</head>
	<body target="main">
		<table width='99%' height="100%" border='0' cellspacing='0'
			cellpadding='0'>
			<tr>
				<td style='padding-left: 3px; padding-top: 8px' valign="top">
					<!-- Item 1 Strat -->

					<!-- Item 客户意向查询 -->

					<dl class='bitem' id="bitem0">
						<dt onClick='showHide("items0_1")'>
							<b>新闻管理</b>
						</dt>
						<dd style='display: block' class='sitem' id='items0_1'>
							<ul class='sitemu'>
								

<li>
									<div class='items'>
										<div class='fllct'>
											<a href='findSupernewsList.action' target='main'>新闻列表</a>
										</div>

									</div>
								</li>
<li>
									<div class='items'>
										<div class='fllct'>
											<a href='manager/addnews.jsp' target='main'>添加新闻</a>
										</div>

									</div>
								</li>
								


							</ul>
						</dd>
					</dl>










					<!-- Item 1 End -->
					<!-- Item 2 Strat -->
					<dl class='bitem'>
						<dt onClick='showHide("items6_1")'>
							<b>更多功能</b>
						</dt>
						<dd style='display: block' class='sitem' id='items6_1'>
							<ul class='sitemu'>
								<li>
									待扩建
								</li>
								<li>
									待扩建
									</l
						</dd>
					</dl>
					<!-- Item 2 End -->
				</td>
			</tr>
		</table>
	</body>
</html>