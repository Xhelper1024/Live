/**
 * blogUsers操作
 */
$("#button_login").click(function() {
	var t = {
		email : $("#input_unm").val(),
		password : $("#input_pwd").val()
	};
	$.ajax({
		type : "POST",
		url : root + "/blogUsers/login",
		data : {
			t : t
		},
		success : function(data) {
			alert(data);
		}
	})
})