<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>회원가입</title>
<script src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
<script>
var status = true;
function idchk() {
	var query = {"userid":$("#userid").val(), "pass": "1"};
	
	if($("#userid").val() != ""){
	$.ajax({
		type:"post",
		url:"http://192.168.0.174:8080/webtodo/join",
		//정확히는 컨텍스트 패스를 구해야한다.
		data: query,
		success:function(data){
			if(data == 1){
				$("span").css("color", "red");
				$("span").text("사용불가");
			}else if (data == -1){
				$("span").css("color", "green");
				$("span").text("사용가능");
			}
		}
	})
	} else {
		$("span").text("");
	}
};

$(document).ready(function(){
	//버튼클릭 중복체크 구문
		/*
	$("#idchk").click(function() {
		if($("#id").val() != ""){
			var query = {"userid":$("#userid").val(), "pass": 1};
			
			$.ajax({
				type:"post",
				url:"http://localhost:8088/webtodo/join",
				//정확히는 컨텍스트 패스를 구해야한다.
				data: query,
				success:function(data){
					if(data == 1){
						alert("사용하실 수 없습니다.")
						$("#userid").val("");
					}else if (data == -1){
						alert("사용 가능한 아이디 입니다.")
					}
				}
					
			});
		}else {
			alert("아이디를 입력하세요.");
			$("#id").focus();
		}
	});
	*/

	
	function checkIt() {
		status = true;
		
	    if(!$("#id").val()) {
	        alert("아이디를 입력하세요");
	        $("#id").focus();
	        status = false;
	        return false;
	    }
	    
	    if(!$("#pass").val()) {
	        alert("비밀번호를 입력하세요");
	        $("#pass").focus();
	        status = false;
	        return false;
	    }
	    
	    if(!$("#name").val()) {
	        alert("사용자 이름을 입력하세요");
	        $("#name").focus();
	        status = false;
	        return false;
	    }
	    
	    if(!$("#email").val()) {
	        alert("이메일을 입력하세요");
	        $("#email").focus();
	        status = false;
	        return false;
	    }
	    
	}
});

</script>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp" flush="false"/>
	<form action="${pageContext.request.contextPath }/join" method="post">
	아이디:<input type="text" id="userid" name="userid" oninput="idchk()"> <span></span><br>
	<!-- <input type="button" id="idchk" value="중복체크"><br>-->
	비밀번호:<input type="password" id="pw" name="pw"><br>
	이름:<input type="text" id="name" name="name"><br>
	이메일:<input type="email" id="email" name="email"><br>
	 <input type="submit" value="가입"> 
	 <!-- 인풋타입 버튼으로바꾸고 submit 스크립트 따로만들어서 아이디 중복체크관련 판별 추가요망 -->
	<!--<button id="join" onclick="submit()">가입</button>-->
	<button type="reset">다시쓰기</button>
	</form>
	<div style="color: red">${error}</div>
</body>
</html>