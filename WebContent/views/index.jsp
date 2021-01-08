<%@page import="java.util.List"%>
<%@page import="com.skmisk.todolist.entity.Task"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Todo list 0.1.0</title>
</head>
<body>
	Todo list 0.1.0
	<br />

	<form action="addtask.do" method="post">
	<input type="text" name="userid" value="<c:out value='${userid}'/>" />
		代办事项: <input type="text" name="taskName" /> <br /> <input
			type="submit" value="新增" />
		<!-- Input Todo detail <input type="text" name="taskDetail"/> <br/> -->

	</form>
	我的代办事项：
	<br />
	<table border="1">
		<tr>
			<th>Task id</th>
			<th>标记完成</th>
			<th>Task</th>
			<th>Action</th>

		</tr>
		<c:forEach var="task" items="${tasks}">
			<tr>
				<td><c:out value='${task.id }' /></td>
				<td><a href="finishtask.do?taskId=<c:out value='${task.id }'/>&userid=<c:out value='${userid}'/>">
						完成 </a></td>
				<td><c:choose>
						<c:when test="${task.finished}">
							<del>
								<c:out value='${task.name }' />
							</del>
						</c:when>
						<c:otherwise>
							<c:out value='${task.name }' />
						</c:otherwise>
					</c:choose></td>
				<td><a href="deletetask.do?taskId=<c:out value='${task.id }'/>&userid=<c:out value='${userid}'/>">删除</a></td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>