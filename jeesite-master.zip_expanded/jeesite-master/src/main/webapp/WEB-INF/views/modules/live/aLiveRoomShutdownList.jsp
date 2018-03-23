<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>房间禁言管理</title>
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
		<li class="active"><a href="${ctx}/live/aLiveRoomShutdown/">房间禁言列表</a></li>
		<shiro:hasPermission name="live:aLiveRoomShutdown:edit"><li><a href="${ctx}/live/aLiveRoomShutdown/form">房间禁言添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="aLiveRoomShutdown" action="${ctx}/live/aLiveRoomShutdown/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>id：</label>
				<form:input path="id" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>房间id：</label>
				<form:input path="roomId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>房管id：</label>
				<form:input path="roomManagerId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>被禁用户id：</label>
				<form:input path="shutdownUserId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>被禁内容：</label>
				<form:input path="shutdownContent" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>禁言时间：</label>
				<input name="createDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${aLiveRoomShutdown.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
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
				<th>房间id</th>
				<th>房管id</th>
				<th>被禁用户id</th>
				<th>被禁内容</th>
				<th>禁言时间</th>
				<shiro:hasPermission name="live:aLiveRoomShutdown:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="aLiveRoomShutdown">
			<tr>
				<td><a href="${ctx}/live/aLiveRoomShutdown/form?id=${aLiveRoomShutdown.id}">
					${aLiveRoomShutdown.id}
				</a></td>
				<td>
					${aLiveRoomShutdown.roomId}
				</td>
				<td>
					${aLiveRoomShutdown.roomManagerId}
				</td>
				<td>
					${aLiveRoomShutdown.shutdownUserId}
				</td>
				<td>
					${aLiveRoomShutdown.shutdownContent}
				</td>
				<td>
					<fmt:formatDate value="${aLiveRoomShutdown.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="live:aLiveRoomShutdown:edit"><td>
    				<a href="${ctx}/live/aLiveRoomShutdown/form?id=${aLiveRoomShutdown.id}">修改</a>
					<a href="${ctx}/live/aLiveRoomShutdown/delete?id=${aLiveRoomShutdown.id}" onclick="return confirmx('确认要删除该房间禁言吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>