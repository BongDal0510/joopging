
/* 출석관련 이미지 팝업창 */
function attendInfo() {
    /* var url = "http://www.daum.net"; */
    var url = "attendPopup";
    var name = "GET";
    var option = "width=716, height=755, top=150, left=600, location=no";

    window.open(url, name, option);
}

/* 출석체크 테이블 연산 */
function showAttend(){
    tbl1 = "";
    tbl2 = "";

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