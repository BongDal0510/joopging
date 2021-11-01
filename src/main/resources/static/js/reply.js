/*reply ajax 모듈*/
console.log("Reply Module.......");

let replyService = (function(){

    //댓글 등록
    function add(replyInfo, callback, error){
        console.log("add reply..........");
        $.ajax({
            url:"/replies/new",
            type:"post",
            data:JSON.stringify(replyInfo),//stringify 함수로 키 값을 문자열 처리
            contentType:"application/json; charset=utf-8", //전달할 타입
            success:function(result, status, xhr){//성공시
                if(callback){
                    callback(result);
                }
            },
            error:function(xhr, status, err){//실패시
                if(error){
                    error(err);
                }
            }
        });
    }

    //댓글 삭제
    function remove(commuRno, callback, error){
        $.ajax({
            type:"DELETE",
            url:"/replies/" + commuRno,
            success:function(result){
                if(callback){
                    callback(result);
                }
            },
            error:function(xhr, status, er){
                if(error){
                    error(er);
                }
            }
        });
    }
    //댓글 수정
    function update(commuReply, callback, error){
        console.log("update...........");
        $.ajax({
            type:"patch",
            url:"/replies/" + commuReply.commuRno,
            data:JSON.stringify(commuReply),
            contentType:"application/json; charset=utf-8",
            success:function(result, status, xhr){
                if(callback){
                    callback(result);
                }
            },
            error:function(xhr, status, err){
                if(error){
                    error(err);
                }
            }
        });
    }

    //댓글 목록
    function getList(params, callback, error){
        console.log("list..........");
        // let data = x | y : x가 없으면 y
        let page = params.page || 1;
        // get방식으로 요청 후 JSON으로 응답
        // $.getJSON(url, callback).fail(callback)
        $.getJSON(
            "/replies/pages/" + commuBno + "/" + page,
            function(result){
                if(callback){
                    callback(result.replyCnt, result.list);
                }
            }
        ).fail(function(xhr, status, er){
            if(error){
                error(er);
            }
        })
    }

    //댓글 조회
    function get(commuRno, callback, error){
        $.get(
            "/replies/" + commuRno,
            function(replyInfo){
                if(callback){
                    callback(replyInfo);
                }
            }
        ).fail(function(xhr, status, err){
            if(error){
                error(err);
            }
        });
    }

    function displayTime(timeValue){
        let today = new Date();
        let dateObj = new Date(timeValue);
        let gap = today.getTime() - dateObj.getTime();

        if(gap < (1000 * 60 * 60 * 24)){
            let hh = dateObj.getHours();
            let mi = dateObj.getMinutes();
            let ss = dateObj.getSeconds();

            return [(hh > 9 ? '' : '0') + hh, ':', (mi > 9 ? '' : '0') + mi, ':', (ss > 9 ? '' : '0') + ss].join(' ');
        }else{

            let yy = dateObj.getFullYear();
            let mm = dateObj.getMonth() + 1;
            let dd = dateObj.getDate();

            return [yy, '-', (mm > 9 ? '' : '0') + mm, '-', (dd > 9 ? '' : '0') + dd].join(' ');
        }
    }

    return {add : add, remove : remove, update : update, getList : getList, get : get, displayTime : displayTime};
//    외부에서는 replyService.add(객체, 콜백)형식으로 사용하며,
//    Ajax 호출이 감춰져 있기 때문에 사용부의 코드가 더 깔끔해진다.
})();


















