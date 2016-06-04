<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
                      场地类型:<select name="site.itemState">
                    <option value="111">正在被使用</option>
                    <option value="222">空闲</option>
                    <option value="333">维修</option>
                    <option value="444">教学使用</option>
                    <option value="555">暂停使用</option>
                </select><br/>
        <input type="submit" value="改变" />
    </form>
    
</body>
</html>