/**
 * 
 */
function changeElement() {
	var list = document.getElementById("repwd");
	list.removeChild(list.childNodes[0]);
	// 创建子节点
	var table = document.createElement("table");
	var tr1 = document.createElement("tr");
	var tr2 = document.createElement("tr");
	var tr3 = document.createElement("tr");
	var tr4 = document.createElement("tr");
	var td1 = document.createElement("td");
	var td2 = document.createElement("td");
	var td3 = document.createElement("td");
	var td4 = document.createElement("td");
	var input1 = document.createElement("input");
	var input2 = document.createElement("input");
	var input3 = document.createElement("input");
	var button1 = document.createElement("input");
	var button2 = document.createElement("input");
	// 设置子节点的属性
	table.setAttribute("class", "tab-userinfo");
	button1.setAttribute("type", "button");
	button1.setAttribute("id", "alterPwd");
	button1.setAttribute("value", "确认修改");
	button1.setAttribute("onclick", "alterPwd()");
	button2.setAttribute("type", "button");
	button2.setAttribute("id", "cancel");
	button2.setAttribute("value", "取消修改");
	button2.setAttribute("onclick", "cancel()");
	// type
	input1.setAttribute("type", "password");
	input2.setAttribute("type", "password");
	input3.setAttribute("type", "password");
	// id
	input1.setAttribute("id", "oldpwd");
	input2.setAttribute("id", "newpwd");
	input3.setAttribute("id", "enterpwd");
	// 设置文本节点
	input1.setAttribute("placeholder", "请输入原密码");
	input2.setAttribute("placeholder", "请输入新密码");
	input3.setAttribute("placeholder", "确认密码");
	// 添加节点
	td1.appendChild(input1);
	td2.appendChild(input2);
	td3.appendChild(input3);
	td4.appendChild(button1);
	td4.appendChild(button2);
	tr1.appendChild(td1);
	tr2.appendChild(td2);
	tr3.appendChild(td3);
	tr4.appendChild(td4);
	table.appendChild(tr1);
	table.appendChild(tr2);
	table.appendChild(tr3);
	table.appendChild(tr4);
	list.appendChild(table);
}

function alterPwd() {
	if (check()) {
		cancel();
	}
}

// 验证并处理
function check() {
	var oldpwd = document.getElementById("oldpwd");
	var newpwd = document.getElementById("newpwd");
	var enterpwd = document.getElementById("enterpwd");
	if (oldpwd.value.toString().trim() == "") {
		oldpwd.setAttribute("placeholder", "密码不能为空");
		oldpwd.focus();
		setTimeout(() => {
			oldpwd.setAttribute("placeholder", "请输入旧密码");
		}, 3000);
		return false;
	}
	if (newpwd.value.toString().trim() == "") {
		newpwd.setAttribute("placeholder", "密码不能为空");
		newpwd.focus();
		setTimeout(() => {
			newpwd.setAttribute("placeholder", "请输入新密码");
		}, 3000);
		return false;
	}
	if (enterpwd.value.toString().trim() == "") {
		enterpwd.setAttribute("placeholder", "密码不能为空");
		enterpwd.focus();
		setTimeout(() => {
			enterpwd.setAttribute("placeholder", "请在此输入新密码");
		}, 3000);
		return false;
	}
	if(enterpwd.value != newpwd.value){
		alert("两次密码不一致，请重新输入");
		enterpwd.focus();
		return false;
	}
	var data = {
		username: document.getElementById("uid").innerHTML,
		type: "userinfo",
		oldpwd: $("#oldpwd").val(),
		newpwd: $("#newpwd").val()
	};
	$.post("userinfo.do", data, function(result){
		alert(result);
		if(result.toString() == "success")
			history.go(0);
	}, "text");
	return false;
}

function cancel() {
	var repwd = document.getElementById("repwd");
	var childs = repwd.childNodes;
	for (var i = 0; i < childs.length; i++) {
		// alert(childs[i].nodeName);
		repwd.removeChild(childs[i]);
	}
	var button = document.createElement("input");
	button.setAttribute("type", "button");
	button.setAttribute("value", "修改密码");
	button.setAttribute("id", "repwdBtn");
	button.setAttribute("onclick", "changeElement()");
	repwd.appendChild(button);
}

$(function() {
	// 修改房间信息
	$("#alterRoomInfo").click(function() {
		var roomtitle = document.getElementById('roomtitle');
		var roomimage = document.getElementById('roomimage');
		var classification = document.getElementsByName("classification");
		// 取到对象数组后，我们来循环检测它是不是被选中
		var s = '';
		for (var i = 0; i < classification.length; i++) {
			if (classification[i].checked)
				s += classification[i].value + ' '; // 如果选中，将value添加到变量s中
		}
		// 那么现在来检测s的值就知道选中的复选框的值了
		// alert(s == '' ? '你还没有选择任何内容！' : s);
		// alert(roomtitle.val().toString());
		if (roomtitle.value.toString().trim() == "") {
			roomtitle.setAttribute("placeholder", "房间标题不能为空");
			roomtitle.focus();
			setTimeout(() => {
				roomtitle.setAttribute("placeholder", "醒目的房间标题");
			}, 3000);
			return;
		}
		if(roomtitle.value.length > 30){
			alert("房间标题长度不能大于30个字符");
			roomtitle.focus();
			return;
		}
		if(roomimage.value.toString().trim() == ""){
			roomimage.setAttribute("placeholder", "图片地址不能为空");
			roomimage.focus();
			setTimeout(() => {
				roomimage.setAttribute("placeholder", "请输入图片url");
			}, 3000);
			return;
		}
		var reg = /https*:\/\/[0-9a-zA-z\/\?\&\%\-\=\.\:]+\.(jpg|png|gif)/;
		if(!reg.test(roomimage.value.toString().trim())){
			alert("图片地址Or格式错误，只支持jpg,png和gif格式");
			roomimage.focus();
			return;
		}
		if(s == ''){
			alert("你还没有选择任何分类！至少选择一个");
			return;
		}
		var data = {
			roomid: document.getElementById("roomid").innerHTML,
			roomtitle: roomtitle.value.toString().trim(),
			roomimage: roomimage.value.toString().trim(),
			classification: s,
			type: "roominfo",
			username: document.getElementById("uid").innerHTML
		};
		$.post("userinfo.do", data, function(result){
			if(result.toString() == "success"){
				alert("房间信息修改成功！");
				history.go(0);
			} else {
				alert("房间信息修改失败！错误：" + result);
			}
		}, "text");
	});
});
