<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>用户管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/live/aLiveUsers/">用户列表</a></li>
		<li class="active"><a href="${ctx}/live/aLiveUsers/form?id=${aLiveUsers.id}">用户<shiro:hasPermission name="live:aLiveUsers:edit">${not empty aLiveUsers.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="live:aLiveUsers:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="aLiveUsers" action="${ctx}/live/aLiveUsers/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">nickname：</label>
			<div class="controls">
				<form:input path="nickname" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">telephone：</label>
			<div class="controls">
				<form:input path="telephone" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">password：</label>
			<div class="controls">
				<form:input path="password" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">head_image：</label>
			<div class="controls">
				<form:hidden id="headImage" path="headImage" htmlEscape="false" maxlength="255" class="input-xlarge"/>
				<sys:ckfinder input="headImage" type="files" uploadPath="/live/aLiveUsers" selectMultiple="true"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">sexy：</label>
			<div class="controls">
				<form:input path="sexy" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">birthday：</label>
			<div class="controls">
				<input name="birthday" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${aLiveUsers.birthday}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">exp：</label>
			<div class="controls">
				<form:input path="exp" htmlEscape="false" maxlength="11" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">gold：</label>
			<div class="controls">
				<form:input path="gold" htmlEscape="false" maxlength="11" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">money：</label>
			<div class="controls">
				<form:input path="money" htmlEscape="false" maxlength="11" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">is_streamer：</label>
			<div class="controls">
				<form:input path="isStreamer" htmlEscape="false" maxlength="255" class="input-xlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="live:aLiveUsers:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>