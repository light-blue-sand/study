<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>最新任务节点</title>
<script type="text/javascript" src="/abhs/js/jquery-1.4.2.js"></script>
<script type="text/javascript">
	$(function(){
		$("select[name='finishStatus']").val("${studyNode.finishStatus}");
		$("select[name='studyId']").val("${studyNode.studyId}");
		
		$("select").change(function(){
			submitQuery();
		});
		
		$("#query").click(function(){
			submitQuery();
		});
	});
	
	function submitQuery(){
		$("form").submit();
	}
</script>
</head>
<body>

	<div align="center">最新任务节点
		<form action="/abhs/studyNode/latestNode.do">
			主任务:<select name="studyId">
					<option value="">全部</option>
					<c:forEach items="${studyList }" var="study">
						<option value="${study.id }">${study.name }</option>
					</c:forEach>
				 </select>
			状态:<select name="finishStatus">
					<option value="">全部</option>
					<option value="待复习">待复习</option>
					<option value="已完成">已完成</option>
				 </select>
			<button id="query">查询</button>
		</form>
		<table>
			<tr>
				<th>名称</th>
				<td width='12'></td>
				<th>复习时间</th>
				<td width='12'></td>
				<th>日期代号</th>
				<td width='12'></td>
				<th>状态</th>
			</tr>
			<c:forEach items="${list }" var="studyNode">
				<tr>
					<td>${studyNode.nodeName }</td>
					<td width='12'></td>
					<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${studyNode.reviewTime }"/></td>
					<td width='12'></td>
					<td align="center">${studyNode.dateCode }</td>
					<td width='12'></td>
					<td><font style="color: rgb(95, 234, 163);">${studyNode.finishStatus }</font>
					</td>
					<td width='12'></td>
				</tr>
			</c:forEach>
		</table>
		<button onclick="backIndex()">返回首页</button>
	</div>
	
	<br>
</body>
<script type="text/javascript">
	//点击完成
	function done(studyNodeId){
		if(window.confirm("你确定完成此项目吗?")){
			window.location.href = "/abhs/studyNode/completeNode.do?studyNodeId=" + studyNodeId;
		}
	}
	
	function backIndex(){
		window.location.href = "/abhs/studyNode/index.do";
	}
</script>
</html>