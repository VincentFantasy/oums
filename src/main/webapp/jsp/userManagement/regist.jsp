<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="../../js/jquery-2.2.3.min.js"></script>
	<script src="../../bootstrap-3.3.5/js/bootstrap.min.js"></script>
	<script src="../../js/jquery.validate.js"></script>
	<link href="../../bootstrap-3.3.5/css/bootstrap.min.css"rel="stylesheet">
	<title>Regist</title>
</head>

<body>
	<form id="registForm" role="form" action="" method="post">
		<ul class="list-group">
			<li class="list-group-item">
				<div class="form-group">
					<label>用户名</label>
					<input type="text" class="form-control" id="cusername" name="username" placeholder=“请输入用户名”>
				</div>
			</li>
			<li class="list-group-item">
				<div class="form-group">
					<label>密码</label>
					<input type="text" class="form-control" id="cpassword" name="password" placeholder=“请输入密码(至少5位)”>
				</div>
			</li>
			<li class="list-group-item">
				<div class="form-group">
					<label>再次输入密码</label>
					<input type="text" class="form-control" id="cpasswordConfirm" name="passwordConfirm" placeholder=“请输入密码”>
				</div>
			</li>
			<li class="list-group-item">
				<div class="form-group">
					<label>手机</label>
					<input type="text" class="form-control" id="ctel" name="tel" placeholder=“请输入手机号码”>
				</div>
			</li>
			<li class="list-group-item">
				<div class="form-group">
					<label>邮箱</label>
					<input type="text" class="form-control" id="cemail" name="email" placeholder=“请输入邮箱”>
				</div>
			</li>
			<li class="list-group-item">
				<div class="form-group">
					<label>身份证</label>
					<input type="text" class="form-control" id="cIdCardNumber" name="IdCardNumber" placeholder="请输入身份证">
				</div>
			</li>
			<li class="list-group-item">
				<div class="form-group">
					<label>手机号码</label>
					<input type="text" class="form-control" id="cphoneNumber" name="phoneNumber" placeholder="请输入手机号码">
				</div>
			</li>
			<li class="list-group-item">
				<div class="form-group">
					<label>学生号</label>
					<input type="text" class="form-control" id="cstudentNumber" name="studentNumber" placeholder="请输入手机号码">
				</div>
			</li>
		</ul>
		<button type="submit" class="btn btn-primary btn-sm">提交</button>
	</form>
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
					IdCardNumber:{
						required:true,
						maxlength:18,
						minlength:18
					},
					phoneNumber:{
						required:true,
						maxlength:11,
						minlength:11
					},
					studentNumber:{
						required:true,
						maxlength:12,
						minlength:12
					},
					password:{
						required:true,
						chrnum:true,
						minlength:5
					},
					passwordConfirm:{
						required:true,
						equalTo:"#cpassword"
					},
					email:{
						required:true,
						email:true
					}
				},
				message:{
					username:{
						required:"必填"
					},
					IdCardNumber:{
						required:"必填",
						maxlength:"长度不符合",
						minlength:"长度不符合"
					},
					phoneNumber:{
						required:"必填",
						maxlength:"长度不符合",
						minlength:"长度不符合"
					},
					studentNumber:{
						required:"必填",
						maxlength:"长度不符合",
						minlength:"长度不符合"
					},
					password:{
						required:"必填",
						minlength:"长度必须大于5位",
					},
					passwordConfirm:{
						required:"必填",
						equalTo:"两次密码输入不相同"
					},
					email:{
						required:"必填",
						email:"不符合邮箱地址格式"
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