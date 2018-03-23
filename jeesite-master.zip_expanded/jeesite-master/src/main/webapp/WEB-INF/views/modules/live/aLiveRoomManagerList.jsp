<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>房间管理管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/live/aLiveRoomManager/">房间管理列表</a></li>
		<shiro:hasPermission name="live:aLiveRoomManager:edit"><li><a href="${ctx}/live/aLiveRoomManager/form">房间管理添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="aLiveRoomManager" action="${ctx}/live/aLiveRoomManager/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>id：</label>
				<form:input path="id" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>用户id：</label>
				<form:input path="userId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>房间id：</label>
				<form:input path="roomId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>授予时间：</label>
				<input name="createDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${aLiveRoomManager.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>id</th>
				<th>用户id</th>
				<th>房间id</th>
				<th>授予时间</th>
				<shiro:hasPermission name="live:aLiveRoomManager:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="aLiveRoomManager">
			<tr>
				<td><a href="${ctx}/live/aLiveRoomManager/form?id=${aLiveRoomManager.id}">
					${aLiveRoomManager.id}
				</a></td>
				<td>
					${aLiveRoomManager.userId}
				</td>
				<td>
					${aLiveRoomManager.roomId}
				</td>
				<td>
					<fmt:formatDate value="${aLiveRoomManager.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="live:aLiveRoomManager:edit"><td>
    				<a href="${ctx}/live/aLiveRoomManager/form?id=${aLiveRoomManager.id}">修改</a>
					<a href="${ctx}/live/aLiveRoomManager/delete?id=${aLiveRoomManager.id}" onclick="return confirmx('确认要删除该房间管理吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>