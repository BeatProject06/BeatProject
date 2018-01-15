<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>전공책을 찾아서</title>

    <link href="resources/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
    	
    </style>
    <script src="resources/js/jquery-1.12.4.min.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
    <script src="resources/js/kakao.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row header">
			<div>
			<a href="#" ><img alt="logo" src="resources/img/book.png"></a>
			</div>
		</div>
	
	<!-- 상단 배너 메뉴 -->
	<nav class="navbar navbar-default">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button> 
	    </div>
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			      <ul class="nav navbar-nav">
			        <li class="active"><a href="/book">HOME <span class="sr-only">(current)</span></a></li>
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
			  <script>
      Kakao.init('fe2b9e6e9dc19c730ad3d547e0772625');
      
      // 카카오 로그인 버튼을 생성합니다.
      Kakao.Auth.createLoginButton({
        container: '#kakao-login-btn',
        size: 'small',
        success: function(authObj) {
          
          // 로그인 성공시 API를 호출합니다.
          Kakao.API.request({
             
          url: '/v1/user/me',
          success: function(res) {
            var sData = JSON.stringify(res);
            //alert(sData);
            
            sData = JSON.parse(sData);
            var route = "kakao"
            var id = sData.id+"@"+route;             
            var nickname = sData.properties.nickname;
            var thumbnail_image = sData.properties.thumbnail_image;
            var profile_image = sData.properties.profile_image;
           
     
            var f = document.createElement("form");
          /*   f.setAttribute("method","get");
            f.setAttribute("action","afterlogin/"+i_id);
            f.setAttribute("target","_self");
            document.body.appendChild(f); */
            
            var i_id=document.createElement("input");
            i_id.setAttribute("type","hidden");
            i_id.setAttribute("name","kakao_id");
            i_id.setAttribute("value",id);
           // f.appendChild(i_id);
            
            var i_nick=document.createElement("input");
            i_nick.setAttribute("type","hidden");
            i_nick.setAttribute("name","kakao_nick");
            i_nick.setAttribute("value",nickname);
           // f.appendChild(i_nick);
            
            var i_thum=document.createElement("input");
            i_thum.setAttribute("type","hidden");
            i_thum.setAttribute("name","kakao_thumbnail_image");
            i_thum.setAttribute("value",thumbnail_image);
           // f.appendChild(i_thum);
            
            var i_profile=document.createElement("input");
            i_profile.setAttribute("type","hidden");
            i_profile.setAttribute("name","kakao_profile_image");
            i_profile.setAttribute("value",profile_image);
           // f.appendChild(i_profile);
            
            var i_accessToken=document.createElement("input");
            i_accessToken.setAttribute("type","hidden");
            i_accessToken.setAttribute("name","accessToken");
            i_accessToken.setAttribute("value",accessToken);
            //f.appendChild(i_accessToken);
            
            var i_refreshToken=document.createElement("input");
            i_refreshToken.setAttribute("type","hidden");
            i_refreshToken.setAttribute("name","refreshToken");
            i_refreshToken.setAttribute("value",refreshToken);
           // f.appendChild(i_refreshToken);
            
            
            f.setAttribute("method","post");
            f.setAttribute("action","afterlogin/"+i_id.value);
            f.setAttribute("target","_self");
            document.body.appendChild(f);
            
            f.appendChild(i_id);
            f.appendChild(i_nick);
            f.appendChild(i_thum);
            f.appendChild(i_profile);
            f.appendChild(i_accessToken);
            f.appendChild(i_refreshToken);
            
            
            f.submit();
          },   fail : function(error){
            console.log(JSON.stringify('api req fail'+error));
         }
          
          });
      var accessToken = Kakao.Auth.getAccessToken();
      var refreshToken = Kakao.Auth.getRefreshToken();
   
          //document.writeln("액세스 토큰 : "+accessToken);
          //document.writeln("<br>");
          //document.writeln("리프레시 토큰 : "+refreshToken);
          //document.writeln("<br>");
          
        },
        
        fail: function(err) {
            console.log('oauth fail'+JSON.stringify(err));
        }
      });
    
    </script>
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
		<div class="row footer">
		  <div class="col-md-12">
		 company2018
		  </div>
		</div>
	</div>
</body>
</html>