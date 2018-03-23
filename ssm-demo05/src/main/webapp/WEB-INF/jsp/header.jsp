<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="css/header.css" />
<div id="myCarousel" class="carousel slide">
	<!-- 轮播（Carousel）指标 -->
	<ol class="carousel-indicators">
		<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		<li data-target="#myCarousel" data-slide-to="1"></li>
		<li data-target="#myCarousel" data-slide-to="2"></li>
	</ol>
	<!-- 轮播（Carousel）项目 -->
	<div class="carousel-inner center">
		<div class="item active">
			<div class="slide" style="background-image: url('image/slide1.jpg');"></div>
		</div>
		<div class="item">
			<div class="slide" style="background-image: url('image/slide2.jpg');"></div>
		</div>
		<div class="item">
			<div class="slide" style="background-image: url('image/slide3.jpg');"></div>
		</div>
	</div>
	<!-- 轮播（Carousel）导航 -->
	<a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
	<a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
</div>
