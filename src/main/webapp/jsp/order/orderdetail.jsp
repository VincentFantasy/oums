<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-type" content="text/html; charset=utf-8" />
    <title>海大体育馆管理系统-查看订单详情</title>
    <link rel="stylesheet" href="../../css/style.css" type="text/css" media="all" />
    <link rel="stylesheet" href="../../css/site/basesite.css" type="text/css" />
    <link rel="stylesheet" href="../../css/order/orderdetail.css" type="text/css" />
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
        <div id="title">
            <h2>查看订单详情</h2>
        </div>

        <div id="content">
            <div class="text">
                订单号:<label id="ordernumber"></label>
            </div>
            <div class="text">
                订单类型:<label id="orderclass"></label>
            </div>
            <div class="text">
                订单状态:<label id="ordertype"></label>
            </div>
            <div class="text">
                订单生产时间:<label id="buildtime"></label>
            </div>
            <div class="text">
                用户备注:<label id="remark"></label>
            </div>
            <div class="text">
                管理员回复:<label id="reply"></label>
            </div>
            <div class="text">
                用户:<label id="userrealname"></label>
            </div>
            <div class="text">
                管理员:<label id="adminrealname"></label>
            </div>
            <div class="text">
                场地名:<label id="sitename"></label>
            </div>
            <!-- 器材赛事 到时自己加 -->

            <div id="datatext">123</div>
        </div>



        <div class="content-footer">
            <div class="title"><h2>操作订单</h2></div>
            <form action="" method="post">
                <div class="text">
                    回复内容:<textarea id="adminreply" rows="2" cols="20" ></textarea>
                </div>
                <div class="text" id="sumbtn-foot">
                    <input class="sumbtn" type="button" onclick="sureorder()" value="接收订单" />
                    <input class="sumbtn" type="button" onclick="rejectorder()" value="拒绝订单" />
                </div>
            </form>
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
<script src="../../js/order/orderdetail.js" type="text/javascript"></script>
</body>
</html>