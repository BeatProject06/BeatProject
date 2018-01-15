<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ include file="/WEB-INF/views/menu/header.jsp" %>
 <!--메뉴별로 active들어가서 header에는 포함시키지 못함.  -->
			       		<li><a href="/major">HOME </a></li>
			           	<li><a href="#">ABOUT US</a></li>
						<li><a href="#">공지사항</a></li>
			            <li  class="active"><a href="borad">게시판<span class="sr-only">(current)</span></a></li>
			            <li><a href="#">문의사항</a></li>
			      </ul>
			      </div>
	  </div>
	</nav>
	</div>
	<!-- 내용 -->	
	<div class="container">
		<div class="row content">
		  <div class="col-md-12">
		  	<div class="page-header">
			  <h1>글쓰기 <small>설명</small></h1>
			</div>
			<form action="" method="post" >
				<div class="col-md-2"> 
					<div class="form-group"> 
						<label for="status">상태</label> 
						<select class="form-control">
						  <option>팔래요</option>
						  <option>살래요</option>
						  <option>거래완료</option>
						</select> 
					</div> 
				</div> 
				<div class="col-md-10">
					<div class="form-group"> 
						<label for="dept">제목</label> 
						<input type="text" class="form-control" name="dept" id="dept" placeholder="제목을 작성하세요">  
					</div> 
				</div>
				<div class="col-md-6">
					<div class="form-group"> 
						<label for="bookname">책이름</label> 
						<input type="text" class="form-control" name="bookname" id="bookname" placeholder="책이름을 작성하세요">  
					</div> 
				</div>
				<div class="col-md-3">
					<div class="form-group"> 
						<label for="publisher">저자</label> 
						<input type="text" class="form-control" name="publisher" id="publisher" placeholder="책저자를 작성하세요">  
					</div> 
				</div>
				<div class="col-md-3">
					<div class="form-group"> 
						<label for="author">출판사</label> 
						<input type="text" class="form-control" name="author" id="author" placeholder="책출판사를 작성하세요">  
					</div> 
				</div>
				<div class="col-md-4">
					<div class="form-group"> 
						<label for="ISBN">고유번호</label> 
						<input type="text" class="form-control" name="ISBN" id="ISBN" placeholder="책고유번호를 작성하세요">  
					</div> 
				</div>
				<div class="col-md-4">
					<div class="form-group"> 
						<label for="costprice">원가</label> 
						<input type="text" class="form-control" name="costprice" id="costprice" placeholder="책원가를 작성하세요">  
					</div> 
				</div>
				<div class="col-md-4">
					<div class="form-group"> 
						<label for="saleprice">판매가</label> 
						<input type="text" class="form-control" name="saleprice" id="saleprice" placeholder="판매가를 작성하세요">  
					</div> 
				</div>
				<div class="col-md-12">
					<div class="form-group"> 
						<label for="writedetail">내용</label> 
						<textarea class="form-control" rows="10" name="writedetail" id="writedetail" placeholder="책상태, 책사진 필히 첨부"></textarea>  
					</div> 
				</div>
				<div class="col-md-6">
					<div class="form-group"> 
						<label for="file">사진첨부</label> 
						<input type="file" id="file"> 
					</div> 
				</div>
				<!-- <div class="col-md-6">
					 
					<a class="btn btn-danger pull-right" href="#">삭제</a>
					<a class="btn btn-default pull-right" href="#">수정</a>
				</div> -->
				<div class="col-md-12 text-center">
				<button class="btn btn-primary" type="submit">완료</button>
				<button class="btn btn-default" type="reset">취소</button>
				</div>
			</form>
				
		  </div><!--col-md-12 end  -->
		</div>
		<%@ include file="/WEB-INF/views/menu/footer.jsp" %>