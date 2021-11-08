/*
    commu reply ajax 모듈화
 */
console.log("Reply Module.......");

let inquiryReplyService = (function(){

    //댓글 등록
    function add(replyInfo, callback, error){
        console.log("add reply.........." + replyInfo);
        $.ajax({
            url:"/inqReplies/new",
            type:"post",
            data:JSON.stringify(replyInfo),
            contentType:"application/json; charset=utf-8",
            success:function(result, status, xhr){
                if(callback){
                    //외부에서 전달받은 값이 있다면 결과를 해당 함수의 매개변수로 전달하여 사용한다.
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

    //댓글 삭제
    function remove(inquiryRno, callback, error){
        $.ajax({
            type:"DELETE",
            url:"/inqReplies/" + inquiryRno,
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
    function update(inquiryReply, callback, inquiryRno){
        console.log("update...........");
        $.ajax({
            type:"patch",
            url:"/inqReplies/" + inquiryReply.inquiryRno,
            data:JSON.stringify(inquiryReply),
            contentType:"application/json; charset=utf-8",
            success:function(result, status, xhr){
                if(callback){
                    callback(result);
                }
            },
            error:function(xhr, status, err){
                if(err){
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
            "/inqReplies/pages/" + inquiryRno + "/" + page,
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
    function get(inquiryRno, callback, error){
        $.get(
            "/inqReplies/" + inquiryRno,
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


















