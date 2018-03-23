/**
 * 
 */
$("#login-submit").click(function() {
	var tip1 = document.getElementById("tip1");
	var tip2 = document.getElementById("tip2");
	var user = {
		username : $("#input-username").val(),
		password : $("#input-password").val()
	}
	$.post("login", user, function(result) {
		switch (result) {
		case "-1":
			$("#tip1").removeClass("success-tips");
			$("#tip1").addClass("warning-tips");
			tip1.innerHTML = "× 用户名未找到";
			break;
		case "0":
			tip1.innerHTML = "√";
			$("#tip1").removeClass("warning-tips");
			$("#tip1").addClass("success-tips");
			tip2.innerHTML = "× 密码错误";
			break;
		case "1":
			tip1.innerHTML = "√";
			tip2.innerHTML = "√";
			$("#tip1").removeClass("warning-tips");
			$("#tip1").addClass("success-tips");
			$("#tip2").removeClass("warning-tips");
			$("#tip2").addClass("success-tips");
			break;
		default:
			alert(result);
			break;
		}
	}, "text");
});