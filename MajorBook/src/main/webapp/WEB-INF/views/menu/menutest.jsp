<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
$(document).ready(function(){
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
			<li class="menus"><a href="/major/notice/">공지사항</a></li>
			<li class="menus"><a href="/major/board/1">게시판</a></li>
			<li class="menus"><a href="/major/question/">문의사항</a></li>
					</c:when>
					<c:when test="${currentmenu eq 'aboutus' }">
			<li class="menus"><a href="/major">HOME <span class="sr-only">(current)</span></a></li>
			<li class="activ menus"><a href="/major/aboutus/">ABOUT US</a></li>
			<li class="menus"><a href="/major/notice/">공지사항</a></li>
			<li class="menus"><a href="/major/board/1">게시판</a></li>
			<li class="menus"><a href="/major/question/">문의사항</a></li>
					</c:when>
					<c:when test="${currentmenu eq 'notice' }">
			<li class="menus"><a href="/major">HOME <span class="sr-only">(current)</span></a></li>
			<li class="menus"><a href="/major/aboutus/">ABOUT US</a></li>
			<li class="active menus"><a href="/major/notice/">공지사항</a></li>
			<li class="menus"><a href="/major/board/1">게시판</a></li>
			<li class="menus"><a href="/major/question/">문의사항</a></li>
					</c:when>
					<c:when test="${currentmenu eq 'board' }">
			<li class="menus"><a href="/major">HOME <span class="sr-only">(current)</span></a></li>
			<li class="menus"><a href="/major/aboutus/">ABOUT US</a></li>
			<li class="menus"><a href="/major/notice/">공지사항</a></li>
			<li class="active menus"><a href="/major/board/1">게시판</a></li>
			<li class="menus"><a href="/major/question/">문의사항</a></li>
					</c:when>
					<c:when test="${currentmenu eq 'question' }">
			<li class="menus"><a href="/major">HOME <span class="sr-only">(current)</span></a></li>
			<li class="menus"><a href="/major/aboutus/">ABOUT US</a></li>
			<li class="menus"><a href="/major/notice/">공지사항</a></li>
			<li class="menus"><a href="/major/board/1">게시판</a></li>
			<li class="active menus"><a href="/major/question/">문의사항</a></li>
					</c:when>
				</c:choose>
			
			
			
			<jsp:include page="../loginoutdel/login.jsp"></jsp:include>
			
		 </ul>
			      



</body>
</html>