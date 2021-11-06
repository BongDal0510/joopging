/*헤더 푸터 js*/

$(function(){
    $("#main_header").load("pageframe/header #header");
    $("#main_footer").load("pageframe/footer #footer");
});
    //헤더 위치에 놓기
    // <div id="main_header"></div>

    //푸터 위치에 놓기
    // <div id="main_footer"></div>

    //js경로 같이 설정해주기
    // <script src="/js/header.js"></script>


/* 이용약관 팝업창 */
function termsInfo() {
    var url = "/main/terms";
    var name = "GET";
    var option = "width=1000, height=800, top=150, left=400, location=no";

    window.open(url, name, option);
}

/* 이용약관 팝업창 */
function privacyInfo() {
    var url = "/main/privacy";
    var name = "GET";
    var option = "width=1000, height=800, top=150, left=400, location=no";

    window.open(url, name, option);
}