function sumbitform() {
    var str = $("#gonggaoid").val();

    if (str != "") {
        $.ajax({
            url : 'deleteGonggao.action', // 请求地址ַ
            type : 'POST',
//            data : $("deletegonggaoform").serialize(),
            data : {
                "gonggao.gonggaoId" : str
            },// 参数，key:value,多个参数逗号隔开
            dataType : 'json',
            timeout : 5000,
            cache : false,
            beforeSend : LoadFunction, //
            error : erryFunction, //
            success : succFunction
            //
        });

        function LoadFunction() {
            $("#datatext").html('waiting...');
        }

        function erryFunction() {
            $("#datatext").html('error,try to refresh');
        }

        function succFunction(getJson) {
            $("#datatext").html('');

            // 解析json(returnMessage)
            var json = eval(getJson);
            var flat = null;
            var content = null;
            $.each(json, function(key, value) {
                // alert(key + ":" + value);
                switch (key) {
                    case "flat":
                        flat = value;
                        break;
                    case "content":
                        content = value;
                        break;
                    default:
                        break;
                }
            });

            $("#datatext").html(content);
        }
    } else
        alert("不能为空");

}
