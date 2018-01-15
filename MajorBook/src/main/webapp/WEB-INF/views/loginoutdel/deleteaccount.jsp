<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
 <script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>

<script type="text/javascript">
$(document).ready(function(){
	//Kakao.init('920ab8edbd5f0f27b6f8c7df2c8d5532'); //연습
	
	Kakao.init('fe2b9e6e9dc19c730ad3d547e0772625');//전공
	
	Kakao.Auth.getStatus(function(statusObj){
		
		console.log(statusObj.status);
		console.log(statusObj.user);
		
		if(statusObj.status=="connected"){
			
			   Kakao.API.request({
 	        	  
	    	          url: '/v1/user/unlink',
	    	          
	    	          success: function(res) {
	    	        	  
						alert('해제됐다~');
						
						location.replace("/major"); //해제시 홈페이지로 돌아감
						
						},
						fail: function(err){
							alert('해제실패:'+JSON.stringify(err));
						},
						always : function(authObj, errorObj){
			    	        	
			    	 		Kakao.Auth.getStatus(function(statusObj){
			    	        		
			    	        console.log("상태는 "+statusObj.status+"상태");
			    	        console.log(statusObj.user+"유저");
			    	        		
			    	        });
			    	    }
			    	        
	});//Kakao.API.request  엔드
	

		}else{
			
			alert('커넥티드 상태 아님');
			location.replace("/major"); //탈퇴하고 싶으면 로그인부터 하라고 홈페이지로 돌아감
		}
		
		
	}); //Kakao.Auth.getStatus 엔드
});
</script>

</head>
<body>

이 페이지는 포스트 방식으로 들어와야 함



	<button id = "dounlink"> 연결 해제</button>
	
	

</body>
</html>