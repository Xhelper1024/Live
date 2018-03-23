<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>用户管理</title>
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
		<li class="active"><a href="${ctx}/live/aLiveUsers/">用户列表</a></li>
		<shiro:hasPermission name="live:aLiveUsers:edit"><li><a href="${ctx}/live/aLiveUsers/form">用户添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="aLiveUsers" action="${ctx}/live/aLiveUsers/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>id：</label>
				<form:input path="id" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>nickname：</label>
				<form:input path="nickname" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>telephone：</label>
				<form:input path="telephone" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>password：</label>
				<form:input path="password" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>head_image：</label>
			</li>
			<li><label>sexy：</label>
				<form:input path="sexy" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>birthday：</label>
				<input name="birthday" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${aLiveUsers.birthday}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>exp：</label>
				<form:input path="exp" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>gold：</label>
				<form:input path="gold" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>money：</label>
				<form:input path="money" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>is_streamer：</label>
				<form:input path="isStreamer" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>create_date：</label>
				<input name="createDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${aLiveUsers.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
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
				<th>nickname</th>
				<th>telephone</th>
				<th>password</th>
				<th>head_image</th>
				<th>sexy</th>
				<th>birthday</th>
				<th>exp</th>
				<th>gold</th>
				<th>money</th>
				<th>is_streamer</th>
				<th>create_date</th>
				<shiro:hasPermission name="live:aLiveUsers:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="aLiveUsers">
			<tr>
				<td><a href="${ctx}/live/aLiveUsers/form?id=${aLiveUsers.id}">
					${aLiveUsers.id}
				</a></td>
				<td>
					${aLiveUsers.nickname}
				</td>
				<td>
					${aLiveUsers.telephone}
				</td>
				<td>
					${aLiveUsers.password}
				</td>
				<td>
					${aLiveUsers.headImage}
				</td>
				<td>
					${aLiveUsers.sexy}
				</td>
				<td>
					<fmt:formatDate value="${aLiveUsers.birthday}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${aLiveUsers.exp}
				</td>
				<td>
					${aLiveUsers.gold}
				</td>
				<td>
					${aLiveUsers.money}
				</td>
				<td>
					${aLiveUsers.isStreamer}
				</td>
				<td>
					<fmt:formatDate value="${aLiveUsers.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="live:aLiveUsers:edit"><td>
    				<a href="${ctx}/live/aLiveUsers/form?id=${aLiveUsers.id}">修改</a>
					<a href="${ctx}/live/aLiveUsers/delete?id=${aLiveUsers.id}" onclick="return confirmx('确认要删除该用户吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>