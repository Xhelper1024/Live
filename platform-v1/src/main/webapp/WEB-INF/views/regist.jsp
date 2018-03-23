<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="${pageContext.request.contextPath}/js/jquery-3.1.1.js"></script>
<script
	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/myDesign.css">
<link rel="icon"
	href="${pageContext.request.contextPath}/images/logo.ico">
<title>立即注册</title>
</head>
<body class="bg-normal">
	<div class="container">
		<jsp:include page="/WEB-INF/views/super/header.jsp"></jsp:include>
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3>立即注册</h3>
			</div>
			<div class="panel-body">
				<table class="table table-default">
					<tbody>
						<tr>
							<td><label for="input_nickname">昵称：</label></td>
							<td><input id="input_nickname" type="text"
								class="form-control" placeholder="昵称/用于显示"></td>
						</tr>
						<tr>
							<td><label>性别：</label></td>
							<td><label for="male">♂男</label><input type="radio"
								name="input_sexy" id="male" value="male" checked>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label
								for="female">♀女</label><input type="radio" name="input_sexy"
								id="female" value="female"></td>
						</tr>
						<tr>
							<td><label for="input_email">邮箱：</label></td>
							<td><input id="input_email" type="text" class="form-control"
								placeholder="邮箱/用于登录"></td>
						</tr>
						<tr>
							<td><label for="input_pwd">密码：</label></td>
							<td><input id="input_pwd" type="password"
								class="form-control" placeholder="密码/由8-16位字母或者数字或者特殊字符组成"></td>
						</tr>
						<tr>
							<td><label for="input_repwd">确认密码：</label></td>
							<td><input id="input_repwd" type="password"
								class="form-control" placeholder="确认密码/两次密码必须一致"></td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="panel-footer">
				<button id="button_regist" class="btn btn-default form-control">立即注册</button>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/super/footer.jsp"></jsp:include>
	</div>
</body>
</html>