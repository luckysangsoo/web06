<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
<script type="text/javascript">
$(document).ready(function(){

	$("#btnUpdate").click(function(){
		var userid=document.form1.userid.value;
		var username=document.form1.username.value;
        if(userid==""){
        	alert("사용자id를 입력하세요");
        	document.form.writer.focus();
        	return;
        }
        if(username==""){
        	alert("사용자이름 입력하세요");
        	document.form.writer.focus();
        	return;
        }
        //수정 주소
        document.form1.action="${path}/member/update.do"
        //폼에 입력한 데이터를 서버로 전송 함.
        document.form1.submit();
	});
	
});
</script>


</head>
<body>
<h1> 회원 정보 </h1>
<form name="form1" method="post">
	<div>회원 ID : </div>
	<div>
		<input name="userid" id="userid" type="text" value="${dto.userid}" />
	</div>
	<div>회원 PW : </div>
	<div>
		<input name="userpw" id="userpw" type="password" value="${dto.userpw}"/>
	</div>
	<div>회원명 :</div>
	<div>
		<input name="username" id="username" type="text" value="${dto.username}" />
	</div>
	<div>email : </div>
	<div>
		<input name="email" id="email" type="text" value="${dto.email}" />
	</div>
	<div>
		<br>
		<button type="button" id="btnUpdate">수 정</button>
	    <button type="button" id="btnDelete">삭 제</button>
	</div>
</form>

</body>
</html>