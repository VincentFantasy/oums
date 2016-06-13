<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
    <title>海大体育馆管理系统-查看场地</title>
    <link rel="stylesheet" href="../../css/style.css" type="text/css" media="all" />
    <link rel="stylesheet" href="../../css/site/basesite.css" type="text/css" />
    <link rel="stylesheet" href="../../css/site/checksite.css" type="text/css" />
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
                        <li><a href="#">预约场地</a></li>
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
            <h2>查看场地</h2>
        </div>

        <div id="searchsite">
            <form action="" method="post">
                场地类型：<select id="siteType">
                <option value="1">羽毛球场</option>
                <option value="2">兵乓球场</option>
                <option value="3">桌球场</option>
                <option value="4">篮球场</option>
                <option value="5">网球场</option>
                </select>
                <input id="sumbtn" type="button" value="查找场地" onclick="sitesearch()" />
            </form>
            <!-- 显示状态信息 -->
            <div id="data"></div>
        </div>

        <div id="sitelist">
            <table id="site-table">
                <tr id="sitetitle">
                    <td class="site-name">场地名称</td>
                    <td class="site-type">场地类型</td>
                    <td class="site-cost">费用（元）</td>
                    <td class="site-dtail">场地描述</td>
                </tr>
                <tr>
                    <td class="site-name" id="site-name0"></td>
                    <td class="site-type" id="site-type0"></td>
                    <td class="site-cost" id="site-cost0"></td>
                    <td class="site-dtail" id="site-dtail0"></td>
                </tr>
                <tr id="site-1">
                    <td class="site-name" id="site-name1"></td>
                    <td class="site-type" id="site-type1"></td>
                    <td class="site-cost" id="site-cost1"></td>
                    <td class="site-dtail" id="site-dtail1"></td>
                </tr>
                <tr id="site-2">
                    <td class="site-name" id="site-name2"></td>
                    <td class="site-type" id="site-type2"></td>
                    <td class="site-cost" id="site-cost2"></td>
                    <td class="site-dtail" id="site-dtail2"></td>
                </tr>
                <tr id="site-3">
                    <td class="site-name" id="site-name3"></td>
                    <td class="site-type" id="site-type3"></td>
                    <td class="site-cost" id="site-cost3"></td>
                    <td class="site-dtail" id="site-dtail3"></td>
                </tr>
                <tr id="site-4">
                    <td class="site-name" id="site-name4"></td>
                    <td class="site-type" id="site-type4"></td>
                    <td class="site-cost" id="site-cost4"></td>
                    <td class="site-dtail" id="site-dtail4"></td>
                </tr>
                <tr id="site-5">
                    <td class="site-name" id="site-name5"></td>
                    <td class="site-type" id="site-type5"></td>
                    <td class="site-cost" id="site-cost5"></td>
                    <td class="site-dtail" id="site-dtail5"></td>
                </tr>
                <tr id="site-6">
                    <td class="site-name" id="site-name6"></td>
                    <td class="site-type" id="site-type6"></td>
                    <td class="site-cost" id="site-cost6"></td>
                    <td class="site-dtail" id="site-dtail6"></td>
                </tr>
                <tr id="site-7">
                    <td class="site-name" id="site-name7"></td>
                    <td class="site-type" id="site-type7"></td>
                    <td class="site-cost" id="site-cost7"></td>
                    <td class="site-dtail" id="site-dtail7"></td>
                </tr>
                <tr id="site-8">
                    <td class="site-name" id="site-name8"></td>
                    <td class="site-type" id="site-type8"></td>
                    <td class="site-cost" id="site-cost8"></td>
                    <td class="site-dtail" id="site-dtail8"></td>
                </tr>
                <tr id="site-9">
                    <td class="site-name" id="site-name9"></td>
                    <td class="site-type" id="site-type9"></td>
                    <td class="site-cost" id="site-cost9"></td>
                    <td class="site-dtail" id="site-dtail9"></td>
                </tr>
            </table>
        </div>

        <div id="main-footer">
            <input class="list-button" id="page-last" type="button" value="&lt" />
            <input class="list-button" id="page-next" type="button" value="&gt" />
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
<script src="../../js/site/checksite.js" type="text/javascript"></script>
</body>
</html>