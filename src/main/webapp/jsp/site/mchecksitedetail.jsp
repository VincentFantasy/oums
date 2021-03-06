<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
    <title>海大体育馆管理系统-查看场地</title>
    <link rel="stylesheet" href="../../css/style.css" type="text/css" media="all" />
    <link rel="stylesheet" href="../../css/site/checksitedetail.css" type="text/css" />
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
                        <li><a href="dealordersite.jsp">场地订单</a></li>

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
        <!-- 显示状态信息 -->
        <div id="data"></div>
        <div id="sitedetail">
            <table id="site-table">
                <tr class="title">
                    <td class="site-name">场地名称</td>
                    <td class="site-type">场地类型</td>
                    <td class="site-cost">费用（元）</td>
                    <td class="site-dtail">场地描述</td>
                </tr>
                <tr id="site-0">
                    <td class="site-name" id="site-name0"></td>
                    <td class="site-type" id="site-type0"></td>
                    <td class="site-cost" id="site-cost0"></td>
                    <td class="site-dtail" id="site-dtail0"></td>
                </tr>
            </table>
        </div>

        <hr id="hrcenter" />

        <div id="weektitle">
            <h2>场地空闲情况</h2>
        </div>

        <div id="week">
            <table id="week-table">
                <tr class="title">
                    <td class="dayofweek" id="dayofweek">星期</td>
                    <td class="time">8:00 - 9:50</td>
                    <td class="time">10:00 - 11:50</td>
                    <td class="time">12:00 - 13:50</td>
                    <td class="time">14:00 - 15:50</td>
                    <td class="time">16:00 - 17:50</td>
                    <td class="time">18:00 - 19:50</td>
                </tr>
                <tr>
                    <td class="dayofweek">星期日</td>
                    <td class="time" id="time00"></td>
                    <td class="time" id="time01"></td>
                    <td class="time" id="time02"></td>
                    <td class="time" id="time03"></td>
                    <td class="time" id="time04"></td>
                    <td class="time" id="time05"></td>
                </tr>
                <tr>
                    <td class="dayofweek">星期一</td>
                    <td class="time" id="time10"></td>
                    <td class="time" id="time11"></td>
                    <td class="time" id="time12"></td>
                    <td class="time" id="time13"></td>
                    <td class="time" id="time14"></td>
                    <td class="time" id="time15"></td>
                </tr>
                <tr>
                    <td class="dayofweek">星期二</td>
                    <td class="time" id="time20"></td>
                    <td class="time" id="time21"></td>
                    <td class="time" id="time22"></td>
                    <td class="time" id="time23"></td>
                    <td class="time" id="time24"></td>
                    <td class="time" id="time25"></td>
                </tr>
                <tr>
                    <td class="dayofweek">星期三</td>
                    <td class="time" id="time30"></td>
                    <td class="time" id="time31"></td>
                    <td class="time" id="time32"></td>
                    <td class="time" id="time33"></td>
                    <td class="time" id="time34"></td>
                    <td class="time" id="time35"></td>
                </tr>
                <tr>
                    <td class="dayofweek">星期四</td>
                    <td class="time" id="time40"></td>
                    <td class="time" id="time41"></td>
                    <td class="time" id="time42"></td>
                    <td class="time" id="time43"></td>
                    <td class="time" id="time44"></td>
                    <td class="time" id="time45"></td>
                </tr>
                <tr>
                    <td class="dayofweek">星期五</td>
                    <td class="time" id="time50"></td>
                    <td class="time" id="time51"></td>
                    <td class="time" id="time52"></td>
                    <td class="time" id="time53"></td>
                    <td class="time" id="time54"></td>
                    <td class="time" id="time55"></td>
                </tr>
                <tr>
                    <td class="dayofweek">星期六</td>
                    <td class="time" id="time60"></td>
                    <td class="time" id="time61"></td>
                    <td class="time" id="time62"></td>
                    <td class="time" id="time63"></td>
                    <td class="time" id="time64"></td>
                    <td class="time" id="time65"></td>
                </tr>
            </table>
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
<script src="../../js/site/basesitetype.js" type="text/javascript"></script>
<script src="../../js/site/checksitedetail.js" type="text/javascript"></script>
</body>
</html>