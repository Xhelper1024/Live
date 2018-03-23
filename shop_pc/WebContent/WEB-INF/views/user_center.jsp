<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="/pc/js/jquery-3.1.1.min.js"></script>
<script src="/pc/js/qrcode.min.js"></script>
<script src="/pc/js/vue.min.js"></script>
<script src="/pc/js/bootstrap.min.js"></script>
<link href="/pc/css/bootstrap.min.css" rel="stylesheet" />
<link rel="icon" href="/upload/logo.jpg" type="image/x-icon" />
<title>个人中心</title>
</head>
<body>
	<!-- 头部 -->
	<%@ include file="/WEB-INF/parts/header.jsp"%>
	<!-- 侧边用户信息 -->
	<div class="container" style="min-height: 700px;">
		<div class="row">
			<!-- 个人信息 -->
			<div class="col-lg-3">
				<div class="panel panel-info">
					<div class="panel-heading">
						<h4>个人信息</h4>
					</div>
					<div id="user_info" class="panel-body">
						<div class="input-group">
							<span class="input-group-addon">头像</span> <img
								style="height: 100px;" class="form-control" alt="userhead"
								title="头像" v-bind:src="user.head_image"
								onerror="this.src='/pc/images/404.png'">
						</div>
						<br>
						<div class="input-group">
							<span class="input-group-addon">用户名：</span> <input
								class="form-control" disabled v-bind:value="user.telephone" />
						</div>
						<br>
						<!-- xx -->
						<div class="input-group">
							<span class="input-group-addon">ID：</span> <input
								class="form-control" disabled v-bind:value="user.id" />
						</div>
						<br>
						<div class="input-group">
							<span class="input-group-addon">年龄：</span> <input
								class="form-control" disabled v-bind:value="user.age" />
						</div>
						<br>
						<div class="input-group">
							<span class="input-group-addon">性别：</span> <input
								class="form-control" disabled v-bind:value="user.sex" />
						</div>
						<br>
						<div class="input-group" v-if="user.telephone == 'admin'">
							<span class="input-group-addon">管理员入口：</span> <a href="/pc/admin"
								class="form-control btn btn-default" title="你好啊，管理员">链接在此</a>
						</div>
					</div>
				</div>
			</div>
			<!-- 右侧导航 -->
			<div class="col-lg-9">
				<ul class="nav nav-tabs nav-justified">
					<li class="active"><a data-toggle="tab" href="#myOrders">我的订单</a></li>
					<li><a data-toggle="tab" href="#usualContact">常用联系人</a></li>
					<li><a data-toggle="tab" href="#myCollection">我的收藏</a></li>
					<li><a data-toggle="tab" href="#personalOption">个人设置</a></li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane fade in active" id="myOrders">
						<h3>我的订单</h3>
						<table class="table table-hover">
							<thead>
								<tr>
									<td>订单ID</td>
									<td>商品ID</td>
									<td>商品名称</td>
									<td>数量</td>
									<td>收件人</td>
									<td>联系方式</td>
									<td>联系地址</td>
									<td>状态</td>
									<td>订单日期</td>
									<td>总价</td>
									<td>操作</td>
								</tr>
							</thead>
							<tbody v-if="res_code == 0">
								<tr>
									<td colspan="11">暂无数据</td>
								</tr>
							</tbody>
							<tbody v-if="res_code != 0">
								<tr v-for="order in orders">
									<td>{{order.id}}</td>
									<td>{{order.projectid}}</td>
									<td>{{order.project.pro_name}}</td>
									<td>{{order.order_number}}</td>
									<td>{{order.name}}</td>
									<td>{{order.moblie}}</td>
									<td>{{order.address}}</td>
									<td>{{order.state}}</td>
									<td>{{order.or_date}}</td>
									<td>{{order.price_sum}}</td>
									<td><a href="#">查看详情</a></td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="tab-pane fade" id="usualContact">
						<h3>常用联系人</h3>
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4>常用联系人</h4>
							</div>
							<div class="panel-body">
								<table class="table">
									<thead>
										<tr>
											<td>默认联系人</td>
											<td>联系人姓名</td>
											<td>联系人姓名</td>
											<td>联系人地址</td>
											<td>操作</td>
										</tr>
									</thead>
									<tbody>
										<tr v-for="h in harvert">
											<td><input v-if="h.type == 0" type="radio"
												name="defult_contact" v-bind:value="h.id" /><input
												v-if="h.type == 1" type="radio" name="defult_contact"
												v-bind:value="h.id" checked="checked" /></td>
											<td><input class="form-control" type="text"
												disabled="disabled" v-bind:value="h.name" /></td>
											<td><input class="form-control" type="text"
												disabled="disabled" v-bind:value="h.moblie" /></td>
											<td><input class="form-control" type="text"
												disabled="disabled" v-bind:value="h.address" /></td>
											<td class="input-group"><span v-bind:id="h.id"
												class="input-group-addon btn btn-danger contact-delete">删除</span>
												<input class="form-control contact-update" type="button"
												value="修改" /></td>
										</tr>
									</tbody>
								</table>
							</div>
							<div class="panel-footer">
								<div class="container-fluid">
									<input class="btn btn-info pull-right" type="button"
										value="保存修改" />
								</div>
							</div>
						</div>
					</div>
					<div class="tab-pane fade" id="myCollection">
						<h3>我的收藏</h3>
					</div>
					<div class="tab-pane fade" id="personalOption">
						<h3>个人设置</h3>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 底部 -->
	<%@ include file="/WEB-INF/parts/footer.jsp"%>
</body>
<script>
	$(document).ready(
			function() {
				var user = JSON.parse(window.localStorage.getItem("me"));
				if (user == null) {
					location.href = "/pc"
				}
				var app6 = new Vue({
					el : '#user_info',
					data : {
						user : user
					}
				})
				// 获取订单
				var url;
				if (user.telephone == "admin") {
					url = "http://192.168.1.104:8080/shop/api/v1/orders/"
				} else {
					url = "http://192.168.1.104:8080/shop/api/v1/orders/"
							+ user.id;
				}
				$.ajax({
					url : url,
					type : "get",
					dataType : "json",
					success : function(data) {
						console.log(data);
						new Vue({
							el : "#myOrders",
							data : {
								orders : data.data.orders,
								res_code : data.data.orders.length
							}
						})
					},
					onerror : function() {
						alert("服务器不在状态");
					}
				});

				// 获取默认地址
				new Vue({
					el : "#usualContact",
					data : {
						harvert : user.harvert
					}
				});
				// 点击删除联系人
				$(".contact-delete").click(
						function(e) {
							if (confirm("确认删除？")) {
								$.ajax({
									url : "http://192.168.1.104:8080/shop/"
											+ "api/v1/harverts/delete/"
											+ e.target.id,
									type : "post",
									dataType : "json",
									success : function(data) {
										console.log(data.data.user);
										window.localStorage.setItem("me",
												JSON.stringify(data.data.user));
										$(e.target).parent().parent().addClass(
												"hidden");
									}
								})
							}
						});
				// 点击修改联系人按钮时
				$(".contact-update").click(
						function(e) {
							var btn = $(e.target);
							if (btn.val() == "修改") {
								var tds = btn.parent().siblings();
								$(tds[1]).children("input").removeAttr(
										"disabled");
								$(tds[2]).children("input").removeAttr(
										"disabled");
								$(tds[3]).children("input").removeAttr(
										"disabled");
								btn.val("保存");
							} else {
								var tds = btn.parent().siblings();
								$(tds[1]).children("input").attr("disabled",
										"disabled");
								$(tds[2]).children("input").attr("disabled",
										"disabled");
								$(tds[3]).children("input").attr("disabled",
										"disabled");
								btn.val("修改");
							}
						})
			})
</script>
</html>
