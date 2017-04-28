<!-- 修改图书类型弹出层  start -->
<div class="modal fade" id="add-libraryType" tabindex="-1" role="dialog"
				aria-labelledby="add-libraryType" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">&times;</span><span class="sr-only">关闭</span>
							</button>
							<h4 class="modal-title" id="modal-label">新增图书类型</h4>
						</div>
						<div class="modal-body">
							<form class="form-inline" role="form" method="post" id="bookTypeForm">
								类型名称：&nbsp;&nbsp; <input type="text"
									class="form-control" id="addTypeName">
									<div style="margin-top: 20px">
										<button type="submit" class="btn btn-default">保存</button>
										<button type="button" class="btn btn-default"
											data-dismiss="modal">退出</button>
									</div>
							</form>
						</div>
					</div>
				</div>
			</div>
<!-- 修改图书类型弹出层  end -->

<!-- "关于"菜单弹出层start -->
    <div class="modal fade" id="about-modal" tabindex="-1" role="dialog" aria-labelledby="modal-label"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span
                            aria-hidden="true">&times;</span><span class="sr-only">关闭</span></button>
                    <h4 class="modal-title" id="modal-label">关于</h4>
                </div>
                <div class="modal-body">
                    <p>Bootstrap 是一个用于快速开发 Web 应用程序和网站的前端框架。Bootstrap 是基于 HTML、CSS、JavaScript的。</p>
                    <p>Spring Boot是由Pivotal团队提供的全新框架，其设计目的是用来简化新Spring应用的初始搭建以及开发过程。该框架使用了特定的方式来进行配置，从而使开发人员不再需要定义样板化的配置。</p>
                    <p>FreeMarker是一款模板引擎： 即一种基于模板和要改变的数据，   并用来生成输出文本（HTML网页、电子邮件、配置文件、源代码等）的通用工具。  它不是面向最终用户的，而是一个Java类库，是一款程序员可以嵌入他们所开发产品的组件。
                    </p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">了解了</button>
                </div>
            </div>
        </div>
    </div>
<!-- "关于"菜单弹出层end -->

<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>

<script type="text/javascript">
$(document).ready(function(){
	$("#bookTypeForm").submit(function(){
		var url = window.location.pathname + window.location.search;
		var typeName = $("#addTypeName").val();
		$.ajax({
			type : "POST",
			data : {"typeName":typeName},
			url : "${pageContext.request.contextPath}/addBookType",
			async: false,
			success : function(info){
				alert(info);
				window.location.href = url;
			}
		});
	});
});
</script>
