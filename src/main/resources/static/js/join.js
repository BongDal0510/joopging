/**
 * 	회원가입
 */

/* 이용약관 팝업창 */
/* 별도의 연산 없을 예정, 디자인 수정 보류 */
function terms() {
	/* var url = "http://www.daum.net"; */
	var url = "terms";
	var name = "GET";
	var option = "width=500, height=700, top=100, left=200, location=no";

	window.open(url, name, option);
}


//이전 게시판 예제에서 사용한 체크박스 두개 동시에 체크하는 알고리즘
/*$("#term").on("click", function(){
	if($(this).is(":checked")){
		//체크가 되어 있다면,
		$(".terms").prop("checked", true);
	}else{
		//체크되어 있지 않다면
		$(".terms").prop("checked", false);
	}
})*/


// var check = false;


function formSubmit(){
	let form = document.joinForm;

	/*아이디*/
	if(!form.memberId.value){
		alert("아이디를 입력해주세요.");
		return;
	}
	/*비밀번호*/
	if(!form.memberPw.value){
		alert("비밀번호를 입력해주세요.");
		return;
	}
	/*전화번호*/
	if(!form.memberPhone.value){
		alert("전화번호를 입력해주세요.");
		return;
	}
	/*이름*/
	if(!form.memberName.value){
		alert("이름을 입력해주세요.");
		return;
	}
	/*주민번호 앞 6자리 (생일)*/
	if(!form.memberBirth.value){
		alert("주민번호 앞 6자리를 입력해주세요.");
		return;
	}

	/*생년월일*/
	var format = /^([0-9][0-9]|20\d{2})(0[0-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])$/;
	if(!format.test(document.getElementById("memberBirth").value)){
		alert("옳바르지 않은 주민번호 형식입니다.");
		return;
	}

	/*주민번호 뒤 1자리 (성별)*/
	if(!form.memberGender.value){
		alert("주민번호 뒤 1자리를 입력해주세요.");
		return;
	}

	/*이메일 아이디*/
	if(!form.memberEmailId.value){
		alert("이메일을 입력해주세요.");
		return;
	}

	/*이메일 사이트*/
	if(!form.memberEmailSite.value == "선택 안함"){
		alert("이메일을 입력해주세요.");
		return;
	}

	console.log(form.memberEmailSite.value);

	/*우편번호*/
	if(!form.memberZipcode.value){
		alert("주소를 선택해주세요.");
		return;
	}

	console.log(form.memberZipcode.value);
	// /*주소 : 우편번호를 입력하면 자동입력이기 때문에 형식적인 유효성 검사*/
	// if(!form.memberAddress.value){
	// 	alert("주소을 입력해주세요.");
	// 	return;
	// }
	/*상세주소 : 나머지주소*/
	if(!form.memberAddressDetail.value){
		alert("상세주소를 입력해주세요.");
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

	alert("줍깅에 오신 것을 환영합니다! 로그인 후 이용해주세요 ^^");
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











