<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="/pc/js/jquery-3.1.1.min.js"></script>
<script src="/pc/js/vue.min.js"></script>
<script src="/pc/js/bootstrap.min.js"></script>
<link href="/pc/css/bootstrap.min.css" rel="stylesheet" />
<link rel="icon" href="/upload/logo.jpg" type="image/x-icon" />
<title>注册</title>
</head>
<body>
	<!-- 头部 -->
	<%@ include file="../parts/header.jsp"%>
	<!-- 主体 -->
	<div class="container" style="margin-top: 20px;">
		<div class="row">
			<div class="col-lg-6">
				<img alt="LOGO" class="img-thumbnail" src="/pc/images/logo.jpg"
					onerror="this.src = '/pc/images/404.png'">
			</div>
			<div class="col-lg-6">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3>用户注册</h3>
						<span id="regist_tips" class="text-sm text-danger"></span>
					</div>
					<div class="panel-body">
						<p class="input-group">
							<span class="input-group-addon"> +86 </span> <input id="phone"
								type="text" class="form-control" placeholder="手机号码" />
						</p>
						<p class="input-group">
							<span class="input-group-addon">收到的验证码</span> <input
								id="validate_code" type="text" class="form-control"
								placeholder="请输入手机验证码" />
						</p>
						<p>
							<input id="regist_password" type="password" class="form-control"
								placeholder="密码" />
						</p>
						<p>
							<input id="regist_repassword" type="password"
								class="form-control" placeholder="确认密码" />
						</p>
						<p>
							<input id="send_code_btn" type="button" class="btn btn-info"
								value="发送手机验证码"> <input id="regist_btn" type="button"
								class="btn btn-danger pull-right" value="注册">
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	$("#regist_btn").click(function() {
		// 空值检测
		if ($("#phone").val().trim() == "") {
			$("#regist_tips").text("手机号码为空！");
			setTimeout(function() {
				$("#regist_tips").text("");
			}, 2000);
			$("#phone").focus();
			return;
		}
		if ($("#regist_password").val().trim() == "") {
			$("#regist_tips").text("密码为空！");
			setTimeout(function() {
				$("#regist_tips").text("");
			}, 2000);
			$("#regist_password").focus();
			return;
		}
		if ($("#regist_repassword").val().trim() == "") {
			$("#regist_tips").text("确认密码为空！");
			setTimeout(function() {
				$("#regist_tips").text("");
			}, 2000);
			$("#regist_repassword").focus();
			return;
		}
		// 验证手机号码
		var reg = /^1[3,5,7,8][0-9]{9}$/;
		if (!reg.test($("#phone").val())) {
			$("#regist_tips").text("手机号码格式错误");
			setTimeout(function() {
				$("#regist_tips").text("");
			}, 2000);
			$("#phone").focus();
			return;
		}
		// 验证两次密码是否一致
		if ($("#regist_password").val() != $("#regist_repassword").val()) {
			$("#regist_tips").text("两次密码不一致！");
			setTimeout(function() {
				$("#regist_tips").text("");
			}, 2000);
			$("#regist_repassword").focus();
			return;
		}
		var user = {
			phone : $("#phone").val(),
			password : $("#regist_password").val()
		}
		// 注册
		$.ajax({
			type : "post",
			url : "http://192.168.1.104:8080/shop/api/v1/user/register",
			data : {
				user : JSON.stringify(user)
			},
			success : function(result) {
				var msg = JSON.parse(result).msg;
				if (msg == "1") {
					alert("注册成功")
					window.location = "/pc/"
				}
				if (msg == "-1") {
					$("#regist_tips").html("用户已经存在");
					setTimeout(function() {
						$("#regist_tips").text("");
					}, 2000);
				}
			}
		});
	});
</script>
</html>

<!--
   _____ _____  ______       _______ ______   ______     __ 
  / ____|  __ \|  ____|   /\|__   __|  ____| |  _ \ \   / / 
 | |    | |__) | |__     /  \  | |  | |__    | |_) \ \_/ /  
 | |    |  _  /|  __|   / /\ \ | |  |  __|   |  _ < \   /   
 | |____| | \ \| |____ / ____ \| |  | |____  | |_) | | |    
  \_____|_|__\_\______/_/    \_\_|  |______|_|____/  |_|__  
 |  __ \|  __ \|  ____|   /\   |  \/  |  ____| | \ \   / /  
 | |  | | |__) | |__     /  \  | \  / | |__  | |  \ \_/ /   
 | |  | |  _  /|  __|   / /\ \ | |\/| |  __| | |   \   /    
 | |__| | | \ \| |____ / ____ \| |  | | |    | |____| |     
 |_____/|_|  \_\______/_/    \_\_|  |_|_|    |______|_|     
                                                            
 -->
















