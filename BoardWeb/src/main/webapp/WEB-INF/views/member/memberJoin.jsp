<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/mall/member/memberJoin.css">
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

<style>
input[type="text"],input[type="password"] {
	height: 20px;
}
/* 상단의 메인,서브 타이틀*/
.t_title {
	font-family:'Do Hyeon',sans-serif;
	font-size:2em;
	text-align:center;
	margin: 30px 0;
}
/* 중단 - 입력 테이블*/
table {
	width:500px;
	border:1px solid black;
	border-collapse:collapse;
	margin:0 auto;
}
tr {
	height:65px;
}
th,td {
	border:1px solid black;
}
td {
	padding-left:5px;
}
th {
	background:#ced4da;
}
.addr_row {
	height:100px;
}
.addr_row input {
	margin:2px 0;
}
#btn_chk_id {
	width:100px;
	height:28px;
	border:none;
	background:#1e94be;
	color:white;
	font-size:12px;
	cursor:pointer;
	border-radius:3px;
	margin-left:10px
}
#btn_address {
	width:100px;
	height:28px;
	border:none;
	background:#1e94be;
	color:white;
	font-size:12px;
	cursor:pointer;
	border-radius:3px;
	margin-left:10px
}
table span {
	font-size: 0.8em;
}
/* 하단 - 가입,취소 버튼*/
.btns {
	text-align:center;
	margin-top:30px;
}
.btns input[type="button"] {
	width:200px;
	height:40px;
	background:black;
	color:white;
	border:none;
	font-size:1.1em;
	font-weight:bold;
	cursor: pointer;
}
</style>
<script>
	let isChecked = false;
	// ajax 사용. 중복체크
	function memberCheck(){
		let id = $("#id").val();
		
		$.ajax({
			url: 'memberCheck',
			type:'post',
			data:{id:id},
			success:function(cnt){
				if(cnt == 1){
					alert('사용중인 아이디입니다.');
				} else if (cnt == 0){
					if(confirm('사용 가능한 아이디입니다. 사용하시겠습니까?')) {
						$("#id").attr('readonly', 'true');
						$("#btn_chk_id").val('중복체크 완료');
						$("#btn_chk_id").css('background-color', '#000');
						isChecked = true;
					}
				}
			},
			error:function(){
				alert("에러");
			}
		})
	}
	document.addEventListener("DOMContentLoaded", function(){
		let form = document.joinForm;
				
		// 비밀번호 - password
		// 비밀번호 유효성 검사 - 4글자 이상 입력하도록
		let chk_password = document.getElementById("chk_password");
		form.password.addEventListener("keyup", function(){
			if(form.password.value.length < 4){
				chk_password.innerText = "비밀번호는 4글자 이상이어야합니다.";
				chk_password.style.color = "red";
			} else{
				chk_password.innerText = "사용 가능한 비밀번호입니다.";
				chk_password.style.color = "blue";
			}
		})
		// 비밀번호 확인 - password2
		// 비밀번호와 비밀번호 확인의 내용이 동일한지 유무를 판단.
		let chk_password2 = document.getElementById("chk_password2");
		form.password2.addEventListener("keyup", function(){
			if(form.password.value == form.password2.value){
				chk_password2.innerText = "비밀번호가 일치합니다."
				chk_password2.style.color = "blue";
			} else{
				chk_password2.innerText = "비밀번호가 일치하지 않습니다."
				chk_password2.style.color = "red";
			}
		})
		// 이메일 검사 함수
		let isEmail = function(value){
			return (value.indexOf('@')>2) && (value.split('@')[1].indexOf('.')>2);
		}
		
		// 이메일 확인
		// 1. '@'문자를 포함하고 있는지의 여부 -> 아이디가 3글자 이상인지 판별
		// 2. '@'문자 다음에 '.'을 포함하고 있는지의 여부 -> 도메인도 3글자 이상인지 판별
		let chk_email = document.getElementById("chk_email");
		form.email.addEventListener("keyup", function(event){
			let value = form.email.value;
			if(isEmail(value)){
				chk_email.innerText = "이메일 형식이 맞습니다. " + value;
				chk_email.style.color="blue";
			} else{
				chk_email.innerText = "이메일 형식이 아닙니다. " + value;
				chk_email.style.color="red";
			}
		})
				
		// 회원가입 페이지의 전체 내용 입력 유무에 따른 유효성 검사와 페이지 이동 처리
		let btn_insert = document.getElementById("btn_insert");
		btn_insert.addEventListener("click", function(){
			if(form.id.value.length == 0){
				alert(`아이디를 입력하고, 아이디 중복체크를 해주세요.`);
				form.id.focus();
				return;
			}
			if(form.password.value.length == 0){
				alert(`비밀번호를 입력해주세요.`);
				form.password.focus();
				return;
			}
			if(form.password2.value.length == 0){
				alert(`비밀번호를 확인해주세요.`);
				form.password2.focus();
				return;
			}
			if(form.password.value != form.password2.value){
				alert("비밀번호가 일치하지 않습니다.");
				form.password2.focus();
				return;
			}
			if(form.name.value.length == 0){
				alert(`이름을 입력해주세요.`);
				form.name.focus();
				return;
			}
			if(form.email.value.length == 0){
				alert(`이메일을 입력해주세요.`);
				form.email.focus();
				return;
			}
			if(!isChecked){
				alert(`아이디 중복체크를 해주세요.`);
				return;
			}
			form.submit();
		})
		let btn_cancel = document.getElementById("btn_cancel");
		btn_cancel.addEventListener("click", function(){
			history.back();
		})
	})
</script>
<main>
<div class="t_title">
	회원가입
</div>
<form action="join" method="post" name="joinForm">
	<table>
	<tr>
		<th>
			아이디
		</th>
		<td>
			<input type="text" name="id" id="id">
			<input type="button" value="ID 중복 체크" id="btn_chk_id" onclick="memberCheck()"><br>
		</td>
	</tr>
	<tr>
		<th>
			비밀번호
		</th>
		<td>
			<input type="password" name="password" size=15><br>
			<span id="chk_password"></span>
		</td>
	</tr>
	<tr>
		<th>
			비밀번호 확인
		</th>
		<td>
			<input type="password" name="password2" id="" size=15><br>
			<span id="chk_password2"></span>
		</td>
	</tr>
	<tr>
		<th>
			이름
		</th>
		<td>
			<input type="text" name="name" id="name" size=15>
		</td>
	</tr>
	<tr>
		<th>
			이메일
		</th>
		<td>
			<input type="email" name="email" id="email" size=30><br>
			<span id="chk_email"></span>
		</td>
	</tr>
	</table>
	<div class="btns">
		<input type="button" value="회원가입" id="btn_insert">&emsp;&emsp; <input type="button" value="취소" id="btn_cancel">
	</div>
</form>
</main>