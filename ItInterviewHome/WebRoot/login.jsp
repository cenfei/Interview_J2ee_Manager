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
		     <link rel="shortcut icon" href="webfront/images/logo.png">
		
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
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
	<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	overflow: hidden;
}

.STYLE3 {
	color: #528311;
	font-size: 14px;
}

.STYLE4 {
	color: #42870a;
	font-size: 12px;
}
-->
</style>
	</head>

	<body>
		<form action="loginManger.action" name="loginForm" method="post"
			enctype="multipart/form-data">
			<table width="100%" height="100%" border="0" cellpadding="0"
				cellspacing="0">
				<tr>
					<td bgcolor="#e5f6cf">
						&nbsp;
					</td>
				</tr>
				<tr>
					<td height="608" background="images/login_03.gif">
						<table width="862" border="0" align="center" cellpadding="0"
							cellspacing="0">
							<tr>
								<td height="266" background="images/login_04_new.png">
									&nbsp;
								</td>
							</tr>
							<tr>
								<td height="95">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td width="424" height="95" background="images/login_06.gif">
												&nbsp;
											</td>
											<td width="183" background="images/login_07.gif">
												<table width="100%" border="0" cellspacing="0"
													cellpadding="0">
													<tr>
														<td width="26%" height="30">
															<div align="center">
																<span class="STYLE3">用户：</span>
															</div>
														</td>
														<td width="74%" height="30">
															<input type="text" id="userNameId" name="userName"
																style="height: 20px; width: 130px; border: solid 1px #cadcb2; font-size: 12px; color: #81b432;">
														</td>
													</tr>
													<tr>
														<td height="30">
															<div align="center">
																<span class="STYLE3">密码：</span>
															</div>
														</td>
														<td height="30">
															<input type="password" name="passWord" id="passwordId"
																style="height: 20px; width: 130px; border: solid 1px #cadcb2; font-size: 12px; color: #81b432;">
														</td>
													</tr>
													<tr>
														<td height="30">
															&nbsp;
														</td>
														<td height="30">
															<input type="button" value="登陆" onclick="loginFunc()"
																width="100">


															<!-- <a href="#" onclick="loginFunc();return false"><img  src="images/log_but.gif"  height="24">  </a>
               -->
														</td>
													</tr>
												</table>
											</td>
											<td width="255" background="images/login_08.gif">
												&nbsp;
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td height="247" valign="top" background="images/login_09.gif">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td width="22%" height="30">
												&nbsp;
											</td>
											<td width="56%">
												<div id="showWordId"
													style="margin-left: 60%; color: red; font-size: 10px;"></div>
											</td>
											<td width="22%">
												&nbsp;
											</td>
										</tr>
										<tr>
											<td>
												&nbsp;
											</td>
											<td height="30">
												<table width="100%" border="0" cellspacing="0"
													cellpadding="0">
													<tr>
														<td width="44%" height="20">
															&nbsp;
														</td>
														<td width="56%" class="STYLE4">
															版本 2013V1.0
														</td>
													</tr>
												</table>
											</td>
											<td>
												&nbsp;
											</td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td bgcolor="#a2d962">
						&nbsp;
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
