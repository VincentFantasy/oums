var pageNum = 1;
var pageCount = 1;

function sitesearch(m){
    $.ajax({
        url: 'findSiteType.action', //请求地址ַ
        type: 'POST',
        data:{"site.siteType":$("#siteType").val(), "page.pageNum":pageNum},//参数，key:value,多个参数逗号隔开
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
            $("#site-name"+i).html('');
            $("#site-type"+i).html('');
            $("#site-cost"+i).html('');
            $("#site-dtail"+i).html('');
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

        var site = new Array();
        //解析object
        if(flat == true){
        	//将Object转化为字符串
        	var str = JSON.stringify(object);
        	//变成json对象
        	json = eval("("+str+")");
            //获取多个场地,并解析输出
            $.each(json, function (key, value) {
                site[key] = value;
                $.each(site[key], function (i, v){
                    switch (i){
                        case "siteName":
                            $("#site-name"+key).html("<a href='" + m + "checksitedetail.jsp?sitename=" + v + "'>" + v + "</a>");
                            break;
                        case "siteType":
                            $("#site-type"+key).html(sitetype(v));
                            break;
                        case "siteCost":
                            $("#site-cost"+key).html(v);
                            break;
                        case "siteDtail":
                            $("#site-dtail"+key).html(v);
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
