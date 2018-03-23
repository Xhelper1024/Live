<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript">
	function b() {
		//创建登录层div并插入body
		var login = document.createElement("div");
		login.id = "login";
		login.innerHTML = '<div class="title" id="title">登录百度账号'
				+ '<a href="#" class="close">x</a>' + '</div>'
				+ '<div class="content">' + '<div class="user">'
				+ '<input class="pt" type="input" value="手机/邮箱/用户名">'
				+ '</div>' + '<div class="password">'
				+ '<input class="pt" type="input" value="密码">' + '</div>'
				+ '<div class="submit">'
				+ '<input class="sm" type="submit" value="登录">' + '</div>'
				+ '</div>';
		document.body.appendChild(login);
		//窗口可视区域宽度
		var cwidth = document.documentElement.clientWidth
				|| document.body.clientWidth;
		//窗口可视区域高度
		var cheight = document.body.clientHeight;
		//登录框宽度
		var lwidth = login.offsetWidth;
		//登录框高度
		var lheight = login.offsetHeight;
		//设置登录框的居中显示
		login.style.left = (cwidth - lwidth) / 2 + "px";
		login.style.top = (cheight - lheight) / 2 + "px";
		//设置遮罩层的高度
		window.onresize = function() {
			if (document.compatMode == "CSS1Compat") {
				cwidth = document.documentElement.clientWidth;
				cheight = document.documentElement.clientHeight;
			} else {
				cwidth = document.body.clientWidth;
				cheight = document.body.clientHeight;
			}
			login.style.left = (cwidth - lwidth) / 2 + "px";
			login.style.top = (cheight - lheight) / 2 + "px";
		}
		window.onscroll = function() {
			if (document.compatMode == "CSS1Compat") {
				cheight = document.documentElement.clientHeight;
			} else {
				cheight = document.body.clientHeight;
			}
			login.style.top = (cheight - lheight) / 2 + getScrollTop() + "px";
		}
		function getScrollTop() {
			var scrollTop = 0;
			if (document.documentElement && document.documentElement.scrollTop) {
				scrollTop = document.documentElement.scrollTop;
			} else if (document.body) {
				scrollTop = document.body.scrollTop;
			}
			return scrollTop;
		}
		//获取拖拽容器
		var title = document.getElementById("title");
		var isDraging = false;
		var mouseOffsetX;
		var mouseOffsetY;
		//鼠标按下事件
		title.onmousedown = function(e) {
			var e = e || window.event;
			/*var el=e.srcElement;
			if(!el){
			el=e.target;//兼容火狐
			}*/
			//鼠标相对于登录框的位置
			mouseOffsetX = e.pageX - login.offsetLeft;
			mouseOffsetY = e.pageY - login.offsetTop;
			//鼠标摁下时为true
			isDraging = true;
			/*console.log(mouseOffsetY, mouseOffsetX)*/
		}
		//鼠标移动事件
		document.onmousemove = function(e) {
			var e = e || window.event;
			//鼠标移动时的坐标
			var newMX = e.pageX;
			var newMY = e.pageY;
			//判断为true时可以拖拽
			if (isDraging === true) {
				//登录框的偏移值=当前位置-鼠标到登录框的距离
				var loginL = newMX - mouseOffsetX;
				var loginT = newMY - mouseOffsetY;
				//如果left top值超过边缘时就让他等于边缘
				if (loginL < 0) {
					loginL = 0;
				} else if (loginL > (cwidth - lwidth)) {
					loginL = cwidth - lwidth;
				}
				if (loginT < 0) {
					loginT = 0;
				} else if (loginT > (cheight - lheight)) {
					loginT = cheight - lheight;
				}
				login.style.left = loginL + "px";
				login.style.top = loginT + "px";
			}
		}
		//鼠标弹起时设置为不可拖拽
		document.onmouseup = function() {
			isDraging = false;
		}
		//点击X关闭登录框和弹出层
		var close = login.getElementsByClassName("close")[0];
		close.onclick = function() {
			document.body.removeChild(login);
		}
	}
	//点击登录弹出登录框和弹出层
	window.onload = function() {
		var loginBtn = document.getElementById("login-btn");
		loginBtn.onclick = function() {
			if($("#login").is(":visible"))
				return;
			b();
		}
	}
</script>
