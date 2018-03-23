<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<script type="text/javascript"
	src="http://libs.baidu.com/jquery/2.1.1/jquery.min.js"></script>
</head>
<body>
	<form style="text-align: center; top: 100px; position: relative;">
		<fieldset>
			<legend>用户注册</legend>
			<table style="text-align: center; margin: auto;">
				<tr>
					<td>昵称：</td>
					<td><input type="text" placeholder="请输入用户名" id="name"></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input type="password" placeholder="请输入密码" id="pwd"></td>
				</tr>
				<tr>
					<td>确认密码：</td>
					<td><input type="password" placeholder="确认密码" id="repwd"></td>
				</tr>
				<tr>
					<td>邮箱：</td>
					<td><input type="text" placeholder="邮箱" id="email"></td>
				</tr>
				<tr>
					<td><input id="registerBtn" type="button" value="注册"></td>
					<td><input id="returnBtn" type="button" value="返回"
						onclick="history.back();"></td>
				</tr>
			</table>
			<h1 id="tips"></h1>
		</fieldset>
	</form>
	<script type="text/javascript">
		$(function() {
			$("#registerBtn").click(function() {
				var nickname = $("#name").val().trim();
				var pwd = $("#pwd").val().trim();
				var repwd = $("#repwd").val().trim();
				var email = $("#email").val().trim();
				if (nickname == "" || pwd == "" || email == "") {
					show_tips("请填写完整！");
					return;
				}
				if (pwd != repwd) {
					show_tips("两次密码不一致，请重新输入");
					return;
				}
				var emailReg = /^[0-9a-zA-Z]+\@[0-9a-zA-Z]+\.[a-zA-Z]/;
				if(!emailReg.test(email)){
					show_tips("邮箱格式错误，格式：xxx@xxx.xxx，请重新输入");
					return;
				}
				if(pwd.length < 8){
					show_tips("密码过于短，应不少于8个字符，请重新输入");
					return;
				}
				var data = {
					name: nickname,
					pwd: pwd,
					email: email
				};
				$.post("register.do", data, function(result){
					if(result.toString() == "true"){
						show_tips("注册成功，3秒后即将跳转页面...");
						setTimeout(() => {
							window.location="/xhtv1.0.1";
						}, 3000);
					} else {
						show_tips("注册失败，用户名已存在！");
					}
				}, "text"); 
			});
		});
		function show_tips(msg) {
			document.getElementById("tips").innerHTML = msg;
			setTimeout(() => {
				document.getElementById("tips").innerHTML = "";
			}, 3000);
		}
	</script>
</body>
</html>