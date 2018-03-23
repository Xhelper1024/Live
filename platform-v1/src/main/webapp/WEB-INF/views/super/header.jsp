<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="${pageContext.request.contextPath}">首页</a>
		</div>
		<div>
			<form class="navbar-form navbar-left" role="search">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="站内搜索">
				</div>
				<button type="submit" class="btn btn-default">搜索</button>
			</form>
			<div class="pull-right">
				<button id="button_forward_login" type="button"
					class="btn btn-default navbar-btn">登录</button>
				<button id="button_forward_regist" type="button"
					class="btn btn-default navbar-btn">注册</button>
			</div>
		</div>
	</div>
</nav>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/forward.js"></script>