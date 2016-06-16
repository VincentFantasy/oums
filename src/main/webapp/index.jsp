<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
	<title>海大体育馆管理系统</title>
	<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	%>
	<base href="<%=basePath%>">
	<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
	<link rel="stylesheet" href="css/index.css" type="text/css" />
</head>

<body>
	<div id="page" class="shell">
		<!-- Logo + Search + Navigation -->
		<div id="top">
			<div class="cl">&nbsp;</div>
			<h1 id="logo">
				<a href="#">OUMS</a>
			</h1>
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
					<li><a href="#"><span>个人信息</span></a>
						<ul>
							<li><a href="jsp/userManagement/user/userModifyPassword.jsp">修改密码</a></li>
						</ul>
					</li>
				</ul>
			</div>
		</div>

		<hr/>
		
		<!-- Header -->
    <div id="header">
        <!-- Slider -->
        <div id="slider">
            <div id="slider-holder">
                <ul>
                    <li>
                        <div class="slide-info">
                            <h2 class="notext txt-we-love-mondays">广东海洋大学体育馆官网</h2>
                            <p>欢迎进入广东海洋大学体育馆管理系统，</p>
                            <a href="#" class="button-more">更多</a>
                        </div>
                        <div class="slide-image">
                            <img src="images/ty5.jpg" alt="图片失效" />
                        </div>
                    </li>
                    <li>
                        <div class="slide-info">
                            <h2 class="notext txt-we-love-mondays">坚持运动</h2>
                            <p>每天运到一小时，健康长寿50年</p>
                            <a href="#" class="button-more">更多</a>
                        </div>
                        <div class="slide-image">
                            <img src="images/yundong.jpg" alt="图片失效" />
                        </div>
                    </li>
                    <li>
                        <div class="slide-info">
                            <h2 class="notext txt-we-love-mondays">放点图片</h2>
                            <p>广告位招租,有意请联系XXXXXXX</p>
                            <a href="#" class="button-more">更多</a>
                        </div>
                        <div class="slide-image">
                            <img src="images/ty6.png" alt="图片失效" />
                        </div>
                    </li>
                    <li>
                        <div class="slide-info">
                            <h2 class="notext txt-we-love-mondays">广告位招租</h2>
                            <p>广告位招租,有意请联系XXXXXXX</p>
                            <a href="#" class="button-more">更多</a>
                        </div>
                        <div class="slide-image">
                            <img src="images/chijing.jpg" alt="图片失效" />
                        </div>
                    </li>
                </ul>
            </div>
            <div class="slider-nav">
                <a href="#" class="prev">Previous</a>
                <a href="#" class="next">Next</a>
            </div>
        </div>
        <!-- END Slider -->
    </div>
    <!-- END Header -->
    
    <hr/>
		
		<!-- Main 在这里编辑正文内容-->
		<div id="main">
            
        <div>
			<h2>欢迎你 </h2>
            <input style='border-left:0px;border-top:0px;border-right:0px;border-bottom:1px ' 
            	value="${session.userVo.getRealName()}" readOnly="true"/>
				
        </div>
        <div id="content">
        	<p>系统消息:</p>
			<div class="SystemMessage">
				
			</div>
        </div>
        
        <div class="text"><h3 id="gonggao0"></h3></div>
        <div class="text"><h3 id="gonggao1"></h3></div>
        <div class="text"><h3 id="gonggao2"></h3></div>
        <div class="text"><h3 id="gonggao3"></h3></div>
        <div class="text"><h3 id="gonggao4"></h3></div>
        <div class="text"><h3 id="gonggao5"></h3></div>
        <div class="text"><h3 id="gonggao6"></h3></div>
        <div class="text"><h3 id="gonggao7"></h3></div>
        <div class="text"><h3 id="gonggao8"></h3></div>
        <div class="text"><h3 id="gonggao9"></h3></div>

        <!-- <div id="main-footer">
            <input class="list-button" id="page-last" type="button" value="&lt" onclick="subpage()" />
            <label id="pageNum">1</label>
            <input class="list-button" id="page-next" type="button" value="&gt" onclick="addpage()" />
        </div> -->
        <div id="text"></div>
        
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
    <script src="js/jquery-1.4.1.min.js" type="text/javascript"></script>
    <script src="js/jquery.jcarousel.pack.js" type="text/javascript"></script>
    <script src="js/jquery-func.js" type="text/javascript"></script>
    <script src="js/index.js" type="text/javascript" ></script>
</body>
</html>
