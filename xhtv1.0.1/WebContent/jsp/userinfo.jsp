<%@page import="com.xhtv.entity.Liver"%>
<%@page import="java.util.List"%>
<%@page import="com.xhtv.dao.UserDAO"%>
<%@page import="com.xhtv.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人信息</title>
<%
	User user = (User) session.getAttribute(request.getCookies()[0].getValue());
	UserDAO userDAO = new UserDAO();
	int roomid = userDAO.getRoomId(user);
	Liver liver = userDAO.getLiver(roomid);
%>
<link rel="stylesheet" type="text/css" href="css/side-tools-bar.css">
<link rel="stylesheet" type="text/css" href="css/live-room-list.css">
<link rel="stylesheet" type="text/css" href="css/userinfo.css">
<script type="text/javascript"
	src="http://libs.baidu.com/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="js/output.js"></script>
<script type="text/javascript" src="js/login.js"></script>
<script type="text/javascript" src="js/userinfo.js"></script>
</head>
<body>
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
					class="sidebar-item" href="/xhtv1.0.1/all"><span>全部分类</span></a> <a
					class="sidebar-item" href="/xhtv1.0.1/follow"><span>我的订阅</span></a>
				<a class="sidebar-item" href="/xhtv1.0.1/phone"><span>手游在线</span></a>
				<a class="sidebar-item" href="/xhtv1.0.1/pcgame"><span>网游在线</span></a>
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
	<!-- 用户信息 -->
	<div id="main-container" class="main-container">
		<fieldset>
			<legend>我的信息</legend>
			<table class="tab-userinfo">
				<tr>
					<td>昵称</td>
					<td>账号</td>
					<td>用户余额</td>
				</tr>
				<tr>
					<td id="unickname"><%=user.getNickname()%></td>
					<td id="uid"><%=user.getUid()%></td>
					<td id="ubalance"><%=user.getBalance()%></td>
				</tr>
				<tr>
					<td>修改密码</td>
					<td colspan="2" id="repwd"><input type="button" value="修改密码"
						id="repwdBtn" onclick="changeElement()"></td>
				</tr>
			</table>
			<%
				if (user.isLiver()) {
			%>
			<fieldset>
				<legend>编辑房间</legend>
				<table class="tab-userinfo">
					<tr>
						<td>我的房间ID：</td>
						<td id="roomid"><%=roomid%></td>
					</tr>
					<tr>
						<td>FMS URL:</td>
						<td id="FMSURL">rtmp://10.238.70.95:1935/hls</td>
					</tr>
					<tr>
						<td>房间标题：</td>
						<td><input type="text" class="tab-userinfo-roominfo"
							id="roomtitle" placeholder="醒目的房间标题"
							value="<%=liver.getRoomtitle()%>" /></td>
					</tr>
					<tr>
						<td>房间封面：</td>
						<td><input type="text" class="tab-userinfo-roominfo"
							id="roomimage" placeholder="请输入图片url"
							value="<%=liver.getRoomimage()%>" /></td>
					</tr>
					<tr>
						<td>房间分类：</td>
						<td><input type="checkbox" class="tab-userinfo-roominfo"
							name="classification" id="phone" value="手游在线" /><label
							for="phone">手游在线</label> <input type="checkbox"
							class="tab-userinfo-roominfo" name="classification" id="pcgame"
							value="网游在线" /><label for="pcgame">网游在线</label> <input
							type="checkbox" class="tab-userinfo-roominfo"
							name="classification" id="other" value="其他" /><label for="other">其他</label>
						</td>
					</tr>
					<tr>
						<td colspan="2" style="text-align: center;"><input
							type="button" value="确定提交" style="padding: 10px;"
							id="alterRoomInfo" /></td>
					</tr>
				</table>
			</fieldset>
			<%
				}
			%>
		</fieldset>
		<fieldset>
			<legend>充值记录</legend>
			<table class="tab-userinfo">
				<tr>
					<td>用户账号</td>
					<td>充值金额</td>
					<td>充值日期</td>
				</tr>
				<%
					List<String[]> recharge_record = userDAO.getRechargeRecord(user);
					if (recharge_record.size() != 0)
						for (String[] str : recharge_record) {
				%>
				<tr>
					<td><%=str[0]%></td>
					<td><%=str[1]%></td>
					<td><%=str[2]%></td>
				</tr>
				<%
					}
					else {
				%>
				<tr>
					<td colspan="3">暂无充值记录</td>
				</tr>
				<%
					}
				%>
			</table>
		</fieldset>
		<fieldset>
			<legend>消费记录</legend>
			<table class="tab-userinfo">
				<tr>
					<td>用户账号</td>
					<td>消费金额</td>
					<td>直播间</td>
					<td>消费日期</td>
				</tr>
				<tr>
					<td colspan="4">暂无消费记录</td>
				</tr>
			</table>
		</fieldset>
		<fieldset>
			<legend>其他功能</legend>
			<table class="tab-userinfo">
				<tr>
					<td><a href="doLive">认证主播</a></td>
					<td><a href="recharge">充值</a></td>
					<td><a href="taskcenter">任务中心</a></td>
					<td><a href="help">帮助与反馈</a></td>
				</tr>
			</table>
		</fieldset>
	</div>
</body>
</html>