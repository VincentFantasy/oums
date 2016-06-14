<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
    <title>海大体育馆管理系统-添加场地</title>
    <link rel="stylesheet" href="../../css/style.css" type="text/css" media="all" />
    <link rel="stylesheet" href="../../css/site/basesite.css" type="text/css" />
    <link rel="stylesheet" href="../../css/site/addsite.css" type="text/css" />
</head>
<body>
<div id="page" class="shell">
    <!-- Logo + Search + Navigation -->
    <div id="top">
        <div class="cl">&nbsp;</div>
        <h1 id="logo">
            <a href="../../index-m.jsp">OUMS</a>
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
                <li><a href="../../index-m.jsp" class="active"><span>首页</span></a></li>
                <li><a href="site.jsp"><span>场地</span></a>
                    <li><a href="#"><span>场地</span></a>
						<ul>
							<li><a href="checksite.jsp">查看场地</a></li>
							<li><a href="addsite.jsp">添加场地</a></li>
							<li><a href="deletesite.jsp">删除场地</a></li>
							<li><a href="updatesite.jsp">更改场地</a></li>
							<li><a href="checksite.jsp">查看场地</a></li>
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
                        <li><a href="#">about us</a></li>
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
            </ul>
        </div>
    </div>

    <hr/>
    <!-- Main 在这里编辑正文内容-->
    <div id="main">
        <div id="title">
            <h2>添加场地</h2>
        </div>
        <div id="content">
            <form id="addsiteform" action="" method="post">
                <div class="text">
                    场地名:<input class="itext" id="sitename" name="sitename" type="text" /> * 长度不能超过16个字符
                </div>

                <div class="text">
                    价格(小时):<input class="itext" name="sitecost" id="sitecost" type="text" /> * 必须为数字
                </div>

                <div class="text">
                    场地类型:<select id="sitetype" name="sitetype">
                    <option value="1">羽毛球场</option>
                    <option value="2">兵乓球场</option>
                    <option value="3">桌球场</option>
                    <option value="4">篮球场</option>
                    <option value="5">网球场</option>
                </select>
                </div>
                <div class="text">
                    场地备注:<input class="itext" id="sitedtail" name="sitedtail" type="text" />可不填
                </div>
                <div class="text">
                    <input class="sumbtn" type="submit" value="添加" onclick="valid()" />
                </div>

                <div id="datatext"></div>
            </form>
        </div>
    </div>

    <!-- Footer -->
    <div id="footer">
        <p class="right">
            &copy; 软件1131第九小组 &nbsp; Design by <a href="#" title="">VincentFantasy</a>
        </p>
        <p>
            <a href="../../index-m.jsp">首页</a><span>&nbsp;</span>
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
<script src="../../js/site/addsite.js" type="text/javascript"></script>
</body>
</html>