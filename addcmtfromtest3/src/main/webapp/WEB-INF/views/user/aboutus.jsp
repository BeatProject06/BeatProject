<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../menu/header.jsp"></jsp:include>
    <!--메뉴별로 active들어가서 header에는 포함시키지 못함.  -->
			        	<li id="home"><a href="/major">HOME </a></li>
			           	<li id="aboutus" class="/major/active/"><a href="aboutus">ABOUT US</a></li>
						<li id="notice"><a href="/major/notice/">공지사항</a></li>
			            <li id="board"><a href="/major/board/">게시판<span class="sr-only">(current)</span></a></li>
			            <li id="question"><a href="/major/question/">문의사항</a></li>
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
			  <h1>ABOUT US</h1>
			  <p></p>
			</div>
		  
	

<jsp:include page="../menu/footer.jsp"></jsp:include>