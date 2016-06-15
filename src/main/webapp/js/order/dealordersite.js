var pageNum = 1;
var pageCount = 1;
var search = 0;

function ordersearch(){
	if(search == 2){
		pageNum = 1;
		pageCount = 1;
		search = 1;
	}			
	
    $.ajax({
        url: '../siteManager/findSiteOrderByType.action', //请求地址ַ
        type: 'POST',
        data:{"order.orderType":$("#orderType").val(), "page.pageNum":pageNum},//参数，key:value,多个参数逗号隔开
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
            $("#order-name"+i).html('');
            $("#order-type"+i).html('');
            $("#order-class"+i).html('');
            $("#order-time"+i).html('');
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
            //获取多个场地,并解析输出
            $.each(json, function (key, value) {
                orders[key] = value;
                $.each(orders[key], function (i, v){
                    switch (i){
                        case "orderNumber":
                            $("#order-name"+key).html("<a href='orderdetail.jsp?ordername=" + v + "'>" + v + "</a>");
                            break;
                        case "orderType":
                            $("#order-type"+key).html(ordertype(v));
                            break;
                        case "orderClass":
                            $("#order-class"+key).html(orderclass(v));
                            break;
                        case "buildTime":
                            $("#order-time"+key).html(v);
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

function ordersearch2(){
	if(search == 1){
		pageNum = 1;
		pageCount = 1;
		search = 2;
	}		
	
    $.ajax({
        url: '../order/findOrderLikeNumber.action', //请求地址ַ
        type: 'POST',
        data:{"order.orderNumber":$("#ordernumber").val(), "page.pageNum":pageNum},//参数，key:value,多个参数逗号隔开
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
            $("#order-name"+i).html('');
            $("#order-type"+i).html('');
            $("#order-class"+i).html('');
            $("#order-time"+i).html('');
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
            //获取多个场地,并解析输出
            $.each(json, function (key, value) {
                orders[key] = value;
                $.each(orders[key], function (i, v){
                    switch (i){
                        case "orderNumber":
                            $("#order-name"+key).html("<a href='orderdetail.jsp?ordername=" + v + "'>" + v + "</a>");
                            break;
                        case "orderType":
                            $("#order-type"+key).html(ordertype(v));
                            break;
                        case "orderClass":
                            $("#order-class"+key).html(orderclass(v));
                            break;
                        case "buildTime":
                            $("#order-time"+key).html(v);
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
		if(search == 1)
			ordersearch("");
		else if(search == 2)
			ordersearch2("");
	} else {
		alert("最后一页");
	}
}

function subpage(){
	if(pageNum > 1) {
		pageNum = pageNum - 1;
		$("#pageNum").html(pageNum);
		if(search == 1)
			ordersearch("");
		else if(search == 2)
			ordersearch2("");
	} else {
		alert("最前一页");
	}
}
