var url = location.search; //获取url中"?"符后的字串
if (url.indexOf("?") != -1) {
    var str = url.substr(1);
    str = str.split("=")[1];
    
    //如果变成中文编码
    if(str.charAt(0) == "%")
    	str = decodeURIComponent(str);

    //吧原来的名字设置进隐藏域
    $("#rsitename").val(str);

    $.ajax({
        url: '../../site/findSite.action', //请求地址ַ
        type: 'POST',
        data:{"site.siteName":str},//参数，key:value,多个参数逗号隔开
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

        //解析object
        if(flat == true){
            //将Object转化为字符串
            var str = JSON.stringify(object);
            //变成json对象
            json = eval("("+str+")");
            //获取到单个site
            $.each(json, function (key, value) {
                switch (key){
                    case "siteName":
                        $("#sitename").val(value);
                        break;
                    case "siteType":
                        $("#sitetype").val(sitetype(value));
                        break;
                    case "siteCost":
                        $("#sitecost").val(value);
                        break;
                    case "siteDtail":
                        $("#sitedtail").val(value);
                        break;
                    case "week":
                        object = value;
                        break;
                    default :
                        break;

                }
            });
        }else
            $("#datatext").html(content);
    }
}

function sitetype(type){
    var str;
    switch (type){
        case 1:
            str = "羽毛球场";
            break
        case 2:
            str = "兵乓球场";
            break;
        case 3:
            str = "桌球场";
            break;
        case 4:
            str = "篮球场";
            break;
        case 5:
            str = "网球场";
            break;
        default :
            break;
    }

    return str;
}

function valid() {
    $("#addsiteform").validate({
        rules: {
            sitename: {
                required: true,
                maxlength: 20
            },
            sitecost: {
                required: true,
                number: true,
                min: 0,
                max: 100
            },
            sitetype: {
                required: true,
            }
        },
        messages: {
            sitename: {
                required: "请输入场地名",
                maxlength: "长度最大为20个字符"
            },
            sitecost: {
                required: "请输入价格",
                number: "价格必须为数字",
                min: "价格不能少于0",
                max: "价格最大为0"
            },
            sitetype: {
                required: "请输入场地类型"
            }
        },
        submitHandler:function() {
            sumbitform();
        }
    });
}
/*});*/

function sumbitform() {
    $.ajax({
        url: '../../siteManager/updateSite.action', //请求地址ַ
        type: 'POST',
        data:{"rSiteName":$("#rsitename").val(),"site.siteName":$("#sitename").val(), "site.siteCost":$("#sitecost").val(), "site.siteType":$("#sitetype").val(), "site.siteDtail":$("#sitedtail").val()},//参数，key:value,多个参数逗号隔开
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

        $("#datatext").html(content);

        //成功改变隐藏域的场地名
        if(flat)
            $("#rsitename").val($("#sitename").val());
    }
}

function sumbitform2() {

    $.ajax({
        url: '../../siteManager/updateSiteType.action', //请求地址ַ
        type: 'POST',
        data:{"site.siteName":$("#rsitename").val(), "day.dayOfWeek":$("#weekofday").val(), "timeInDay":$("#timeofday").val(), "itemType":$("#itemtype").val()},//参数，key:value,多个参数逗号隔开
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

        $("#datatext").html(content);
    }
}
