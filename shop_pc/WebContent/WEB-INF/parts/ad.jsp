<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 广告轮播 -->
<div class="carousel slide" id="ad">
	<ol class="carousel-indicators" id="ad-indicators">
		<li v-for="(project, index) in adverts" data-target="#ad"
			v-bind:data-slide-to="index" class=""></li>
	</ol>
	<!-- 轮播（Carousel）项目 -->
	<div class="carousel-inner" id="ad-inner">
		<div class="item" v-for="project in adverts">
			<div class="ad-img">
				<img alt="AD" v-bind:src="project.pro_image"
					style="width: 100%; height: 300px;"
					onerror="this.src='/pc/images/404.png'">
			</div>
			<div class="carousel-caption">{{ project.title }}</div>
		</div>
	</div>
	<!-- 翻页 -->
	<a class="carousel-control left" href="#ad" data-slide="prev"><span
		class="glyphicon glyphicon-chevron-left"></span></a> <a
		class="carousel-control right" href="#ad" data-slide="next"><span
		class="glyphicon glyphicon-chevron-right"></span></a>
</div>
<style>
.ad-img {
	height: 200px;
	background-size: cover;
	background-repeat: no-repeat;
	background-size: cover;
}

#ad {
	margin-bottom: 20px;
}
</style>
<script type="text/javascript">
	$(document).ready(
			function() {
				$.ajax({
					url : "http://192.168.1.104:8080/shop/api/v1/adverts",
					type : "get",
					dataType : "json",
					success : function(data) {
						console.log(data);
						var projects = new Vue({
							el : "#ad-inner",
							data : data
						})
						$($("#ad-inner").children("div").get(0)).addClass(
								"active");
						var projects = new Vue({
							el : "#ad-indicators",
							data : data
						})
						$($("#ad-indicators").children("li").get(0)).addClass(
								"active");
						$("#ad").carousel({
							interval : 2000
						})
					}
				})
			})
</script>
