<%@page import="co.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../public/Header.jsp"%>

<%
	BoardVO board = (BoardVO)request.getAttribute("board");
    String paging = (String)request.getAttribute("page");
%>
<p><%=board %></p>
<table class="table">
    <tr>
        <th>글번호</th><td><%=board.getBoardNo() %></td>
        <th class="col-sm-1">조회수</th><td class="col-sm-1"><%=board.getClickCnt() %></td>
    </tr>
    <tr>
        <th>제목</th><td colspan="3"><%=board.getTitle() %></td>
    </tr>
    <tr>
        <th>내용</th><td colspan="3"><textarea readonly cols="80" rows="3"><%=board.getContent() %></textarea></td>
    </tr>
    <tr>
        <th>작성자</th><td colspan="3"><%=board.getWriter() %></td>
    </tr>
    <tr>
        <th>작성일시</th><td colspan="3"><%=board.getCreationDate() %></td>
    </tr>
</table>
<a href="boardList.do?page=<%=paging %>">목록으로 이동하기</a>
<form action="removeBoardForm.do">
	<input type="submit" class="btn btn-warning" value="삭제 화면으로">
</form>
<%@include file="../public/Footer.jsp"%>