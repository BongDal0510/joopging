/**
 * 
 */
/*난수*/
/*function generateRandomCode() {
	  let str = ''
	  for (let i = 0; i < 6; i++) {
	    str += Math.floor(Math.random() * 10);
	  }
	  return str;

	}*/
// function keyCkeck(){
// 	/*$(document).ready(function() {
// 		$('#userLoginID').keypress(function (event) {
// 			if (event.which && (event.which <= 47 || event.which >= 58) && event.which != 8) {
// 				alert("입력 안됨 ㅅㄱ");
// 				event.preventDefault();
// 			}
// 		});
//
// 	});*/
// 	this.value=this.value.replace(/[^0-9]/g,'');
// }
function certifyId(){
	var form = document.findId;

	console.log(form.member_name.value);

	/*이름 유효성 검사*/
	if(!form.member_name.value){
		alert("이름을 입력해주세요.");
		return false;
	}
	/*생년월일 유효성 검사*/
	if(!form.member_birth.value){
		alert("생년월일을 입력해주세요.");
		return false;
	}

	let format = /^([0-9][0-9]|20\d{2})(0[0-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])$/;
	if(!format.test(document.getElementById("member_birth").value)){
		alert("옳바른 형식의 생년월일이 아닙니다.");
		return false;
	}

	/*성별 유효성 검사*/
	if(!form.member_gender.value){
		alert("주민번호 뒤 1자리를 입력해주세요.");
		return false;
	}
	/*휴대폰번호 유효성 검사*/
	if(!form.member_phone.value){
		alert("휴대폰 번호를 입력해주세요.");
		return false;
	}

	/* 생성한 난수와 이름 태그에 값 넣기
	var memberName = document.getElementById('member_name');
	document.getElementById('memberName').value = memberName.value;
	document.getElementById('randomNum').value = generateRandomCode();
	*/

	form.action = "/member/searchId";
	form.submit();
}