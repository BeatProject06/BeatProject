<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../menu/header.jsp"></jsp:include>
<script src=" ${pageContext.request.contextPath}/resources/js/jquery-1.12.4.min.js"></script>

<script type="text/javascript">
	Kakao.init('fe2b9e6e9dc19c730ad3d547e0772625');//전공
	
	Kakao.Auth.getStatus(function(statusObj){
	//	console.log(tempid);
		
		console.log(statusObj.status);
		console.log(statusObj.user);
		
		if(statusObj.status=="connected"){
			
			   Kakao.API.request({
 	        	  
	    	          url: '/v1/user/unlink',
	    	          
	    	          success: function(res) {
	    	        	  
						alert(statusObj.user.id);
						
						  var deleteid=document.createElement("input");
						  deleteid.setAttribute("type","hidden");
						  deleteid.setAttribute("name","delid");
						  deleteid.setAttribute("value", statusObj.user.id);
		    	          document.getElementById('accountdeleteform').appendChild(deleteid);
						alert("성공");
						
						//location.replace("/major"); //해제시 홈페이지로 돌아감
						
						},
						fail: function(err){
							alert('해제실패:'+JSON.stringify(err));
						},
						always : function(authObj, errorObj){
			    	        	
			    	 		Kakao.Auth.getStatus(function(statusObj){
			    	        		
			    	        console.log("상태는 "+statusObj.status+"상태");
			    	        console.log(statusObj.user+"유저");
							alert("항상...뭐니????");
			    	        
			    	        
			    	        		
			    	        });
			    	    }
			    	        
	});//Kakao.API.request  엔드
	

		}else{
			
			alert('커넥티드 상태 아님');
			//location.replace("/major"); //탈퇴하고 싶으면 로그인부터 하라고 홈페이지로 돌아감
		}
		
		
	}); //Kakao.Auth.getStatus 엔드

</script>

			        	<li><a href="/major">HOME </a></li>
			           	<li><a href="/major/aboutus">ABOUT US</a></li>
						<li><a href="/major/notice">공지사항</a></li>
			            <li  class="active"><a href="/major/board/1">게시판<span class="sr-only">(current)</span></a></li>
			            <li><a href="/major/question">문의사항</a></li>
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
			  <h1>회원탈퇴</h1>
			</div>
			  <p>카카오와 연결이 끊겼습니다.<br/><br/>
			  	개인정보가 해당서비스에서 삭제됩니다.<br/><br/>
			  	"전공책을 찾아서" 서비스에 남아있는 삭제를 위해 회원탈퇴를 클릭해주세요
			  </p>
			  <br/><br/>
			 <form  action="/major/userdelete" method="post" id="accountdeleteform">
			  		<input name="_method" value="DELETE" type="hidden">
					<button class="btn btn-danger" id="accountdeletebtn">회원탈퇴</button>
			</form>
			
			

<jsp:include page="../menu/footer.jsp"></jsp:include>