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
			<form action="../question/edit/${bean.qnaNo }">
				<div class="col-md-2"> 
					<div class="form-group"> 
						<label for="status">상태</label> 
						<input type="text" class="form-control" name="qnaStatus" id="qnaStatus" value="상담중" readonly="readonly"/>
					</div> 
				</div> 
				<div class="col-md-10">
					<div class="form-group"> 
						<label for="qnaTitle">제목</label> 
						<input type="text" class="form-control" name="qnaTitle" id="qnaTitle" value="${bean.qnaTitle }" readonly="readonly"/>  
					</div> 
				</div>
				<input type="hidden" name="qnaNick" value="${bean.qnaNick }" id="qnaNick">
				
				<div class="col-md-12">
					<div class="form-group"> 
						<label for="qnaContent">내용</label> 
						<textarea class="form-control" rows="20" name="qnaContent" id="qnaContent" readonly="readonly">${bean.qnaContent }</textarea>  
					</div> 
				</div>
				<!-- <div class="col-md-6">
					<div class="form-group"> 
						<label for="file">사진첨부</label> 
						<input type="file" id="file"> 
					</div> 
				</div> -->
						<input type="hidden" name="noticeDay" id="qnaDay"> 
				<div class="col-md-12 text-center">
						<a class="btn btn-primary" href="../../question/">목록으로</a>
						<a class="btn btn-default" href="../question/edit/${bean.noticeNo }" >수정</a>
						<a class="btn btn-danger" href="../question/delete/${bean.noticeNo }" >삭제</a>
				</div>
			</form>
			<div class="col-md-12">
				<jsp:include page="comment.jsp"></jsp:include>
				</div>
				
	<jsp:include page="../../menu/footer.jsp"></jsp:include>