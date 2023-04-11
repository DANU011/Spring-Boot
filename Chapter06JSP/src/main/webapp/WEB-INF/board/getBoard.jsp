<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitinal//EN" "http://www.w3.org/TR/html14.loose.dtd">
<html>
<head>
<meta http-equiv="context-Type" content="text/html; charset="UTF-8">
<title>글 상세</title>
</head>
<body>
<center>
<h1>게시글 상세</h1>
	<br>
	<form action="updateBoard" method="post">
		<input name="seq" type="hidden" value=${board.seq }"/>
		<table border="1" cellpadding="0" cellspacing="0" >
			<tr>
				<td bgcolor="orange" width="70">제목</td>
				<td align="left"><input name="title" value="${board.title }/></td>
			</tr>
	
			<tr>
				<td bgcolor="orange" >작성자</td>
				<td align="left">${board.writer}</td>
			</tr>
		<!-- ================================================================== -->
			<tr>
				<td bgcolor="orange" >등록일</td>
				<td align="left">${board.writer}</td>
			</tr>
	
			<tr>
				<td bgcolor="orange" >내용</td>
				<td align="left"><textarea name="content" cols="40"/></textarea></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="새글 등록"/>
				</td>
			</tr>
		</table>
	</form>
	</center>
</body>
</html>