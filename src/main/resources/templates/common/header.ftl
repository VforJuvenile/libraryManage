<!--下面是顶部导航栏的代码-->
<nav class="navbar navbar-default navbar-inverse navbar-fixed-top"
	role="navigation">
	<!--代表导航栏-->
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.html">图书借阅管理系统</a>
		</div>
</nav>

<!—自适应布局-->
<div class="container-fluid">
	<div class="row">
		<!—左侧导航栏-->

		<div class="col-sm-3 col-md-2 sidebar">
			<ul class="nav nav-sidebar">
				<li><a href="/index"><i class="glyphicon glyphicon-home"></i>&nbsp;
						首页</a></li>
				<li><a href="/bookList"><i class="glyphicon glyphicon-book"></i>&nbsp;
						图书管理</a></li>
			</ul>
			<ul class="nav nav-sidebar">
				<li><a href="javascript:;"><i
						class="glyphicon glyphicon-cog"></i>&nbsp; 设置</a></li>
				<li><a href="javascript:;" data-toggle="modal"
					data-target="#about-modal"><i
						class="glyphicon glyphicon-magnet"> </i>&nbsp; 关于</a></li>
			</ul>
		</div>