var url = location.search; //获取url中"?"符后的字串
if (url.indexOf("?") != -1) {
    var str = url.substr(1);
    str = str.split("=")[1];

    //如果变成中文编码
    if(str.charAt(0) == "%")
        str = decodeURIComponent(str);

    $.ajax({
        url: 'findOrder.action', //请求地址ַ
        type: 'POST',
        data:{"order.orderNumber":str},//参数，key:value,多个参数逗号隔开
        dataType: 'json',
        timeout: 5000,
        cache: false,
        beforeSend: LoadFunction, //
        error: erryFunction,  //
        success: succFunction //
    });

    function LoadFunction() {
        $("#datatext").html('waiting...');
    }

    function erryFunction() {
        $("#datatext").html('error,try to refresh');
    }

    function succFunction(getJson) {
        $("#datatext").html('');

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

        var user = null;
        var admin = null;
        var site;
        //解析object
        if(flat == true){
            //将Object转化为字符串
            var str = JSON.stringify(object);
            //变成json对象
            json = eval("("+str+")");
            //获取到单个order
            $.each(json, function (key, value) {
                switch (key){
                    case "orderNumber":
                        $("#ordernumber").html(value);
                        break;
                    case "orderClass":
                        $("#orderclass").html(orderclass(value));
                        break;
                    case "orderType":
                        $("#ordertype").html(ordertype(value));
                        break;
                    case "buildTime":
                        $("#buildtime").html(value);
                        break;
                    case "remark":
                        $("#remark").html(value);
                        break;
                    case "reply":
                        $("#reply").html(value);
                        break;
                    case "user":
                        user = value;
                        break;
                    case "adminUser":
                        admin = value;
                        break;
                    case "siteList":
                        site = value;
                        break;
                    default :
                        break;

                }
            });

            //解析
            $.each(user, function (key, value) {
                if(key == "realName")
                    $("#userrealname").html(value);
            });

            //解析
            $.each(admin, function (key, value) {
                if(key == "realName")
                    $("#adminrealname").html(value);
            });

            //解析
            var str2 = "";
            $.each(site, function (key, value) {
                $.each(value, function (k, v) {
                    if(k == "siteName")
                        str2 = v + "," + str2;
                });
            });

            $("#sitename").html(str2);

        }else
            $("#datatext").html(content);
    }
}

function cancelorder(){
    var str = $("#ordernumber").html();

    if(str != ""){

        var str2 = $("#ordertype").html();

        if(str2 == "等待确认"){
            $.ajax({
                url: '../site/cancelOrder.action', //请求地址ַ
                type: 'POST',
                data:{"order.orderNumber":str, "order.remark":$("#userremark").val()},//参数，key:value,多个参数逗号隔开
                dataType: 'json',
                timeout: 5000,
                cache: false,
                beforeSend: LoadFunction, //
                error: erryFunction,  //
                success: succFunction //
            });

            function LoadFunction() {
                $("#datatext").html('waiting...');
            }

            function erryFunction() {
                $("#datatext").html('error,try to refresh');
            }

            function succFunction(getJson) {
                $("#datatext").html('');

                //解析json(returnMessage)
                var json = eval(getJson);
                var flat = null;
                var content = null;
                $.each(json, function (key, value) {
                    switch (key) {
                        case "flat":
                            flat = value;
                            break;
                        case "content":
                            content = value;
                            break;
                        default :
                            break;
                    }
                });

                $("#datatext").html(content);
            }
        } else {
            alert("不是等待确认状态");
        }
    }
}
