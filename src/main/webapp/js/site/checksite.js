function sitesearch(){
    $.ajax({
        url: '../../site/findSiteType.action', //请求地址ַ
        type: 'POST',
        data:{"site.siteType":$("#siteType").val()},//参数，key:value,多个参数逗号隔开
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
        var flat;
        var content;
        var object;
        $.each(json, function (key, value) {
            if(key == "flat") {
                flat = value;
            }else if(key == "content") {
                content = value;
            }else if(key == "object") {
                object = value;
            }
        });

        //解析object
        if(flat == true){
        	//将Object转化为字符串
        	var str = JSON.stringify(object);
        	//去除首尾的[]
        	str = str.substring(1,str.length-1);
        	//再次转化为对象
        	var obj = JSON.parse(str);
        	//变成json对象
        	json = eval(obj);
        	//输出json里面的东西
        	$.each(json, function (key, value) {
                if(key == "siteName")
                    $("#site-name1").html(value);
                else if(key == "siteType")
                    $("#site-type1").html(sitetype(value));
                else if(key == "siteCost")
                    $("#site-cost1").html(value);
                else if(key == "siteDtail")
                    $("#site-dtail1").html(value);
            });
        }else
            $("#data").html(content);
    }
}

function sitetype(type){
    var str;
    if(type == 1)
        str = "羽毛球场";
    else if(type == 2)
        str = "兵乓球场";
    else if(type == 3)
        str = "桌球场";
    else if(type == 4)
        str = "篮球场";
    else if(type == 5)
        str = "网球场";

    return str;
}
