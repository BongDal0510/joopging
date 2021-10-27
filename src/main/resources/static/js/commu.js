/**
 * 내정보
 */

var tempList= new Array;

$(".commu").each(function(index, item){
    tempList.push($(item).text());
});

$("#myPageMainList").css("color", "#94c477");

$(".commu").on("click", function(){
    var value = $(this).text();
    var check = true;
    $.each($(".class"), function(index,item){
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
        /*if(check){
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
        }*/
    });
});

$('a').on("click", function(){
    var value = $(this).text();

    if(value.includes("커뮤니티 게시판")){
        $("#commuBoardMiddle").show();
        $(".rotateMainContent").not($("#commuBoardMiddle")).hide();
    }
    else if(value.includes("인터뷰")){
        $("#interviewLists").show();
        $(".rotateMainContent").not($("#interviewLists")).hide();
    }
    else if(value.includes("문의하기")){
        $("#inquiryOneonOne").show();
        $(".rotateMainContent").not($("#inquiryOneonOne")).hide();
    }
    else if(value.includes("신고글")){
        $("#reportedBoard").show();
        $(".rotateMainContent").not($("#reportedBoard")).hide();
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


$(".listbtn").click(function() {
    alert("해당 페이지는 준비중에 있어요~ 다음시즌을 기대해 주세요^^");
    return false;
});``