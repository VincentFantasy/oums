<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>site</title>
</head>
<body>
    <form action="findRace.action" method="post">
                       场地名:<input name="race.raceName" type="text" /><br/>
        <input type="submit" value="查找" />
    </form>
    
    <form action="findLikeRace.action" method="post">
                       场地名:<input name="race.raceName" type="text" /><br/>
        <input type="submit" value="查找" />
    </form>

</body>
</html>