<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
    <title>海大体育馆管理系统-查看赛事</title>
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
                        <li><a href="../site/addsite.jsp">添加场地</a></li>
                        <li><a href="../site/deletesite.jsp">删除场地</a></li>
                        <li><a href="../site/updatesite.jsp">更改场地</a></li>
                        <li><a href="../site/mchecksite.jsp">查看场地</a></li>
                    </ul>
                </li>
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
                
            </ul>
        </div>
    </div>

    <hr/>
    <!-- Main 在这里编辑正文内容-->
    <div id="main">
        <div id="title">
            <h2>查看赛事</h2>
        </div>

        <div class="searchorder">
            <form action="" method="post">
                赛事名：<input id="racename" type="text" />
                <input class="sumbtn" type="button" value="搜索赛事" onclick="racesearch()" />
            </form>
        </div>

        <!-- 显示状态信息 -->
        <div id="data"></div>

        <div id="siteorderlist">
            <table id="siteorder-table">
                <tr id="ordertitle">
                    <td class="race-name">赛事名</td>
                    <td class="race-time">赛事时间</td>
                    <td class="race-detail">赛事描述</td>
                </tr>
                <tr>
                    <td class="race-name" id="race-name0"></td>
                    <td class="race-time" id="race-time0"></td>
                    <td class="race-detail" id="race-detail0"></td>
                </tr>
                <tr id="race-1">
                    <td class="race-name" id="race-name1"></td>
                    <td class="race-time" id="race-time1"></td>
                    <td class="race-detail" id="race-detail1"></td>
                </tr>
                <tr id="race-2">
                    <td class="race-name" id="race-name2"></td>
                    <td class="race-time" id="race-time2"></td>
                    <td class="race-detail" id="race-detail2"></td>
                </tr>
                <tr id="race-3">
                    <td class="race-name" id="race-name3"></td>
                    <td class="race-time" id="race-time3"></td>
                    <td class="race-detail" id="race-detail3"></td>
                </tr>
                <tr id="race-4">
                    <td class="race-name" id="race-name4"></td>
                    <td class="race-time" id="race-time4"></td>
                    <td class="race-detail" id="race-detail4"></td>
                </tr>
                <tr id="race-5">
                    <td class="race-name" id="race-name5"></td>
                    <td class="race-time" id="race-time5"></td>
                    <td class="race-detail" id="race-detail5"></td>
                </tr>
                <tr id="race-6">
                    <td class="race-name" id="race-name6"></td>
                    <td class="race-time" id="race-time6"></td>
                    <td class="race-detail" id="race-detail6"></td>
                </tr>
                <tr id="race-7">
                    <td class="race-name" id="race-name7"></td>
                    <td class="race-time" id="race-time7"></td>
                    <td class="race-detail" id="race-detail7"></td>
                </tr>
                <tr id="race-8">
                    <td class="race-name" id="race-name8"></td>
                    <td class="race-time" id="race-time8"></td>
                    <td class="race-detail" id="race-detail8"></td>
                </tr>
                <tr id="race-9">
                    <td class="race-name" id="race-name9"></td>
                    <td class="race-time" id="race-time9"></td>
                    <td class="race-detail" id="race-detail9"></td>
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
<script src="../../js/race/findrace.js" type="text/javascript"></script>
</body>
</html>