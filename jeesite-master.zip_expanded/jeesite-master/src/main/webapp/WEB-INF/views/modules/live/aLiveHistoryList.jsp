<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>历史记录管理</title>
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
		<li class="active"><a href="${ctx}/live/aLiveHistory/">历史记录列表</a></li>
		<shiro:hasPermission name="live:aLiveHistory:edit"><li><a href="${ctx}/live/aLiveHistory/form">历史记录添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="aLiveHistory" action="${ctx}/live/aLiveHistory/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>记录id：</label>
				<form:input path="id" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>开始时间：</label>
				<input name="startTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${aLiveHistory.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>结束时间：</label>
				<input name="endTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${aLiveHistory.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>用户id：</label>
				<form:input path="userId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>房间id：</label>
				<form:input path="roomId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>create_date：</label>
				<input name="createDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${aLiveHistory.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
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
				<th>记录id</th>
				<th>开始时间</th>
				<th>结束时间</th>
				<th>用户id</th>
				<th>房间id</th>
				<th>create_date</th>
				<shiro:hasPermission name="live:aLiveHistory:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="aLiveHistory">
			<tr>
				<td><a href="${ctx}/live/aLiveHistory/form?id=${aLiveHistory.id}">
					${aLiveHistory.id}
				</a></td>
				<td>
					<fmt:formatDate value="${aLiveHistory.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${aLiveHistory.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${aLiveHistory.userId}
				</td>
				<td>
					${aLiveHistory.roomId}
				</td>
				<td>
					<fmt:formatDate value="${aLiveHistory.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="live:aLiveHistory:edit"><td>
    				<a href="${ctx}/live/aLiveHistory/form?id=${aLiveHistory.id}">修改</a>
					<a href="${ctx}/live/aLiveHistory/delete?id=${aLiveHistory.id}" onclick="return confirmx('确认要删除该历史记录吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>