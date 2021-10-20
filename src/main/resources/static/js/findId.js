/**
 * 
 */
function generateRandomCode() {
	  let str = ''
	  for (let i = 0; i < 6; i++) {
	    str += Math.floor(Math.random() * 10);
	  }
	  return str;

	}
function certifyId() {
	
	let form = document.findId;
	// console.log(form.member_name.value);
	
	if(!form.memberName.value){
		alert("이름을 입력해주세요.");
		return false;
	}
	if(!form.memberBirth.value){
		alert("생년월일 6자리를 입력해주세요.");
		return false;
	}
	if(!form.memberGender.value){
		alert("주민번호 뒤 1자리를 입력해주세요.");
		return false;
	}
	if(!form.memberPhone.value){
		alert("전화번호를 입력해주세요.");
		return false;
	}

	/*
	var memberName = document.getElementById('member_name');
	document.getElementById('memberName').value = memberName.value;
	document.getElementById('randomNum').value = generateRandomCode();
	*/
	
	// form = document.actionSubmit;
	form.submit();
}