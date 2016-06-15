<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
	<title>海大体育馆管理系统</title>
	<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/jsp/userManagement/admin";
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
            <h2>欢迎进入广东海洋大学体育馆系统</h2>
        </div>
        <div id="content">
        	<p>注册用户:</p>
		<form id="registerForm" action="${pageContext.request.contextPath}/userRegister.action" method="post">
		<ul class="list-group">
			<li class="list-group-item">
				<div class="form-group">
					<label>姓名</label>
					<input type="text" class="form-control" id="cusername" name="userVo.realName" placeholder=“请输入姓名”>
				</div>
			</li>
			<li class="list-group-item">
				<div class="form-group">
					<label>密码</label>
					<input type="password" class="form-control" id="cpassword" name="userVo.password" placeholder=“请输入密码(至少5位)”>
				</div>
			</li>
			<li class="list-group-item">
				<div class="form-group">
					<label>再次输入密码</label>
					<input type="password" class="form-control" id="cpasswordConfirm" name="passwordConfirm" placeholder=“请输入密码”>
				</div>
			</li>
			<li class="list-group-item">
				<div class="form-group">
					<label>手机</label>
					<input type="text" class="form-control" id="ctel" name="userVo.phone" placeholder=“请输入手机号码”>
				</div>
			</li>
			<li class="list-group-item">
				<div class="form-group">
					<label>身份证</label>
					<input type="text" class="form-control" id="cIdCardNumber" name="userVo.iDCardNumber" placeholder="请输入身份证">
				</div>
			</li>
			<li class="list-group-item">
				<div class="form-group">
					<label>证件号</label>
					<input type="text" class="form-control" id="cstudentNumber" name="userVo.certificateNumber" placeholder="请输入证件号">
				</div>
			</li>
			<li class="list-group-item">
				<div class="form-group">
					<label>是否游客</label>
					<select name="userVo.isTourist" class="selectpicker show-tick" id = "cperiod" onchange="isTourist(this.value)">
						<option></option>
						<option value = "TRUE">是</option>
						<option value = "FALSE">否</option>
					</select>
				</div>
			</li>
			<li class="list-group-item" id="period_li" style="">
				<div class="form-group">
					<label>入学年份</label>
					<input type="text" class="form-control" id="cstudentNumber" name="userVo.period" placeholder="请输入入学年份">
				</div>
			</li>
			<li class="list-group-item" id="classes_li" style="">
				<div class="form-group"  >
					<label>班级</label>
					<input type="text" class="form-control" id="cstudentNumber" name="userVo.classes" placeholder="请输入班级">
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
	<script src="../../js/jquery-2.2.3.min.js" type="text/javascript"></script>
	<script src="../../js/jquery.validate.min.js" type="text/javascript"></script>
	<script src="../../js/userManagement/validate.js" type="text/javascript"></script>
	<script type="text/javascript">
	function isTourist(value){
		var periodLi = document.getElementById("period_li");
		var classesLi = document.getElementById("classes_li");
		if(value === "TRUE"){
			periodLi.style.display="none";
			classesLi.style.display="none";
		}else{
			periodLi.style.display="block";
			classesLi.style.display="block";
		}
	};
	</script>
</body>
</html>