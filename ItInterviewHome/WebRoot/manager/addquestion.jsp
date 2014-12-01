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

<title>发布面试题</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
<meta name="description" content="">
<meta name="author" content="">
<script type="text/javascript" src="managerstyle/js/jquery.min.js"></script>

<link rel="stylesheet" href="managerstyle/css/add.css" type="text/css"
	media="screen" />
<link rel="stylesheet" href="managerstyle/utilLib/bootstrap.min.css"
	type="text/css" media="screen" />
<script language="javascript">
	function registerButton() {
		var result = $("input").filter("[required]").map(function(i, n) {
			if ($(this).val() === "") {
				return true;
			}
		}).length;
		var result2 = $("textarea").filter("[required]").map(function(i, n) {
			if ($(this).val() === "") {
				return true;
			}
		}).length;
		
		result = result && $("select").filter("[required]").map(function(i,n){if( $(this).find("option:selected").val()==="请选择"){return true;}}).length;
		
		result = result && result2;
		if (result) {
			alert("请把必填项填完整");

		} else {
			document.regform.submit();
		}
	}
</script>
</head>
<body>

	<div class="div_from_aoto" style="width: auto;">
		<form class="form-register" role="form" name="regForm"
			action="registrAccount.action" method="post"
			enctype="multipart/form-data">
			<div class="control-group">
				<label class="laber_from"> 发布人昵称 </label>
				<div class="controls">
					<p class=help-block>
						<input class="input_from" type=text name="publisherName"
							placeholder=" 发布人昵称" required="required"> &nbsp;
					</p>
				</div>
			</div>

			<div class="control-group">
				<label class="laber_from"> 问题语言分类 </label>
				<div class="controls">
					<p class=help-block>
						<select name="s_language_type" id="s_language_type"  required="required">

						</select> &nbsp;选择发布的面试题语言
					</p>
				</div>
			</div>

			<div class="control-group">
				<label class="laber_from"> 问题内容一级分类 </label>
				<div class="controls">
					<p class=help-block>
						<select name="s_contentfirst_type" id="s_contentfirst_type"  required="required">


						</select> &nbsp;选择面试题的一级内容分类
					</p>
				</div>
			</div>
			<div class="control-group">
				<label class="laber_from"> 问题内容二级分类 </label>
				<div class="controls">
					<p class=help-block>
						<select name="s_contentsecond_type" id="s_contentsecond_type"  required="required">

						</select> &nbsp;选择面试题的二级内容分类
					</p>
				</div>
			</div>
			<!--********************************此处的类别三级级联必须写在这里**************************-->
			<script type="text/javascript" src="managerstyle/js/interviewtype.js"></script>
			<script type="text/javascript">
				_init_area();
			</script>
			<!--********************************此处的类别三级级联必须写在这里**************************-->

			<div class="control-group">
				<label class="laber_from"> 问题来源 </label>
				<div class="controls">
					<INPUT class="input_from" style="width: 300px;" type=text
						name="publisherName" required="required" placeholder="问题来源">
					<p class=help-block></p>
				</div>

			</div>
			<div class="control-group">
				<label class="laber_from"> 题型分类 </label>
				<div class="controls">
					<select class="input_select">
						<option selected>选择题</option>
						<option>填空题</option>
						<option>简答题</option>

					</select>
				</div>
			</div>
			<div class="control-group">
				<label class="laber_from"> 问题描述(左中右英) </label>
				<div class="controls">
					<textarea class="input_from" style="width: 500px; height: 150px;"
						type=text placeholder="问题描述(中文)" required="required"></textarea>
					&nbsp;
					<textarea class="input_from" style="width: 500px; height: 150px;"
						type=text placeholder="问题描述(英文)"></textarea>
					<p class=help-block></p>
				</div>
			</div>

			<div class="control-group">
				<label class="laber_from"> 问题选项(左中右英) </label>
				<div class="controls">
					<p class=help-block>
						<textarea class="input_from" style="width: 500px; height: 150px;"
							type=text placeholder="选择题时需要填(中文)"></textarea>
						&nbsp;
						<textarea class="input_from" style="width: 500px; height: 150px;"
							type=text placeholder="选择题时需要填(英文)"></textarea>
					</p>
				</div>
			</div>
			<div class="control-group">
				<label class="laber_from"> 推荐答案(左中右英) </label>
				<div class="controls">
					<textarea class="input_from" style="width: 500px; height: 200px;"
						type=text placeholder="推荐答案及描述(中文)" required="required"></textarea>
					&nbsp;
					<textarea class="input_from" style="width: 500px; height: 200px;"
						type=text placeholder="推荐答案及描述(英文)"></textarea>
					<p class=help-block></p>
				</div>
			</div>

			<div class="control-group">
				<label class="laber_from"> 问题关键字 </label>
				<div class="controls">
					<p class=help-block>
						<INPUT class="input_from" style="width: 400px;" type=text
							required="required" placeholder="问题关键字">
						&nbsp;用逗号隔开,最多8个,总长度不能超过150个字符
					</p>
				</div>

			</div>

			<div class="control-group">
				<label class="laber_from"> 题型难度分类 </label>
				<div class="controls">
					<select class="input_select">
						<option selected>简单</option>
						<option>中等</option>
						<option>难</option>
					</select>
				</div>
			</div>
			<div class="control-group">
				<label class="laber_from"></label>
				<div class="controls">
					<button type="submit" class="btn btn-success">提交</button>
					<!-- 						<button class="btn btn-success" style="width: 120px;"> -->
					<!-- 							确认 -->
					<!-- 						</button> -->
				</div>
			</div>
		</form>
	</div>
</body>
</html>