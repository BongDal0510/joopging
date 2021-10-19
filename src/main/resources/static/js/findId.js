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
function certifyId(){
	
	var form = document.findName;
	console.log(form.member_name.value);
	
	if(!form.member_name.value){
		alert("이름을 입력해주세요.");
		return false;
	}
	
	
	 
	var memberName = document.getElementById('member_name');
	document.getElementById('memberName').value = memberName.value;
	document.getElementById('randomNum').value = generateRandomCode();
	
	form = document.actionSubmit;
	form.submit();
}