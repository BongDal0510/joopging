/**
 * 	회원가입
 */

/* 이용약관 팝업창 */
/* 별도의 연산 없을 예정, 디자인 수정 보류 */
function terms() {
	/* var url = "http://www.daum.net"; */
	var url = "/";
	var name = "terms";
	var option = "width=500, height=700, top=100, left=200, location=no";

	window.open(url, name, option);
}

$("#term").on("click", function(){
	if($(this).is(":checked")){
		//체크가 되어 있다면,
		$(".terms").prop("checked", true);
	}else{
		//체크되어 있지 않다면
		$(".terms").prop("checked", false);
	}
})


var check = false;

function formSubmit(){
	var form = document.joinForm;
	
	console.log(document.getElementById("member_age"))
	
	 var format = /^([0-9][0-9]|20\d{2})(0[0-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])$/;
	 if(!format.test(document.getElementById("member_age").value)){
		 alert("생년월일을 다시 입력해주세요.");
		 return;
	 }
	
	if(!form.member_id.value || !check){
		alert("아이디를 확인해주세요");
		return;
	}
	
	check = false;
	
	$.each($(".terms"), function(index, item){
		if(!$(item).is(":checked")){
			check = true;
		}
	});
	
	if(check){
		alert("이용약관 동의가 필요합니다.");
		return;
	}
	
	form.submit();
}

function checkId(id){
	check = false;
	
	if(id == ""){
		$("#idCheck_text").text("");
		return;
	}
	
	$.ajax({
		url:contextPath+"/member/MemberCheckIdOk.me?id=" + id,
		type:"get",
		dataType:"json",
		success:function(result){
			if(result.status == "ok"){
				//DOM
				$("#idCheck_text").text("사용 가능");
				$("#idCheck_text").css("color", "blue");
				check = true;
			}else{
				//DOM
				$("#idCheck_text").text("사용 불가");
				$("#idCheck_text").css("color", "red");
			}
		},
		error:function(){
			console.log("오류");
		}
	});
}

$("input[name='member_id']").keyup(function(){
	//중복 검사
	checkId($(this).val())
})











