/**
 * 내정보
 */


var tempList = new Array;

$(".list").each(function (index, item) {
    tempList.push($(item).text());
});

$("#myPageMainList").css("color", "#94c477");

$(".list").on("click", function () {
    var value = $(this).text();
    var check = true;
    $.each($(".list"), function (index, item) {
        check = true;
        if (value != tempList[index]) {

            if (value.includes($(item).text())) {
                value = tempList[index];
            } else {
                $(item).text(tempList[index]);
                $(item).css("color", "#5d5d5d");
                check = false;
            }

        }
        if (check) {
            $(item).css("color", "#94c477");
            if (value == tempList[3]) {
                $(".payment").show();
                $(".hiddenList").not($(".payment")).hide();
            } else if (value == tempList[4]) {
                $(".member").show();
                $(".hiddenList").not($(".member")).hide();
            } else {
                $(".hiddenList").hide();
            }
        }
    });
});

$('#selectBox').change(function () {
    let reason = $('#selectBox option:selected').val();
    if (reason == 'etc') {
        $("#etcReason").show();
    } else {
        $("#etcReason").css("display", "none");
    }
});

$('li').on("click", function () {
    let value = $(this).text();

    /*메인페이지로 이동하기*/
    if (value.includes("My Home")) {
        $("#myHome").show();
        $(".imp-medium").not($("#myHome")).hide();
    }
    /*플로깅 내역*/
    else if (value.includes("플로깅 예약 확인")) {
        // $.ajax({
        //     type: "GET",
        //     url:"/mypagePloRes",
        //     dataType: 'JSON',
        //     success : function(ploResAll){
        //         console.log(ploResAll);
        //     }
        // });
        $("#checkPloggingMain").show();
        $(".imp-medium").not($("#checkPloggingMain")).hide();
    }
    /*포인트 내역*/
    else if (value.includes("포인트 내역")) {
        $("#checkPoint").show();
        $(".imp-medium").not($("#checkPoint")).hide();
    }
    /*내 상품*/
    else if (value.includes("내 상품")) {
        $(".payment").not($(this)).css("color", "#5d5d5d");
        $("#paymentMainList").css("color", "#94c477");

        $("#paymentMain").show();
        $(".imp-medium").not($("#paymentMain")).hide();
    }
    /*찜 목록*/
    else if (value == "- 찜 목록") {
        $(this).css("color", "#94c477");
        $(".payment").not($(this)).css("color", "#5d5d5d");

        $("#paymentDib").show();
        $(".imp-medium").not($("#paymentDib")).hide();
        /*회원정보 수정*/
    } else if (value.includes("회원 정보")) {
        $(".member").not($(this)).css("color", "#5d5d5d");
        $("#memberMainList").css("color", "#94c477");

        $("#updateInfo").show();
        $(".imp-medium").not($("#updateInfo")).hide();
        /*회원 탈퇴*/
    } else if (value == "- 회원 탈퇴") {
        $(this).css("color", "#94c477");
        $(".member").not($(this)).css("color", "#5d5d5d");

        $("#deleteInfo").show();
        $(".imp-medium").not($("#deleteInfo")).hide();
    }
    /*게시글*/
    else if (value.includes("게시글")) {
        $("#myWriting").show();
        $(".imp-medium").not($("#myWriting")).hide();
    }
    /*문의하기*/
    else if (value.includes("문의하기")) {
        $("#question").show();
        $(".imp-medium").not($("#question")).hide();
    }
});

$("#deleteMember").on("click", function () {
    let form = $("form[name=deleteForm]");

    if ($('input[name=deleteMemberPw]').val() == "") {
        alert("비밀번호를 입력해주세요.");
        return;
    }

    if ($("#selectBox option:selected").val() == "etc") {
        if ($('input[name=etcReason]').val() == "") {
            alert("탈퇴 사유를 작성해주세요.");
            return;
        }
    }

    if ($("#selectBox option:selected").val() == "deleteReason") {
        alert("탈퇴 사유를 선택해 주세요.");
        return;
    }

    if (confirm("회원 탈퇴를 진행하겠습니까?")) {
        form.submit();
    } else {
        alert("회원 탈퇴가 취소 되었습니다.")
        return;
    }
});