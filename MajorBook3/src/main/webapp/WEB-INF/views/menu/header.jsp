<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
    <link href=" ${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
	.navbar{
		background-color:orange;
		
	}
	
	.navbar-default .navbar-nav>li>a {
    	color: #fff;
	}
	.navbar-default .navbar-brand {
    	color: #fff;
	}
	 .navbar-default .navbar-nav>.active>a, .navbar-default .navbar-nav>.active>a:focus, .navbar-default .navbar-nav>.active>a:hover{
		color: #fff;
    	background-color: yellow;
	}
	#logotext h1{
		margin-top: 30px;
		
	}
	
	.navbar .navbar-collapse {
		  text-align: center;
		}
		
	
	@media (max-width : 767px){
		.container .header {
			display : none;
			visibility: hidden;
		}
	}
	
	
</style>

    <script src=" ${pageContext.request.contextPath}/resources/js/jquery-1.12.4.min.js"></script>
    <script src=" ${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    <script src=" ${pageContext.request.contextPath}/resources/js/kakao.min.js"></script>
</head>
<body>
	<div class="container header">
		<div class="row header">
			<div class="col-md-2 pull-left">
			<a href="/major" ><img alt="logo" src=" ${pageContext.request.contextPath}/resources/img/book.png"></a>
			</div>
			<div class="col-md-10 text-center" id="logotext">
			<h1><strong>전공책을 찾아서</strong></h1>
			</div>
		</div><!-- row header end -->
	</div>
	<!-- 상단 배너 메뉴 -->
	<nav class="navbar navbar-default">
	
	<div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="/major">전공책을 찾아서</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
          