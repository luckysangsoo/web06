<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> BOARD ADD </h1>
<form action="/board/boardAdd" method="post">
	<div>boardPw : </div>
	<div>
		<input name="boardPwd" id="boardPw" type="password" />
	</div>
	<div>boardTitle</div>
	<div>
		<input name="boardTitle" id="boardTitle" type="text" />
	</div>
	<div>boardContent</div>
	<div>
		<textarea name="boardContent" id="boardContent" rows="5" cols="50"></textarea>
	</div>
	<div>boardName : </div>
	<div>
		<input name="boarduser" id="boardUser" type="text" /><br>
	</div>
	<div>
		<br>
		<input type="submit" value="글입력" />  <input type="reset" value="초기화" />
	</div>
</form>

</body>
</html>