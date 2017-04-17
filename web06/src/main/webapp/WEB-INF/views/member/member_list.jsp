<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
</head>
<body>
<h2> 회원 목록</h2>

<table border="1">
	<tr>
		<th>회원ID</th>
		<th>회원명</th>
		<th>email</th>
		<th>가입일자</th>
	</tr>
	<c:forEach var="row" items="${list}">
		<tr>
			<td><a href="${path}/member/view.do?userid=${row.userid}">${row.userid}</a></td>
			<td>${row.username}</td>
			<td>${row.email}</td>
			<%-- <td><fmt:formatDate pattern="dd/MM/yyyy" value="${row.regdate}" /></td> --%>
			<td>${row.regdate}</td>
		</tr>
	</c:forEach>
	
</table>
</body>
</html>