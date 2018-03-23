/**
 * 跳转功能
 */
var pathName = window.document.location.pathname;
var root = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
// 跳转登录页面
$("#button_forward_login").click(function() {
	window.location = root + "/forward/login";
})
// 跳转注册页面
$("#button_forward_regist").click(function() {
	window.location = root + "/forward/regist";
})