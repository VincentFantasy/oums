<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
    <title>海大体育馆管理系统-查看订单</title>
    <link rel="stylesheet" href="../../css/style.css" type="text/css" media="all" />
    <link rel="stylesheet" href="../../css/site/basesite.css" type="text/css" />
    <link rel="stylesheet" href="../../css/order/dealordersite.css" type="text/css" />
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
                        <li><a href="mysiteorder.jsp">场地订单</a></li>
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
            <h2>查看场地订单</h2>
        </div>

        <!-- 显示状态信息 -->
        <div id="data"></div>

        <div id="siteorderlist">
            <table id="siteorder-table">
                <tr id="ordertitle">
                    <td class="order-name">订单编号</td>
                    <td class="order-type">订单类型</td>
                    <td class="order-class">订单状态</td>
                    <td class="order-time">订单生成时间</td>
                </tr>
                <tr>
                    <td class="order-name" id="order-name0"></td>
                    <td class="order-type" id="order-type0"></td>
                    <td class="order-class" id="order-class0"></td>
                    <td class="order-time" id="order-time0"></td>
                </tr>
                <tr id="site-1">
                    <td class="order-name" id="order-name1"></td>
                    <td class="order-type" id="order-type1"></td>
                    <td class="order-class" id="order-class1"></td>
                    <td class="order-time" id="order-time1"></td>
                </tr>
                <tr id="site-2">
                    <td class="order-name" id="order-name2"></td>
                    <td class="order-type" id="order-type2"></td>
                    <td class="order-class" id="order-class2"></td>
                    <td class="order-time" id="order-time2"></td>
                </tr>
                <tr id="site-3">
                    <td class="order-name" id="order-name3"></td>
                    <td class="order-type" id="order-type3"></td>
                    <td class="order-class" id="order-class3"></td>
                    <td class="order-time" id="order-time3"></td>
                </tr>
                <tr id="site-4">
                    <td class="order-name" id="order-name4"></td>
                    <td class="order-type" id="order-type4"></td>
                    <td class="order-class" id="order-class4"></td>
                    <td class="order-time" id="order-time4"></td>
                </tr>
                <tr id="site-5">
                    <td class="order-name" id="order-name5"></td>
                    <td class="order-type" id="order-type5"></td>
                    <td class="order-class" id="order-class5"></td>
                    <td class="order-time" id="order-time5"></td>
                </tr>
                <tr id="site-6">
                    <td class="order-name" id="order-name6"></td>
                    <td class="order-type" id="order-type6"></td>
                    <td class="order-class" id="order-class6"></td>
                    <td class="order-time" id="order-time6"></td>
                </tr>
                <tr id="site-7">
                    <td class="order-name" id="order-name7"></td>
                    <td class="order-type" id="order-type7"></td>
                    <td class="order-class" id="order-class7"></td>
                    <td class="order-time" id="order-time7"></td>
                </tr>
                <tr id="site-8">
                    <td class="order-name" id="order-name8"></td>
                    <td class="order-type" id="order-type8"></td>
                    <td class="order-class" id="order-class8"></td>
                    <td class="order-time" id="order-time8"></td>
                </tr>
                <tr id="site-9">
                    <td class="order-name" id="order-name9"></td>
                    <td class="order-type" id="order-type9"></td>
                    <td class="order-class" id="order-class9"></td>
                    <td class="order-time" id="order-time9"></td>
                </tr>
            </table>
        </div>

        <div id="main-footer">
            <input class="list-button" id="page-last" type="button" value="&lt" onclick="subpage()" />
            <label id="pageNum">1</label>
            <input class="list-button" id="page-next" type="button" value="&gt" onclick="addpage()" />
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
<script src="../../js/order/baseorder.js" type="text/javascript"></script>
<script src="../../js/order/mysiteorder.js" type="text/javascript"></script>
</body>
</html>