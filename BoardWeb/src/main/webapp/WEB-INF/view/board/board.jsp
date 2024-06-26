<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<style>
	div.reply div{
		margin: auto;
	}
	
	div.reply ul{
		list-style-type: none;
		margin-top: 3px;
	}
	div.reply li {
		padding-top: 1px;
		padding-bottom: 1px;
	}
	div.reply span {
		display: inline-block;
	}
</style>
<form name ="myForm" action="removeForm.do">
<input type="hidden" value="${board.boardNo }" name="bno">
<input type="hidden" value="${page}" name="page">
<input type="hidden" value="${searchCondition }" name="searchCondition">
<input type="hidden" value="${keyword }" name="keyword">
<table class="table">
    <tr>
        <th>글번호</th><td><c:out value="${board.boardNo }"/></td>
        <th class="col-sm-1">조회수</th><td class="col-sm-1"><c:out value="${board.clickCnt }"/></td>
    </tr>
    <tr>
        <th>제목</th><td colspan="2"><c:out value="${board.title }"/></td>
    </tr>
    <tr>
        <th>내용</th><td colspan="4"><textarea readonly cols="80" rows="3"><c:out value="${board.content }"/></textarea></td>
    </tr>
    <tr>
        <th>작성자</th><td colspan="2"><c:out value="${board.writer }"/></td>
    </tr>
    <tr>
        <th>작성일시</th><td colspan="3"><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${board.creationDate }"/></td>
    </tr>
    <tr align="center">
    	<td colspan="3">
    		<c:choose>
    			<c:when test="${!empty logId && logId == board.writer}">
    				<button type="submit" class="btn btn-danger">삭제 이동</button>
    				<button type="submit" class="btn btn-warning">수정 이동</button>
    				<a href="boardList.do?page=${page}&searchCondition=${searchCondition}&keyword=${keyword}" class="btn btn-success">목록으로 이동하기</a>
    			</c:when>
    			<c:otherwise>
    				<button type="submit" disabled class="btn btn-danger">삭제 이동</button>
    				<button type="submit" disabled class="btn btn-warning">수정 이동</button>
    				<a href="boardList.do?page=${page}&searchCondition=${searchCondition}&keyword=${keyword}" class="btn btn-success">목록으로 이동하기</a>
    			</c:otherwise>
    		</c:choose>
    	</td>
    </tr>
</table>
</form>

<!-- 댓글관련 시작 -->
<div class="container reply">

	<div class="headr">
	 <input class="col-sm-8" id="reply">
	 <button class="col-sm-3" id="addReply">등록</button>
	</div>
	
	<div class="content">
		<ul>
			<li>
				<span class="col-sm-1">글번호</span>
				<span class="col-sm-4">글내용</span>
				<span class="col-sm-2">작성자</span>
				<span class="col-sm-3">작성일시</span>
				<span class="col-sm-1">삭제</span>
			</li>
			<li><hr /></li>
			<li style="display: none">
				<span class="col-sm-1">3</span>
				<span class="col-sm-4">글을 잘봤습니다.</span>
				<span class="col-sm-2">user01</span>
				<span class="col-sm-3">2024-05-08 13:22:34</span>
				<span class="col-sm-1"><button onclick="deleteRow(event)">삭제</button></span>
			</li>
		</ul>
	</div>
</div>

<script>
const bno= "${board.boardNo }";
const replyer = "${logId }";
document.querySelector('button.btn-danger').addEventListener('click', function(e) {
	//삭제화면이동일 경우에는 removeForm.do
	//수정화면이동으로 처리할 경우에는 action="modifyForm.do"
	document.forms.myForm.action = "removeForm.do";
	document.forms.myForm.submit();
	});

document.querySelector('button.btn-warning').addEventListener('click', function(e) {
//삭제화면이동일 경우에는 removeForm.do
//수정화면이동으로 처리할 경우에는 action="modifyForm.do"
document.forms.myForm.action = "modifyForm.do";
document.forms.myForm.submit();
});
</script>
<script src="js/replyService.js"></script>
<script src="js/reply.js"></script>
