<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
	<title>海大体育馆管理系统-管理员版</title>
	<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
</head>

<body>
	<div id="page" class="shell">
		<!-- Logo + Search + Navigation -->
		<div id="top">
			<div class="cl">&nbsp;</div>
			<h1 id="logo">
				<a href="#">OUMS</a>
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
					<li><a href="index-m.jsp" class="active"><span>首页</span></a></li>
					<li id = "siteLi" style = "display:none"><a href="#"><span>场地</span></a>
						<ul>
							<li><a href="jsp/site/addsite.jsp">添加场地</a></li>
							<li><a href="jsp/site/deletesite.jsp">删除场地</a></li>
							<li><a href="jsp/site/updatesite.jsp">更改场地</a></li>
							<li><a href="jsp/site/mchecksite.jsp">查看场地</a></li>
						</ul>
					</li>
					<li id = "equipmentLi" style = "display:none"><a href="#"><span>器材</span></a>
						<ul>
							<li><a href="jsp/equipment/equipmentFind.jsp">器材查询</a></li>
							<li><a href="jsp/equipment/equipmentAdd.jsp">添加器材</a></li>
							<li><a href="jsp/equipment/equipmentUpdate.jsp">修改器材</a></li>
							<li><a href="jsp/equipment/equipmentDel.jsp">删除器材</a></li>
						</ul>
					</li>
					<li id = "matchLi" style = "display:none"><a href="#"><span>赛事</span></a>
						<ul>
							<li><a href="jsp/race/findrace.jsp">查找赛事</a></li>			
						</ul>
					</li>
					<li id = "orderLi" style = "display:none"><a href="#"><span>订单</span></a>
						<ul>
							<li><a href="jsp/order/dealordersite.jsp">场地订单</a></li>

						</ul>
					</li>
					<li id = "financyLi" style="display:none"><a href="#"><span>财务</span></a>
						<ul>

						</ul>
					</li>
					<li id = "userManagementLi" style = "display:none"><a href="#"><span>用户管理</span></a>
						<ul>
							<li id = "userManagementLi1" style = "display:none"><a href="jsp/userManagement/admin/userRegister.jsp">注册用户</a></li>
							<li id = "userManagementLi2" style = "display:none"><a href="jsp/userManagement/admin/searchUser.jsp">查询用户</a></li>
							<li id = "userManagementLi3" style = "display:none"><a href="jsp/userManagement/superUser/adminRegister.jsp">注册管理员用户</a></li>
							<li id = "userManagementLi4" style = "display:none"><a href="jsp/userManagement/superUser/searchAdminUser.jsp">查询管理员用户</a></li>
						</ul>
					</li>
					<li><a href="#"><span>个人信息</span></a>
						<ul>
							<li><a href="jsp/userManagement/admin/adminModifyPassword.jsp">修改密码</a></li>
						</ul>
					</li>
					<li id = "gonggaoLi" style = "display:none"><a href="#"><span>公告</span></a>
						<ul>
							<li><a href="jsp/gonggao/addgonggao.jsp">添加公告</a></li>
							<li><a href="jsp/gonggao/deletegonggao.jsp">删除公告</a></li>
						</ul>
					</li>
				</ul>
			</div>
		</div>

		<hr/>
		<!-- Main 在这里编辑正文内容-->
		<div id="main">
				欢迎你
				<input style='border-left:0px;border-top:0px;border-right:0px;border-bottom:1px ' 
					value="${session.adminVo.getRealName()}" readOnly="true"/>
        </div>
        <div id="content">
        	<p>系统消息:</p>
			<div class="SystemMessage">
				
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
				<a href="index-m.html">首页</a><span>&nbsp;</span>
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
	window.onload = setIndex;
	function setIndex(){
		var siteLi = document.getElementById("siteLi");
		var equipmentLi = document.getElementById("equipmentLi");
		var orderLi = document.getElementById("orderLi");
		var matchLi = document.getElementById("matchLi");
		var financyLi = document.getElementById("financyLi");
		var userManagementLi = document.getElementById("userManagementLi");
		var gonggaoLi = document.getElementById("gonggaoLi");
		var adminVoString = '<%=session.getAttribute("adminVo")%>';
		var adminVo = JSON.parse('{'+adminVoString+'}');
		console.log(adminVo.permission);
		if(adminVo.permission == 1){
			userManagementLi.style.display="block";
			userManagementLi1.style.display="block";
			userManagementLi2.style.display="block";
			gonggaoLi.style.display="block";
		}
		if(adminVo.permission == 2){
			financyLi.style.display="block";
		}
		if(adminVo.permission == 3){
			siteLi.style.display="block";
		}
		if(adminVo.permission == 4){
			equipmentLi.style.display="block";
		}
		if(adminVo.permission == 5){
			matchLi.style.display="block";
		}
		if(adminVo.permission == 6){
			userManagementLi.style.display="block";
			userManagementLi3.style.display="block";
			userManagementLi4.style.display="block";
		}
	};
	</script>
</body>
</html>