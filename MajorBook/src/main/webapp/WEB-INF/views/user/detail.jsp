<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<jsp:include page="../menu/header.jsp"></jsp:include>
<jsp:include page="../menu/menutest.jsp"></jsp:include>

<script>
$(document).ready(function(){
	
		//alert("1");
		
	 Kakao.Auth.getStatus(function(statusObj){ //현재 로그인 상태를 확인
		//alert("2");
   	  console.log("디텔"+statusObj.user.id);
  
   	var currentuser= statusObj.user.properties.nickname;
 	var writer = '${bean.nickName}';
  	
	//alert(currentuser);
  	//alert( writer );
	
	if(writer==currentuser){
		alert("같음");
		 document.getElementById("btnplace").innerHTML='<a class="btn btn-default" href="../edit/${bean.no }" >수정</a>		<a class="btn btn-default" href="../delete/${bean.no }" >삭제</a>';
		
	}
	
	 });
	 
 
 }); 
 </script>




			      </div>

	  </div>
	</nav>
	</div>
	<!-- 내용 -->	
	<div class="container">
		<div class="row content">
		  <div class="col-md-12">
		  	<div class="page-header">
			  <h1>내용보기 </h1>
			</div>
			<form action="edit/${bean.no }">
			
				<div class="col-md-2"> 
					<div class="form-group"> 
						<label for="status">상태</label> 
						<select class="form-control">
						  <option id="sell">${bean.status}</option>
						</select> 
					</div> 
				</div> 
				<div class="col-md-10">
					<div class="form-group"> 
						<label for="title">제목</label> 
						<input type="text" class="form-control" name="title" id="title" value="${bean.title }" readonly="readonly"/>  
					</div> 
				</div>
				<div class="col-md-4">
					<div class="form-group"> 
						<label for="nickName">이름</label> 
						<input type="text" class="form-control" name="nickName" id="nickName" value="${bean.nickName }(${bean.id})" readonly="readonly">  
					</div> 
				</div>
				<div class="col-md-4">
					<div class="form-group"> 
						<label for="university">대학교</label> 
						<input type="text" class="form-control" name="university" id="university" value="${bean.university }" readonly="readonly">  
					</div> 
				</div>
				<div class="col-md-4">
					<div class="form-group"> 
						<label for="dept">과</label> 
						<input type="text" class="form-control" name="dept" id="dept" value="${bean.dept }" readonly="readonly">  
					</div> 
				</div>	
				<!-- ///////////////////////////////////////////////////////////////////////////////// -->
				<div class="col-md-6">
					<div class="form-group"> 
						<label for="bookName">책이름</label> 
						<input type="text" class="form-control" name="bookName" id="bookName" value="${bean.bookName }" readonly="readonly"/>  
					</div> 
				</div>
				<div class="col-md-3">
					<div class="form-group"> 
						<label for="author">저자</label> 
						<input type="text" class="form-control" name="author" id="author" value="${bean.publisher }" readonly="readonly"/>  
					</div> 
				</div>
				<div class="col-md-3">
					<div class="form-group"> 
						<label for="publisher">출판사</label> 
						<input type="text" class="form-control" name="publisher" id="publisher" value="${bean.author }" readonly="readonly"/>  
					</div> 
				</div>
				<!-- ///////////////////////////////////////////////////////////////////////////////// -->
				<div class="col-md-4">
					<div class="form-group"> 
						<label for="ISBN">고유번호</label> 
						<input type="text" class="form-control" name="ISBN" id="ISBN" value="${bean.ISBN }" readonly="readonly"/>  
					</div> 
				</div>
				<div class="col-md-4">
					<div class="form-group"> 
						<label for="costPrice">원가</label> 
						<input type="text" class="form-control" name="costPrice" id="costPrice" value="${bean.costPrice }" readonly="readonly"/>  
					</div> 
				</div>
				<div class="col-md-4">
					<div class="form-group"> 
						<label for="salePrice">판매가</label> 
						<input type="text" class="form-control" name="salePrice" id="salePrice" value="${bean.salePrice }" readonly="readonly"/>  
					</div> 
				</div>
				<!-- ///////////////////////////////////////////////////////////////////////////////// -->
				<div class="col-md-12">
					<div class="form-group"> 
						<label for="content">내용</label> 
						<textarea class="form-control" rows="20" name="content" id="content" readonly="readonly">${bean.content }</textarea>  
					</div> 
				</div>
				<div class="col-md-6">
					<div class="form-group"> 
						<label for="file">사진첨부</label> 
						<input type="file" id="file"> 
					</div> 
				</div>
						<input type="hidden" name="view" id="view"> 
						<input type="hidden" name="day" id="day"> 
				
				
					<div class="col-md-6 pull-right" id="btnplace">
				
					</div>
					
					
					
					
				<div class="col-md-12 text-center">
						<a class="btn btn-default" href="#">이전글</a>
						<a class="btn btn-default" href="../../board/1">목록</a>
						<a class="btn btn-default" href="#">다음글</a>
				</div>
			</form>
				<div class="col-md-12">
				<jsp:include page="../user/comment.jsp"></jsp:include>
				</div>
				
	<jsp:include page="../menu/footer.jsp"></jsp:include>