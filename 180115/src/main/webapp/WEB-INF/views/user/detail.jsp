<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ include file="/WEB-INF/views/menu/header.jsp" %>
<!--메뉴별로 active들어가서 header에는 포함시키지 못함.  -->

<script type="text/javascript">
$(document).ready(function() {
	$('#edit').click(function() {
		$('.form-group input').remove('${readonly}');
	});
});


</script>
			       		<li><a href="/major">HOME </a></li>
			           	<li><a href="aboutus">ABOUT US</a></li>
						<li><a href="notice">공지사항</a></li>
			            <li  class="active"><a href="borad">게시판<span class="sr-only">(current)</span></a></li>
			            <li><a href="question">문의사항</a></li>
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
			  <h1>${title } <small>설명</small></h1><!--title:  글보기, 수정 두가지 -->
			</div>
			<form action="edit/${bean.no }"  method="get" >
				<div class="col-md-2"> 
					<div class="form-group"> 
						<label for="status">상태</label> 
						<select class="form-control">
						  <option>${bean.status}</option><!--bbslist에 status없음.  -->
						 
						</select> 
					</div> 
				</div> 
				<div class="col-md-10">
					<div class="form-group"> 
						<label for="dept">제목</label> 
						<input type="text" class="form-control" name="dept" id="dept" value="${bean.dept }" ${readonly }/>  
					</div> 
				</div>
				<div class="col-md-6">
					<div class="form-group"> 
						<label for="bookname">책이름</label> 
						<input type="text" class="form-control" name="bookname" id="bookname" value="${bean.bookname }" ${readonly }/>  
					</div> 
				</div>
				<div class="col-md-3">
					<div class="form-group"> 
						<label for="publisher">저자</label> 
						<input type="text" class="form-control" name="publisher" id="publisher" value="${bean.publisher }" ${readonly }/>  
					</div> 
				</div>
				<div class="col-md-3">
					<div class="form-group"> 
						<label for="author">출판사</label> 
						<input type="text" class="form-control" name="author" id="author" value="${bean.author }" ${readonly }/>  
					</div> 
				</div>
				<div class="col-md-4">
					<div class="form-group"> 
						<label for="ISBN">고유번호</label> 
						<input type="text" class="form-control" name="ISBN" id="ISBN" value="${bean.ISBN }" ${readonly }/>  
					</div> 
				</div>
				<div class="col-md-4">
					<div class="form-group"> 
						<label for="costprice">원가</label> 
						<input type="text" class="form-control" name="costprice" id="costprice" value="${bean.costprice }" ${readonly }/>  
					</div> 
				</div>
				<div class="col-md-4">
					<div class="form-group"> 
						<label for="saleprice">판매가</label> 
						<input type="text" class="form-control" name="saleprice" id="saleprice" value="${bean.saleprice }" ${readonly }/>  
					</div> 
				</div>
				<div class="col-md-12">
					<div class="form-group"> 
						<label for="writedetail">내용</label> 
						<textarea class="form-control" rows="10" name="writedetail" id="writedetail" ${readonly }>
							${bean.dept }
						</textarea>  
					</div> 
				</div>
				<div class="col-md-6">
					<div class="form-group"> 
						<label for="file">사진첨부</label> 
						<input type="file" id="file"> 
					</div> 
				</div>
				<c:if test="${title eq '게시글 수정' }">
					<div class="col-md-6">
						<a class="btn btn-default" id="edit" href="/major/user/edit/{idx}">수정</button>
						<a class="btn btn-default" id="delete" href="/major/user/delete/{idx}">삭제</button>
					</div>
				</c:if>
				<c:if test="${title eq '내용보기' }">
				<div class="col-md-12 text-center">
						<a class="btn btn-default" href="#">이전글</a>
						<a class="btn btn-default" href="#">뒤로</a>
						<a class="btn btn-default" href="#">다음글</a>
				</div>
				</c:if>
			</form>
				
		<%@ include file="/WEB-INF/views/menu/footer.jsp" %>