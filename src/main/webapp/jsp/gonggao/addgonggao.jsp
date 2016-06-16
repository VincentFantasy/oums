<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
    <title>海大体育馆管理系统-添加场地</title>
    <link rel="stylesheet" href="../../css/style.css" type="text/css" media="all" />
    <link rel="stylesheet" href="../../css/site/basesite.css" type="text/css" />
    <link rel="stylesheet" href="../../css/gonggao/addgonggao.css" type="text/css" />
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
                <li><a href="#"><span>场地</span></a>
                    <ul>
                        <li><a href="../site/addsite.jsp">添加场地</a></li>
                        <li><a href="../site/deletesite.jsp">删除场地</a></li>
                        <li><a href="../site/updatesite.jsp">更改场地</a></li>
                        <li><a href="../site/mchecksite.jsp">查看场地</a></li>
                    </ul>
                <li><a href="#"><span>器材</span></a>
                    <ul>
                        
                    </ul>
                </li>
                <li><a href="#"><span>赛事</span></a>
                    <ul>
                         <li><a href="../race/findrace.jsp">查看赛事</a></li>
                    </ul>
                </li>
                <li><a href="#"><span>订单</span></a>
                    <ul>
                        <li><a href="../order/dealordersite.jsp">场地订单</a></li>
                        
                    </ul>
                </li>
                <li><a href="#"><span>个人信息</span></a>
                    <ul>
                       
                    </ul>
                </li>
                <li><a href="#"><span>财务</span></a>
                    <ul>
                        
                    </ul>
                </li>
                <li><a href="#"><span>公告</span></a>
						<ul>
							<li><a href="../gonggao/addgonggao.jsp">添加公告</a></li>
							<li><a href="../gonggao/deletegonggao.jsp">删除公告</a></li>
						</ul>
				</li>
            </ul>
        </div>
    </div>

    <hr/>
    <!-- Main 在这里编辑正文内容-->
    <div id="main">
        <div id="title">
            <h2>添加公告</h2>
        </div>
        <div id="content">
            <form id="addgonggaoform" action="" method="post">
                <div class="text">
                    公告标题:<input class="itext" id="gonggaoTitile" name="gonggao.gonggaoTitile" type="text" />
                </div>

                公告内容:<div class="text">
                    <textarea id="gonggaodetail" name="gonggao.gonggaoDtail" ></textarea>
                </div>
                <div class="text">
                    <input id="sumbtn" class="sumbtn" type="submit" value="添加" onclick="sumbitform()" />
                </div>

                
            </form>
            
            <div id="datatext"></div>
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
<script src="../../js/gonggao/addgonggao.js" type="text/javascript"></script>
</body>
</html>