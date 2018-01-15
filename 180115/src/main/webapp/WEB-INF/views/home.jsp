<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/menu/header.jsp" %>
<!--메뉴별로 active들어가서 header에는 포함시키지 못함.  -->
			        <li class="active"><a href="/major">HOME <span class="sr-only">(current)</span></a></li>
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
			  <script src="resources/js/kakaologin.js"></script>
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
	<%@ include file="/WEB-INF/views/menu/footer.jsp" %>	