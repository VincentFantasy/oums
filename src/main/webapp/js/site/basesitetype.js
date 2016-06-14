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
