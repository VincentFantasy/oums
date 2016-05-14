<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="" method="post" onsubmit="test()"
		enctype="multipart/form-data">
		用户名：<input id="username" name="user.userName" type="text" /><br /> 
		密码：<input id="password" name="user.password" type="text" /><br /> 
		<input type="submit" value="注册">
	</form>

	<ul id="list"></ul>

	<script src="js/jquery-2.2.3.min.js" type="text/javascript"></script>
	<script type="text/javascript">
		function test() {
// 			var s = $("input[name='user.userName']").val();
// 			var s = $("#username").val();
// 			alert(s);
			$.ajax({
				type : 'POST',
				url : 'testJson.action',
				data : {"user.userName":$("#username").val()},
				dataType : 'json',
				timeout : 5000,
				cache : false,
				beforeSend : LoadFunction, //加载执行方法    
				error : erryFunction, //错误执行方法    
				success : succFunction //成功执行方法    			
			});
			
// 			alert("success");
			
			function LoadFunction() {
				$("#list").html('加载中...');
			}
			
			function erryFunction() {
				alert("error");
			}
			
			function succFunction(tt) {
				var json = eval(tt); //数组         
				$.each(json, function(index, item) {
					if(index == "userName")
						alert(item);
				});
				
			}
			
			alert("success");
		}
	</script>

</body>
</html>