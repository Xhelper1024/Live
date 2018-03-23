<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container">
	<div class="row" style="margin: 20px;">
		<div class="col-lg-3">
			<a href="/pc"><img style="height: 34px;" alt="WEB应用软件开发比赛"
				title="WEB应用软件开发比赛" src="/upload/logo.jpg"
				onerror="this.src='/pc/images/404.png';this.title='404错误'"></a>
		</div>
		<div class="col-lg-7 text-center">
			<div class="input-group">
				<input class="form-control" type="text" placeholder="搜索……">
				<span class="input-group-addon btn btn-danger">搜索</span>
			</div>
		</div>
		<div class="col-lg-2">
			<div id="user_control">
				<!-- 按钮触发模态框 -->
				<button class="btn btn-info form-control" data-toggle="modal"
					id="model-btn-show" data-target="#model-panel-login">
					<span class="glyphicon glyphicon-log-in"></span>登录
				</button>
				<div class="hidden" id="model-btn-user">
					<div class="input-group">
						<span class="input-group-addon btn btn-default"
							onclick="location.href='/pc/user_center';"><span
							id="show_username" class="glyphicon glyphicon-user"
							v-bind:title="user.telephone">{{user.telephone}}</span></span> <input
							type="button" value="注销" id="model-btn-logout"
							class="form-control"
							onclick="if(confirm('是否注销')){window.localStorage.removeItem('me');history.go(0);}" />
					</div>
				</div>
			</div>
		</div>
		<!-- 模态框（Modal） -->
		<div class="modal fade" id="model-panel-login" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">登录</h4>
						<small id="login-tips" class="text-danger"></small>
					</div>
					<div class="modal-body">
						<p>
							<input id="username" class="form-control" type="text"
								placeholder="用户名" />
						</p>
						<p>
							<input id="password" class="form-control" type="password"
								placeholder="密码" />
						</p>
					</div>
					<div class="modal-footer">
						<input id="model-btn-login" type="submit" class="btn btn-primary"
							value="登录" /> <input id="model-btn-regist" type="button"
							class="btn btn-default right" value="还没有账号？立即注册" />
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<hr>
<style>
#show_username {
	width: 100px;
	text-overflow: ellipsis;
	overflow: hidden;
}
</style>
<!-- 登录 -->
<script type="text/javascript">
	// 清空输入的内容
	$("#model-btn-show").click(function() {
		$("#username").val("");
		$("#password").val("");
	});
	// 判断用户是否登录
	$(document).ready(function() {
		var me = window.localStorage.getItem("me");
		if (me == null) {
			$("#model-btn-show").removeClass("hidden");
			$("#model-btn-user").addClass("hidden");
		} else {
			console.log(window.localStorage.getItem("me"));
			new Vue({
				el : "#user_control",
				data : {
					user : JSON.parse(window.localStorage.getItem("me"))
				}
			});
			$("#model-btn-show").addClass("hidden");
			$("#model-btn-user").removeClass("hidden");
		}
	});
	// 点击登录
	$("#model-btn-login").click(function() {
		if ($("#username").val().trim() == "") {
			$('#login-tips').html("用户名输入不能为空");
			setTimeout(function() {
				$('#login-tips').html("");
			}, 3000);
			$("#username").focus();
			return;
		}
		if ($("#password").val().trim() == "") {
			$('#login-tips').html("密码输入不能为空");
			setTimeout(function() {
				$('#login-tips').html("");
			}, 3000);
			$("#password").focus();
			return;
		}
		var user = {
			username : $("#username").val().trim(),
			password : $("#password").val().trim()
		};
		// 请求登录
		$.ajax({
			url : "http://192.168.1.104:8080/shop/api/v1/user/login",
			type : "post",
			data : {
				user : JSON.stringify(user)
			},
			dataType : "json",
			success : function(data) {
				console.log(data.msg);
				if (data.msg == -1) {
					$('#login-tips').html("用户不存在");
					setTimeout(function() {
						$('#login-tips').html("");
					}, 3000);
					$("#username").focus();
				}
				if (data.msg == 0) {
					$('#login-tips').html("密码错误");
					setTimeout(function() {
						$('#login-tips').html("");
					}, 3000);
					$("#password").focus();
				}
				if (data.msg == 1) {
					var user = JSON.stringify(data.user)
					window.localStorage.setItem("me", user);
					if (data.user.telephone != "admin") {
						history.go(0);
					} else {
						location.href = "/pc/user_center";
					}
				}
			},
			error : function() {
				alert("服务器开小差了，请先喝杯茶稍后再试");
			}
		});
	});
	// 立即注册，跳转注册界面
	$("#model-btn-regist").click(function() {
		location.href = "/pc/v2/user/regist_page";
	});
</script>
