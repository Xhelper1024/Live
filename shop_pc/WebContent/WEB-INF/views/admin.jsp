<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/vue.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link rel="icon" href="/upload/logo.jpg" type="image/x-icon" />
<title>管理员界面</title>
</head>
<body>
	<%@ include file="/WEB-INF/parts/header.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-lg-3">
				<div class="panel panel-default navbar navbar-default">
					<div class="panel-body">
						<ul class="nav nav-stacked">
							<li class="active"><a href="#">xx</a></li>
							<li><a href="#">xx</a></li>
							<li><a href="#">xx</a></li>
							<li><a href="#">xx</a></li>
						</ul>
					</div>
				</div>
				<!-- 左侧导航结束 -->
			</div>
			<div class="col-lg-9">
				<div class="panel panel-default navbar navbar-default">
					<div class="panel-body">
						xx
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(document).ready(function() {
		var user = localStorage.getItem('me');
		console.log(user)
		if (user == null || JSON.parse(user).telephone != "admin") {
			location.href = "/pc";
		}
	});
</script>
</html>