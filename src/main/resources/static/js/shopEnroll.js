/**
 *
 */

// 상품 옵션 추가 및 삭제 버튼

/* https://meanbymin.tistory.com/78 참고 */
/* add_textbox 상수를 만들고 화살표 함수를 사용하여 바로 사용되도록 해주었다 */
var num = 0;

const add_textbox = () => {
    const goods_option = document.getElementById("goods_option");
    const newP = document.createElement('p');
    num++;
    newP.innerHTML = "색상<input type='text' id='goodsColor' name='goodsOptionColor" + num + "' style='width:20%;'>사이즈<input type='text' id='goodsSize' name='goodsOptionSize" + num + "' style='width:20%;'><input type='button' value='삭제' onclick='remove(this)'>";
    goods_option.appendChild(newP);
}
const remove = (obj) => {
    document.getElementById('goods_option').removeChild(obj.parentNode);
}

// $(document).ready (function (){
//     var num = 0;
//    $('#goods_option_btn').click(function(){
//       $('#goods_option').append(
//           "색상<input type='text' id='goodsColor' name='goods_option_color" + num + "' style='width:20%;'>" +
//           "사이즈<input type='text' id='goodsSize' name='goods_option_size" + num + "' style='width:20%;'>" +
//           "<input type='button' value='삭제' onclick='remove(this)'>"
// //     goods_option.appendChild(newP);
//
//       )
//
//    });
//
//
// });










var frm = document.enrollform;



function enrollSubmit(){

    var reg = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[#?!@$%^&*-])(?=.*[ㄱ-ㅎ|ㅏ-ㅣ|가-힣])/;

    if(!frm.goodsName.value){
        alert("상품명을 입력해주세요");
        frm.goodsName.focus();
        return false;
    }
    if(frm.goodsCategory.value =="no select"){
        alert("상품 카테고리를 선택해주세요");
        frm.goodsCategory.focus();
        return false;
    }

/*    var imgFile = $('#board_file1').val();
    var fileForm = /(.*?)\.(jpg|jpeg|png|gif|bmp|pdf)$/;
    var maxSize = 5 * 1024 * 1024;
    var fileSize;*/

/*    if($('#board_file1').val() == "") {
        alert("첨부파일은 필수!");
        $("#board_file1").focus();
        return;
    }
    if($('#board_file2').val() == "") {
        alert("첨부파일은 필수!");
        $("#board_file1").focus();
        return;
    }
    if($('#board_file3').val() == "") {
        alert("첨부파일은 필수!");
        $("#board_file1").focus();
        return;
    }*/
    if(!frm.goodsContent.value){
        alert("상품 설명을 입력해주세요");
        frm.goodsContent.focus();
        return false;
    }
    if(!frm.goodsPrice.value){
        alert("가격을 입력해주세요");
        frm.goodsPrice.focus();
        return false;
    }

    /*if(frm.password.value.search(reg) != -1){
        alert("가격은 숫자만 입력해주세요");
        frm.goods_price.focus();
        return false;
    }*/

    /* var option = frm.goods_option_color+"num"
     console.log(option);
     if(!option.value){
         alert("색상을 입력해주세요");
         this.option.focus();
         return false;
     }

     if(!this.frm.goods_option_size.value){
         alert("사이즈를 입력해주세요");
         this.frm.goods_option_size.focus()
         return false;
     }

     if(!frm.goods_option_stock.value){
         alert("수량을 입력해주세요");
         frm.goods_option_stock.focus()
         return false;
     }*/

    frm.submit();
}


