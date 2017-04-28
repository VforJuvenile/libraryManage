<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>图书管理系统</title>
		<link href="css/bootstrap.min.css" rel="stylesheet">
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
		<h1 class="page-header">查看入库书籍</h1>

		<div style="padding-top: 30px"></div>

		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title text-center">查看图书信息</h3>
					</div>
					<div class="panel-body">
						<table class="table table-bordered">
							<tr>
								<td>图书编号：</td>
								<td><input type="text" class="form-control" value="${bookInfo.bookCode}" disabled></td>
								<td colspan="2"></td>
								<td>图书名称：</td>
								<td><input type="text" class="form-control" value="${bookInfo.bookName}" disabled></td>
							</tr>
							<tr>
								<td>图书类型：</td>
								<td><input type="text" class="form-control" value="${bookInfo.bookType.typeName}" disabled></td>
								<td colspan="2"></td>
								<td>作者：</td>
								<td><input type="text" class="form-control" value="${bookInfo.bookAuthor}" disabled></td>
							</tr>
							<tr>
								<td>出版社：</td>
								<td><input type="text" class="form-control" value="${bookInfo.publishPress}" disabled></td>
								<td colspan="2"></td>
								<td>是否借阅：</td>
								<td><input type="text" class="form-control" value="${(bookInfo.borrowed==0)?string('未借阅','已借阅')}" disabled></td>
							</tr>
							<tr>
								<td>入库人：</td>
								<td><input type="text" class="form-control" value="${bookInfo.createdBy}" disabled></td>
								<td colspan="2"></td>
								<td>入库时间：</td>
								<td><input type="text" class="form-control" value="${bookInfo.creationTime}" disabled></td>
							</tr>
						</table>
						<div class="text-center">
							<a class="btn btn-warning" href="/bookUpdate?id=${bookInfo.bookId}">修改</a>
							<button class="btn btn-success"
								onclick='javascript:history.go(-1)'>返回</button>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-2"></div>

			<!-- 关于与Addresses联系信息声明  -->
			<#include "common/layerInfo.ftl"/>
</body>
</html>



