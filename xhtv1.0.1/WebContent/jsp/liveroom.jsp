<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.xhtv.entity.User"%>
<%@page import="com.xhtv.entity.Liver"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
	Liver liver = (Liver) request.getAttribute("liver");
	User user = (User) session.getAttribute(request.getCookies()[0].getValue());
	String[] imgList = (String[]) request.getAttribute("imgList");
%>
<meta name="keyword"
	content="<%=liver.getRoomtitle()%>,<%=liver.getClassification()%>">
<meta name="description"
	content="XHYV1.0.1-<%=liver.getRoomtitle()%>,<%=liver.getClassification()%>">
<title><%=liver.getRoomtitle()%></title>
<link rel="stylesheet" type="text/css" href="css/side-tools-bar.css">
<link rel="stylesheet" type="text/css" href="css/live-room-list.css">
<link rel="stylesheet" type="text/css" href="css/liveroomstyle.css">
<script type="text/javascript"
	src="http://libs.baidu.com/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="js/output.js"></script>
<script type="text/javascript" src="js/login.js"></script>
<script type="text/javascript" src="player/cyberplayer.js"></script>
<script type="text/javascript" src="js/chat.js"></script>
</head>
<body
	onload="play('http://dlhls.cdn.zhanqi.tv/zqlive/20910_uUMgC.m3u8')">
	<!-- 侧边工具栏 -->
	<div id="side-tools-bar" class="side-tools-bar">
		<div id="sidebar-header" class="sidebar-header">
			<!-- 头部LOGO -->
			<div id="sidebar-logo" class="sidebar-logo">
				<a href="/xhtv1.0.1"> <img id="version-img"
					src="emoji/blush.png" /> <span id="version-txt">XHTV-Version1.0.1</span>
				</a>
			</div>
			<!-- 搜索框 -->
			<div id="sidebar-search" class="sidebar-search">
				<form name="room-search" action="/search" method="get" target="_top"
					class="search-form">
					<input type="text" name="kw" value="搜游戏/主播" class="search-key"
						onfocus="if(this.value == '搜游戏/主播')this.value=''"
						onblur="if(this.value == '')this.value='搜游戏/主播'">
					<div class="search-submit">
						<input type="submit" class="search-submit-btn" value=">>">
					</div>
				</form>
			</div>
			<div class="split-line"></div>
		</div>
		<!-- 导航栏 -->
		<div id="sidebar-navigation" class="sidebar-navigation">
			<div id="sidebar-navigation-ul" class="sidebar-navigation-ul">
				<a class="sidebar-item" href="/xhtv1.0.1"><span>全部直播</span></a> <a
					class="sidebar-item" href="classification?type=all"><span>全部分类</span></a>
				<a class="sidebar-item" href="classification?type=follow"><span>我的订阅</span></a>
				<a class="sidebar-item" href="classification?type=phone"><span>手游在线</span></a>
				<a class="sidebar-item" href="classification?type=pcgame"><span>网游在线</span></a>
				<a class="sidebar-item" href="#"><span>预留位置</span></a>
			</div>
			<!-- 侧边栏我实在是搞不下去了，太JB烦了，啊啊啊，前端真让人头大 -->
		</div>
		<!-- 登陆/用户信息栏 -->
		<div id="sidebar-userinfo" class="sidebar-userinfo">
			<div class="split-line"></div>
			<!-- 用户是否登陆，默认为否 -->
			<%
				if (user == null) {
			%>
			<div class="sidebar-userinfo-login-panel">
				<a class="sidebar-userinfo-login-btn" href="javascript:void(0);"
					onclick="document.getElementById('login-frame').style.display='block';">登录</a>
				<a href="register" class="sidebar-userinfo-register-btn">注册</a>
			</div>
			<%
				} else {
			%>
			<div class="sidebar-userinfo-login-panel">
				<p id="sidebar-username" class="sidebar-username">
					<a href="personal" id="username"><%=user.getNickname()%></a>
				</p>
				<div id="sidebar-user-logout-div" class="sidebar-user-logout-div">
					<div id="sidebar-user-balance" class="sidebar-user-balance">
						<img src="emoji/cry.png" style="width: 20px;" title="用户余额">
						<span id="user-balance" title="用户余额"><%=user.getBalance()%></span>
					</div>
					<div id="sidebar-user-free-balance"
						class="sidebar-user-free-balance">
						<img src="emoji/grin.png" style="width: 20px;" title="用户免费余额">
						<span id="user-free-balance" title="用户免费余额"><%=user.getBalance()%></span>
					</div>
					<p id="sidebar-user-logout"
						style="position: absolute; bottom: 10px;">
						<a href="login.do?type=logout">退出登录</a>
					</p>
				</div>
			</div>
			<%
				}
			%>
		</div>
	</div>
	<!-- 登陆框 -->
	<div id="login-frame" class="login-frame" style="display: none;">
		<div id="login-frame-header" class="login-frame-header">
			<div style="margin: auto; line-height: 35px; text-align: center;">登录</div>
			<input type="button" id="login-frame-close-btn"
				class="login-frame-close-btn" value="X"
				onclick="document.getElementById('login-frame').style.display='none';" />
		</div>
		<div id="login-frame-content" class="login-frame-content">
			<input type="text" class="input-content" id="input-username"
				placeholder="请输入邮箱/账号" /> <input type="password"
				class="input-content" id="input-password" placeholder="请输入密码" />
			<div id="input-login-tips" class="input-content">&nbsp;</div>
			<div id="input-content-register" class="input-content">
				<a href="register">立即注册</a>
			</div>
			<input type="button" class="input-content" id="input-loginbtn"
				value="立即登录" />
		</div>
	</div>
	<!-- 主播直播间画面 -->
	<div class="main-container">
		<!-- 中间直播间 -->
		<div class="center_display_frame">
			<div class="room-info">
				<i id="room-img"> <img alt="房间封面"
					src="<%=liver.getRoomimage()%>"
					style="background-size: cover; width: 30px; height: 30px;">
				</i> <span id="room-title"><%=liver.getRoomtitle()%></span>
			</div>
			<div id="playercontainer" style="z-index: -1111;"></div>
			当前在线人数：<span id="cur_num">-</span>人<br>
		</div>
		<!-- 聊天 -->
		<div class="right_display_frame">
			<div class="show_msg_div">
				<div id="show_msg">
					<ul class="msgList" id="msgList"></ul>
				</div>
			</div>
			<!-- 选择图片 -->
			<div class="chooseBq">
				<ul>
					<%
						for (int i = 1; i < imgList.length; i++) {
					%>
					<li><img src="emoji/<%=imgList[i]%>" class="small_bq"
						title="[<%=imgList[i].substring(0, imgList[i].length() - 4)%>]"
						onclick="addImg(this)"></li>
					<%
						}
					%>
				</ul>
			</div>
			<!-- 聊天框 -->
			<div class="input_msg_div">
				<div class="input_msg_div_outside">
					<textarea rows="2" id="ta_input" onkeypress="onKeyPress(event)">
					</textarea>
				</div>
				<div id="send" class="send" onclick="start()">发送</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function play(src) {
			var win_width = window.screen.width;
			var player = cyberplayer("playercontainer").setup({
				width : 0.60 * win_width,
				height : 500,
				backcolor : "#FFFFFF",
				stretching : "uniform",
				file : src,
				autoStart : true,
				volume : 90,
				controls : 2,
				hls : {
					reconnecttime : 5
				// hls直播的重连次数
				},
				ak : '41707430fa52422f83b8efdc797f90c1'
			});
		}
	</script>
</body>
</html>