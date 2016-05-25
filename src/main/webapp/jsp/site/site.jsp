<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>site</title>
</head>
<body>
	<a href="http://localhost:8080/OUMS/siteManager/testAddSite.action">測試</a>

    <form action="http://localhost:8080/OUMS/siteManager/addSite.action" method="post">
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
    <form action="http://localhost:8080/OUMS/site/findSite.action" method="post">
                       场地名:<input name="site.siteName" type="text" /><br/>
        <input type="submit" value="查找" />
    </form>
    
    <br/>
    
    <form action="http://localhost:8080/OUMS/siteManager/deleteSite.action" method="post">
                       场地名:<input name="site.siteName" type="text" /><br/>
        <input type="submit" value="删除" />
    </form>
    
    <br/>
    <form action="http://localhost:8080/OUMS/siteManager/updateSite.action" method="post">
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
    
</body>
</html>