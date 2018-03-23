<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>充值订单管理</title>
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
		<li class="active"><a href="${ctx}/live/aLiveOrder/">充值订单列表</a></li>
		<shiro:hasPermission name="live:aLiveOrder:edit"><li><a href="${ctx}/live/aLiveOrder/form">充值订单添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="aLiveOrder" action="${ctx}/live/aLiveOrder/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>订单id：</label>
				<form:input path="id" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>用户id：</label>
				<form:input path="userId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>充值金额：</label>
				<form:input path="money" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>订单时间：</label>
				<input name="createDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${aLiveOrder.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
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
				<th>订单id</th>
				<th>用户id</th>
				<th>充值金额</th>
				<th>订单时间</th>
				<shiro:hasPermission name="live:aLiveOrder:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="aLiveOrder">
			<tr>
				<td><a href="${ctx}/live/aLiveOrder/form?id=${aLiveOrder.id}">
					${aLiveOrder.id}
				</a></td>
				<td>
					${aLiveOrder.userId}
				</td>
				<td>
					${aLiveOrder.money}
				</td>
				<td>
					<fmt:formatDate value="${aLiveOrder.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="live:aLiveOrder:edit"><td>
    				<a href="${ctx}/live/aLiveOrder/form?id=${aLiveOrder.id}">修改</a>
					<a href="${ctx}/live/aLiveOrder/delete?id=${aLiveOrder.id}" onclick="return confirmx('确认要删除该充值订单吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>