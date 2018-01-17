<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
    	
    </style>
    <script src="${pageContext.request.contextPath}/resources/js/jquery-1.12.4.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/kakao.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row header">
			<div class="col-md-2">
			<a href="/major" ><img alt="logo" src="${pageContext.request.contextPath}/resources/img/book.png"></a>
			</div>
			<div class="col-md-10 text-center">
			<h1>전공책을 찾아서</h1>
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