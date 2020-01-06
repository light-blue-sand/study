<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增已学完任务</title>
<script type="text/javascript" src="/abhs/js/jquery-1.4.2.js"></script>
</head>
<body>
	<form action="/abhs/study/save.do" method="post">
		任务名称: <input type="text" name="name"/>
		<input type="submit" value="保存">
	</form>
</body>
</html>