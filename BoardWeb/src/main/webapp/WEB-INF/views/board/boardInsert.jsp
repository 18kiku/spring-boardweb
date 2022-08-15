<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 등록</title>
<style>
.container { width: 500px; margin: 20px auto;}
h1, .d1 { text-align: center;}
.d1 { margin-bottom: 20px;}
a { text-decoration: none; color: #186ab3; font-weight: bold; font-size: 1.05em;}
table { width: 100%; border: 1px solid black; border-collapse: collapse;}
tr { height: 40px;}
th, td { border: 1px solid black;}
th { background: #e9ecef;}
td { padding: 5px;}
table .seq { width: 100px; height: 20px; background: #f1f3f5;}
table .title { width: 380px; height: 20px;}
table .writer { width: 150px; height: 20px; background: #f1f3f5;}
.btns { margin-top: 20px; text-align: center;}
.btns input { width: 100px; height: 35px; font-size: 1.05em; font-weight: bold; border-radius: 3px; cursor: pointer;}
.btns input[type=submit] { background: #000; color: #fff; border: 1px solid #000;}
.btns input[type=submit] { background: #868e96; color: #fff; border: 1px solid #868e96;}
</style>
<script>
	document.addEventListener("DOMContentLoaded", function(){
		let form = document.insertForm;
		let pageNum = form.pageNum.value;
		// 글등록 버튼 처리
		let btn_insert = document.getElementById("btn_insert");
		btn_insert.addEventListener("click", function(){
			form.action = "insert?pageNum=" + pageNum;
			form.submit();
		})
		// 글목록 버튼처리
		let btn_list = document.getElementById("btn_list");
		btn_list.addEventListener("click", function(){
			form.action = "list?pageNum=" + pageNum;
			form.submit();
		})
	})
</script>
</head>
<body>
<div class="container">
	<h1>글등록</h1>
	<div class="d1"><a href="../member/logout">로그아웃</a></div>
	<form action="insert" method="post" name="insertForm">
	<input type="hidden" name="pageNum" value="${param.pageNum }">
	<table>
		<tr>
			<th width="20%">제목</th>
			<td width="80%"><input type="text" name="title" class="title"></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input type="text" name="writer" class="writer" value="${member.id }" readonly></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea name="content" rows="15" cols="52"></textarea></td>
		</tr>
	</table>
	<div class="btns">
		<input type="submit" id="btn_insert" value="글등록">&ensp;
		<input type="button" id="btn_list" value="글목록">
	</div>
	</form>
</div>
</body>
</html>