<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>直播礼物管理</title>
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
		<li class="active"><a href="${ctx}/live/aLiveGifts/">直播礼物列表</a></li>
		<shiro:hasPermission name="live:aLiveGifts:edit"><li><a href="${ctx}/live/aLiveGifts/form">直播礼物添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="aLiveGifts" action="${ctx}/live/aLiveGifts/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>礼物id：</label>
				<form:input path="id" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>礼物名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li><label>价格：</label>
				<form:input path="price" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>图片：</label>
			</li>
			<li><label>可得经验值：</label>
				<form:input path="exp" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>create_date：</label>
				<input name="createDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${aLiveGifts.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
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
				<th>礼物id</th>
				<th>礼物名称</th>
				<th>价格</th>
				<th>图片</th>
				<th>可得经验值</th>
				<th>create_date</th>
				<shiro:hasPermission name="live:aLiveGifts:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="aLiveGifts">
			<tr>
				<td><a href="${ctx}/live/aLiveGifts/form?id=${aLiveGifts.id}">
					${aLiveGifts.id}
				</a></td>
				<td>
					${aLiveGifts.name}
				</td>
				<td>
					${aLiveGifts.price}
				</td>
				<td>
					${aLiveGifts.image}
				</td>
				<td>
					${aLiveGifts.exp}
				</td>
				<td>
					<fmt:formatDate value="${aLiveGifts.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="live:aLiveGifts:edit"><td>
    				<a href="${ctx}/live/aLiveGifts/form?id=${aLiveGifts.id}">修改</a>
					<a href="${ctx}/live/aLiveGifts/delete?id=${aLiveGifts.id}" onclick="return confirmx('确认要删除该直播礼物吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>