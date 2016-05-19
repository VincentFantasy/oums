<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/jquery.js" type="text/javascript"></script>
<script src="bootstrap-3.3.5/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.js"></script>
<link href="bootstrap-3.3.5/css/bootstrap.min.css" rel="stylesheet">


<title>Regist</title>
</head>

<body>
	<form id="registForm" role="form" action="javascript:alert('验证成功,可以提交.');">
		<ul class="list-group">
			<li class="list-group-item">
				<div class="form-group">
					<label>用户名</label>
					<input type="text" class="form-control" id="username" placeholder=“请输入用户名”>
				</div>
			</li>
			<li class="list-group-item">
				<div class="form-group">
					<label>密码</label>
					<input type="text" class="form-control" id="password1" placeholder=“请输入密码(至少5位)”>
				</div>
			</li>
			<li class="list-group-item">
				<div class="form-group">
					<label>再次输入密码</label>
					<input type="text" class="form-control" id="password2" placeholder=“请输入密码”>
				</div>
			</li>
			<li class="list-group-item">
				<div class="form-group">
					<label>手机</label>
					<input type="text" class="form-control" id="tel" placeholder=“请输入手机号码”>
				</div>
			</li>
			<li class="list-group-item">
				<div class="form-group">
					<label>邮箱</label>
					<input type="text" class="form-control" id="email" placeholder=“请输入邮箱”>
				</div>
			</li>
		</ul>
		<div class="form-group"> 
			<button type="submit" class="btn btn-primary btn-sm">提交</button>
		</div> 
	</form>
	<script type="text/javascript">
		$(document).ready(function(){
			console.log("1");
			$("#registForm").validate({
				debug: true,
				onfocusout: false,
				focusCleanup: true,
				onkeyup:false, 
				onsubmit: false,
				rules:{
					username:{
						required:true
					},
					password1:{
						required:true,
						minlength:5
					},
					email:{
						required:true,
						email:true
					}
				},
				message:{
					username:"必填"
				},
				highlight: function(element){
					$(element).closest('.form-group').addClass('has-error');
				},
				submitHandler:function(){
					alert("succeed!")
				}
			});
			console.log("2");
		})
	</script>
</body>
</html>