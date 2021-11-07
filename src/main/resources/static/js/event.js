
/* 신규가입 이벤트 날짜 연산 */
$(document).ready(function(){
    let today = new Date();
    let year = today.getFullYear();
    let month = today.getMonth() + 1;

    let lastDate = new Date(year, month - 2, 0);

    $("#joinEventTitle").html(month + "월 신규가입");
    $("#joinEventDate").html(month + "월 1일-" + month + "월 " + lastDate.getDate() + "일");
});

/* 출석안내 이미지 팝업창 */
function attendInfo() {
    var url = "attendPopup";
    var name = "GET";
    var option = "width=716, height=755, top=150, left=600, location=no";

    window.open(url, name, option);
}

/* 출석체크 테이블 연산 */
function showAttend(attendCnt){
    tbl1 = "";
    tbl2 = "";

    console.log("showAttend...............");

    if(attendCnt <= 5) {
        for(let i=0; i < attendCnt; i++){
            tbl1 += "<td style='padding: 0; text-align: center;'><img src='/images/eventImage/check.png\' style='height: 20px'></td>";
        }
        for(let i=0; i < (5 - attendCnt); i++){
            tbl1 += "<td></td>";
        }
        for(let i=0; i < 5; i++){
            tbl2 += "<td></td>";
        }
    }else{
        for(let i=0; i < 5; i++){
            tbl1 += "<td style='padding: 0; text-align: center;'><img src='/images/eventImage/check.png\' style='height: 20px'></td>";
        }
        for(let i=0; i < (attendCnt - 5); i++){
            tbl2 += "<td style='padding: 0; text-align: center;'><img src='/images/eventImage/check.png\' style='height: 20px'></td>";
        }
        for(let i=0; i < (10 - attendCnt); i++){
            tbl2 += "<td style='padding: 0;'></td>";
        }
    }
    attendTable_1.html(tbl1);
    attendTable_2.html(tbl2);
}

/* 출석하기 버튼 클릭후 뷰단 설정 */
function attendUpdate(){
    $.ajax({
        url:'/event/attendUpdate',
        type:'post',
        success:function(memberVO){
            alert("출석체크 완료!");

            $("#attendCntLeft").text(memberVO.memberAttend + "/10");
            $("#attendButton").hide();
            $("#attendNotButtonCheck").show();

            showAttend(memberVO.memberAttend);
            console.log("성공");
        },
        error:function(){
            console.log("오류");
        }
    });
}
