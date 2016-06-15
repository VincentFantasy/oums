var pageNum = 1;
var pageCount = 1;

function racesearch(){	
    $.ajax({
        url: 'findLikeRace().action', //请求地址ַ
        type: 'POST',
        data:{"race.raceName":$("#racename").val(), "page.pageNum":pageNum},//参数，key:value,多个参数逗号隔开
        dataType: 'json',
        timeout: 5000,
        cache: false,
        beforeSend: LoadFunction, //
        error: erryFunction,  //
        success: succFunction //
    });

    function LoadFunction() {
        $("#data").html('waiting...');
    }

    function erryFunction() {
        $("#data").html('error,try to refresh');
    }

    function succFunction(getJson) {
        $("#data").html('');
        for(var i=0; i<11; i++){
            $("#race-name"+i).html('');
            $("#race-time"+i).html('');
            $("#race-detail"+i).html('');
        }

        //解析json(returnMessage)
        var json = eval(getJson);
        var flat = null;
        var content = null;
        var object = null;
        $.each(json, function (key, value) {
            switch (key){
                case "flat":
                    flat = value;
                    break;
                case "content":
                    content = value;
                    break;
                case "object":
                    object = value;
                    break;
                case "pageCount":
                	pageCount = value;
                	break;
                default :
                    break;
            }
        });

        var orders = new Array();
        //解析object
        if(flat == true){
            //将Object转化为字符串
            var str = JSON.stringify(object);
            //变成json对象
            json = eval("("+str+")");
            //获取多个赛事,并解析输出
            $.each(json, function (key, value) {
                orders[key] = value;
                $.each(orders[key], function (i, v){
                    switch (i){
                        case "raceName":
                            $("#race-name"+key).html(v);
                            break;
                        case "siteTime":
                            $("#race-time"+key).html(v);
                            break;
                        case "raceDtail":
                            $("#race-detail"+key).html(v);
                            break;
                        default :
                            break;

                    }
                });
            });
        }else
            $("#data").html(content);
    }
}

function addpage(){
	if(pageNum < pageCount) {
		pageNum = pageNum + 1;
		$("#pageNum").html(pageNum);
			racesearch();
	} else {
		alert("最后一页");
	}
}

function subpage(){
	if(pageNum > 1) {
		pageNum = pageNum - 1;
		$("#pageNum").html(pageNum);
			racesearch();
	} else {
		alert("最前一页");
	}
}

