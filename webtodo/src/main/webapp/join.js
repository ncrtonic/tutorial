var status = true;
function idchk() {
	var query = {"userid":$("#userid").val(), "pass": 1};
	
	if($("#userid").val() != ""){
	$.ajax({
		type:"post",
		url:"http://localhost:8088/webtodo/join",
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