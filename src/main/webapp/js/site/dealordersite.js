function ordersearch(){
    $.ajax({
        url: '../siteManager/findSiteOrderByType.action', //请求地址ַ
        type: 'POST',
        data:{"order.orderType":$("#orderType").val()},//参数，key:value,多个参数逗号隔开
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
                            $("#order-name"+key).html("<a href='orderdetail.html?ordername=" + v + "'>" + v + "</a>");
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
    $.ajax({
        url: '../order/findOrderLikeNumber.action', //请求地址ַ
        type: 'POST',
        data:{"order.orderNumber":$("#ordernumber").val()},//参数，key:value,多个参数逗号隔开
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
                            $("#order-name"+key).html("<a href='orderdetail.html?ordername=" + v + "'>" + v + "</a>");
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

function orderclass(clazz) {
    var str;
    switch (clazz){
        case 1:
            str = "场地";
            break
        case 2:
            str = "器材";
            break;
        case 3:
            str = "赛事";
            break;
        default :
            break;
    }

    return str;
}

function ordertype(type){
    var str;
    switch (type){
        case 1:
            str = "未付款";
            break
        case 2:
            str = "等待确认";
            break;
        case 3:
            str = "已确认";
            break;
        case 4:
            str = "已取消";
            break;
        case 5:
            str = "已退款";
            break;
        case 6:
            str = "已拒绝";
            break;
        default :
            break;
    }

    return str;
}
