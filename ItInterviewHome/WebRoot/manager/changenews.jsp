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
		<link rel="shortcut icon" href="webfront/images/logo.png">

		<title>更新新闻</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport"
			content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" />
		<meta name="description" content="">
		<meta name="author" content="">
		<link rel="stylesheet" type="text/css" href="skin/css/base.css">
		<link rel="shortcut icon" href="docs-assets/ico/favicon.png">
		<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
		<script type="text/javascript" src="js/ajaxfileupload.js"></script>
		<script src="style/js/p-sign-register.js"></script>

		<script language="javascript">// Example: obj = findObj("image1");
function findObj(theObj, theDoc)
{ 
var p, i, foundObj; 
if(!theDoc) theDoc = document; 
if( (p = theObj.indexOf("?")) > 0 && parent.frames.length) 
{    theDoc = parent.frames[theObj.substring(p+1)].document;    theObj = theObj.substring(0,p); } if(!(foundObj = theDoc[theObj]) && theDoc.all) foundObj = theDoc.all[theObj]; for (i=0; !foundObj && i < theDoc.forms.length; i++)     foundObj = theDoc.forms[i][theObj]; for(i=0; !foundObj && theDoc.layers && i < theDoc.layers.length; i++)     foundObj = findObj(theObj,theDoc.layers[i].document); if(!foundObj && document.getElementById) foundObj = document.getElementById(theObj);    return foundObj;
}
//添加一个参与人填写行
function AddSignRow(){ //读取最后一行的行号，存放在txtTRLastIndex文本框中 
var txtTRLastIndex = findObj("txtTRLastIndex",document);
var rowID = parseInt(txtTRLastIndex.value);

var signFrame = findObj("SignFrame",document);
//添加行
var newTR = signFrame.insertRow(signFrame.rows.length);
newTR.id = "SignItem" + rowID;
newTR.class="SignItemClass";
//添加列:序号
var newNameTD=newTR.insertCell(0);
//添加列内容
newNameTD.innerHTML = newTR.rowIndex.toString();

//添加列:姓名
var newNameTD=newTR.insertCell(1);
//添加列内容
var  fileId='tfile' + rowID;
var  imgId='img' + rowID;
var fileNameId='fileName' + rowID;
var  onchangeC="uploadPic('"+fileId+"','"+imgId+"','"+fileNameId+"')";
newNameTD.innerHTML = '<input name="tfile" id="' + fileId + '" type="file" onchange="uploadPic(&quot;'+fileId+'&quot;,&quot;'+imgId+'&quot;,&quot;'+fileNameId+'&quot;)"/>';

//添加列:电子邮箱
var newEmailTD=newTR.insertCell(2);
//添加列内容
newEmailTD.innerHTML = "<img name='txtEMail" + rowID + "' id='img" + rowID + "' src='UploadHeadPic/logo.png' size='20' style='width: 150px; height: 150px;' />"
+"		<input type='hidden' name='superUrl' id='fileName"+rowID+"' />"
;



//添加列:删除按钮
var newDeleteTD=newTR.insertCell(3);
//添加列内容
newDeleteTD.innerHTML = "<div align='center' style='width:40px' ><input type='button' class='btn' value='删除' onclick=\"DeleteSignRow('SignItem" + rowID + "')\"></div>";

//将行号推进下一行
txtTRLastIndex.value = (rowID + 1).toString() ;
}



//删除指定行
function DeleteSignRow(rowid){
var signFrame = findObj("SignFrame",document);
var signItem = findObj(rowid,document);

//获取将要删除的行的Index
var rowIndex = signItem.rowIndex;

//删除指定Index的行
signFrame.deleteRow(rowIndex);

//重新排列序号，如果没有序号，这一步省略
for(i=rowIndex;i<signFrame.rows.length;i++){
signFrame.rows[i].cells[0].innerHTML = i.toString();
}
}//清空列表
function ClearAllSign(){
if(confirm('确定要清空所有参与人吗？')){
var signFrame = findObj("SignFrame",document);
var rowscount = signFrame.rows.length;

//循环删除行,从最后一行往前删除
for(i=rowscount - 1;i > 0; i--){
   signFrame.deleteRow(i);
}

//重置最后行号为1
var txtTRLastIndex = findObj("txtTRLastIndex",document);
txtTRLastIndex.value = "1";

//预添加一行
AddSignRow();
}
}



function uploadPic(tf,imgid,fname){
    
	
  	
	
	$.ajaxFileUpload({
        url:"uploadHeadpic.action",            //需要链接到服务器地址
        secureuri:false,
        fileElementId:tf,                     //文件选择框的id属性
        dataType: 'text/xml',  
   
        success: function (data)            //相当于java中try语句块的用法
       {
        	//var result=data.resultFileName;
        	//	   alert(data.resultFileName);
        	var result = data.replace("<pre>", "");
            result = result.replace("</pre>", "");
          
     result=     result.substring(result.indexOf(">")+1);
         
          var  h_img="#"+imgid;
          var  h_fname="#"+fname;
          
            $(h_img).attr("src","<%=basePath%>"+result);
            $(h_fname).val("<%=basePath%>" + result);
			}
		});
	}
</script>







		<!-- Bootstrap core CSS -->
		<link href="style/css/bootstrap.min.css" rel="stylesheet">

		<!-- Custom styles for this template -->
		<link href="style/css/p-register.css" rel="stylesheet">


		<link href="style/css/p.css" rel="stylesheet">

		<!-- Custom styles for this template -->

		<link href="style/css/p-active.css" rel="stylesheet">


	</head>
	<body leftmargin="8" topmargin='8'>


		<!--  快速转换位置按钮  -->
		<table width="98%" border="0" cellpadding="0" cellspacing="1"
			align="center" bgcolor="#EEF4EA">
			<tr>
				<td height="26">
					<div style='float: left'>
						<img height="14" src="skin/images/frame/book1.gif" width="20" />
						&nbsp;欢迎使用超级大薯条后台管理系统>>>更新新闻>>
					</div>

				</td>
			</tr>
			<tr>
				<td height="1" background="skin/images/frame/sp_bg.gif"
					style='padding: 0px'></td>
			</tr>
		</table>

		<!-- 注册页 -->
		<div class="container">

			<!-- 	<h2>注册用户</h2> -->
			<form class="form-register" role="form"
				action="updateSuperInfo.action" method="post"
				enctype="multipart/form-data">
				




<fieldset>




					<div class="form-group form-group-required">
						<label for="">
							新闻主题
						</label>
							<input type="hidden" value="${supernews.id}" name="supernews.id">
						<input type="text" class="form-control" id="" placeholder=""
							name="supernews.title" value="${supernews.title}">
					</div>


					<div class="form-group form-group-required">
						<label for="">
							新闻时间
						</label>
						<br>
						<input id="d4311" name="supernews.showTimeDate" value="${supernews.showTimeDate}" class="Wdate" type="text"
							onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
					</div>
					<div class="form-group form-group-required">
						<label for="">
							新闻内容
						</label>
						<textarea class="form-control" id="" placeholder=""
							name="supernews.content" style="height:300px;">${supernews.content}</textarea>
					</div>
					<div class="form-group form-group-required">


						<label for="">
							新闻标题图片
						</label>
						<div>
							<input type="file" id="tfile0" name="tfile"
								onchange="uploadPic('tfile0','img0','fileName0')" />

							<img alt="" src="${supernews.picUrl}" id="img0"
								style="width: 150px; height: 150px;" />
							<input type="hidden" name="headPicUrl" id="fileName0"  value="${supernews.picUrl}" />


							<p class="help-block">
								上传图片可以进行预览
							</p>
						</div>
					</div>



						<div class="form-group">

							<div>
								<label for="">
									上传新闻图片
								</label>
								<div>
									<input type="button" name="Submit" value="添加图片"
										onclick="AddSignRow()" class="btn btn-primary" />
									<input type="button" name="Submit2" value="清空"
										onclick="ClearAllSign()" class="btn" />
									<input name='txtTRLastIndex' type='hidden' id='txtTRLastIndex'
										value="1" />
								</div>
								<fieldset>
									<div class="form-group form-group-required">
										<table width="60%" border="0" cellpadding="2" cellspacing="1"
											bgcolor="#FCFDEE" align="center" style="margin-top: 8px"
											id="SignFrame">
											<tr id="trHeader" bgcolor="#E7E7E7">
												<td width="40" align="center">
													序号
												</td>
												<td width="64" align="center">
													选择文件
												</td>
												<td width="98" align="center">
													图片预览
												</td>

												<td width="57" align="center">
													操作
												</td>
											</tr>

<%int i=1;%>

<s:iterator value="picList" var="pic">
											<tr id="SignItem<%=i %>">
												<td>
													<%=i %>
												</td>
												<td>
													<input name="tfile" id="tfile<%=i %>" type="file"
														onchange="uploadPic('tfile<%=i %>','img<%=i %>','fileName<%=i %>')">
												</td>
												<td>
													<img name="txtEMail1" id="img<%=i %>"
														src="${pic}"
														size="20" style="width: 150px; height: 150px;">
													<input type="hidden" name="superUrl" id="fileName<%=i %>"
														value="${pic}">
												</td>
												<td>
													<div align="center" style="width: 40px">
														<input type="button" class="btn" value="删除"
															onclick="DeleteSignRow('SignItem<%=i%>')">
													</div>
												</td>
											</tr>
											<%i++;%>
											</s:iterator>


										</table>
									</div>
								</fieldset>
							</div>






						</div>

					
				</fieldset>



				<fieldset>
					<div class="form-group">

						<button type="submit" class="btn btn-primary">
							提交
						</button>

						<button type="reset" class="btn">
							重置
						</button>
					</div>
				</fieldset>
			</form>
		</div>
		<!-- /container -->


		<!-- Bootstrap core JavaScript
    ================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->

		<script src="style/js/bootstrap.min.js"></script>


	</body>
</html>