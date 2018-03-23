<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>直播房间管理</title>
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
		<li class="active"><a href="${ctx}/live/aLiveRooms/">直播房间列表</a></li>
		<shiro:hasPermission name="live:aLiveRooms:edit"><li><a href="${ctx}/live/aLiveRooms/form">直播房间添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="aLiveRooms" action="${ctx}/live/aLiveRooms/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>id：</label>
				<form:input path="id" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>主播id：</label>
				<form:input path="userId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>直播类型id：</label>
				<form:input path="liveTypeId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>房间名：</label>
				<form:input path="roomName" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>房间状态：</label>
				<form:input path="roomState" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>创建日期：</label>
				<input name="createDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${aLiveRooms.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
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
				<th>主播id</th>
				<th>直播类型id</th>
				<th>房间名</th>
				<th>房间状态</th>
				<th>创建日期</th>
				<shiro:hasPermission name="live:aLiveRooms:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="aLiveRooms">
			<tr>
				<td><a href="${ctx}/live/aLiveRooms/form?id=${aLiveRooms.id}">
					${aLiveRooms.id}
				</a></td>
				<td>
					${aLiveRooms.userId}
				</td>
				<td>
					${aLiveRooms.liveTypeId}
				</td>
				<td>
					${aLiveRooms.roomName}
				</td>
				<td>
					${aLiveRooms.roomState}
				</td>
				<td>
					<fmt:formatDate value="${aLiveRooms.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="live:aLiveRooms:edit"><td>
    				<a href="${ctx}/live/aLiveRooms/form?id=${aLiveRooms.id}">修改</a>
					<a href="${ctx}/live/aLiveRooms/delete?id=${aLiveRooms.id}" onclick="return confirmx('确认要删除该直播房间吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>