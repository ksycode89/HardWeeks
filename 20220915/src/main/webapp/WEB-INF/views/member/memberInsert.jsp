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
			<h1>�ɹ��߰�</h1>
			<div>
				<label for="memberId" style="padding-right: 20px">���̵�</label> <input
					type="text" id='memberId' name='memberId' required="required">
				 <button type='button' id='btn' name= 'btn' value='no' onclick="idCheck()">�ߺ�üũ</button>
				<br>
				<label for="memberPassWord">��й�ȣ</label> <input
					type="text" id='memberPassWord' name='memberPassWord'
					required="required"><br> <label for="pwc">��й�ȣ Ȯ��</label> <input
					type="text" id='pwc' name='pwc'
					required="required"><br><label for="memberName"
					style="padding-right: 30px">�̸�</label> <input type="text"
					id='memberName' name='memberName' required="required"><br>
				<label for="memberTel">��ȭ��ȣ</label> <input type="text"
					id='memberTel' name='memberTel'><br>
				<br>

			</div>
			<div>
			<input type = "hidden" name="memberAuhor" id="memberAuhor" value="user">
				<input type="submit" value="���" onclick ="check()" > &ensp; 
				<input type="reset" value="���"> &ensp; 
				<input type="button" value="���"	onclick="location.href='memberSelectList.do'">

			</div>
		</div>

	</form>
<script type="text/javascript">
	function check() {
		let pass1 =document.getElementById("memberPassWord").value;
		let pass2 =document.getElementById("pwc").value;
		let idChecked = document.getElementById("btn").value
		if(idChecked == 'no'){
			alert("���̵��ߺ�")
			return false;
		}
		
		
		if(pass1 !=pass2){
			alert("�н����� �ٸ�")
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
			alert("�����")
		}
	}
	xttp.open("GET","ajaxMemberIdCheck.do?id="+id);
	xttp.send()
	

		
	}

</script>
</body>
</html>