<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.javaex.dao.PhoneDao" %>
<%@ page import="com.javaex.vo.PersonVo" %>
<%@ page import="java.util.List" %>
    
<%
	List<PersonVo> list = (List<PersonVo>)request.getAttribute("pList");
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
	<%
	for(int i = 0; i < list.size(); i++) {
		int personId = list.get(i).getPersonId();
	%>
		<table border="1">
			<tr>
				<td>이름(name)</td>
				<td><%= list.get(i).getName()%></td>
			</tr>
			<tr>
				<td>핸드폰(hp)</td>
				<td><%= list.get(i).getHp()%></td>
			</tr>
			<tr>
				<td>회사(company)</td>
				<td><%= list.get(i).getCompany()%></td>
			</tr>
			<tr>
				<td><a href="pbc?action=delete&personId=<%= personId%>">삭제</a></td>
				<td><a href="pbc?action=updateForm&personId=<%= personId%>">수정</a></td>
			</tr>
		</table>
		<br/>
	<%
	}
	%>
	
	<a href="./pbc?action=writeForm">추가번호 등록</a>
</body>
</html>