<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>


  <script>
	
	var putcmtinf = function(){
	
	 var cmtnick=document.createElement("input");
	 cmtnick.setAttribute("type","hidden");
	 cmtnick.setAttribute("name","comment_nick");
	 cmtnick.setAttribute("value",tempnick);
	 
	 var cmtid=document.createElement("input");
	 cmtid.setAttribute("type","hidden");
	 cmtid.setAttribute("name","comment_id");
	 cmtid.setAttribute("value",tempid);
	 
	 var cform = document.getElementById('commentform');
		cform.appendChild(cmtnick);
		cform.appendChild(cmtid);
	};
 </script>


<c:forEach items="${cmtlist }" var="cmtbean">
	<div class="list-group">
	    <h4 class="list-group-item-heading">${cmtbean.comment_num } :        ${cmtbean.comment_nick }(${cmtbean.comment_id })             ____${cmtbean.comment_date}</h4>
	    <p class="list-group-item-text">${cmtbean.comment_content }</p>
	</div>
 </c:forEach>
 

	<form action="writecomment" method="post" id="commentform" onsubmit="putcmtinf()">
		<input type="hidden" name="comment_board" value="${bean.no }">
		
		<div class="col-md-12">
			<div class="form-group"> 
			
			<label for="comment_content">코멘트 내용</label> 
			<textarea class="form-control" rows="4" name="comment_content" id="comment_content"></textarea>  
			<button class="btn btn-default col-md-12" type="submit">코멘트 등록</button> 
			</div>
		</div>
		
	</form>
	
</html>