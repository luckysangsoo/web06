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
<h1> 회원 추가 </h1>
<form action="${path}/member/memberAdd.do" method="post">
	<div>회원 ID : </div>
	<div>
		<input name="userid" id="userid" type="text" />
	</div>
	<div>회원 PW : </div>
	<div>
		<input name="userpw" id="userpw" type="password" />
	</div>
	<div>회원명 :</div>
	<div>
		<input name="username" id="username" type="text" />
	</div>
	<div>email : </div>
	<div>
		<input name="email" id="email" type="text" />
	</div>
	<div>
		<br><input type="submit" value="회원입력" /> <input type="reset" value="초기화" />
	</div>
</form>

</body>
</html>