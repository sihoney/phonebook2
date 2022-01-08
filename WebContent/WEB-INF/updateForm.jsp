<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.javaex.dao.PhoneDao" %>
<%@ page import="com.javaex.vo.PersonVo" %>

<%
	int personId = Integer.parseInt(request.getParameter("personId"));

	PhoneDao phoneDao = new PhoneDao();

	PersonVo personVo = phoneDao.getPerson(personId);
	
	String name = personVo.getName();
	String hp = personVo.getHp();
	String company = personVo.getCompany();
	
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>[Phonebook2]</h1>
	
	<h2>전화번호 수정폼</h2>
	
	<p>
		전화번호를 수정하려면 아래 항복을 기입하고 '수정'버튼을 클릭하세요.
	</p>
	
	<form action="/phonebook2/pbc" method="get">
		이름(name): <input type="text" name="name" value="<%= name%>"><br/>
		핸드폰(hp): <input type="text" name="hp" value="<%= hp %>"><br/>
		회사(company): <input type="text" name="company" value="<%= company%>"><br/>
		<input type="hidden" name="personId" value="<%= personId%>">
		<input type="hidden" name="action" value="update">
		<button type="submit">수정</button>
	</form>
</body>
</html>