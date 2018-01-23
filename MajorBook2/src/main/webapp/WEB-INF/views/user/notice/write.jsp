<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
 <jsp:include page="../../menu/header.jsp" ></jsp:include>
 <jsp:include page="../../menu/menutest.jsp"></jsp:include>
  <script type="text/javascript" >


	var putnick = function(){
	
	 var nick=document.createElement("input");
	 nick.setAttribute("type","hidden");
	 nick.setAttribute("name","nickName");
	 nick.setAttribute("value",tempnick);
	 
	 var wform = document.getElementById('writeform');
		wform.appendChild(nick);	
	};

		$("#writeform").validate();
	
	
 </script>
 </head>
 <body>

	<!-- 내용 -->	
	<div class="container">
		<div class="row content">
		  <div class="col-md-12">
		  	<div class="page-header">
			  <h1>공지사항 작성 <small>설명</small></h1>
			</div>
			<form action="write" method="post" id="noticeform" onsubmit="putnick()">
			
				<div class="col-md-12">
					<div class="form-group"> 
						<label for="noticeTitle" id="noticeTitle">제목</label> 
						<input type="text" class="form-control" name="noticeTitle" id="noticeTitle" placeholder="제목을 작성하세요" minlength="2" maxlength="100" required="required">  
					</div> 
				</div>
				<div class="col-md-12">
					<div class="form-group"> 
						<label for="noticeContent">내용</label> 
						<textarea class="form-control" rows="20" name="noticeContent" id="noticeContent"></textarea>  
					</div> 
				</div>
				<!-- <div class="col-md-6">
					<div class="form-group"> 
						<label for="filename">사진첨부</label> 
						<input type="file" name="filename" id="filename"> 
					</div> 
				</div> -->
				<div class="col-md-12 text-center">
				<button class="btn btn-primary" type="submit">완료</button>
				<button class="btn btn-default" type="reset">취소</button>
				</div>
			</form>
		<jsp:include page="../../menu/footer.jsp"></jsp:include>