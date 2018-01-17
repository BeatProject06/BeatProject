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

</head>
<body>


	<%@ include file="/WEB-INF/views/menu/header.jsp" %>

    <!--메뉴별로 active들어가서 header에는 포함시키지 못함.  -->
			        	<li><a href="/major">HOME </a></li>
			           	<li><a href="#">ABOUT US</a></li>
						<li><a href="#">공지사항</a></li>
			            <li  class="active"><a href="board">게시판<span class="sr-only">(current)</span></a></li>
			            <li><a href="#">문의사항</a></li>
			      </ul>
			      
<jsp:include page="../loginoutdel/login.jsp"></jsp:include>
			      </div>
	  </div>
	</nav>
	</div>
	<!-- 내용 -->	
	<div class="container">
		<div class="row content">
		  <div class="col-md-12">
		  	<div class="page-header">
			  <h1>게시판 <small>설명</small></h1>
			</div>
			
			<table class="table table-hover">
			  <tr>
			  	<th  class="col-md-1">번호</th>
			  	<th  class="col-md-2">상태</th>
			  	<th  class="col-md-4">제목</th>
			  	<th  class="col-md-2">글쓴이</th>
			  	<th  class="col-md-2">작성일</th>
			  	<th  class="col-md-1">조회수</th>
			  </tr>
<!-- 			  <tr> -->
<!-- 			  	<td>1</td> -->
<!-- 			  	<td>살래요</td> -->
<!-- 			  	<td><a href="#">test1</a></td> -->
<!-- 			  	<td>test1</td> -->
<!-- 			  	<td>2018-01-12</td> -->
<!-- 			  	<td>1</td> -->
<!-- 			  </tr> -->
			<c:forEach items="${list }" var="bean">
			<tr>
				<td>${bean.no }</td>
				<td>${bean.status }</td>
				<td><a href="detail/${bean.no}">${bean.title }</a></td>
				<td>${bean.nickName }</td>
				<td>${bean.day }</td>
				<td>${bean.view }</td>
			</tr>
			</c:forEach>
			</table>
			<a class="btn btn-default pull-right" href="write" role="button">글쓰기</a>
			<div class="text-center">
			
				  <ul class="pagination">
				    <!-- <li class="disabled">
				    <a href="#" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a>
				    </li> -->
				    <li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
				    <li><a href="#">2</a></li>
				    <li><a href="#">3</a></li>
				    <li><a href="#">4</a></li>
				    <li><a href="#">5</a></li>
				    <li>
				      <a href="#" aria-label="Next">
				        <span aria-hidden="true">&raquo;</span>
				      </a>
				    </li>
				  </ul>
				</div>
		  </div>
		</div>
		<%@ include file="../menu/footer.jsp" %>
		
		
		
		</body>
		</html>