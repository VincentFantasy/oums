<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<title>海大体育馆管理系统-超级用户版</title>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/jsp/userManagement/superUser";
%>
<base href="<%=basePath%>">
<link href="../../css/style.css" rel="stylesheet" type="text/css"
	media="all" />
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
							<li><a href="jsp/site/checksite.jsp">查看场地</a></li>
							<li><a href="jsp/site/addsite.html">添加场地</a></li>
							<li><a href="#">删除场地</a></li>
							<li><a href="#">更改场地</a></li>
							<li><a href="jsp/site/checksite.jsp">查看场地</a></li>
							<li><a href="#">改变场地状态</a></li>
						</ul></li>
					<li><a href="#"><span>器材</span></a>
						<ul>
							<li><a href="#">about us</a></li>
							<li><a href="#">services</a></li>
							<li><a href="#">solutions</a></li>
							<li><a href="#">support</a></li>
							<li><a href="#">partners</a></li>
							<li><a href="#">contact</a></li>
						</ul></li>
					<li><a href="#"><span>赛事</span></a>
						<ul>
							<li><a href="#">about us</a></li>
							<li><a href="#">services</a></li>
							<li><a href="#">solutions</a></li>
							<li><a href="#">support</a></li>
							<li><a href="#">partners</a></li>
							<li><a href="#">contact</a></li>
						</ul></li>
					<li><a href="#"><span>订单</span></a>
						<ul>
							<li><a href="#">场地订单</a></li>
							<li><a href="#">services</a></li>
							<li><a href="#">solutions</a></li>
							<li><a href="#">support</a></li>
							<li><a href="#">partners</a></li>
							<li><a href="#">contact</a></li>
						</ul></li>
					<li><a href="#"><span>个人信息</span></a>
						<ul>
							<li><a href="#">about us</a></li>
							<li><a href="#">services</a></li>
							<li><a href="#">solutions</a></li>
							<li><a href="#">support</a></li>
							<li><a href="#">partners</a></li>
							<li><a href="#">contact</a></li>
						</ul></li>
					<li><a href="#"><span>财务</span></a>
						<ul>
							<li><a href="#">about us</a></li>
							<li><a href="#">services</a></li>
							<li><a href="#">solutions</a></li>
							<li><a href="#">support</a></li>
							<li><a href="#">partners</a></li>
							<li><a href="#">contact</a></li>
						</ul></li>
				</ul>
			</div>
		</div>

		<hr />
		<!-- Main 在这里编辑正文内容-->
		<div id="main">
			<form id="deleteUser" action="${pageContext.request.contextPath}/deleteUser.action" method="post">
				<table class="table table-striped">
					<caption>用户列表</caption>
					<thead>
						<tr>
							<th>姓名</th>
							<th>身份证号</th>
							<th>证件号</th>
							<th>电话号码</th>
							<th>入学年份</th>
							<th>班级</th>
							<th>是否游客</th>
							<th>选择</th>
						</tr>
					</thead>
					<c:forEach items="${requestScope.userArray}" var="user" varStatus="status">
						<tr>
							<td>${user.realName}</td>
							<td>${user.IDCardNumber}</td>
							<td>${user.certificateNumber}</td>
							<td>${user.phone}</td>
							<td>${user.period}</td>
							<td>${user.classes}</td>
							<td>${user.isTourist}</td>
							<td><input type="checkbox" value = "${status.count-1}" name="deleteUserCheckboxList" type="text" /></td>
							<td><input type="text"  value ="${user.certificateNumber}" name="userCerNumList" type="text" /></td>
							<!--  <td><input type="text"  value ="${status.count-1}" name="index" class=" type="text" /></td>
							<td><input type="text"  value ="${user.certificateNumber}" name="deleteUserList[${status.count-1}].certificateNumber" type="text" /></td>
							-->
						</tr>
					</c:forEach>
				</table>
				<input type="submit" value="删除"/>
			</form>
			<p>查询用户</p>
			<form id="searchUser"
				action="${pageContext.request.contextPath}/searchUser.action"
				method="post">
				<div class="text">
					入学年份:<input class="itext" id="period" name="userVo.period"
						type="text" />
				</div>
				<div class="text">
					班级:<input class="itext" id="classes" name="userVo.classes"
						type="text" />
				</div>
				<div class="text">
					是否游客:<input type="checkbox" id="isTourist" name="userVo.isTourist"
						type="text" />
				</div>
				<div class="text">
					证件号:<input class="itext" id="cerNum" name="userVo.cerNum"
						type="text" />
				</div>
				<div class="text">
					<input id="sumbtn" type="submit" value="查询" />
				</div>
			</form>
		</div>
		<!-- END Main -->
		<hr />

		<!-- Footer -->
		<div id="footer">
			<p class="right">
				&copy; 软件1131第九小组 &nbsp; Design by <a href="#" target="_blank"
					title="">VincentFantasy</a>
			</p>
			<p>
				<a href="index.html">首页</a><span>&nbsp;</span> <a href="#">关于我们</a><span>&nbsp;</span>
				<a href="#">更多服务</a><span>&nbsp;</span> <a href="#">解决方案</a><span>&nbsp;</span>
				<a href="#">支持</a><span>&nbsp;</span> <a href="#">合作伙伴</a><span>&nbsp;</span>
				<a href="#">联系方式</a>
			</p>
			<div class="cl">&nbsp;</div>
		</div>

		<!-- END Footer -->
		<br />
	</div>

	<!-- js -->
	
	<script type="text/javascript">
		function getValue(){
			var el = document.getElementsByClassName('foo');
			return el;
		}
	</script>

	<script src="../js/jquery-2.2.3.min.js" type="text/javascript"></script>
</body>
</html>