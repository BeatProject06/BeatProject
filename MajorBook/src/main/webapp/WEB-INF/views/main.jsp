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
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
    	
    </style>
    <script src="resources/js/jquery-1.12.4.min.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
    <script src="resources/js/kakao.min.js"></script>
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
			        <li class="active"><a href="/book">HOME <span class="sr-only">(current)</span></a></li>
			           	<li><a href="#">ABOUT US</a></li>
						<li><a href="#">공지사항</a></li>
			            <li><a href="board">게시판</a></li>
			            <li><a href="#">문의사항</a></li>
			      </ul>
			      <form class="navbar-form navbar-left">
			          <input type="text" class="form-control" placeholder="search">
			        <button type="submit" class="btn btn-default">검색</button>
			        </form>
			        <div>
			        <a id="kakao-login-btn" class="pull-right"></a>
			        </div>


<jsp:include page="loginoutdel/login.jsp"></jsp:include>


		</div>
	  </div>
	</nav>
	</div>
	<!-- 내용 -->	
	<div class="container">
		<div class="row content">
		  <div class="col-md-12">
		  	<div class="jumbotron">
			  <h1>전공책을 찾아서</h1>
			  <p>설명</p>
			  
			  
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