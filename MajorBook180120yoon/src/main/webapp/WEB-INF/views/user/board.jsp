<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<jsp:include page="../menu/header.jsp"></jsp:include>
    <!--메뉴별로 active들어가서 header에는 포함시키지 못함.  -->
			        	<li><a href="/major">HOME </a></li>
			           	<li><a href="../aboutus/">ABOUT US</a></li>
						<li><a href="../notice/">공지사항</a></li>
			            <li class="active"><a href="../board/1">게시판<span class="sr-only">(current)</span></a></li>
			            <li><a href="../question/">문의사항</a></li>
			      </ul>
			        <form class="navbar-form navbar-left" id="bbssearchform" method="get" action="bbssearch" >
			          <input type="text" class="form-control" placeholder="search" name="bbssearchkeyword" id="bbssearchkeyword">
			          <button type="submit"class="btn btn-default" >검색</button>
			        </form>
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
		<c:forEach items="${list }" var="bean">
			  <tr>
			  	<td>${bean.no }</td>
			  	<td>${bean.status }</td>
			  	<td><a href="detail/${bean.no }">${bean.title }</a></td>
			  	<td>${bean.nickName }</td>
			  	<td>${bean.day }</td>
			  	<td>${bean.view }</td>
			  </tr>
			  </c:forEach>
			</table>
			<a class="btn btn-default pull-right" href="write" role="button">글쓰기</a>
			<div class="text-center">
				  <ul class="pagination">
				  <li><a href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                  </a>
                
					
				<!--게시글 10개 페이지 5개씩 동적 처리 -->
		
						<c:forEach var="paging" begin="${startpage }" end="${endpage}" step="1"  >
							<c:choose>
							<c:when test="${currentpage eq paging }">
								<li class="active"> <a href="<c:out value='${ paging }' />"> <c:out value="${ paging }" />	</a></li>
							</c:when>
							<c:otherwise>
								<li> <a href="<c:out value='${ paging }' />"> <c:out value="${ paging }" />	</a></li>
							</c:otherwise>
						</c:choose>
						
						
						</c:forEach>
				
				
				
				    <li>
				      <a href="#" aria-label="Next">
				        <span aria-hidden="true">&raquo;</span>
				      </a>
				    </li>
				  </ul>
				</div>
		<jsp:include page="../menu/footer.jsp"></jsp:include>