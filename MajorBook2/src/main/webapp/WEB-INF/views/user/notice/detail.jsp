<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../../menu/header.jsp"></jsp:include>
<jsp:include page="../../menu/menutest.jsp"></jsp:include>
	<!-- 내용 -->	
	<div class="container">
		<div class="row content">
		  <div class="col-md-12">
		  	<div class="page-header">
			  <h1>공지사항 보기 </h1>
			</div>
			<form action="../notice/edit/${bean.noticeNo }">
			
				<div class="col-md-12">
					<div class="form-group"> 
						<label for="noticeTitle">제목</label> 
						<input type="text" class="form-control" name="noticeTitle" id="noticeTitle" value="${bean.noticeTitle }" readonly="readonly"/>  
					</div> 
				</div>
				<input type="hidden" name="noticeNick" value="${bean.noticeNick }" id="noticeNick">
				
				<div class="col-md-12">
					<div class="form-group"> 
						<label for="noticeContent">내용</label> 
						<textarea class="form-control" rows="20" name="noticeContent" id="noticeContent" readonly="readonly">${bean.noticeContent }</textarea>  
					</div> 
				</div>
				<!-- <div class="col-md-6">
					<div class="form-group"> 
						<label for="file">사진첨부</label> 
						<input type="file" id="file"> 
					</div> 
				</div> -->
						<input type="hidden" name="iew" id="view"> 
						<input type="hidden" name="noticeDay" id="noticeDay"> 
				<div class="col-md-12 text-center">
						<a class="btn btn-primary" href="../../notice/">목록으로</a>
						<a class="btn btn-default" href="../notice/edit/${bean.noticeNo }" >수정</a>
						<a class="btn btn-danger" href="../notice/delete/${bean.noticeNo }" >삭제</a>
				</div>
			</form>
				
	<jsp:include page="../../menu/footer.jsp"></jsp:include>