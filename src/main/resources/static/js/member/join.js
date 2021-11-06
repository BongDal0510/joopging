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

var check = false;
function checkId(){
	var id = $('#memberId').val();

	if(id == ""){
		$("#idCheck_text").text("");
		return;
	}
	$.ajax({
		url:'/member/checkId/',
		type:'post',
		data:{id:id},
		success:function(result){ //컨트롤러에서 넘어온 cnt값을 받는다
			if(result != 1){ //cnt가 1이 아니면(=0일 경우) -> 사용 가능한 아이디
				// console.log("성공");
				$("#idCheck_text").val("사용 가능");
				$("#idCheck_text").css("color", "blue");
				check=true;
			} else { // cnt가 1일 경우 -> 이미 존재하는 아이디
				// console.log("실패");
				$("#idCheck_text").val("사용 불가");
				$("#idCheck_text").css("color", "red");
				check=false;
			}
		},
		error:function(){
			console.log("오류");
		}
	});
}

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
	if(!form.memberEmail.value){
		alert("이메일을 입력해주세요.");
		return;
	}

	/*이메일 사이트*/
	if(!form.memberEmailSite.value == "선택 안함"){
		alert("이메일을 입력해주세요.");
		return;
	}

	// console.log(form.memberEmailSite.value);

	/*우편번호*/
	if(!form.memberZipcode.value){
		alert("주소를 선택해주세요.");
		return;
	}

	// console.log(form.memberZipcode.value);
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

	var chk1 = document.joinForm.term.checked;
	// console.log(chk1);

	if(!chk1){
		alert("이용약관 동의가 필요합니다.");
		return;
	}

	if(!check){
		alert("아이디를 다시 입력하세요.")
		return;
	}

	alert("줍깅 가입 기념 3000 포인트 지급! 로그인 후 이용해주세요 ^^");
	form.submit();
}










