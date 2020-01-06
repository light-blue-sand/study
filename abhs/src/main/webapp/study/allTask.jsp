<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查看全部任务</title>
<script type="text/javascript" src="/abhs/js/jquery-1.4.2.js"></script>
<script type="text/javascript">
	$(function(){
		$("select").val("${study.finishStatus}");
		
		var str = "${study.name}";
		if(str){
			str = str.substring(1,str.length-1);
		}
		$("#name").val(str);
		
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
	<div align="center">
		<form action="/abhs/study/allTask.do">
			名称: <input id="name" name="name">
			状态:<select name="finishStatus">
					<option value="">全部</option>
					<option value="复习中">复习中</option>
					<option value="已完成">已完成</option>
					<option value="已中断">已中断</option>
				 </select>
			<button id="query">查询</button>
		</form>
		<table>
			<tr>
				<th>名称</th>
				<td width='12'></td>
				<th>学习时间</th>
				<td width='12'></td>
				<th>状态</th>
				<td width='12'></td>
				<th>操作</th>
				<td width='12'></td>
				<th>完成时间</th>
			</tr>
			<c:forEach items="${studyList }" var="study">
				<tr>
					<td>${study.name }</td>
					<td width='12'></td>
					<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${study.learnedTime }"/></td>
					<td width='12'></td>
					<td>${study.finishStatus }</td>
					<td width='12'></td>
					<td>
						<a href="/abhs/studyNode/detailList.do?studyId=${study.id }" target="_blank">详情</a>
						&nbsp;<button onclick="restart(${study.id })">重新开始</button>
						&nbsp;<button onclick="remove(${study.id })">删除</button>
					</td>
					<td width='12'></td>
					<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${study.finishTime }"/></td>
				</tr>
			</c:forEach>
		</table>
		<button onclick="backIndex()">返回首页</button>
	</div>
</body>
<script type="text/javascript">
	function restart(studyId){
		if(window.confirm("你确定要重新开始此项目吗")){
			window.location.href = "/abhs/study/restart.do?studyId=" + studyId;
		}
	}
	function remove(studyId){
		if(window.confirm("你确定要删除此项目吗")){
			window.location.href = "/abhs/study/delete.do?studyId=" + studyId;
		}
	}
	
	function backIndex(){
		window.location.href = "/abhs/studyNode/index.do";
	}
</script>
</html>