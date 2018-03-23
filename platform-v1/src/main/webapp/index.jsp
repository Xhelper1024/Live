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
<title>Platform_v1</title>
</head>
<body class="bg-normal">
	<div class="container">
		<jsp:include page="/WEB-INF/views/super/header.jsp"></jsp:include>
		<%
			for (int i = 1; i < 12; i++) {
		%>
		<div class="bg bg<%=i < 10 ? "0" + i : i%>">
			<figure>
				<figcaption>
					<h1>此处是文章标题</h1>
				</figcaption>
				<div class="small">
					<a href="">文章详情</a>
				</div>
			</figure>
		</div>
		<%
			}
		%>
		<div class="" style="text-align: center;">
			<ul class="pagination pagination-lg">
				<li class="disabled"><a href="#">&laquo;</a></li>
				<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">&raquo;</a></li>
			</ul>
		</div>
		<jsp:include page="/WEB-INF/views/super/footer.jsp"></jsp:include>
	</div>
</body>
</html>