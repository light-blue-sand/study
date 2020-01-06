<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>任务详情</title>
<script type="text/javascript" src="/abhs/js/jquery-1.4.2.js"></script>
</head>
<body>
	<div align="center">
		<table>
			<tr>
				<th>名称</th>
				<td width='12'></td>
				<th>复习时间</th>
				<td width='12'></td>
				<th>日期代号</th>
				<td width='12'></td>
				<th>状态</th>
				<td width='12'></td>
				<th>完成时间</th>
			</tr>
			<c:forEach items="${nodeList }" var="studyNode">
				<tr>
					<td>${studyNode.nodeName }</td>
					<td width='12'></td>
					<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${studyNode.reviewTime }"/></td>
					<td width='12'></td>
					<td align="center">${studyNode.dateCode }</td>
					<td width='12'></td>
					<td>
						<c:choose>
							<c:when test="${studyNode.finishStatus=='待复习' }">
								<font style="color: rgb(95, 234, 163);">${studyNode.finishStatus }</font>
							</c:when>
							<c:when test="${studyNode.finishStatus=='已完成' }">
								<font style="color: rgb(216, 35, 41);">${studyNode.finishStatus }</font>
							</c:when>
							<c:otherwise>
								${studyNode.finishStatus }
							</c:otherwise>
						</c:choose>
					</td>
					<td width='12'></td>
					<td>
						<c:choose>
							<c:when test="${studyNode.finishStatus=='已完成' }">
								<font style="color: rgb(216, 35, 41);"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${studyNode.finishedTime }"/></font>
							</c:when>
							<c:otherwise>
								<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${studyNode.finishedTime }"/>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>