<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
	<title>海大体育馆管理系统</title>
	<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/jsp/userManagement/user";
	%>
	<base href="<%=basePath%>">
	<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
	<link rel="stylesheet" href="css/site/addsite.css" type="text/css" />
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
					<li><a href="#"><span>个人信息</span></a>
						<ul>
							<li><a href="#">修改密码</a></li>
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
			修改密码
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
</body>
</html>