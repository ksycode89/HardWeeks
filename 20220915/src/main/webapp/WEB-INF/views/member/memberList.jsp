<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>- 맴버 리스트 -</title>
<div align="center">
	<div>
		<h1>맴버 전체</h1>
	</div>
	<table border="1">
		<div>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>전화번호</th>
				<th>권한</th>
			</tr>
			<c:forEach items="${members }" var="var">
				<tr id="info" onclick = "select('${var.memberId}')">
					<td>${var.memberId}</td>
					<td>${var.memberName}</td>
					<td>${var.memberTel}</td>
					<td>${var.memberAuthor}</td>
					
					<!--   ${var.memberId} : ${var.memberPassword}: ${var.memberName}: ${var.memberTel}: ${var.memberAuthor} -->
				</tr>
			</c:forEach>

		</div>

	</table>
	<div>
		<a href="../../20220915">돌아가기</a>
		<a href="memberInsert.do">맴버추가하기</a>
		<a href="memberSelect.do">맴버선택하기</a>
	
	</div>

	
	<div>
		<form id="frm" method="POST">
			<input type = "hidden"  id='id' name ='id'>
		</form>
	</div>

	
		

</div>

<script type="text/javascript">
	function select(id) {
	 frm.id.value=id;
	 frm.action = "MemberSelect.do";
	 frm.submit();
	}

</script>
</head>
<body>

</body>
</html>