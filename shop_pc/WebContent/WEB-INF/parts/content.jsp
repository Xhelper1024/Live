<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="comm" class="container" style="min-height: 700px;">
	<div class="row">
		<div class="col-lg-3">
			<div class="col-lg-12">
				<div class="panel panel-default navbar navbar-default">
					<div class="panel-body">
						<h3>分类</h3>
						<ul class="nav nav-pills nav-stacked">
							<li><a href="#">家电类</a></li>
							<li><a href="#">电脑类</a></li>
							<li><a href="#">电子类</a></li>
							<li><a href="#">科技类</a></li>
							<li><a href="#">男装</a></li>
							<li><a href="#">女装</a></li>
							<li><a href="#">水果店</a></li>
							<li><a href="#">运动服装</a></li>
							<li><a href="#">休闲类</a></li>
							<li><a href="#">测试分类</a></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown"> 更多分类 <b class="caret"></b>
							</a>
								<ul class="dropdown-menu">
									<li><a href="#">。。。</a></li>
									<li><a href="#">。。。</a></li>
									<li><a href="#">。。。</a></li>
								</ul></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="col-lg-9">
			<div class="panel panel-default navbar navbar-default">
				<div class="panel-body">
					<div class="col-lg-12" style="margin-bottom: 20px;">
						<!-- 广告 -->
						<%@ include file="/WEB-INF/parts/ad.jsp"%>
					</div>
					<div class="col-lg-4" v-for="project in projects">
						<div class="panel panel-info" v-bind:id="project.pro_id">
							<div class="panel-heading" onmouseover="show_btn(this);"
								onmouseout="hidden_btn(this);">
								<div class="row">
									<div class="col-lg-8">
										<span style="font-size: 24px;">{{project.pro_name}}</span>
									</div>
									<div class="btn btn-default col-lg-4 hidden">
										<span class="glyphicon glyphicon-star-empty"></span> <span>收藏</span>
									</div>
								</div>
							</div>
							<div class="panel-body">
								<p class="form-control">数量：{{project.pro_number}}</p>
								<p class="form-control">平均价格：{{project.avg_price}}</p>
								<p style="height: 100px;">
									图片：<img style="width: 100%; height: 100%;" alt="商品图片"
										v-bind:src="project.pro_image"
										onerror="this.src='/pc/images/404.png'" />
								</p>
							</div>
							<div class="panel-footer">
								<i class="badge">价格：{{project.pro_price}}</i> <i class="badge">分类：{{project.pro_type}}</i>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- 获得商品 -->
<script type="text/javascript">
	$(document).ready(function() {
		$.ajax({
			type : "get",
			url : "http://192.168.1.104:8080/shop/api/v1/projects",
			dataType : "json",
			success : function(data) {
				console.log(data);
				// 显示商品
				var comm = new Vue({
					el : "#comm",
					data : data
				});
			}
		});
	});
	function show_btn(e) {
		console.log($(e).children(".row").children(".btn")
				.removeClass('hidden'))
	}
	function hidden_btn(e) {
		console.log($(e).children(".row").children(".btn").addClass('hidden'))
	}
</script>