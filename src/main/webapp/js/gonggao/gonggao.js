var url = location.search; //获取url中"?"符后的字串
if (url.indexOf("?") != -1) {
    var str = url.substr(1);
    str = str.split("=")[1];

    //如果变成中文编码
    if(str.charAt(0) == "%")
        str = decodeURIComponent(str);

    $.ajax({
        url: 'findGonggao.action', //请求地址ַ
        type: 'POST',
        data:{"gonggao.gonggaoId":str},//参数，key:value,多个参数逗号隔开
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
            //获取到单个order
            $.each(json, function (key, value) {
                switch (key){
                    case "gonggaoTitile":
                        $("#title").html(value);
                        break;
                    case "gonggaoDtail":
                        $("#gonggaoDtail").html(value);
                        break;
                    case "buildTime":
                        $("#time").html(value);
                        break;
                    default :
                        break;

                }
            });

        }else
            $("#datatext").html(content);
    }
}
