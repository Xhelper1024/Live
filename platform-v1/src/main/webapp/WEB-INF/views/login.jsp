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
<title>登录</title>
</head>
<body class="bg-normal">
	<div class="container">
		<jsp:include page="/WEB-INF/views/super/header.jsp"></jsp:include>
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3>登录</h3>
			</div>
			<div class="panel-body">
				<table class="table table-default">
					<tbody>
						<tr>
							<td><label for="input_unm">用户名：</label></td>
							<td><input id="input_unm" type="text" class="form-control"
								placeholder="邮箱/用户名/手机号码"></td>
						</tr>
						<tr>
							<td><label for="input_pwd">密码：</label></td>
							<td><input id="input_pwd" type="password"
								class="form-control" placeholder="请输入密码"></td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="panel-footer">
				<button id="button_login" class="btn btn-default form-control">登录</button>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/super/footer.jsp"></jsp:include>
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/blogUsers.js"></script>
</body>
</html>