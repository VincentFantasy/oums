$.ajax({
        url: 'jsp/gonggao/findAllGonggao.action', //请求地址ַ
        type: 'POST',
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
//                case "pageCount":
//                	pageCount = value;
//                	break;
                default :
                    break;
            }
        });

        var gonggao = new Array();
        var id = null;
        //解析object
        if(flat == true){
        	//将Object转化为字符串
        	var str = JSON.stringify(object);

        	//变成json对象
        	json = eval("("+str+")");
            //获取多个场地,并解析输出
            $.each(json, function (key, value) {
                gonggao[key] = value;
                $.each(gonggao[key], function (i, v){
                    switch (i){
                    	case "gonggaoId":
                    		id = v;
                    		break;
                        case "gonggaoTitile":
                            $("#gonggao"+key).html("<a href='jsp/gonggao/gonggaodetail.jsp?gonggaoId=" + id + "'>" + v + "</a>");
                            break;
                        default :
                            break;

                    }
                });
            });
        }else
            $("#data").html(content);
    }

var pageNum = 1;
var pageCount = 1;

function addpage(){
    if(pageNum < pageCount) {
        pageNum = pageNum + 1;
        $("#pageNum").html(pageNum);
        sitesearch("");
    } else {
        alert("最后一页");
    }
}

function subpage(){
    if(pageNum > 1) {
        pageNum = pageNum - 1;
        $("#pageNum").html(pageNum);
        sitesearch("");
    } else {
        alert("最前一页");
    }
}
