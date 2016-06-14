<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
    <title>海大体育馆管理系统-预约场地</title>
    <link rel="stylesheet" href="../../css/style.css" type="text/css" media="all" />
    <link rel="stylesheet" href="../../css/site/basesite.css" type="text/css" />
    <link rel="stylesheet" href="../../css/site/ordersite.css" type="text/css" />
</head>
<body>
<div id="page" class="shell">
    <!-- Logo + Search + Navigation -->
    <div id="top">
        <div class="cl">&nbsp;</div>
        <h1 id="logo">
            <a href="../../index.jsp">OUMS</a>
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
                <li><a href="../../index.jsp" class="active"><span>首页</span></a></li>
                <li><a href="site.jsp"><span>场地</span></a>
                    <ul>
                        <li><a href="ordersite.jsp">预约场地</a></li>
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
            <h2>预约场地</h2>
        </div>

        <div id="content">
            <form id="orderform" action="" method="post">
                <div class="text">
                    场地名:<input class="itext" id="sitename" name="sitename" type="text" />
                </div>
                <div class="text">
                    选择时间
                </div>
                <div class="text">
                    星期:<select id="dayofweek" name="day.dayOfWeek">
                    <option value="0">星期天</option>
                    <option value="1">星期一</option>
                    <option value="2">星期二</option>
                    <option value="3">星期三</option>
                    <option value="4">星期四</option>
                    <option value="5">星期五</option>
                    <option value="6">星期六</option>
                </select>
                </div>
                <div class="text">
                    时间段：<select id="timeofday" name="timeInDay">
                    <option value="0">8:00 - 9:50</option>
                    <option value="1">10:00 - 11:50</option>
                    <option value="2">12:00 - 13:50</option>
                    <option value="3">14:00 - 15:50</option>
                    <option value="4">16:00 - 17:50</option>
                    <option value="5">18:00 - 19:50</option>
                </select>
                </div>
                <div class="text" id="textarea">
                	 备注：<textarea id="remark" name="order.remark" rows="2" cols="20"></textarea>
                </div>
                <div class="text">
                    <input class="sumbtn" type="button" value="预约" onclick="sumbitform()" />
                </div>
            </form>
            <div id="datatext"></div>
        </div>

    </div>
    <!-- END Main -->
    <hr/>

    <!-- Footer -->
    <div id="footer">
        <p class="right">
            &copy; 软件1131第九小组 &nbsp; Design by <a href="#" title="">VincentFantasy</a>
        </p>
        <p>
            <a href="../../index.jsp">首页</a><span>&nbsp;</span>
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
<script src="../../js/site/ordersite.js" type="text/javascript"></script>
</body>
</html>