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

.footer {
	position: fixed;
	bottom: 0px;
	left: 50%;
	text-align: center;
}

/* 查询详情图标按钮居中 */
.table tr td a {
	margin-left: 25px;
}
</style>
</head>

<body>
	<!--下面是顶部导航栏的代码-->
	<#include "common/header.ftl" />

	<!—右侧管理控制台-->
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

		<h1 class="page-header">
			图书列表
			<!-- 搜索 -->
			<form class="page-header navbar-form navbar-right "
				action="/bookList">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="${(seachName=='')?string('Seach',seachName)}" name="seachName">
				</div>
				<button type="submit" class="btn">提交</button>
			</form>
		</h1>

		<!-- 操作按钮 -->
		<p>
			<a href="/bookAdd" class="btn btn-primary">新增</a> 
			<button class="btn btn-danger" onclick="bookDel()">删除</button>
		</p>

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
									<th>图书分类</th>
									<th>图书名称</th>
									<th>作者</th>
									<th>出版社</th>
									<th>入库时间</th>
									<th>是否借阅</th>
									<th>查看详情</th>
								</tr>
							</thead>
							<tbody>
							<#list bookInfoList as bookInfo>
								<tr>
									<td><input type="checkbox" value="${bookInfo.bookId}"></td>
									<td>${bookInfo.bookCode}</td>
									<td>${bookInfo.bookType.typeName}</td>
									<td>${bookInfo.bookName}</td>
									<td>${bookInfo.bookAuthor}</td>
									<td>${bookInfo.publishPress}</td>
									<td>${bookInfo.creationTime}</td>
									<td>
									<#if bookInfo.borrowed == 0 >
										未借阅
										<#else> 已借阅
									</#if>
									</td>
									<td><a href="/bookInfo?id=${bookInfo.bookId}"><i
											class="glyphicon glyphicon-search"></i></a></td>
								</tr>
							</#list>	
							</tbody>
						</table>
						<!-- 分页start -->
						<div>
							<ul class="pager">
								<li class="previous"><a href="/bookList?seachName=${seachName}">首页</a></li>
								<#if page gt 0>
									<li><a href="/bookList?seachName=${seachName}&page=${page-1}">上一页</a></li>
								</#if>
									<#list 1..totalPageNum as pageNum>
										<#if pageNum gt 0>
											<li><a href="/bookList?seachName=${seachName}&page=${pageNum-1}">${pageNum}</a></li>
										</#if>
									</#list>
								<#if page lt totalPageNum-1>
								<li><a href="/bookList?seachName=${seachName}&page=${page+1}">下一页</a></li>
								</#if>
								<li class="next"><a href="/bookList?seachName=${seachName}&page=${totalPageNum-1}">末页</a></li>
							</ul>
						</div>
						<!-- 分页end -->
					</div>
				</div>
			</div>

			<!-- 关于与Addresses联系信息声明  -->

			<#include "common/layerInfo.ftl"/>
			
			<script type="text/javascript">
				function bookDel(){
					var $selected = $("input:checkbox:checked");
					if($selected.length==0){
						alert("请选择要删除的记录!");
						return ;
					}
					
					var bookIdAry = new Array();
					
					$selected.each(function(i){
						bookIdAry[i] = $(this).val();
					});
					
					if(confirm("确定要删除吗")){
						$.ajax({
							type : "POST",
							data : {"bookIdAry":bookIdAry},
							url : "${pageContext.request.contextPath}/deleteBookInfo",
							async: false,
							success : function(delInfo){
								alert(delInfo);
							}
						});
					}
					window.location.href = "${pageContext.request.contextPath}/bookList";
				}
			
			</script>
</body>
</html>



