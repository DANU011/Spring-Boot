<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitinal//EN" "http://www.w3.org/TR/html14.loose.dtd">
<html>
<head>
<meta http-equiv="context-Type" content="text/html; charset="UTF-8">
<title>글 목록</title>
</head>
<body>
<center>
<h1>게시글 목록</h1>
	<table border="1" width="700" style="border-collapse:collapse;">
		<tr>
			<td bgcolor="orange" width="100">번호</td>
			<td bgcolor="orange" width="200">제목</td>
			<td bgcolor="orange" width="150">작성자</td>
			<!-- <td bgcolor="orange" width="150">content</td> -->
			<td bgcolor="orange" width="150">등록일</td>
			<td bgcolor="orange" width="100">조회수</td>
		</tr>
		<c:forEach var="board" items="${boardList }">
		<tr>
			<td>${board.seq }</td>
			<td align="left"><a href="getBoard?seq=${board.seq}">${board.title }</a></td>
			<td>${board.writer }</td>
			<!-- <td>${board.content }</td> -->
			<td><fmt:formatDate value="${board.createDate }" pattern="yyyy-MM-dd"></fmt:formatDate></td>
			<td>${board.cnt }</td>
		</tr>
		</c:forEach>
	</table>
	<br>
	<a href="insertBoard">새글 등록</a>
	</center>
</body>
</html>