<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!--PhoneController 포워드 시켰다 personList-->
<%@ page import = "java.util.List" %>
<%@ page import = "com.javaex.vo.PersonVo" %>
<%
	List<PersonVo> personList = (List<PersonVo>)request.getAttribute("pList");	
	System.out.println("==========");
	System.out.println(personList);
%> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>전화번호 리스트</h1>
	<p>입력한 정보 내역입니다.</p>
	<%for (int i = 0; i<personList.size(); i++){ %>
	<table border="1">
		<tr>
			<td>이름(name)</td>
			<td><%=personList.get(i).getName() %></td>
		</tr>
	
		<tr>
			<td>핸드폰(hp)</td>
			<td><%=personList.get(i).getHp() %></td>
		</tr>
	
		<tr>
			<td>회사(company)</td>
			<td><%=personList.get(i).getCompany()%></td>
		</tr>
		<tr>
			<td><a href="/phonebook2/pbc?action=updateform&id=<%=personList.get(i).getPersonId()%>">수정</a></td>
			<td><a href="/phonebook2/pbc?action=delete&id=<%=personList.get(i).getPersonId()%>">삭제</a></td>			
		</tr>
	</table>
	<br>
	<%} %>
	<a href="/phonebook2/pbc?action=wform">추가번호 등록</a>
	
</body>
</html>