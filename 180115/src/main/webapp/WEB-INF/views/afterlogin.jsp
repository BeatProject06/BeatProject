<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
 <script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>

<script>
//logoutdel>logout으로 대체 

$(document).ready(function(){


//Kakao.init('920ab8edbd5f0f27b6f8c7df2c8d5532');
Kakao.init('fe2b9e6e9dc19c730ad3d547e0772625'); //전공책앱
 
console.log('access token?'+ Kakao.Auth.getAccessToken());
console.log('refresh token?'+ Kakao.Auth.getRefreshToken());


Kakao.Auth.getStatus(function(statusObj){
		
		console.log(statusObj.status);
		console.log(statusObj.user);
	
	});
	
	
  $('#outbtn').on('click', function(){
	
		Kakao.Auth.logout(
				function(){
					
				alert('로그아웃됨');

					Kakao.Auth.getStatus(function(statusObj){
							
							console.log("로갓 상태"+statusObj.status);
							console.log("로갓 아이디"+statusObj.user);
						
						});
					
					location.replace("/major");
					
				});
	
});  

/* document.getElementById("demo").addEventListener("click",  function(){
	alert('클릭');
	
});  */





});

</script>
</head>
<body>

<h1>after login</h1>


<button id="outbtn">로그아웃하기</button>
<form action="../unlinkapp" method="post">
	<button type="submit">연결해제 페이지 버튼</button>
<p>근데 이걸...폼을 써야 하나....전송할 데이터도 없는데 포스트로 보내려고...?</p>
</form>

</body>
</html>