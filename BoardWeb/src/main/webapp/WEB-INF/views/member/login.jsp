<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style>
.container { width: 400px; margin: 20px auto;}
h1, .d1 { text-align: center;}
.d1 { margin: 10px 0;}
a { text-decoration: none; text-align: center; color: #000;}
table { width: 100%; border: 1px solid black; border-collapse: collapse;}
tr { height: 50px;}
th, td { border: 1px solid black;}
th { background: #dee2e6;}
td { padding-left: 5px;}
tr:nth-of-type(3) td{ text-align: center}
input[type=text], input[type=password] { width: 190px; height: 25px;}
input[type=submit] { width: 100px; height: 35px; font-size: 1.1em; font-weight: bold;}
.a_tags { text-align: center;}
.a_tags a { text-decoration: none; color: gray;}
</style>
</head>
<body>
<div class="container">
	<h1>로그인</h1>
	<hr>
	
	<hr>
	<form action="login" method="post">
		<table>
			<tr>
				<th>로그인</th>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="로그인"></td>
			</tr>
		</table>
	</form>
	<hr>
	<div class="d1">
		<a href="join">회원가입</a>
	</div>
</div>
</body>
</html>