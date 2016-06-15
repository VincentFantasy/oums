<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>ExtJS World</title>
<link rel="stylesheet" type="text/css" href="../../css/ext-all.css" />
<script type="text/javascript" src="../../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../js/ext-all.js"></script>
<script>
Ext.onReady(function () {
    var win = Ext.create("Ext.Window", {
        title: "ExtJS Window",
        width: 500,
        height: 300,
        html:'<iframe style="overflow:auto;width:100%; height:100%;" src="http://www.qeefee.com" frameborder="0"></iframe>',
        autoShow: true
    });
});
</script>
</head>
<body>
	
</body>
</html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>site</title>
</head>
<body>
	<a href="../../siteManager/testAddSite.action">測試</a>

    <form action="../../siteManager/addSite.action" method="post">
        场地名：<input name="site.siteName" type="text" /><br/>
        价格（小时）:<input name="site.siteCost" type="text" /><br/>
        场地类型:<select name="site.siteType">
                    <option value="1">羽毛球场</option>
                    <option value="2">兵乓球场</option>
                    <option value="3">桌球场</option>
                    <option value="4">篮球场</option>
                    <option value="5">网球场</option>
                </select><br/>
        场地备注：<input name="site.siteDtail" type="text" /><br/>
        <input type="submit" value="添加" />
    </form>

    <br/>
    <form action="../../site/findSite.action" method="post">
                       场地名:<input name="site.siteName" type="text" /><br/>
        <input type="submit" value="查找" />
    </form>
    
    <br/>
    
    <form action="../../siteManager/deleteSite.action" method="post">
                       场地名:<input name="site.siteName" type="text" /><br/>
        <input type="submit" value="删除" />
    </form>
    
    <br/>
    <form action="../../siteManager/updateSite.action" method="post">
        场地名：<input name="site.siteName" type="text" /><br/>
        价格（小时）:<input name="site.siteCost" type="text" /><br/>
        场地类型:<select name="site.siteType">
                    <option value="1">羽毛球场</option>
                    <option value="2">兵乓球场</option>
                    <option value="3">桌球场</option>
                    <option value="4">篮球场</option>
                    <option value="5">网球场</option>
                </select><br/>
        场地备注：<input name="site.siteDtail" type="text" /><br/>
        <input type="submit" value="更新" />
    </form>
    
    <form action="../../site/findSiteType.action" method="post">
                      场地类型:<select name="site.siteType">
                    <option value="1">羽毛球场</option>
                    <option value="2">兵乓球场</option>
                    <option value="3">桌球场</option>
                    <option value="4">篮球场</option>
                    <option value="5">网球场</option>
                </select><br/>
        <input type="submit" value="类型查找" />
    </form>
    
    <br>
    
    <form action="../../siteManager/updateSiteType.action" method="post">
       	场地名：<input name="site.siteName" type="text" />
       	星期:<select name="day.dayOfWeek">
                    <option value="0">星期天</option>
                    <option value="1">星期一</option>
                    <option value="2">星期二</option>
                    <option value="3">星期三</option>
                    <option value="4">星期四</option>
                    <option value="5">星期五</option>
                    <option value="6">星期六</option>
                </select><br/>
                      场地状态:<select name="day.time1">
                    <option value="111">正在被使用</option>
                    <option value="222">空闲</option>
                    <option value="333">维修</option>
                    <option value="444">教学使用</option>
                    <option value="555">暂停使用</option>
                    <option value="666">被预约</option>
                </select><br/>
        <input type="submit" value="改变" />
    </form>
    <br/>
    <form action="../../site/findWeekBySite.action" method="post">
       	场地名：<input name="site.siteName" type="text" />         
        <input type="submit" value="查找周表" />
    </form>
    <br/>
    <form action="../../site/newSiteOrder.action" method="post">
       	场地名：<input name="site.siteName" type="text" /> 
       	用户名：<input name="user.certificateNumber" type="text" />
       	星期:<select name="dayOfWeek">
                    <option value="0">星期天</option>
                    <option value="1">星期一</option>
                    <option value="2">星期二</option>
                    <option value="3">星期三</option>
                    <option value="4">星期四</option>
                    <option value="5">星期五</option>
                    <option value="6">星期六</option>
                </select><br/>
                         时间段：<select name="timeInDay">
                    <option value="0">8:00 - 9:50</option>
                    <option value="1">10:00 - 11:50</option>
                    <option value="2">12:00 - 13:50</option>
                    <option value="3">14:00 - 15:50</option>
                    <option value="4">16:00 - 17:50</option>
                    <option value="5">18:00 - 19:50</option>
                </select><br/>
             备注：   <textarea name="order.remark" rows="5" cols="10"></textarea>
        <input type="submit" value="预约" />
    </form>
    <br/>
    <form action="../../siteManager/findAllSiteOrder.action" method="post">       
        <input type="submit" value="查找所有的场地的订单" />
    </form>
    <br/>
    <form action="../../site/findUserSiteOrder.action" method="post">
    	用户名（证件号）：<input name="user.certificateNumber" type="text" />
        <input type="submit" value="查找所有的场地的订单" />
    </form>
    <br/>
    <form action="../../siteManager/findSiteOrderByType.action" method="post">
    	订单状态:<select name="order.orderType">
                    <option value="1">未付款</option>
                    <option value="2">等待确认</option>
                    <option value="3">已确认</option>
                    <option value="4">已取消</option>
                    <option value="5">已退款</option>
                    <option value="6">已拒绝</option>
                </select><br/>
        <input type="submit" value="查找订单" />
    </form>
    <br/>
     <form action="../../site/payOrder.action" method="post">
    	订单号：<input name="order.orderNumber" type="text" />
        <input type="submit" value="付款" />
    </form>
    <br/>
    <form action="../../site/cancelOrder.action" method="post">
    	订单号：<input name="order.orderNumber" type="text" />
        <input type="submit" value="取消订单" />
    </form>
    <br/>
    <form action="../../siteManager/sureSiteOrder.action" method="post">
    	订单号：<input name="order.orderNumber" type="text" />
    	管理员号:<input name="adminUser.employeeNumber" type="text" />
        <input type="submit" value="确认" />
    </form>
    <br/>
    <form action="../../siteManager/rejectOrder.action" method="post">
    	订单号：<input name="order.orderNumber" type="text" />
    	管理员号:<input name="adminUser.employeeNumber" type="text" />
        <input type="submit" value="拒绝" />
    </form>
    <br/>
</body>
</html>