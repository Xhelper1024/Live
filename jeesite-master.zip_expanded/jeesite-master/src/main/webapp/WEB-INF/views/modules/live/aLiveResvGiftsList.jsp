<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>礼物收益管理</title>
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
		<li class="active"><a href="${ctx}/live/aLiveResvGifts/">礼物收益列表</a></li>
		<shiro:hasPermission name="live:aLiveResvGifts:edit"><li><a href="${ctx}/live/aLiveResvGifts/form">礼物收益添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="aLiveResvGifts" action="${ctx}/live/aLiveResvGifts/" method="post" class="breadcrumb form-search">
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
			<li><label>礼物id：</label>
				<form:input path="giftId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>数量：</label>
				<form:input path="number" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>时间：</label>
				<input name="createDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${aLiveResvGifts.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
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
				<th>礼物id</th>
				<th>数量</th>
				<th>时间</th>
				<shiro:hasPermission name="live:aLiveResvGifts:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="aLiveResvGifts">
			<tr>
				<td><a href="${ctx}/live/aLiveResvGifts/form?id=${aLiveResvGifts.id}">
					${aLiveResvGifts.id}
				</a></td>
				<td>
					${aLiveResvGifts.userId}
				</td>
				<td>
					${aLiveResvGifts.roomId}
				</td>
				<td>
					${aLiveResvGifts.giftId}
				</td>
				<td>
					${aLiveResvGifts.number}
				</td>
				<td>
					<fmt:formatDate value="${aLiveResvGifts.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="live:aLiveResvGifts:edit"><td>
    				<a href="${ctx}/live/aLiveResvGifts/form?id=${aLiveResvGifts.id}">修改</a>
					<a href="${ctx}/live/aLiveResvGifts/delete?id=${aLiveResvGifts.id}" onclick="return confirmx('确认要删除该礼物收益吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>