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

/* 底部文本置底居中 */
.footer {
	position: fixed;
	bottom: 0px;
	left: 50%;
	text-align: center;
}
</style>
</head>

<body>
	<!--下面是顶部导航栏的代码-->
	<#include "common/header.ftl" />

	<!—右侧管理控制台-->
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		<h1 class="page-header">管理控制台</h1>
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">最新上架</h3>
					</div>
					<div class="panel-body">
						<table class="table table-striped ">
							<thead>
								<tr>
									<th>#</th>
									<th>图书编号</th>
									<th>图书名称</th>
									<th>作者</th>
									<th>出版社</th>
									<th>入库时间</th>
								</tr>
							</thead>
							<tbody>
							<#list bookInfoNewList as bookInfo>
								<tr>
									<td>${bookInfo_index}</td>
									<td>${bookInfo.bookCode}</td>
									<td>${bookInfo.bookName}</td>
									<td>${bookInfo.bookAuthor}</td>
									<td>${bookInfo.publishPress}</td>
									<td>${bookInfo.creationTime}</td>
								</tr>
							</#list>	
							</tbody>
						</table>
						<p>
							<a class="btn btn-primary" href="/bookList" role="button">查看详细&raquo;</a>
						</p>
					</div>
				</div>
			</div>

			<!-- 关于与Addresses联系信息声明  -->
			<#include "common/layerInfo.ftl"/> <#include "common/footer.ftl"/>
</body>
</html>



