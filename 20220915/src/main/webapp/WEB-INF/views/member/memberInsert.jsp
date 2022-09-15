<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert Member Page</title>
</head>
<body>
	<form action="memberInsert2.do" style="margin-top: 200px">
		<div align="center">
			<h1>맴버추가</h1>
			<div>
				<label for="memberId" style="padding-right: 20px">아이디</label> <input
					type="text" id='memberId' name='memberId' required="required">
				 <button type='button' id='btn' name= 'btn' value='no' onclick="idCheck()">중복체크</button>
				<br>
				<label for="memberPassWord">비밀번호</label> <input
					type="text" id='memberPassWord' name='memberPassWord'
					required="required"><br> <label for="pwc">비밀번호 확인</label> <input
					type="text" id='pwc' name='pwc'
					required="required"><br><label for="memberName"
					style="padding-right: 30px">이름</label> <input type="text"
					id='memberName' name='memberName' required="required"><br>
				<label for="memberTel">전화번호</label> <input type="text"
					id='memberTel' name='memberTel'><br>
				<br>

			</div>
			<div>
			<input type = "hidden" name="memberAuhor" id="memberAuhor" value="user">
				<input type="submit" value="등록" onclick ="check()" > &ensp; 
				<input type="reset" value="취소"> &ensp; 
				<input type="button" value="목록"	onclick="location.href='memberSelectList.do'">

			</div>
		</div>

	</form>
<script type="text/javascript">
	function check() {
		let pass1 =document.getElementById("memberPassWord").value;
		let pass2 =document.getElementById("pwc").value;
		let idChecked = document.getElementById("btn").value
		if(idChecked == 'no'){
			alert("아이디중복")
			return false;
		}
		
		
		if(pass1 !=pass2){
			alert("패스워드 다름")
			pass1.value = " ";
		    pass2.value = " ";
		    pass1.focus();
		    return false
		}
		return true;
	}
	function idCheck() {
		let id = document.getElementById("memberId").value;
		
	const xttp = XMLHTTPRequest();
	xttp.onload = function () {
		if(this.reponseText=='1'){
					document.getElementById("btn").value='yse';
		}else {
			alert("사용중")
		}
	}
	xttp.open("GET","ajaxMemberIdCheck.do?id="+id);
	xttp.send()
	

		
	}

</script>
</body>
</html>