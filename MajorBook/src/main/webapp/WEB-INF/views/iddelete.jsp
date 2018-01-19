<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	Kakao.init('fe2b9e6e9dc19c730ad3d547e0772625');//전공
	
	Kakao.Auth.getStatus(function(statusObj){
		
		console.log(statusObj.status);
		console.log(statusObj.user);
		
	       // 로그인 성공시 API를 호출합니다.
	       Kakao.API.request({
	        	  
	          url: '/v1/user/me',
	          
	          success: function(res) {
	            var sData = JSON.stringify(res);
	            
	            sData = JSON.parse(sData);
	            
	            console.log(JSON.stringify(sData));
	            
	            var id = sData.id;     

	            var f = document.createElement("form");
	            
	            var i_id=document.createElement("input");
	            i_id.setAttribute("type","hidden");
	            i_id.setAttribute("name","kakao_id");
	            i_id.setAttribute("value",id);

	            document.body.appendChild(f);
	            
	            f.appendChild(i_id);

	       
	          },	
	          fail : function(error){
	      		console.log('api req fail'+JSON.stringify(error));
	      	  }	
	          
	      }); //Kakao.API.request end
		
		
	}); //Kakao.Auth.getStatus 엔드
});
</script>
</head>
<body>
	<form action="iddelete" method="post">
		<input name="_method" value="DELETE" type="hidden">
		<button>id삭제</button>
	</form>
</body>
</html>