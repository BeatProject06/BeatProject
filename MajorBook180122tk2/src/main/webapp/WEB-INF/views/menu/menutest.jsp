<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
$(document).ready(function(){
	//��� ���������� menu.jsp�� login.jsp���� ���� include �Ǿ����
Kakao.init('fe2b9e6e9dc19c730ad3d547e0772625'); //����å��
	 
Kakao.Auth.getStatus(function(statusObj){

	//console.log("�޴�"+statusObj.status);
	//console.log("�޴�"+statusObj.user);
	
	 if(statusObj.status=="not_connected"){ //���ӻ��°� ��α����϶�
		 
		 var currenturl = location.href;
		 var suburl = currenturl.split("/major/")[1];
	
		 
		 if(suburl != ""){ //main�ƴҶ��� main����
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
			<li class="menus"><a href="/major/notice/">��������</a></li>
			<li class="menus"><a href="/major/board/1">�Խ���</a></li>
			<li class="menus"><a href="/major/question/">���ǻ���</a></li>
					</c:when>
					<c:when test="${currentmenu eq 'aboutus' }">
			<li class="menus"><a href="/major">HOME <span class="sr-only">(current)</span></a></li>
			<li class="activ menus"><a href="/major/aboutus/">ABOUT US</a></li>
			<li class="menus"><a href="/major/notice/">��������</a></li>
			<li class="menus"><a href="/major/board/1">�Խ���</a></li>
			<li class="menus"><a href="/major/question/">���ǻ���</a></li>
					</c:when>
					<c:when test="${currentmenu eq 'notice' }">
			<li class="menus"><a href="/major">HOME <span class="sr-only">(current)</span></a></li>
			<li class="menus"><a href="/major/aboutus/">ABOUT US</a></li>
			<li class="active menus"><a href="/major/notice/">��������</a></li>
			<li class="menus"><a href="/major/board/1">�Խ���</a></li>
			<li class="menus"><a href="/major/question/">���ǻ���</a></li>
					</c:when>
					<c:when test="${currentmenu eq 'board' }">
			<li class="menus"><a href="/major">HOME <span class="sr-only">(current)</span></a></li>
			<li class="menus"><a href="/major/aboutus/">ABOUT US</a></li>
			<li class="menus"><a href="/major/notice/">��������</a></li>
			<li class="active menus"><a href="/major/board/1">�Խ���</a></li>
			<li class="menus"><a href="/major/question/">���ǻ���</a></li>
					</c:when>
					<c:when test="${currentmenu eq 'question' }">
			<li class="menus"><a href="/major">HOME <span class="sr-only">(current)</span></a></li>
			<li class="menus"><a href="/major/aboutus/">ABOUT US</a></li>
			<li class="menus"><a href="/major/notice/">��������</a></li>
			<li class="menus"><a href="/major/board/1">�Խ���</a></li>
			<li class="active menus"><a href="/major/question/">���ǻ���</a></li>
					</c:when>
				</c:choose>
			
			
			
			<jsp:include page="../loginoutdel/login.jsp"></jsp:include>
			
		 </ul>
			      



</body>
</html>