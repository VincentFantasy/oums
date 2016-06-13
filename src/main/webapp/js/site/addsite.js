/*$().ready(function() {*/
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
        url: '../../siteManager/addSite.action', //请求地址ַ
        type: 'POST',
        data:{"site.siteName":$("#sitename").val(), "site.siteCost":$("#sitecost").val(), "site.siteType":$("#sitetype").val(), "site.siteDtail":$("#sitedtail").val()},//参数，key:value,多个参数逗号隔开
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

        $("#datetext").html(content);
    }
}
