<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert Member Page</title>
</head>
<body>
	<form action="memberSelectList.do" style="margin-top: 200px" onsubmit="return formCheck()" method="post">
		<div align="center">
			<h1>�ɹ��߰�</h1>
			<div>
				<label for="memberId" style="padding-right: 20px">���̵�</label> 
				<input	type="text" id='memberId' name='memberId' required="required" value ="aa">
				 <button type='button' id='btn' name= 'btn' value='no' onclick="idCheck()">�ߺ�üũ</button>
				<br>
				<label for="memberPassWord">��й�ȣ</label> 
				<input type="text" id='memberPassWord' name='memberPassWord' required="required"><br> 
				<label for="pwc">��й�ȣ Ȯ��</label>
			    <input	type="text" id='pwc' name='pwc'	required="required"><br>
			    <label for="memberName"	style="padding-right: 30px">�̸�</label> 
			    <input type="text"	id='memberName' name='memberName' required="required"><br>
				<label for="memberTel">��ȭ��ȣ</label>
				 <input type="text"	id='memberTel' name='memberTel'><br>
				<br>

			</div>
		 	<div>
		    	<input type = "hidden" name="memberAuhor" id="memberAuhor" value="user">
				<input type="submit" value="���"  > &ensp; 
				<input type="button" value="���" onclick="formCheck()"> &ensp; 
				<input type="button" value="���"	onclick="location.href='memberSelectList.do'">

			</div>
		
		</div>

	</form>
<script type="text/javascript">
function formCheck() {
	let pass1 = document.getElementById("memberPassWord").value
	let pass2 = document.getElementById("pwc").value
	//pass1='55'
	//ass1='55'	
	console.log(pass1);
	console.log(pass2);
/* 	let idChecked = document.getElementById("btn").value;
	if(idChecked == 'No') {
		alert("���̵� �ߺ�üũ�� ���ּ���.");
		return false;
	} */
	
	
	if(pass1 != pass2) {
		alert("�н����尡 ��ġ���� �ʽ��ϴ�.");
	

		document.getElementById("pwc").value=''
		document.getElementById("memberPassWord").value=''
		 document.getElementById("memberPassWord").focus()
		return false
	}
	

}
	function idCheck() {
		let id = document.getElementById("memberId").value;
		console.log('idCheck='+id)
		fetch('isMemberId.do', {
			method: 'POST',
			headers: { 'Content-type': 'application/x-www-form-urlencoded' },
			body: 'memberId'+id +"&do=idCheck"
		})
		.then(a=> a.text())
		.then(a=> {
			console.log(a)
		})
	}

</script>
</body>
</html>