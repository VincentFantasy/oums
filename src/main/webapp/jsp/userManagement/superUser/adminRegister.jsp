<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
	<title>海大体育馆管理系统-超级用户端</title>
	<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/jsp/userManagement/superUser";
	%>
	<base href="<%=basePath%>">
	<link rel="stylesheet" href="../../css/style.css" type="text/css" media="all" />
	<link href="../../css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
	<div id="page" class="shell">
		<!-- Logo + Search + Navigation -->
		<div id="top">
			<div class="cl">&nbsp;</div>
			<h1 id="logo">
				<a href="index.jsp">OUMS</a>
			</h1>
			<!-- 搜索不要没时间做 -->
			<!--<form action="" method="post" id="search">
			<div class="field-holder">
				<input type="text" class="field" value="Search" title="Search" />
			</div>
			<input type="submit" class="button" value="Search" />
			<div class="cl">&nbsp;</div>
		</form>-->
			<div class="cl">&nbsp;</div>
			<div id="navigation">
				<ul>
					<li><a href="index.jsp" class="active"><span>首页</span></a></li>
					<li><a href="jsp/site/site.jsp"><span>场地</span></a>
						<ul>
							<li><a href="#">预约场地</a></li>
							<li><a href="jsp/site/checksite.jsp">查看场地</a></li>
						</ul>
					</li>
					<li><a href="#"><span>器材</span></a>
						<ul>
							<li><a href="#">about us</a></li>
							<li><a href="#">services</a></li>
							<li><a href="#">solutions</a></li>
							<li><a href="#">support</a></li>
							<li><a href="#">partners</a></li>
							<li><a href="#">contact</a></li>
						</ul>
					</li>
					<li><a href="#"><span>赛事</span></a>
						<ul>
							<li><a href="#">about us</a></li>
							<li><a href="#">services</a></li>
							<li><a href="#">solutions</a></li>
							<li><a href="#">support</a></li>
							<li><a href="#">partners</a></li>
							<li><a href="#">contact</a></li>
						</ul>
					</li>
					<li><a href="#"><span>订单</span></a>
						<ul>
							<li><a href="#">场地订单</a></li>
							<li><a href="#">services</a></li>
							<li><a href="#">solutions</a></li>
							<li><a href="#">support</a></li>
							<li><a href="#">partners</a></li>
							<li><a href="#">contact</a></li>
						</ul>
					</li>
					<li><span>个人信息</span>
						<ul>
							<li><a href="jsp/userManagement/user/userModifyPassword.jsp">修改密码</a></li>
						</ul>
					</li>
					<li><a href="#"><span>财务</span></a>
						<ul>
							<li><a href="#">about us</a></li>
							<li><a href="#">services</a></li>
							<li><a href="#">solutions</a></li>
							<li><a href="#">support</a></li>
							<li><a href="#">partners</a></li>
							<li><a href="#">contact</a></li>
						</ul>
					</li>
				</ul>
			</div>
		</div>

		<hr/>
		<!-- Main 在这里编辑正文内容-->
		<div id="main">
			<div id="title">
        </div>
        <div id="content">
        	<p>注册管理员用户:</p>
		<form id="registForm" action="${pageContext.request.contextPath}/adminRegister.action" method="post">
		<ul class="list-group">
			<li class="list-group-item">
				<div class="form-group">
					<label>姓名</label>
					<input type="text" class="form-control" id="cusername" name="adminVo.realName" placeholder=“请输入姓名”>
				</div>
			</li>
			<li class="list-group-item">
				<div class="form-group">
					<label>密码</label>
					<input type="text" class="form-control" id="cpassword" name="adminVo.password" placeholder=“请输入密码(至少5位)”>
				</div>
			</li>
			<li class="list-group-item">
				<div class="form-group">
					<label>再次输入密码</label>
					<input type="text" class="form-control" id="cpasswordConfirm" name="passwordConfirm" placeholder=“请输入再密码”>
				</div>
			</li>
			<li class="list-group-item">
				<div class="form-group">
					<label>手机</label>
					<input type="text" class="form-control" id="cphone" name="adminVo.phone" placeholder=“请输入手机号码”>
				</div>
			</li>
			<li class="list-group-item">
				<div class="form-group">
					<label>身份证</label>
					<input type="text" class="form-control" id="cIdCardNumber" name="adminVo.IDCardNumber" placeholder="请输入身份证">
				</div>
			</li>
			<li class="list-group-item">
				<div class="form-group">
					<label>员工号</label>
					<input type="text" class="form-control" id="cstudentNumber" name="adminVo.employeeNumber" placeholder="请输入员工号">
				</div>
			</li>
			<li class="list-group-item">
				<div class="form-group">
					<label>权限</label>
					<select name="adminVo.permission" class="selectpicker show-tick">
						<option></option>
						<option value = "1">用户管理员</option>
						<option value = "2">财务管理员</option>
						<option value = "3">场地管理员</option>
						<option value = "4">器材管理员</option>
						<option value = "5">赛事管理员</option>
					</select>
				</div>
			</li>
		</ul>
		<button type="submit" class="btn btn-primary btn-sm">提交</button>
	</form>
        </div>
		</div>
		<!-- END Main -->
		<hr/>

		<!-- Footer -->
		<div id="footer">
			<p class="right">
				&copy; 软件1131第九小组 &nbsp; Design by <a href="#" target="_blank" title="">VincentFantasy</a>
			</p>
			<p>
				<a href="index.html">首页</a><span>&nbsp;</span>
				<a href="#">关于我们</a><span>&nbsp;</span>
				<a href="#">更多服务</a><span>&nbsp;</span>
				<a href="#">解决方案</a><span>&nbsp;</span>
				<a href="#">支持</a><span>&nbsp;</span>
				<a href="#">合作伙伴</a><span>&nbsp;</span>
				<a href="#">联系方式</a>
			</p>
			<div class="cl">&nbsp;</div>
		</div>

		<!-- END Footer -->
		<br />
	</div>
	
	<!-- js -->
	<script src="js/jquery-2.2.3.min.js" type="text/javascript"></script>
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