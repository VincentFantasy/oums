<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加器材</title>
</head>
<body>

    <form action="../../manager/addEquipment.action" method="post">
        器材名：<input name="equipment.equipName" type="text" /><br/>
        器材品牌：<input name="equipment.equipBrand" type="text" /><br/>
        收购价格:<input name="equipment.equipPrice" type="text" /><br/>
        出租价格（小时）:<input name="equipment.rentPrice" type="text" /><br/>
      	器材数量：<input name="equipment.totalNum" type="text" /><br/>
        场地备注：<input name="equipment.equipDtail" type="text" /><br/>
        <input type="submit" value="添加" />
    </form>
    
    
    <br/>
</body>
</html>