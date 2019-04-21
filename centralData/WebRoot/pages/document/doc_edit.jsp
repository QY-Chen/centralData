<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- start: Mobile Specific -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- end: Mobile Specific -->

    <!-- start: CSS -->
    <link id="bootstrap-style" href="../../resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="../../resources/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
    <link id="base-style" href="../../resources/bootstrap/css/style.css" rel="stylesheet">
    <link id="base-style-responsive" href="../../resources/bootstrap/css/style-responsive.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&subset=latin,cyrillic-ext,latin-ext' rel='stylesheet' type='text/css'>
    <link href="../../resources/css/querydata.css" rel="stylesheet">
    <!-- end: CSS -->

    <!-- data picker-->
    <script src="../../resources/js/My97DatePicker/WdatePicker.js"></script>

    <!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <link id="ie-style" href="../../resources/bootstrap/css/ie.css" rel="stylesheet">
    <![endif]-->

    <!--[if IE 9]>
    <link id="ie9style" href="../../resources/bootstrap/css/ie9.css" rel="stylesheet">
    <![endif]-->

    <!-- start: Favicon -->
    <link rel="shortcut icon" href="../../resources/bootstrap/img/favicon.ico">
    <!-- end: Favicon -->




</head>

<body>
<!-- start: Header -->
<div class="navbar">
    <div class="navbar-inner" style="min-height: 120px;">
        <div class="container-fluid">
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".top-nav.nav-collapse,.sidebar-nav.nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <a class="brand" href="index.html">
                <span class="avatar"><img style="margin-top: 0px; height: 80px;width: 80px" src="../../resources/images/timg.jpg" alt="Avatar"></span>
                <span>空调节能控制与能耗监测系统</span></a>
            <!-- start: Header Menu -->
            <div class="nav-no-collapse header-nav">
                <ul class="nav pull-right">
                    <li class="dropdown hidden-phone">
                        <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
                            <i class="icon-bell"></i>
                            <span class="badge red">
								7 </span>
                        </a>
                        <ul class="dropdown-menu notifications">
                            <li class="dropdown-menu-title">
                                <span>You have 11 notifications</span>
                                <a href="#refresh"><i class="icon-repeat"></i></a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="icon blue"><i class="icon-user"></i></span>
                                    <span class="message">New user registration</span>
                                    <span class="time">1 min</span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="icon green"><i class="icon-comment-alt"></i></span>
                                    <span class="message">New comment</span>
                                    <span class="time">7 min</span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="icon green"><i class="icon-comment-alt"></i></span>
                                    <span class="message">New comment</span>
                                    <span class="time">8 min</span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="icon green"><i class="icon-comment-alt"></i></span>
                                    <span class="message">New comment</span>
                                    <span class="time">16 min</span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="icon blue"><i class="icon-user"></i></span>
                                    <span class="message">New user registration</span>
                                    <span class="time">36 min</span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="icon yellow"><i class="icon-shopping-cart"></i></span>
                                    <span class="message">2 items sold</span>
                                    <span class="time">1 hour</span>
                                </a>
                            </li>
                            <li class="warning">
                                <a href="#">
                                    <span class="icon red"><i class="icon-user"></i></span>
                                    <span class="message">User deleted account</span>
                                    <span class="time">2 hour</span>
                                </a>
                            </li>
                            <li class="warning">
                                <a href="#">
                                    <span class="icon red"><i class="icon-shopping-cart"></i></span>
                                    <span class="message">New comment</span>
                                    <span class="time">6 hour</span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="icon green"><i class="icon-comment-alt"></i></span>
                                    <span class="message">New comment</span>
                                    <span class="time">yesterday</span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="icon blue"><i class="icon-user"></i></span>
                                    <span class="message">New user registration</span>
                                    <span class="time">yesterday</span>
                                </a>
                            </li>
                            <li class="dropdown-menu-sub-footer">
                                <a>View all notifications</a>
                            </li>
                        </ul>
                    </li>
                    <!-- start: Notifications Dropdown -->
                    <li class="dropdown hidden-phone">
                        <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
                            <i class="icon-calendar"></i>
                            <span class="badge red">
								5 </span>
                        </a>
                        <ul class="dropdown-menu tasks">
                            <li class="dropdown-menu-title">
                                <span>You have 17 tasks in progress</span>
                                <a href="#refresh"><i class="icon-repeat"></i></a>
                            </li>
                            <li>
                                <a href="#">
										<span class="header">
											<span class="title">iOS Development</span>
											<span class="percent"></span>
										</span>
                                    <div class="taskProgress progressSlim red">80</div>
                                </a>
                            </li>
                            <li>
                                <a href="#">
										<span class="header">
											<span class="title">Android Development</span>
											<span class="percent"></span>
										</span>
                                    <div class="taskProgress progressSlim green">47</div>
                                </a>
                            </li>
                            <li>
                                <a href="#">
										<span class="header">
											<span class="title">ARM Development</span>
											<span class="percent"></span>
										</span>
                                    <div class="taskProgress progressSlim yellow">32</div>
                                </a>
                            </li>
                            <li>
                                <a href="#">
										<span class="header">
											<span class="title">ARM Development</span>
											<span class="percent"></span>
										</span>
                                    <div class="taskProgress progressSlim greenLight">63</div>
                                </a>
                            </li>
                            <li>
                                <a href="#">
										<span class="header">
											<span class="title">ARM Development</span>
											<span class="percent"></span>
										</span>
                                    <div class="taskProgress progressSlim orange">80</div>
                                </a>
                            </li>
                            <li>
                                <a class="dropdown-menu-sub-footer">View all tasks</a>
                            </li>
                        </ul>
                    </li>
                    <!-- end: Notifications Dropdown -->
                    <!-- start: Message Dropdown -->
                    <li class="dropdown hidden-phone">
                        <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
                            <i class="icon-envelope"></i>
                            <span class="badge red">
								4 </span>
                        </a>
                        <ul class="dropdown-menu messages">
                            <li class="dropdown-menu-title">
                                <span>You have 9 messages</span>
                                <a href="#refresh"><i class="icon-repeat"></i></a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="avatar"><img src="../../resources/bootstrap/img/avatar.jpg" alt="Avatar"></span>
                                    <span class="header">
											<span class="from">
										    	Dennis Ji
										     </span>
											<span class="time">
										    	6 min
										    </span>
										</span>
                                    <span class="message">
                                            Lorem ipsum dolor sit amet consectetur adipiscing elit, et al commore
                                        </span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="avatar"><img src="../../resources/bootstrap/img/avatar.jpg" alt="Avatar"></span>
                                    <span class="header">
											<span class="from">
										    	Dennis Ji
										     </span>
											<span class="time">
										    	56 min
										    </span>
										</span>
                                    <span class="message">
                                            Lorem ipsum dolor sit amet consectetur adipiscing elit, et al commore
                                        </span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="avatar"><img src="../../resources/bootstrap/img/avatar.jpg" alt="Avatar"></span>
                                    <span class="header">
											<span class="from">
										    	Dennis Ji
										     </span>
											<span class="time">
										    	3 hours
										    </span>
										</span>
                                    <span class="message">
                                            Lorem ipsum dolor sit amet consectetur adipiscing elit, et al commore
                                        </span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="avatar"><img src="../../resources/bootstrap/img/avatar.jpg" alt="Avatar"></span>
                                    <span class="header">
											<span class="from">
										    	Dennis Ji
										     </span>
											<span class="time">
										    	yesterday
										    </span>
										</span>
                                    <span class="message">
                                            Lorem ipsum dolor sit amet consectetur adipiscing elit, et al commore
                                        </span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="avatar"><img src="../../resources/bootstrap/img/avatar.jpg" alt="Avatar"></span>
                                    <span class="header">
											<span class="from">
										    	Dennis Ji
										     </span>
											<span class="time">
										    	Jul 25, 2012
										    </span>
										</span>
                                    <span class="message">
                                            Lorem ipsum dolor sit amet consectetur adipiscing elit, et al commore
                                        </span>
                                </a>
                            </li>
                            <li>
                                <a class="dropdown-menu-sub-footer">View all messages</a>
                            </li>
                        </ul>
                    </li>

                    <!-- start: User Dropdown -->
                    <li class="dropdown">
                        <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
                            <i class="halflings-icon white user"></i> Dennis Ji
                            <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu">
                            <li class="dropdown-menu-title">
                                <span>Account Settings</span>
                            </li>
                            <li><a href="#"><i class="halflings-icon user"></i> Profile</a></li>
                            <li><a href="login.html"><i class="halflings-icon off"></i> Logout</a></li>
                        </ul>
                    </li>
                    <!-- end: User Dropdown -->
                </ul>
            </div>
            <!-- end: Header Menu -->

        </div>
    </div>
</div>

<div class="container-fluid-full">
    <div class="row-fluid" style="height: 100%">

        <!-- start: Main Menu -->
        <div id="sidebar-left" class="span2" style="height:100%">
            <div class="nav-collapse sidebar-nav">
                <ul class="nav nav-tabs nav-stacked main-menu">
                    <li><a href="index.html"><i class="icon-bar-chart"></i><span class="hidden-tablet">空调节能监控</span></a></li>
                    <li>
                        <a class="dropmenu" href="messages.html"><i class="icon-envelope"></i><span class="hidden-tablet">能耗监测分析</span><span class="label label-important"> 2 </span></a>
                        <ul>
                            <li><a class="submenu" href="submenu.html"><i class="icon-file-alt"></i><span class="hidden-tablet">能耗统计</span></a></li>
                            <li><a class="submenu" href="submenu2.html"><i class="icon-file-alt"></i><span class="hidden-tablet">能耗预测与分析</span></a></li>
                        </ul>
                    </li>

                    <li><a href="tasks.html"><i class="icon-tasks"></i><span class="hidden-tablet">数据查询与报表</span></a></li>
                    <li>
                        <a class="dropmenu" href="ui.html"><i class="icon-eye-open"></i><span class="hidden-tablet">文档管理</span><span class="label label-important"> 2 </span></a>
                        <ul>
                            <li><a class="submenu" href="submenu.html"><i class="icon-file-alt"></i><span class="hidden-tablet">文档编辑</span></a></li>
                            <li><a class="submenu" href="submenu2.html"><i class="icon-file-alt"></i><span class="hidden-tablet">文档管理</span></a></li>
                        </ul>
                    </li>
                    <li>
                        <a class="dropmenu" href="#"><i class="icon-folder-close-alt"></i><span class="hidden-tablet"> 系统管理</span><span class="label label-important"> 2 </span></a>
                        <ul>
                            <li><a class="submenu" href="submenu.html"><i class="icon-file-alt"></i><span class="hidden-tablet">日志管理</span></a></li>
                            <li><a class="submenu" href="submenu2.html"><i class="icon-file-alt"></i><span class="hidden-tablet">用户管理</span></a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
        <!-- end: Main Menu -->

        <noscript>
            <div class="alert alert-block span10">
                <h4 class="alert-heading">Warning!</h4>
                <p>You need to have <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a> enabled to use this site.</p>
            </div>
        </noscript>

        <!-- start: Content -->
        <div id="content" class="span10" style="height: 100%">


            <ul class="breadcrumb">
                <li>
                    <i class="icon-home"></i>
                    <a href="index.html">主页</a>
                    <i class="icon-angle-right"></i>
                </li>
                <li>
                    <a href="#">文档管理</a>
                    <i class="icon-angle-right"></i>
                </li>
                <li>
                    <a href="#">文档编辑</a>
                    <i class="icon-angle-right"></i>
                </li>

            </ul>

            <div class="row-fluid">
                <div id="data_search_shower" style="height: 800px;width: 100%">
                    <div id="query_entry">
                        <form action="data_search.jsp" method="post">

                            文档名称：
                            <input type="text " name="title" value="" /> &nbsp;&nbsp;&nbsp;&nbsp;
                            作者：
                            <input type="text" name="num" value="" />
                            <br>
                            文章种类：
                            <select name="tag">
                                <option>1</option>
                                <option>2</option>
                            </select> &nbsp;&nbsp;
                            时间：
                            <input type="text" name="startTime" onclick="WdatePicker()" value="" />
                            至：
                            <input type="text" name="endTime" onclick="WdatePicker()" value="" /> &nbsp;&nbsp;&nbsp;&nbsp;
                            <input  type="submit" name="query" value="查询" alt="Search" title="Search"/>
                        </form>
                    </div>

                    <div class="row-fluid sortable">
                        <div class="box span12" style="margin-top: 2px">
                            <div class="box-header" data-original-title>
                                <h2><i class="halflings-icon white edit"></i><span class="break"></span>Form Elements</h2>
                                <div class="box-icon">
                                    <a href="#" class="btn-setting"><i class="halflings-icon white wrench"></i></a>
                                    <a href="#" class="btn-minimize"><i class="halflings-icon white chevron-up"></i></a>
                                    <a href="#" class="btn-close"><i class="halflings-icon white remove"></i></a>
                                </div>
                            </div>
                            <div class="box-content">
                                <form class="form-horizontal">
                                    <fieldset>
                                        <div class="control-group">
                                            <label class="control-label" for="typeahead">Auto complete </label>
                                            <div class="controls">
                                                <input type="text" class="span6 typeahead" id="typeahead"  data-provide="typeahead" data-items="4" data-source='["Alabama","Alaska","Arizona","Arkansas","California","Colorado","Connecticut","Delaware","Florida","Georgia","Hawaii","Idaho","Illinois","Indiana","Iowa","Kansas","Kentucky","Louisiana","Maine","Maryland","Massachusetts","Michigan","Minnesota","Mississippi","Missouri","Montana","Nebraska","Nevada","New Hampshire","New Jersey","New Mexico","New York","North Dakota","North Carolina","Ohio","Oklahoma","Oregon","Pennsylvania","Rhode Island","South Carolina","South Dakota","Tennessee","Texas","Utah","Vermont","Virginia","Washington","West Virginia","Wisconsin","Wyoming"]'>
                                                <p class="help-block">Start typing to activate auto complete!</p>
                                            </div>
                                        </div>
                                        <div class="control-group">
                                            <label class="control-label" for="date01">Date input</label>
                                            <div class="controls">
                                                <input type="text" class="input-xlarge datepicker" id="date01" value="02/16/12">
                                            </div>
                                        </div>

                                        <div class="control-group">
                                            <label class="control-label" for="fileInput">File input</label>
                                            <div class="controls">
                                                <input class="input-file uniform_on" id="fileInput" type="file">
                                            </div>
                                        </div>
                                        <div class="control-group hidden-phone">
                                            <label class="control-label" for="textarea2">Textarea WYSIWYG</label>
                                            <div class="controls">
                                                <textarea  id="textarea2" rows="3"></textarea>
                                            </div>
                                        </div>
                                        <div class="form-actions">
                                            <button type="submit" class="btn btn-primary">Save changes</button>
                                            <button type="reset" class="btn">Cancel</button>
                                        </div>
                                    </fieldset>
                                </form>

                            </div>
                        </div><!--/span-->

                    </div><!--/row-->
                </div>
            </div>


        </div><!--/.fluid-container-->
        <!-- end: Content -->
    </div><!--/#content.span10-->
</div><!--/fluid-row-->

<div class="clearfix"></div>

<footer>

    <p>
        <span style="text-align:left;float:left">&copy; 2013 <a href="downloads/janux-free-responsive-admin-dashboard-template/" alt="Bootstrap_Metro_Dashboard"></a></span>

    </p>

</footer>

<!-- start: JavaScript-->
<script src="../../resources/bootstrap/js/jquery-1.9.1.min.js"></script>
<script src="../../resources/bootstrap/js/jquery-migrate-1.0.0.min.js"></script>

<script src="../../resources/bootstrap/js/jquery-ui-1.10.0.custom.min.js"></script>

<script src="../../resources/bootstrap/js/jquery.ui.touch-punch.js"></script>

<script src="../../resources/bootstrap/js/modernizr.js"></script>

<script src="../../resources/bootstrap/js/bootstrap.min.js"></script>

<script src="../../resources/bootstrap/js/jquery.cookie.js"></script>

<script src='../../resources/bootstrap/js/fullcalendar.min.js'></script>

<script src='../../resources/bootstrap/js/jquery.dataTables.min.js'></script>

<script src="../../resources/bootstrap/js/excanvas.js"></script>
<script src="../../resources/bootstrap/js/jquery.flot.js"></script>
<script src="../../resources/bootstrap/js/jquery.flot.pie.js"></script>
<script src="../../resources/bootstrap/js/jquery.flot.stack.js"></script>
<script src="../../resources/bootstrap/js/jquery.flot.resize.min.js"></script>

<script src="../../resources/bootstrap/js/jquery.chosen.min.js"></script>

<script src="../../resources/bootstrap/js/jquery.uniform.min.js"></script>

<script src="../../resources/bootstrap/js/jquery.cleditor.min.js"></script>

<script src="../../resources/bootstrap/js/jquery.noty.js"></script>

<script src="../../resources/bootstrap/js/jquery.elfinder.min.js"></script>

<script src="../../resources/bootstrap/js/jquery.raty.min.js"></script>

<script src="../../resources/bootstrap/js/jquery.iphone.toggle.js"></script>

<script src="../../resources/bootstrap/js/jquery.uploadify-3.1.min.js"></script>

<script src="../../resources/bootstrap/js/jquery.gritter.min.js"></script>

<script src="../../resources/bootstrap/js/jquery.imagesloaded.js"></script>

<script src="../../resources/bootstrap/js/jquery.masonry.min.js"></script>

<script src="../../resources/bootstrap/js/jquery.knob.modified.js"></script>

<script src="../../resources/bootstrap/js/jquery.sparkline.min.js"></script>

<script src="../../resources/bootstrap/js/counter.js"></script>

<script src="../../resources/bootstrap/js/retina.js"></script>

<script src="../../resources/bootstrap/js/custom.js"></script>
<!-- end: JavaScript-->

</body>
</html>

