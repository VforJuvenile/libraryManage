<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>图书管理系统</title>
		<link href="css/bootstrap.min.css" rel="stylesheet">
			<link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet" />
			<!-- （重要，这就是日期控件所需的样式表） -->
			<!--[if lt IE 9]>
				<script src="js/html5shiv.js"></script>
				<script src="js/respond.min.js"></script>
			<![endif]-->
			<style>
body {
	padding-top: 50px;
	padding-bottom: 40px;
	color: #5a5a5a;
}

/* 下面是左侧导航栏的代码 */
.sidebar {
	position: fixed;
	top: 51px;
	bottom: 0;
	left: 0;
	z-index: 1000;
	display: block;
	padding: 20px;
	overflow-x: hidden;
	overflow-y: auto;
	background-color: #ddd;
	border-right: 1px solid #eee;
}

.nav-sidebar {
	margin-right: -21px;
	margin-bottom: 20px;
	margin-left: -20px;
}

.nav-sidebar>li>a {
	padding-right: 20px;
	padding-left: 20px;
}

.nav-sidebar>.active>a, .nav-sidebar>.active>a:hover, .nav-sidebar>.active>a:focus
	{
	color: #fff;
	background-color: #428bca;
}

.main {
	padding: 20px;
}

.main .page-header {
	margin-top: 0;
}

.table tr td {
	vertical-align: middle !important; /* 表格文本居中 */
	border: 1px solid transparent !important; /* 去除表格边框，设置为隐藏*/
}
</style>
</head>

<body>
	<!--下面是顶部导航栏的代码-->
	<#include "common/header.ftl" />

	<!—右侧管理控制台-->
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<h1 class="page-header">新增入库书籍</h1>

		<div style="padding-top: 30px"></div>

		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<div class="panel panel-primary">
					<div class="panel-heading">

						<h3 class="panel-title text-center">新增图书信息</h3>
					</div>
					<div class="panel-body">
						<form action="/saveBookInfo" role="form" method="post" >

							<table class="table table-bordered">
								<tr>
									<td>图书编号：</td>
									<td><input type="text" class="form-control" name="bookCode"></td>
									<td colspan="2"></td>
									<td>图书名称：</td>
									<td><input type="text" class="form-control" name="bookName"></td>
								</tr>
								<tr>
									<td>图书类型：
										<div style="margin-left: 20px;">
											<a herf="JavaScript:;" data-target="#add-libraryType" data-toggle="modal"
												class="glyphicon glyphicon-plus "></a>
										</div>
									</td>
									<td><select class="form-control" name="bookType">
											<option>--请选择--</option>
											<#list bookTypeList as bookType>
												<option value="${bookType.id}">${bookType.typeName}</option>
											</#list>	
									</select></td>
									<td colspan="2"></td>
									<td>作者：</td>
									<td><input type="text" class="form-control" name="bookAuthor"></td>
								</tr>
								<tr>
									<td>出版社：</td>
									<td><input type="text" class="form-control" name="publishPress"></td>
									<td colspan="2"></td>
									<td>是否借阅：</td>
									<td><select class="form-control" name="borrowed">
											<option value="0">未借阅</option>
											<option value="1">已借阅</option>
									</select></td>
								</tr>
								<tr>
									<td>入库人：</td>
									<td><input type="text" class="form-control" name="createdBy"></td>
									<td colspan="2"></td>
									<td>入库时间：</td>
									<td><input type="text" class="form-control"
										id="datetimepicker" name="creationTime"></td>
								</tr>
							</table>
							<div class="text-center">
								<button type="submit" class="btn btn-info">保存</button>
								<button class="btn btn-success"
									onclick='javascript:history.go(-1)'>返回</button>
							</div>
						</form>
					</div>
				</div>
			</div>
			<div class="col-md-2"></div>
			<!-- 关于弹出层   -->
			<#include "common/layerInfo.ftl"/>
			<script type="text/javascript"
				src="js/bootstrap-datetimepicker.min.js"></script>
			 <!--（重要，这就是日期控件所需的js） -->
			<script type="text/javascript"
				src="js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
			<!-- （重要，弹出日历里面 显示的文字,bootstrap里面显示的是英文 ，触发后显示的年月日等的显示文字，即为：Jan，feb等等） -->
			
			<!-- bootstrap-datetimepicker时间插件设置 -->
			<script type="text/javascript">
			
			    $("#datetimepicker").datetimepicker({
			        minView: "month",   //  选择日期后，不会再跳转去选择时分秒 
			        language:  'zh-cn',
			        autoclose : true,   //  设置选择时间后自动关闭
			        format: 'yyyy-mm-dd',   // 文本框时间格式
			        todayBtn: true,
			        endDate : new Date()    // 最大时间
			    });
			    
			</script>
</body>
</html>



