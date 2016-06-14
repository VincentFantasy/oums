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