<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/jsp/userManagement";
	%>
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="../css/bootstrap.min.css"rel="stylesheet">

	<title>欢迎登陆</title>
</head>
<body>
<div class="page=header">
	<h1>欢迎进入广东海洋大学体育馆管理系统！</h1>
</div>
<div class="container">
	<ul id="myTab" class="nav nav-tabs">
   <li class="active">
      <a href="#userLoginForm" data-toggle="tab">
         	普通用户登录
      </a>
   </li>
   <li><a href="#adminLoginForm" data-toggle="tab">管理员用户登录</a></li>
</ul>
<div id="myTabContent" class="tab-content">
   <div class="tab-pane fade in active" id="userLoginForm">
   			<form action="${pageContext.request.contextPath}/userLogin.action" method="post">
				证件号：<input id="certificateNumber" name="userVo.certificateNumber" type="text" /><br /> 
				密码：<input id="password" name="userVo.password" type="password" /><br /> 
				<button type="submit" class="btn btn-primary btn-sm">登陆</button>
			</form>
   
   </div>
   <div class="tab-pane fade" id="adminLoginForm">
   			<form action="${pageContext.request.contextPath}/adminLogin.action" method="post">
				员工号：<input id="employeeNumber" name="adminVo.employeeNumber" type="text" /><br /> 
				密码：<input id="password" name="adminVo.password" type="password" /><br /> 
				<button type="submit" class="btn btn-primary btn-sm">登陆</button>
			</form>
   </div>
</div>

</div>
<div id="footer" class="container">
	<nav class="navbar navbar-default navbar-fixed-bottom">
	    <div class="navbar-inner navbar-content-center">
	        <p class="text-muted credit" style="padding: 10px;">
	                                  咨询电话：87654321
	        </p>
	    </div>
	</nav>
</div>
</body>
	<script src="../js/jquery-2.2.3.min.js"></script>
	<script src="../js/jquery.validate.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$.validator.addMethod(
			    "chrnum", function(value, element) {
			    var chrnum = /^([a-zA-Z0-9_]+)$/;
			    return this.optional(element) || (chrnum.test(value));
			    }, "只能输入数字和字母(字符A-Z, a-z, 0-9)"

		);
		$(document).ready(function(){
			$("#userLoginForm").validate({
				rules:{
					"userVo.certificateNumber":{
						required:true,
						chrnum:true
					},
					"userVo.password":{
						required:true,
						chrnum:true
					}
				},
				message:{
					"userVo.certificateNumber":{
						required:"必填"
					},
					"userVo.password":{
						required:"必填",
						
					}
				}
			});
		},
		function(){
			$("#adminLoginForm").validate({
				rules:{
					"adminVo.employeeNumber":{
						required:true,
						chrnum:true
					},
					"adminVo.password" :{
						required:true,
						chrnum:true
					}
				},
				message:{
					"adminVo.employeeNumber":{
						required:"必填"
					},
					"adminVo.password" :{
						required:"必填",
						
					}
				}
			});
		}
		)
	</script>

	
</html>