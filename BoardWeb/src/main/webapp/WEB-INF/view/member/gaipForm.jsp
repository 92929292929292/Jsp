<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags" prefix="myTag"%>

<h3>회원가입화면</h3>
<myTag:line/>
<!-- JSP standard tag library -->
<form action="gaip.do">
<table class="table">
	<tr>
		<th>아이디</th><td><input type="text" name="id"></td>
	</tr>
	<tr>
		<th>비밀번호</th><td><input type="password" name="pw"></td>
	</tr>
	<tr>
		<th>이름</th><td><input type="text" name="name"></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="회원가입" class="btn btn-primary"></td>
	</tr>
</table>
</form>
