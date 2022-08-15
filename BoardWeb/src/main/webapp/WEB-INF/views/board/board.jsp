<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세보기</title>
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
table .writer { width: 100px; height: 20px; background: #f1f3f5;}
table .title { width: 380px; height: 20px;}
table .comment { width: 350px; height: 20px;}
.btns { margin-top: 20px; text-align: center;}
.btns input { width: 100px; height: 35px; font-size: 1.05em; font-weight: bold; border-radius: 3px; cursor: pointer;}
.btns input[type=submit] { background: #000; color: #fff; border: 1px solid #000;}
.btns input[type=submit] { background: #868e96; color: #fff; border: 1px solid #868e96;}
#btn_delete { background: #c84557;}
</style>
<script>
	document.addEventListener("DOMContentLoaded", function(){
		let form = document.detailForm;
		let pageNum = form.pageNum.value;
		let commentId = form.commentId.value;
		// 댓글 등록
		let btn_comment = document.getElementById("btn_comment");
		btn_comment.addEventListener("click", function(){
			form.action = "insertComment?pageNum=" + pageNum;
			form.submit();
		})
		// 글목록 버튼 처리
		let btn_board_list = document.getElementById("btn_board_list");
		btn_board_list.addEventListener("click", function(){
			form.action = "list?pageNum=" + pageNum;
			form.submit();
		})
		// 댓글삭제버튼처리
		let btn_delete_comment = document.getElementById("btn_delete_comment");
		btn_delete_comment.addEventListener("click", function(){
			form.action = "deleteComment?commentId=" + commentId + "&pageNum=" + pageNum;
			form.submit();
		})
		// 글삭제버튼처리
		let btn_delete = document.getElementById("btn_delete");
		btn_delete.addEventListener("click", function(){
			form.action = "delete?pageNum=" + pageNum;
			form.submit();
		})
	})
</script>
</head>
<body>
<div class="container">
	<h1>글상세</h1>
	<div class="d1"><a href="../member/logout">로그아웃</a></div>
	<form action="update?pageNum=${param.pageNum }" method="post" name="detailForm">
	<input type="hidden" name="pageNum" value="${param.pageNum }">
	<table>
		<tr>
			<th width="20%">번호</th>
			<td width="80%"><input type="text" name="id" value="${board.id}" readonly></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" value="${board.title}" class="title"></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input type="text" name="writer" value="${board.writer}" class="writer" readonly></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea name="content" rows="15" cols="52">${board.content}</textarea></td>
		</tr>
		<tr>
			<th>등록일</th>
			<td>${board.createDate }</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${board.cnt }</td>
		</tr>
		<c:if test="${member == null }">
			<tr>
				<th>댓글</th>
				<td><a href="../member/login">로그인을 하시면 댓글을 달 수 있습니다.</a></td>
			</tr>
		</c:if>
		<c:if test="${member != null }">
			<tr>
				<th>댓글</th>
				<td><input type="text" name="comment" class="comment"><input type="button" id="btn_comment" value="등록"></td>
			</tr>
		</c:if>
		<c:if test="${commentList[0] == null }">
			<tr>
				<td colspan="2">댓글이 없습니다.</td>
			</tr>
		</c:if>
		<c:if test="${commentList[0] != null }">
			<c:forEach items="${commentList }" var="comment" varStatus="status">
			<input type="hidden" name="commentId" value="${comment.id }">
				<tr>
					<td>${comment.writer }</td>
					<td>
						${comment.comment }
						<c:if test="${comment.writer == member.id }">
							<input type="button" id="btn_delete_comment" value="삭제">
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<div class="btns">
		<c:if test="${member.id == board.writer }">
			<input type="submit" value="글수정" id="btn_update">&ensp;
			<input type="button" value="삭제" id="btn_delete">&ensp;
		</c:if>
		<input type="button" value="리스트" id="btn_board_list">
	</div>
	</form>
</div>
</body>
</html>