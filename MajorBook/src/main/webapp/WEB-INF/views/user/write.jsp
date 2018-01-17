<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/views/menu/header.jsp"></jsp:include>
<!--메뉴별로 active들어가서 header에는 포함시키지 못함.  -->
<li><a href="/major">HOME </a></li>
<li><a href="aboutus">ABOUT US</a></li>
<li><a href="notice">공지사항</a></li>
<li class="active"><a href="board">게시판<span class="sr-only">(current)</span></a></li>
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
				<h1>
					글쓰기 <small>설명</small>
				</h1>
			</div>
			<form action="detail" method="post" enctype="multipart/form-data">
				<div class="col-md-2">
					<div class="form-group">
						<label for="status">상태</label> <select class="form-control">
							<option>팔래요</option>
							<option>살래요</option>
							<option>거래완료</option>
						</select>
					</div>
				</div>
				<div class="col-md-10">
					<div class="form-group">
						<label for="title">제목</label> <input type="text"
							class="form-control" name="title" id="title"
							placeholder="제목을 작성하세요">
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label for="nickName">이름</label>
						<!-- 카카오userinfo에서 닉네임을 받아오는것인가아? -->
						<input type="text" class="form-control" name="nickName"
							id="nickName" value="test" readonly="readonly">
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label for="university">대학교</label> <input type="text"
							class="form-control" name="university" id="university"
							placeholder="대학교를 작성하세요">
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label for="dept">과</label> <input type="text"
							class="form-control" name="dept" id="dept" placeholder="과를 작성하세요">
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label for="bookName">책이름</label> <input type="text"
							class="form-control" name="bookName" id="bookName"
							placeholder="책이름을 작성하세요">
					</div>
				</div>
				<div class="col-md-3">
					<div class="form-group">
						<label for="author">저자</label> <input type="text"
							class="form-control" name="author" id="author"
							placeholder="책저자를 작성하세요">
					</div>
				</div>
				<div class="col-md-3">
					<div class="form-group">
						<label for="publisher">출판사</label> <input type="text"
							class="form-control" name="publisher" id="publisher"
							placeholder="책출판사를 작성하세요">
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label for="ISBN">고유번호</label> <input type="text"
							class="form-control" name="ISBN" id="ISBN"
							placeholder="책고유번호를 작성하세요">
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label for="costPrice">원가</label> <input type="text"
							class="form-control" name="costPrice" id="costPrice"
							placeholder="책원가를 작성하세요">
					</div>
				</div>
				<div class="col-md-4">
					<div class="form-group">
						<label for="salePrice">판매가</label> <input type="text"
							class="form-control" name="salePrice" id="salePrice"
							placeholder="판매가를 작성하세요">
					</div>
				</div>
				<div class="col-md-12">
					<div class="form-group">
						<label for="content">내용</label>
						<textarea class="form-control" rows="10" name="content"
							id="content" placeholder="책상태, 책사진 필히 첨부"></textarea>
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label for="filename">사진첨부</label> <input type="file"
							name="filename" id="filename">
					</div>
				</div>

				<!-- <input type="hidden" name="view" id="view"> 
						<input type="hidden" name="day" id="day" value="">  -->


				<!-- <div class="col-md-6">
					 
					<a class="btn btn-danger pull-right" href="#">삭제</a>
					<a class="btn btn-default pull-right" href="#">수정</a>
				</div> -->
				<div class="col-md-12 text-center">
					<button class="btn btn-primary" type="submit">완료</button>
					<button class="btn btn-default" type="reset">취소</button>
				</div>
			</form>
			<jsp:include page="/WEB-INF/views/menu/footer.jsp"></jsp:include>