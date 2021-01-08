<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.javaex.vo.PersonVo" %>
<%
		PersonVo personvo = (PersonVo)request.getAttribute("personvo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>전화번호 수정화면</h1>
	
	<form action="/phonebook2/pbc" method = "host">
		이름(name):<input type="text" name = "name" value="<%=personvo.getName()%>"><br>
		핸드폰(hp):<input type="text" name = "hp" value="<%=personvo.getHp()%>"><br>
		회사(company)<input type="text" name = "company" value="<%=personvo.getCompany()%>"><br>
		<input type="hidden" name = "id" value="<%=personvo.getPersonId()%>">
		<input type="hidden" name = "action" value="update">
		<button type = "submit">수정</button>
	</form>
</body>
</html>