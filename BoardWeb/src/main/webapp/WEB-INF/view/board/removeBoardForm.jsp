<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style>
.center {
  text-align: center;
}

.pagination {
  display: inline-block;
}

.pagination a {
  color: black;
  float: left;
  padding: 8px 16px;
  text-decoration: none;
  transition: background-color .3s;
  border: 1px solid #ddd;
  margin: 0 4px;
}

.pagination a.active {
  background-color: #4CAF50;
  color: white;
  border: 1px solid #4CAF50;
}

.pagination a:hover:not(.active) {background-color: #ddd;}
</style>


<h3>삭제화면</h3>
<form action="removeBoard.do">
<table class="table">
    <tr>
        <th>글번호</th><td><input type="text" class="form-control" readonly value="${board.boardNo}" name="bno"></td>
        <th class="col-sm-1">조회수</th><td class="col-sm-1"><c:out value="${board.clickCnt}"/></td>
    </tr>
     <tr>
        <th>제목</th><td colspan="3"><c:out value="${board.title}"/></td>
    </tr>
    <tr>
        <th>내용</th><td colspan="3"><textarea readonly cols="80" rows="3"><c:out value="${board.content}"/></textarea></td>
    </tr>
    <tr>
        <th>작성자</th><td colspan="3"><c:out value="${board.writer}"/></td>
    </tr>
    <tr>
        <th>작성일시</th><td colspan="3"><c:out value="${board.creationDate}"/></td>
    </tr>
    <tr align="center">
    	<td colspan="3">
    		<button type="submit" class="btn btn-danger">삭제</button>
    	</td>
    </tr>
</table>
</form>
<a href="getBoard.do?bno=${board.boardNo}&page=${page}&searchCondition=${searchCondition}&keyword=${keyword}" class="btn btn-success">이전으로</a>
