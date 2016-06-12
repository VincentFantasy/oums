var url = location.search; //获取url中"?"符后的字串
if (url.indexOf("?") != -1) {
    var str = url.substr(1);
    str = str.split("=")[1];
    
    //如果变成中文编码
    if(str.charAt(0) == "%")
    	str = decodeURIComponent(str);
    
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
                        $("#site-name0").html(value);
                        break;
                    case "siteType":
                        $("#site-type0").html(sitetype(value));
                        break;
                    case "siteCost":
                        $("#site-cost0").html(value);
                        break;
                    case "siteDtail":
                        $("#site-dtail0").html(value);
                        break;
                    case "week":
                        object = value;
                        break;
                    default :
                        break;

                }
            });

            //解析week
            $.each(object, function (key, value) {
                daytype(key, value);
            });
        }else
            $("#data").html(content);
    }
}

function daytype(dayofweek, obj) {
    var i = -1;
    switch (dayofweek){
        case "sunday":
            i=0;
            break;
        case "monday":
            i=1;
            break;
        case "tuesday":
            i=2;
            break;
        case "wednesday":
            i=3;
            break;
        case "thurday":
            i=4;
            break;
        case "friday":
            i=5;
            break;
        case "saturday":
            i=6;
            break;
        default:
            break;
    }

    if(i != -1){
        $.each(obj, function (key, value) {
            switch (key){
                case "time0":
                    $("#time" + i + "0").html(timetype(value));
                    break;
                case "time1":
                    $("#time" + i + "1").html(timetype(value));
                    break;
                case "time2":
                    $("#time" + i + "2").html(timetype(value));
                    break;
                case "time3":
                    $("#time" + i + "3").html(timetype(value));
                    break;
                case "time4":
                    $("#time" + i + "4").html(timetype(value));
                    break;
                case "time5":
                    $("#time" + i + "5").html(timetype(value));
                    break;
                default:
                    break;
            }
        });
    }

}

function timetype(type){
    var str;
    switch (type){
        case 111:
            str = "正在被使用";
            break;
        case 222:
            str = "空闲";
            break;
        case 333:
            str = "维修";
            break;
        case 444:
            str = "教学使用";
            break;
        case 555:
            str = "暂停使用";
            break;
        case 666:
            str = "被预约";
            break;
        default :
            break;
    }
    return str;
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
