<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<div class="border-end bg-white" id="sidebar-wrapper">
                <div class="sidebar-heading border-bottom bg-light">Start Bootstrap</div>
                <div class="list-group list-group-flush">
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="main.do">메인 페이지</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="StudentForm.do">학생정보 등록</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="boardList.do">게시글 목록</a>
                    <c:choose>
                    	<c:when test="${empty logId }">
                    	<a class="list-group-item list-group-item-action list-group-item-light p-3" href="loginForm.do">로그인</a>
                    	<a class="list-group-item list-group-item-action list-group-item-light p-3" href="gaipForm.do">회원가입</a>
                    	<a class="list-group-item list-group-item-action list-group-item-light p-3" href="script.do">자바스크립트</a>
                    	<a class="list-group-item list-group-item-action list-group-item-light p-3" href="ajax.do">아작스</a>
                    	</c:when>
                    	<c:otherwise>
                    	<a class="list-group-item list-group-item-action list-group-item-light p-3" href="boardForm.do">게시글 작성</a>
                    	<a class="list-group-item list-group-item-action list-group-item-light p-3" href="logout.do">로그아웃</a>
                    	</c:otherwise>
                    </c:choose>            
                </div>
            </div>