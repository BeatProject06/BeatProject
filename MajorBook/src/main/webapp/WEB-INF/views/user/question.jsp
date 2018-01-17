<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/views/menu/header.jsp"></jsp:include>
<!--메뉴별로 active들어가서 header에는 포함시키지 못함.  -->
<li><a href="/major">HOME </a></li>
<li><a href="aboutus">ABOUT US</a></li>
<li><a href="notice">공지사항</a></li>
<li><a href="board">게시판<span class="sr-only">(current)</span></a></li>
<li class="active"><a href="question">문의사항</a></li>
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
					문의사항 <small>설명</small>
				</h1>
				<table class="table table-hover">
					<tr>
						<th class="col-md-1">번호</th>
						<th class="col-md-2">상태</th>
						<th class="col-md-4">제목</th>
						<th class="col-md-2">글쓴이</th>
						<th class="col-md-2">작성일</th>
						<th class="col-md-1">조회수</th>
					</tr>
					<%--  <c:forEach items="${list }" var="bean" varStatus="status">
			  <tr>
			  	<td>${bean.no }</td>
			  	<td>${bean.status }</td>
			  	<td><a href="#">${bean.dept }</a></td>
			  	<td>${bean.nickname }</td>
			  	<td>${bean.작성일 }</td>
			  	<td>${bean.view }</td>
			  </tr>
			  </c:forEach> --%>
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
						<li><a href="#" aria-label="Next"> <span
								aria-hidden="true">&raquo;</span>
						</a></li>
					</ul>
				</div>
			</div>

			<jsp:include page="/WEB-INF/views/menu/footer.jsp"></jsp:include>