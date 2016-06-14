<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
      <a href="#userLogin" data-toggle="tab">
         	普通用户登录
      </a>
   </li>
   <li><a href="#adminLogin" data-toggle="tab">管理员用户登录</a></li>
</ul>
<div id="myTabContent" class="tab-content">
   <div class="tab-pane fade in active" id="userLogin">
   			<form action="${pageContext.request.contextPath}/userLogin.action" method="post">
				证件号：<input id="certificateNumber" name="userVo.certificateNumber" type="text" /><br /> 
				密码：<input id="password" name="userVo.password" type="text" /><br /> 
				<button type="submit" class="btn btn-primary btn-sm">登陆</button>
			</form>
   
   </div>
   <div class="tab-pane fade" id="adminLogin">
   			<form action="${pageContext.request.contextPath}/adminLogin.action" method="post">
				员工号：<input id="employeeNumber" name="adminVo.employeeNumber" type="text" /><br /> 
				密码：<input id="password" name="adminVo.password" type="text" /><br /> 
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
	<script type="text/javascript">
		$.validator.addMethod(
			    "chrnum", function(value, element) {
			    var chrnum = /^([a-zA-Z0-9_]+)$/;
			    return this.optional(element) || (chrnum.test(value));
			    }, "只能输入数字和字母(字符A-Z, a-z, 0-9)"

		);
		$(document).ready(function(){
			console.log("1");
			$("#registForm").validate({
				rules:{
					username:{
						required:true,
						chrnum:true
					},
					password:{
						required:true,
						chrnum:true,
						minlength:5
					}
				},
				message:{
					username:{
						required:"必填"
					},
					password:{
						required:"必填",
						
					}
				},
				highlight: function(element){
					$(element).closest('.form-group').addClass('has-error');
				},
				submitHandler:function(){
					alert("succeed!")
				}
			});
		})
	</script>
</body>
	<script src="../js/jquery-2.2.3.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/jquery.validate.js"></script>
</html>