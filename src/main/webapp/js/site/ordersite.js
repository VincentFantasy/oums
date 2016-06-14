
function sumbitform() {
	var str = $("#sitename").val();
	if(str != "")
	    $.ajax({
        url: 'newSiteOrder.action',
        type: 'POST',
        data:{"site.siteName":str, "dayOfWeek":$("#dayofweek").val(), "timeInDay":$("#timeofday").val(), "order.remark":$("#remark").val()},
        dataType: 'json',
        timeout: 5000,
        cache: false,
        beforeSend: LoadFunction, //
        error: erryFunction,  //
        success: succFunction //
    });
	else
		alert("场地名不能为空!");

    function LoadFunction() {
        $("#datatext").html('waiting...');
    }

    function erryFunction() {
        $("#datatext").html('error,try to refresh');
    }

    function succFunction(getJson) {
        $("#datatext").html('');

        var json = eval(getJson);
        var flat = null;
        var content = null;
        $.each(json, function (key, value) {
            switch (key){
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
}
