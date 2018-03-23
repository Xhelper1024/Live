<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String sessionid = request.getParameter("session");
%>
<div class="">
	<ul class="nav nav-pills">
		<li class="pull-left"><a href="#"
			class="glyphicon glyphicon-home">首页</a></li>
		<li class="pull-left"><a href="#"
			class="glyphicon glyphicon-leaf">网站特推</a></li>
		<li class="pull-left"><a href="#"
			class="glyphicon glyphicon-link">友情链接</a></li>
		<li class="pull-left"><a href="#"
			class="glyphicon glyphicon-copyright-mark">关于我们</a></li>
		<li class="pull-left"><a href="#"
			class="glyphicon glyphicon-question-sign">帮助</a></li>
		<%
			if ("".equals(sessionid) || sessionid == null) {
		%>
		<li class="pull-right"><a href="#"
			class="glyphicon glyphicon-question-sign">忘记密码？</a></li>
		<li class="pull-right"><a href="#"
			class="glyphicon glyphicon-check">注册</a></li>
		<li class="pull-right"><a href="#" id="login-btn"
			class="glyphicon glyphicon-log-in">登录</a></li>
		<%
			} else {
		%>
		<li class="pull-right"><a href="#"
			class="glyphicon glyphicon-log-out">退出</a></li>
		<li class="pull-right"><a href="#"
			class="glyphicon glyphicon-shopping-cart">购物车</a></li>
		<li class="pull-right active"><a href="#"
			class="glyphicon glyphicon-user">谢辉</a></li>
		<%
			}
		%>
	</ul>
</div>