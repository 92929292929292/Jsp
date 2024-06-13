<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- webapp/WEB-INF/view/Product.jsp -->
	<h3>Product페이지</h3>
	<table>
		<tr>
			<th>학생번호</th><td>${student.stdNo}</td>
		</tr>
		<tr>
			<th>학생이름</th><td>${student.stdName}</td>
		</tr>
		<tr>
			<th>연락처</th><td>${student.phone}</td>
		</tr>
	</table>
	
	<a href="main.do">목록보기</a>
</body>
</html>