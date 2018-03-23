/**
 * 
 */
$(function(){
	$("#input-loginbtn").click(function() {
		var username = $('#input-username').val();
		var pwd = $('#input-password').val();
		if(username == ""){
			show_tips("用户名不能为空");
			return;
		}
		if(pwd == ""){
			show_tips("密码不能为空");
			return;
		}
		var data = {
			username : username,
			password : pwd
		};
		$.post("login.do", data, function(result) {
			switch (result.toString()) {
			case "0":
				show_tips("账号不存在！");
				break;
			case "1":
				show_tips("密码错误！");
				break;
			case "2":
				show_tips("登录成功！");
				history.go(0);
				break;
			default:
				show_tips("登录失败" + result);
				break;
			}
		}, "text");
	});
});

function show_tips(msg){
	var txtHint = document.getElementById('input-login-tips');
	txtHint.innerHTML = msg;
	setTimeout(() => {
		txtHint.innerHTML = ' ';
	}, 3000);
}