<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>

<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">




    <title>健康信息上报系统</title>
    <meta name="description" content="健康信息上报系统">
    <meta name="keywords" content="健康信息上报系统">




    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->


    <link rel="stylesheet" href="../plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="../plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="../plugins/iCheck/square/blue.css">
    <link rel="stylesheet" href="../plugins/morris/morris.css">
    <link rel="stylesheet" href="../plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <link rel="stylesheet" href="../plugins/datepicker/datepicker3.css">
    <link rel="stylesheet" href="../plugins/daterangepicker/daterangepicker.css">
    <link rel="stylesheet" href="../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
    <link rel="stylesheet" href="../plugins/datatables/dataTables.bootstrap.css">
    <link rel="stylesheet" href="../plugins/treeTable/jquery.treetable.css">
    <link rel="stylesheet" href="../plugins/treeTable/jquery.treetable.theme.default.css">
    <link rel="stylesheet" href="../plugins/select2/select2.css">
    <link rel="stylesheet" href="../plugins/colorpicker/bootstrap-colorpicker.min.css">
    <link rel="stylesheet" href="../plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
    <link rel="stylesheet" href="../plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet" href="../plugins/adminLTE/css/skins/_all-skins.min.css">
    <link rel="stylesheet" href="../css/style.css">
    <link rel="stylesheet" href="../plugins/ionslider/ion.rangeSlider.css">
    <link rel="stylesheet" href="../plugins/ionslider/ion.rangeSlider.skinNice.css">
    <link rel="stylesheet" href="../plugins/bootstrap-slider/slider.css">
    <link rel="stylesheet" href="../plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.css">
</head>

<body class="hold-transition skin-purple sidebar-mini">

    <div class="wrapper">

        <%-- 引入页面头部 --%>
        <jsp:include page="header.jsp"/>

        <!-- 导航侧栏 -->
        <aside class="main-sidebar">
            <!-- sidebar: style can be found in sidebar.less -->
            <section class="sidebar">
                <!-- Sidebar user panel -->
                <div class="user-panel">
                    <div class="pull-left image">
                        <img src="../img/user2-160x160.jpg" class="img-circle" alt="User Image">
                    </div>
                    <div id="side_name" class="pull-left info">
                        <security:authentication property="principal.username"></security:authentication>
                    </div>
                    <div style="display: none">

                    </div>
                </div>


                <ul class="sidebar-menu">
                    <li class="header">菜单</li>

                    <li id="admin-index"><a href="${pageContext.request.contextPath}/user/getMain.do"><i class="fa fa-dashboard"></i> <span>首页</span></a></li>

                    <li class="active">
                        <a href="${pageContext.request.contextPath}/punch/getPunch.do">
                            <i class="fa fa-book"></i> <span>健康信息上报</span>
                        </a>
                    </li>

                    <security:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER')">
                        <li class="treeview">
                            <a href="#">
                                <i class="fa fa-cube"></i> <span>学生管理</span>
                                <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                            </a>
                            <ul class="treeview-menu">

                                <li>
                                    <a href="${pageContext.request.contextPath}/class/findAll.do">
                                        <i class="fa fa-circle-o"></i> 全部班级
                                    </a>
                                </li>

                                <li>
                                    <a href="${pageContext.request.contextPath}/student/findAll.do">
                                        <i class="fa fa-circle-o"></i> 全部学生
                                    </a>
                                </li>

                                <li>
                                    <a href="${pageContext.request.contextPath}/student/findNoPunch.do">
                                        <i class="fa fa-circle-o"></i> 未打卡学生
                                    </a>
                                </li>

                            </ul>
                        </li>
                        <%-- 管理员才能访问以下内容 --%>
                        <security:authorize access="hasRole('ROLE_ADMIN')">
                            <li class="treeview">
                                <a href="#">
                                    <i class="fa fa-cube"></i> <span>教师管理</span>
                                    <span class="pull-right-container">
                                <i class="fa fa-angle-left pull-right"></i>
                            </span>
                                </a>
                                <ul class="treeview-menu">

                                    <li>
                                        <a href="${pageContext.request.contextPath}/teacher/findAll.do">
                                            <i class="fa fa-circle-o"></i> 全部教师
                                        </a>
                                    </li>

                                    <li>
                                        <a href="${pageContext.request.contextPath}/teacher/findNoPunch.do">
                                            <i class="fa fa-circle-o"></i> 未打卡教师
                                        </a>
                                    </li>

                                </ul>
                            </li>
                        </security:authorize>
                    </security:authorize>
                </ul>
            </section>
            <!-- /.sidebar -->
        </aside>
        <!-- 导航侧栏 /-->

        <!-- 内容区域 -->
        <div class="content-wrapper">

            <!-- 内容头部 -->
            <section class="content-header">
                <h1>
                    健康信息上报
                </h1>
                <ol class="breadcrumb">
                    <li><a href="all-admin-index.html"><i class="fa fa-dashboard"></i> 首页</a></li>
                    <li class="active">健康信息上报</li>
                </ol>
            </section>
            <!-- 内容头部 /-->

            <!-- 正文区域 -->
            <form action="${pageContext.request.contextPath}/punch/uploadInfo.do" method="post">
                <section class="content">
                    <!--下拉框-->
                    <div class="tab-pane" id="tab-select">
                    <div class="punch">
                            <div class="row data-type">
                                    <div class="col-md-4 title">学/工 号</div>
                                    <div class="col-md-8 data">
                                        <input type="text" class="form-control" id="no" name="no" value="${info.no}" readonly="readonly">
                                    </div>

                                    <div class="col-md-4 title">身体状态</div>
                                    <div class="col-md-8 data">
                                        <select name="physical_state" class="form-control ">
                                            <option value="0">正常</option>
                                            <option value="1">呼吸道可疑症状</option>
                                            <option value="2">未发热且隔离</option>
                                            <option value="3">疑似</option>
                                            <option value="4">确诊</option>
                                            <option value="5">疑似转排除</option>
                                            <option value="6">已治愈</option>
                                        </select>
                                    </div>
                                    <div class="col-md-4 title">当前位置</div>
                                    <div class="col-md-8 data">
                                        <input type="text" class="form-control" name="address" id="location" value="" readonly="readonly">
                                    </div>

                                    <div class="col-md-4 title">当前时间</div>
                                    <div class="col-md-8 data">
                                        <input type="text" class="form-control" id="date" name="date" value="date" readonly="readonly">
                                    </div>

                            </div>
                            <c:if test="${'N'.equals(info.status)}">
                                <div style="margin: 10px 40% 10px 5px;" align="right">
                                    <button type="submit" style="width: 15%;" class="btn btn-block btn-primary">提交</button>
                                </div>
                            </c:if>
                            <c:if test="${'Y'.equals(info.status) || 'S'.equals(info.status)}">
                                <div style="margin: 10px 40% 10px 5px;" align="right">
                                    <button disabled="disabled" type="submit" style="width: 15%; background: grey" class="btn btn-block btn-primary">已上报</button>
                                </div>
                            </c:if>

                    </div>
                    </div>
                </section>
            </form>
            <!-- 正文区域 /-->

        </div>
        <!-- 内容区域 /-->

        <!-- 底部导航 -->
        <jsp:include page="footer.jsp"></jsp:include>
        <!-- 底部导航 /-->

    </div>


    <script src="../plugins/jQuery/jquery-2.2.3.min.js"></script>
    <script src="../plugins/jQueryUI/jquery-ui.min.js"></script>
    <script>
        $.widget.bridge('uibutton', $.ui.button);
    </script>
    <script src="../plugins/bootstrap/js/bootstrap.min.js"></script>
    <script src="../plugins/raphael/raphael-min.js"></script>
    <script src="../plugins/morris/morris.min.js"></script>
    <script src="../plugins/sparkline/jquery.sparkline.min.js"></script>
    <script src="../plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
    <script src="../plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
    <script src="../plugins/knob/jquery.knob.js"></script>
    <script src="../plugins/daterangepicker/moment.min.js"></script>
    <script src="../plugins/daterangepicker/daterangepicker.js"></script>
    <script src="../plugins/daterangepicker/daterangepicker.zh-CN.js"></script>
    <script src="../plugins/datepicker/bootstrap-datepicker.js"></script>
    <script src="../plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
    <script src="../plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
    <script src="../plugins/slimScroll/jquery.slimscroll.min.js"></script>
    <script src="../plugins/fastclick/fastclick.js"></script>
    <script src="../plugins/iCheck/icheck.min.js"></script>
    <script src="../plugins/adminLTE/js/app.min.js"></script>
    <script src="../plugins/treeTable/jquery.treetable.js"></script>
    <script src="../plugins/select2/select2.full.min.js"></script>
    <script src="../plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
    <script src="../plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.zh-CN.js"></script>
    <script src="../plugins/bootstrap-markdown/js/bootstrap-markdown.js"></script>
    <script src="../plugins/bootstrap-markdown/locale/bootstrap-markdown.zh.js"></script>
    <script src="../plugins/bootstrap-markdown/js/markdown.js"></script>
    <script src="../plugins/bootstrap-markdown/js/to-markdown.js"></script>
    <script src="../plugins/ckeditor/ckeditor.js"></script>
    <script src="../plugins/input-mask/jquery.inputmask.js"></script>
    <script src="../plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
    <script src="../plugins/input-mask/jquery.inputmask.extensions.js"></script>
    <script src="../plugins/datatables/jquery.dataTables.min.js"></script>
    <script src="../plugins/datatables/dataTables.bootstrap.min.js"></script>
    <script src="../plugins/chartjs/Chart.min.js"></script>
    <script src="../plugins/flot/jquery.flot.min.js"></script>
    <script src="../plugins/flot/jquery.flot.resize.min.js"></script>
    <script src="../plugins/flot/jquery.flot.pie.min.js"></script>
    <script src="../plugins/flot/jquery.flot.categories.min.js"></script>
    <script src="../plugins/ionslider/ion.rangeSlider.min.js"></script>
    <script src="../plugins/bootstrap-slider/bootstrap-slider.js"></script>
    <script src="../plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.js"></script>
    <script src="../plugins/bootstrap-datetimepicker/locales/bootstrap-datetimepicker.zh-CN.js"></script>
    <script>
        $(document).ready(function() {
            // 选择框
            $(".select2").select2();

            // WYSIHTML5编辑器
            $(".textarea").wysihtml5({
                locale: 'zh-CN'
            });
        });


        // 设置激活菜单
        function setSidebarActive(tagUri) {
            var liObj = $("#" + tagUri);
            if (liObj.length > 0) {
                liObj.parent().parent().addClass("active");
                liObj.addClass("active");
            }
        }


        $(document).ready(function() {
            // 激活导航位置
            setSidebarActive("travellog-setting");

            // 获取当前 ip 的地理位置
            $.ajax({url:"https://apis.map.qq.com/ws/location/v1/ip?output=jsonp&key=这里需要自己到腾讯地图申请一个key",
                    method:"GET",
                    dataType:"jsonp",
                    success:function (data) {
                        var address = data["result"]["ad_info"];
                        var nation = address["nation"];
                        var province = address["province"];
                        var city = address["city"];
                        var district = address["district"];
                        $("#location").attr("value", nation+province+city+district);
                    },
                    error:function () {
                        console.log("fail");
                    }
            });

            // 设置当前时间
            $("#date").attr("value", new Date().format("yyyy-MM-dd hh:mm:ss"));
        });

        // 定义一个日期格式化函数
        Date.prototype.format = function(fmt){
            var o = {
                "M+" : this.getMonth()+1,                 //月份
                "d+" : this.getDate(),                    //日
                "h+" : this.getHours(),                   //小时
                "m+" : this.getMinutes(),                 //分
                "s+" : this.getSeconds(),                 //秒
                "q+" : Math.floor((this.getMonth()+3)/3), //季度
                "S"  : this.getMilliseconds()             //毫秒
            };

            if(/(y+)/.test(fmt)){
                fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
            }

            for(var k in o){
                if(new RegExp("("+ k +")").test(fmt)){
                    fmt = fmt.replace(
                        RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
                }
            }

            return fmt;
        };




    </script>
</body>

</html>