<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加器材</title>
</head>
<body>

    <form action="../../equipManager/udateEquipment.action" method="post">
    	<input name="equipment.equipId" type="hidden" value="${requestScope.list.equipId }"/>
    	<input name="equipment.addTime" type="hidden" value="${requestScope.list.addTime }"/>
        器材名：<input name="equipment.equipName" type="text" value="${requestScope.list.equipName }"/><br/>
        器材品牌：<input name="equipment.equipName" type="text" value="${requestScope.list.equipName}"/><br/>
        收购价格:<input name="equipment.equipPrice" type="text" value="${requestScope.list.equipPrice}" /><br/>
        出租价格（小时）:<input name="equipment.rentPrice" type="text" value="${requestScope.list.rentPrice}" /><br/>
        场地备注：<input name="equipment.equipDtail" type="text" value="${requestScope.list.equipDtail}" /><br/>
        <input type="submit" value="更新" />
    </form>
    
    
    <br/>
</body>
</html>