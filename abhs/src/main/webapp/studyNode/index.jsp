<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>今日应学</title>
<script type="text/javascript" src="/abhs/js/jquery-1.4.2.js"></script>
</head>
<body>

	<div align="center">今日应学
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
					<td><button onclick="done(${studyNode.id })">完成</button></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	<br>
	<div align="center">
		<button id="add">新增任务</button>&nbsp;&nbsp;&nbsp;
		<button id="allTask">查看全部任务</button>&nbsp;&nbsp;&nbsp;
		<button id="latestNode">查看最新节点</button>
	</div>
</body>
<script type="text/javascript">
	//点击完成
	function done(studyNodeId){
		if(window.confirm("你确定完成此项目吗?")){
			window.location.href = "/abhs/studyNode/completeNode.do?studyNodeId=" + studyNodeId;
		}
	}

	$(function(){
		$("#add").click(function(){
			window.location.href = "/abhs/study/add.jsp";
		});
		
		$("#allTask").click(function(){
			window.location.href = "/abhs/study/allTask.do?finishStatus=复习中";
		});
		
		$("#latestNode").click(function(){
			window.location.href = "/abhs/studyNode/latestNode.do?finishStatus=待复习";
		});
	});
</script>
</html>