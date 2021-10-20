/**
 * 내정보
 */

var tempList= new Array;

$(".list").each(function(index, item){
    tempList.push($(item).text());
});

$("#myPageMainList").css("color", "#94c477");
$("#myPageMainList").text("▶"+tempList[0]);

$(".list").on("click", function(){
    var value = $(this).text();
    var check = true;
    $.each($(".list"), function(index,item){
        check = true;
        if(value!=tempList[index]){

            if(value.includes($(item).text())){
                value = tempList[index];
            }else{
                $(item).text(tempList[index]);
                $(item).css("color", "#5d5d5d");
                check=false;
            }

        }
        if(check){
            $(item).css("color", "#94c477");
            $(item).text("▶" + value);
            if(value==tempList[2]){
                $(".payment").show();
                $(".member").hide();
            }else if(value==tempList[3]){
                $(".payment").hide();
                $(".member").show();
            }else{
                $(".payment").hide();
                $(".member").hide();
            }
        }
    });
});

$('li').on("click", function(){
    var value = $(this).text();

    if(value.includes("My Home")){
        $("#myHome").show();
        $(".imp-medium").not($("#myHome")).hide();
    }
    else if(value.includes("플로깅 예약 확인")){
        $("#checkPloggingMain").show();
        $(".imp-medium").not($("#checkPloggingMain")).hide();
    }
    else if(value.includes("내 상품")){
        $(".payment").not($(this)).css("color","#5d5d5d");
        $("#paymentMainList").css("color","#94c477");

        $("#paymentMain").show();
        $(".imp-medium").not($("#paymentMain")).hide();
    }
    else if(value=="- 찜 목록"){
        $(this).css("color","#94c477");
        $(".payment").not($(this)).css("color","#5d5d5d");

        $("#paymentDib").show();
        $(".imp-medium").not($("#paymentDib")).hide();
    }
    else if(value.includes("회원 정보")){
        $(".member").not($(this)).css("color","#5d5d5d");
        $("#memberMainList").css("color","#94c477");

        $("#updateInfo").show();
        $(".imp-medium").not($("#updateInfo")).hide();
    }
    else if(value=="- 회원 탈퇴"){
        $(this).css("color","#94c477");
        $(".member").not($(this)).css("color","#5d5d5d");

        $("#deleteInfo").show();
        $(".imp-medium").not($("#deleteInfo")).hide();
    }
    else if(value.includes("문의하기")){
        $("#question").show();
        $(".imp-medium").not($("#question")).hide();
    }
});

$('#selectBox').change(function() {
    var reason = $('#selectBox option:selected').val();
    if (reason=='etc') {
        $("#etcReason").show();
    } else {
        $("#etcReason").css("display", "none");
    }
});


$('#changePw').on("click", function(){
    if($('#newPw').css("display")=="none"){
        $(this).val("비밀번호 변경 취소");
        $('#newPw').show();
    }else{
        $(this).val("비밀번호 변경");
        $('#newPw').val("");
        $('#newPw').hide();
    }
});

$("#deleteMember").on("click", function(){
    var form = $("form[name=deleteForm]");

    if($('input[name=deleteMember_pw]').val()==""){
        alert("비밀번호를 입력해주세요.");
        return ;
    }

    if($("#selectBox option:selected").val()=="etc"){
        if($('input[name=etcReason]').val()==""){
            alert("탈퇴 사유를 작성해주세요.");
            return ;
        }
    }

    if($("#selectBox option:selected").val()=="deleteReason"){
        alert("탈퇴 사유를 선택해 주세요.");
        return ;
    }

    if(confirm("회원 탈퇴를 진행하겠습니까?")){
        alert("회원 탈퇴가 완료되었습니다.")
        form.submit();
    }else{
        alert("회원 탈퇴가 취소 되었습니다.")
        return;
    }
});

$(".listbtn").click(function() {
    alert("해당 페이지는 준비중에 있어요~ 다음시즌을 기대해 주세요^^");
    return false;
});