<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>전화번호 리스트</h1>
	<p>입력한 정보 내역입니다.</p>

	<c:forEach items = "${personList }" var = "vo">
	<table border="1">
		<tr>
			<td>이름(name)</td>
			<td>${vo.name }</td>
		</tr>
	
		<tr>
			<td>핸드폰(hp)</td>
			<td>${vo.hp }</td>
		</tr>
	
		<tr>
			<td>회사(company)</td>
			<td>${vo.company }</td>
		</tr>
		<tr>
			<td><a href="/phonebook2/pbc?action=updateform&id=${vo.personId }">수정</a></td>
			<td><a href="/phonebook2/pbc?action=delete&id=${vo.personId }]">삭제</a></td>			
		</tr>
	</table>
	<br>
	</c:forEach>
	<a href="/phonebook2/pbc?action=wform">추가번호 등록</a>
	
</body>
</html>