<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="../../js/jquery-2.2.3.min.js"></script>
	<script src="../../bootstrap-3.3.5/js/bootstrap.min.js"></script>
	<script src="../../js/jquery.validate.js"></script>
	<link href="../../bootstrap-3.3.5/css/bootstrap.min.css"rel="stylesheet">
	<title>欢迎登陆</title>
</head>
<body>
<div class="page=header">
	<h1>欢迎进入广东海洋大学体育馆管理系统！</h1>
</div>
<div class="container">
	<div class="row">
		<div class="col-sm-3 col-md-6 col-lg-8"
			style="background-color:#dedef8;
			box-shadow: inset 1px -1px 1px #444,
			inset -1px 1px 1px #444;">
			<img src="../../image/chijing.jpg" class="img-circle">
		</div>
		<div class="col-sm-9 col-md-6 col-lg-4" 
	         style="background-color: #dedef8;
	         box-shadow: inset 1px -1px 1px #444, 
	         inset -1px 1px 1px #444;">
			<form action="../../user/userLogin.action" method="post">
				证件号：<input id="certificateNumber" name="userVo.certificateNumber" type="text" /><br /> 
				密码：<input id="password" name="userVo.password" type="text" /><br /> 
				<tr>
					<td>
						<input name="RadioButtonList1" tabindex="4" id="RadioButtonList1_0" type="radio" value="student">
						<label>student</label>
					</td>
					<td>
						<input name="RadioButtonList2" tabindex="4" id="RadioButtonList2_0" type="radio" value="admin">
						<label>admin</label>
					</td>
				</tr><br/>

				<button type="submit" class="btn btn-primary btn-sm">登陆</button>
			</form>
			<button class="btn btn-primary btn-sm" onclick="window.location.href('regist.jsp')">注册</button>
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
</html>