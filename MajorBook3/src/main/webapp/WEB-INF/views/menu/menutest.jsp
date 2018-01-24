<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
 	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	var tempid;
	var tempnick;
	//어느 문서에서든 menu.jsp는 login.jsp보다 먼저 include 되어야함
Kakao.init('fe2b9e6e9dc19c730ad3d547e0772625'); //전공책앱
	 
Kakao.Auth.getStatus(function(statusObj){

	//console.log("메뉴"+statusObj.status);
	//console.log("메뉴"+statusObj.user);
	
	 if(statusObj.status=="not_connected"){ //접속상태가 비로그인일때
		 
		 var currenturl = location.href;
		 var suburl = currenturl.split("/major/")[1];
	
		 
		 if(suburl != ""){ //main아닐때는 main으로
			 location.replace("/major");
		 }
		 
	 }
	 
});




});
</script>
</head>
<body>
	
			<c:choose>
					<c:when test="${currentmenu eq 'home' }">
			<li class="active menus"><a href="/major">HOME <span class="sr-only">(current)</span></a></li>
			<li class="menus"><a href="/major/aboutus/">ABOUT US</a></li>
			<li class="menus"><a href="/major/notice/page1">공지사항</a></li>
			<li class="menus"><a href="/major/board/page1">게시판</a></li>
			<li class="menus"><a href="/major/question/page1" class="checkright">문의사항</a></li>
					</c:when>
					<c:when test="${currentmenu eq 'aboutus' }">
			<li class="menus"><a href="/major">HOME <span class="sr-only">(current)</span></a></li>
			<li class="activ menus"><a href="/major/aboutus/">ABOUT US</a></li>
			<li class="menus"><a href="/major/notice/page1">공지사항</a></li>
			<li class="menus"><a href="/major/board/page1">게시판</a></li>
			<li class="menus"><a href="/major/question/page1"  class="checkright">문의사항</a></li>
					</c:when>
					<c:when test="${fn:startsWith(currentmenu,'notice') }">
			<li class="menus"><a href="/major">HOME <span class="sr-only">(current)</span></a></li>
			<li class="menus"><a href="/major/aboutus/">ABOUT US</a></li>
			<li class="active menus"><a href="/major/notice/page1">공지사항</a></li>
			<li class="menus"><a href="/major/board/page1">게시판</a></li>
			<li class="menus"><a href="/major/question/page1"  class="checkright">문의사항</a></li>
			
						
		<form class="navbar-form navbar-left" id="noticesearchform" method="get" action="/major/notice/noticesearch" >
             <input type="text" class="form-control" placeholder="search" name="noticesearchkeyword" id="noticesearchkeyword">
             <button type="submit"class="btn btn-default" >검색</button>
       </form>
			
					</c:when>
					<c:when test="${fn:startsWith(currentmenu,'board') }">
			<li class="menus"><a href="/major">HOME <span class="sr-only">(current)</span></a></li>
			<li class="menus"><a href="/major/aboutus/">ABOUT US</a></li>
			<li class="menus"><a href="/major/notice/page1">공지사항</a></li>
			<li class="active menus"><a href="/major/board/page1">게시판</a></li>
			<li class="menus"><a href="/major/question/page1"  class="checkright">문의사항</a></li>
			
		<form class="navbar-form navbar-left" id="bbssearchform" method="get" action="/major/board/bbssearch" >
             <input type="text" class="form-control" placeholder="search" name="bbssearchkeyword" id="bbssearchkeyword">
             <button type="submit"class="btn btn-default" >검색</button>
       </form>
					</c:when>
					<c:when test="${fn:startsWith(currentmenu,'question') }">
			<li class="menus"><a href="/major">HOME <span class="sr-only">(current)</span></a></li>
			<li class="menus"><a href="/major/aboutus/">ABOUT US</a></li>
			<li class="menus"><a href="/major/notice/page1">공지사항</a></li>
			<li class="menus"><a href="/major/board/page1">게시판</a></li>
			<li class="active menus"><a href="/major/question/page1"  class="checkright">문의사항</a></li>
			
						
		<form class="navbar-form navbar-left" id="qnasearchform" method="get" action="/major/question/qnasearch" >
             <input type="text" class="form-control" placeholder="search" name="qnasearchkeyword" id="qnasearchkeyword">
             <button type="submit"class="btn btn-default" >검색</button>
       </form>
					</c:when>
				</c:choose>
			
			
			
			<jsp:include page="../loginoutdel/login.jsp"></jsp:include>
			
		 </ul>
		 
		</div>
	  </div>
	</nav>      


</body>


<!-- <script type="text/javascript">

$(document).on('click', 'a[class="checkright"]', function(e){
	
	//로그인시 관리자인지 아닌지 먼저 체크한 후에 카테고리부터 분기점 나누기....
	e.preventDefault();
	alert(tempnick+tempid);
	
	var toqna=document.createElement("form");
	toqna.setAttribute("method","post");
	toqna.setAttribute("action", "/major/question/");
	
	var checkid = document.createElement("input");
	checkid.setAttribute("type","hidden");
	checkid.setAttribute("name","checkid");
	checkid.setAttribute("value",tempid);
	toqna.appendChild(checkid);
	
	document.body.appendChild(toqna);
	toqna.submit();
	
});
</script> -->
</html>