/**
 * 내정보
 */


var tempList= new Array;

$(".list").each(function(index, item){
    tempList.push($(item).text());
});

$("#myPageMainList").css("color", "#94c477");

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
            if(value==tempList[3]){
                $(".payment").show();
                $(".hiddenList").not($(".payment")).hide();
            }else if(value==tempList[4]){
                $(".member").show();
                $(".hiddenList").not($(".member")).hide();
            }
            else{
                $(".hiddenList").hide();
            }
        }
    });
});

$('li').on("click", function(){
    let value = $(this).text();

    /*메인페이지로 이동하기*/
    if(value.includes("My Home")){
        location.href="mypage/mypageMain"
    }
    /*플로깅 내역*/
    else if(value.includes("플로깅 예약 확인")){
        location.href="mypage/mypageMain"
        $("#checkPloggingMain").show();
        $(".imp-medium").not($("#checkPloggingMain")).hide();
    }
    /*포인트 내역*/
    else if(value.includes("포인트 내역")){
        location.href="mypage/mypageMain"
        $("#checkPoint").show();
        $(".imp-medium").not($("#checkPoint")).hide();
    }
    /*내 상품*/
    else if(value.includes("내 상품")){
        location.href="mypage/mypageMain"
        $(".payment").not($(this)).css("color","#5d5d5d");
        $("#paymentMainList").css("color","#94c477");

        $("#paymentMain").show();
        $(".imp-medium").not($("#paymentMain")).hide();
    }
    /*찜 목록*/
    else if(value=="- 찜 목록"){
        location.href="mypage/mypageMain"
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
    /*게시글*/
    else if(value.includes("게시글")){
        location.href="mypage/mypageMain"
        $("#myWriting").show();
        $(".imp-medium").not($("#myWriting")).hide();
    }
    /*문의하기*/
    else if(value.includes("문의하기")){
        $("#question").show();
        $(".imp-medium").not($("#question")).hide();
    }
});

$('#selectBox').change(function() {
    let reason = $('#selectBox option:selected').val();
    if (reason=='etc') {
        $("#etcReason").show();
    } else {
        $("#etcReason").css("display", "none");
    }
});


$("#deleteMember").on("click", function(){
    let form = $("form[name=deleteForm]");

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
        /*에이젝스로 결과 가져오기*/
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