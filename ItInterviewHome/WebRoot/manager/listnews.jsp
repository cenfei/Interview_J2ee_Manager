<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="pg" uri="/WEB-INF/lib/pager-taglib.jar"%>
<%@taglib prefix="s" uri="/struts-tags"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
	<head>
		   <base href="<%=basePath%>"><link rel="shortcut icon" href="webfront/images/logo.png">

		<title>超级大薯条后台管理系统</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">


		<link href="style/css/auto.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" type="text/css" href="skin/css/base.css">
		<link href="style/css/Pager.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
		
		<script src="js/jquery.pager.js" type="text/javascript"></script>
		<script type="text/javascript" language="javascript">
	$(document).ready(function() {

		$(".menu a").hover(function() {
			$(this).next("em").animate({
				opacity : "show",
				top : "-75"
			}, "slow");
		}, function() {
			$(this).next("em").animate({
				opacity : "hide",
				top : "-85"
			}, "fast");
		});

	});

	var pageSum = 0;
	var nowPage = 1;
	$(document).ready(function() {
		//总页数，当前页数
		//初始化搜索条件参数
		
		var totalNum = "${pm.total}";
		pageSum = totalNum / 10;
		if (totalNum % 10 > 0) {
			pageSum = pageSum + 1;
		}
		nowPage = "${nowPageOffet}";

		document.getElementById("thePageNumId").value = nowPage;
		if (nowPage == null || nowPage == "") {
			nowPage = 1;
		}
		$("#pager").pager({
			pagenumber : nowPage,
			pagecount : pageSum,
			buttonClickCallback : PageClick
		});
	});

	PageClick = function(pageclickednumber) {

		//总页数，当前页数

		$("#pager").pager({
			pagenumber : pageclickednumber,
			pagecount : pageSum,
			buttonClickCallback : PageClick
		});

		document.getElementById("nowPageOffetId").value = pageclickednumber;

		subButton(pageclickednumber);
	};

	function subButton(pageclickednumber) {

		var hrefVal = "findSupernewsList.action?nowPageOffet="
				+ pageclickednumber;

		location.href = encodeURI(hrefVal);

	}

	function toThePage() {

		var thePageValue = $("#thePageNumId").val();
		//alert(thePageValue);
		if (thePageValue > pageSum) {
			thePageValue = pageSum;
			alert("亲，您的页数过大！");

		} else if (0 < thePageValue && thePageValue < pageSum) {

			document.getElementById("nowPageOffetId").value = thePageValue;
			//var cusVal = document.getElementById("customerTextId").value;
			//window.location = "findSingleCustomerVisit.action?nowPageOffet="
			//		+ pageclickednumber + "&customerId=" + cusVal;

			subButton(thePageValue);
		} else {
			alert("亲，您的页不符合规范！");
			document.getElementById("thePageNumId").value = "";
		}
	}
</script>
		<style type="text/css">
.menu {
	padding: 0;
	list-style: none;
}

.menu li {
	padding: 0;
	margin: 0 2px;
	float: left;
	position: relative;
	text-align: center;
}

.menu a {
	padding: 14px 10px;
	display: block;
	width: auto;
	text-decoration: none;
	font-size: 12px;
}

.emclass {
	background-color: yellow;
	color: blue;
	font-size: 16px;
	font-weight: 400;
	width: 250px;
	height: auto;
	position: absolute;
	top: -300px;
	left: -15px;
	text-align: left;
	font-style: normal;
	z-index: 2;
	display: none;
}


.zzpromblem-cont {
	height: 36px;
	overflow: hidden;
}

.zzpromblem-cont:hover {
	height: auto;
	min-height: 36px;
}
</style>

	</head>
	<body leftmargin="8" topmargin="8" >

		<!--  快速转换位置按钮  -->
		<table width="98%" border="0" cellpadding="0" cellspacing="1"
			align="center"  bgcolor="#EEF4EA">
			<tr>
				<td height="26">
					<div style='float: left'>
						<img height="14" src="skin/images/frame/book1.gif" width="20" />
						&nbsp;欢迎使用超级大薯条后台管理系统>>>新闻列表>>
					</div>

				</td>
			</tr>
				<tr>
				<td height="1" background="skin/images/frame/sp_bg.gif"
					style='padding: 0px'></td>
			</tr>
		</table>


		<input name="nowPageOffet" type="text" id="nowPageOffetId"
			value="${nowPageOffet}" style="display: NONE;" value="1" />
		<!--  内容列表   -->

		<table width="98%" border="0" cellpadding="2" cellspacing="1"
			bgcolor="#D1DDAA" align="center" style="margin-top: 8px">
			<tr bgcolor="#E7E7E7">
				<td height="24" colspan="15" background="skin/images/tbg.gif">
					<div>
						<strong>
							<div id="showSpanId"
								style="margin-left: 50px; font-size: 16px; float: left;"></div>
						</strong>


					</div>
				</td>
			</tr>
			<tr align="center" bgcolor="#FAFAF1" height="30">

				<td width="5%">
					<strong>序号</strong>
				</td>
				<td width="5%">
					<strong>新闻图片</strong>
				</td>
				
				<td width="15%">
					<strong>新闻主题</strong>
				</td>
				<td width="45%">
					<strong>内容简介</strong>
				</td>
				<td width="10%">
					<strong>发布时间</strong>
				</td>

				<td width="25%">
					<strong>操作</strong>
				</td>

			</tr>
			<%
				String nowPage = (String) request.getAttribute("nowPageOffet");
				Integer i = 1;
				if (nowPage != null) {
					i = (Integer.valueOf(nowPage) - 1) * 10 + 1;

				}
				if (i == 0) {
					i = 1;
				}
			%>
			<s:iterator value="pm.datas" var="s">
				<tr align='center' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='#FCFDEE';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="100">
					<td>
						<%=i++%>
					</td>
<td>
	<img alt=""
							src="${s.picUrl}"
							id="img1" style="width: 80px; height: 80px;" />				
				</td>
					<td align='left'>
					<div class="zzpromblem-cont">
						${s.title}
						</div>
					</td>
					<td align='left'>
						<div class="zzpromblem-cont">
								${s.content}
							</div>
						
					</td>
					<td>
						<s:if test='#s.showTimeDate!=null'>
						
							<s:property value="showTimeDate.toString().substring(0,16)" />
						</s:if>
					</td>

					<td>

						<a
							href="deleteSuperInfo.action?supernews.id=${s.id}"
						
							style="width: 60px; cursor: pointer; height: 32px; line-height: 32px; text-align: center; background: #999; color: #fff; display: inline-block; margin-left: 10px;">
							删除新闻</a>
						<a
							href="selectSuperInfo.action?supernews.id=${s.id}"
							
							style="width: 60px; cursor: pointer; height: 32px; line-height: 32px; text-align: center; background: #999; color: #fff; display: inline-block; margin-left: 10px;">
							修改新闻</a>
						<a
							href="manager/addnews.jsp"
						
							style="width: 60px; cursor: pointer; height: 32px; line-height: 32px; text-align: center; background: #999; color: #fff; display: inline-block; margin-left: 10px;">
							添加新闻</a>
					</td>
				</tr>
			</s:iterator>


			<tr bgcolor="#FAFAF1">
				<td height="28" colspan="15">
					<!--
	&nbsp;
	<a href="javascript:selAll()" class="coolbg">全选</a>
	<a href="javascript:noSelAll()" class="coolbg">取消</a>
	<a href="javascript:updateArc(0)" class="coolbg">&nbsp;更新&nbsp;</a>
	<a href="javascript:checkArc(0)" class="coolbg">&nbsp;审核&nbsp;</a>
	<a href="javascript:adArc(0)" class="coolbg">&nbsp;推荐&nbsp;</a>
	<a href="javascript:moveArc(0)" class="coolbg">&nbsp;移动&nbsp;</a>
	<a href="javascript:delArc(0)" class="coolbg">&nbsp;删除&nbsp;</a>
    -->
				</td>
			</tr>
			<tr align="right" bgcolor="#EEF4EA">
				<td height="36" colspan="15" align="center">
					<!--翻页代码 -->

					<div id="pager" align="right"></div>
					<div align="left">
						<input type="button" name="Submit2" value="返回"
							onclick="javascript:history.go(-1)" class="Btn" />
						<input type="text" style="width: 50px;" id="thePageNumId" />

						<input type="button" name="Submit3" value="跳转到指定页"
							onclick="toThePage()" class="Btn" />
					</div>
				</td>
			</tr>
		</table>




	</body>
</html>