<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>전공책을 찾아서</title>

    <link href="/book/resources/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
    	
    </style>
    <script src="/book/resources/js/jquery-1.12.4.min.js"></script>
    <script src="/book/resources/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row header">
			<div>
			<a href="#" ><img alt="logo" src="resources/img/book.png"></a>
			</div>
		</div>
	
	<!-- 상단 배너 메뉴 -->
	<nav class="navbar navbar-default">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button> 
	    </div>
				  <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			      <ul class="nav navbar-nav">
			        	<li><a href="/book">HOME </a></li>
			           	<li><a href="#">ABOUT US</a></li>
						<li><a href="#">공지사항</a></li>
			            <li  class="active"><a href="board">게시판<span class="sr-only">(current)</span></a></li>
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
			  <tr>
			  	<td>1</td>
			  	<td>살래요</td>
			  	<td><a href="#">test1</a></td>
			  	<td>test1</td>
			  	<td>2018-01-12</td>
			  	<td>1</td>
			  </tr>
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
		<div class="row footer">
		  <div class="col-md-12">
		 company2018
		  </div>
		</div>
	</div>
</body>
</html>