<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>마이페이지</title>
	</head>
	<body>
		<h1>마이페이지</h1>
		<ul>
			<li>
				<label for="member-id">아이디</label> 
				${member.memberId }
			</li>
			<li>
				<label for="member-name">이름 :</label> 
				${member.memberName }
			</li>
			<li>
				<label for="age">나이 :</label> 
				${member.memberAge }
			</li>
			<li>
				<label for="gender">성별 :</label>
				<c:if test="${member.memberGender eq 77 }">남</c:if> 
				<c:if test="${member.memberGender eq 70 }">여</c:if> 
			</li>
			<li>
				<label for="email">이메일 :</label> 
				${member.memberEmail }
			</li>
			<li>
				<label for="phone">전화번호 :</label> 
				${member.memberPhone }
			</li>
			<li>
				<label for="address">주소 :</label> 
				${member.memberAddress }
			</li>
			<li>
				<label for="hobby">취미 :</label> 
				${member.memberHobby }
			</li>
		</ul>
		<a href="/member/modify.do">정보수정</a> <br>
		<a href="javascript:void(0)" onclick="deleteCheck();">회원탈퇴</a> <br>
	 	<br>
	 	<script>
	 		function deleteCheck() {
	 			if(confirm("탈퇴하시겠습니까?")) {
	 				location.href="/member/delete.do";
	 			}
	 		}
	 	</script>
	</body>
</html>































