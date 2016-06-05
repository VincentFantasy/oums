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