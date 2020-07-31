<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

    <!-- 页面头部 -->
    <jsp:include page="header.jsp" />
    <!-- 页面头部 /-->

    <!-- 导航侧栏 -->
    <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
            <!-- Sidebar user panel -->
            <div class="user-panel">
                <div class="pull-left image">
                    <img src="../img/user2-160x160.jpg" class="img-circle" alt="User Image">
                </div>
                <div class="pull-left info">
                    <security:authentication property="principal.username"></security:authentication>
                </div>
            </div>

            <!-- sidebar menu: : style can be found in sidebar.less -->
            <ul class="sidebar-menu">
                <li class="header">菜单</li>

                <li id="admin-index"><a href="${pageContext.request.contextPath}/user/getMain.do"><i
                        class="fa fa-dashboard"></i> <span>首页</span></a></li>

                <!-- 菜单 -->


                <li class="treeview">
                    <a href="${pageContext.request.contextPath}/punch/getPunch.do">
                        <i class="fa fa-book"></i> <span>健康信息上报</span>
                    </a>
                </li>

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

                <security:authorize access="hasRole('ROLE_ADMIN')">
                    <li class="treeview">
                        <a href="#">
                            <i class="fa fa-cube"></i> <span>教师管理</span>
                            <span class="pull-right-container">
                            <i class="fa fa-angle-left pull-right"></i>
                        </span>
                        </a>
                        <ul class="treeview-menu">

                            <li id="order-manage">
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
                教师管理
                <small>全部教师</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="all-admin-index.html"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li><a href="all-order-manage-list.html">教师管理</a></li>
                <li class="active">全部教师</li>
            </ol>
        </section>
        <!-- 内容头部 /-->

        <!-- 正文区域 -->
        <section class="content">

            <!-- .box-body -->
            <div class="box box-primary">
                <div class="box-header with-border">
                    <h3 class="box-title">列表</h3>
                </div>

                <div class="box-body">

                    <!-- 数据表格 -->
                    <div class="table-box">

                        <!--工具栏-->
                        <div class="pull-left">
                            <div class="form-group form-inline">
                                <div class="btn-group">
                                    <button type="button" class="btn btn-default" title="新建"
                                            onclick='location.href="all-order-manage-edit.html"'><i
                                            class="fa fa-file-o"></i> 新建
                                    </button>
                                    <button type="button" class="btn btn-default" title="删除"
                                            onclick='confirm("你确认要删除吗？")'><i class="fa fa-trash-o"></i> 删除
                                    </button>
                                    <button type="button" class="btn btn-default" title="开启"
                                            onclick='confirm("你确认要开启吗？")'><i class="fa fa-check"></i> 开启
                                    </button>
                                    <button type="button" class="btn btn-default" title="屏蔽"
                                            onclick='confirm("你确认要屏蔽吗？")'><i class="fa fa-ban"></i> 屏蔽
                                    </button>
                                    <button type="button" class="btn btn-default" title="刷新"
                                            onclick="window.location.reload();"><i class="fa fa-refresh"></i> 刷新
                                    </button>
                                </div>
                            </div>
                        </div>
                        <div class="box-tools pull-right">
                            <div class="has-feedback">
                                <input type="text" class="form-control input-sm" placeholder="搜索">
                                <span class="glyphicon glyphicon-search form-control-feedback"></span>
                            </div>
                        </div>
                        <!--工具栏/-->

                        <!--数据列表-->
                        <table id="dataList" class="table table-bordered table-striped table-hover dataTable">
                            <thead>
                            <tr>
                                <th class="" style="padding-right:0px;">
                                    <input id="selall" type="checkbox" class="icheckbox_square-blue">
                                </th>
                                <th class="sorting_asc">序号</th>
                                <th class="sorting">工号</th>
                                <th class="sorting">姓名</th>
                                <th class="sorting">性别</th>
                                <th class="sorting">今日状态</th>
                                <th class="sorting">打卡天数</th>

                                <th class="text-center">操作</th>
                            </tr>
                            </thead>


                            <tbody id="infoList">
                            <c:forEach items="${pageInfo.list}" var="info" varStatus="i">
                                <tr>
                                    <div>
                                        <td><input id="ids" type="checkbox"></td>
                                    </div>
                                    <td>${i.count}</td>
                                    <td>${info.no}</td>
                                    <td>${info.name}</td>
                                    <td>${info.sex}</td>
                                    <c:if test="${info.status.equals('Y')}">
                                        <td><font color="green">正常</font></td>
                                    </c:if>
                                    <c:if test="${info.status.equals('N')}">
                                        <td><font color="#696969">未打卡</font></td>
                                    </c:if>
                                    <c:if test="${info.status.equals('S')}">
                                        <td><font color="red">${info.punches.get(0).physical_state}</font></td>
                                    </c:if>
                                    <td>${info.days}</td>
                                    <td class="text-center">
                                        <button type="button" class="btn bg-olive btn-xs" onclick='location.href="${pageContext.request.contextPath}/teacher/findOne.do?flag=1&no=${info.no}"'>详细信息</button>
                                        <button id="role_manage" type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal" onclick="showRoles('${info.no}' ,'${info.roles[0].roleName}','${info.roles[1].roleName}')">权限分配</button>
                                        <div id="myModal" class="modal modal-primary" role="dialog">
                                            <div class="modal-dialog modal-lg">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                            <span aria-hidden="true">&times;</span></button>
                                                        <h4 class="modal-title">权限分配</h4>
                                                    </div>
                                                    <div class="modal-body">
                                                        <div class="box-body">
                                                            <div class="checkbox" id="role_check">
                                                                <label style="padding-right: 50px"><input type="checkbox" value="1" id="role_user" onclick="checkUser()"> 用户</label>
                                                                <label><input type="checkbox" value="2" id="role_admin"> 管理员</label>
                                                            </div>
                                                        </div>
                                                        <div>
                                                            <span id="roles_now"></span>
                                                        </div>
                                                        </textarea>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-outline" data-dismiss="modal">关闭
                                                        </button>
                                                        <button type="button" id="submit_per" class="btn btn-outline">保存
                                                        </button>
                                                    </div>
                                                </div>
                                                <!-- /.modal-content -->
                                            </div>
                                            <!-- /.modal-dialog -->
                                        </div>
                                        <!-- /.modal -->
                                    </td>
                                </tr>
                            </c:forEach>


                            </tbody>

                        </table>
                        <!--数据列表/-->

                    </div>
                    <!-- 数据表格 /-->


                </div>
                <!-- /.box-body -->

                <!-- .box-footer-->
                <div class="box-footer">
                    <div class="pull-left">
                        <div class="form-group form-inline">
                            总 ${pageInfo.totalPage} 页，共 ${pageInfo.totalCount} 条数据。 每页
                            <select class="form-control" id="pageSize">
                                <option value="5">5</option>
                                <option value="10">10</option>
                                <option value="15">15</option>
                                <option value="20">20</option>
                            </select> 条
                        </div>
                    </div>


                    <div class="box-tools pull-right">
                        <ul class="pagination" id="pageNum">

                        </ul>
                    </div>

                </div>
                <!-- /.box-footer-->


            </div>

        </section>
        <!-- 正文区域 /-->

    </div>
    <!-- 内容区域 /-->

    <!-- 底部导航 -->
    <footer class="main-footer">
        <div class="pull-right hidden-xs">
            <b>Version</b> 1.0.8
        </div>
        <strong>Copyright &copy; 2014-2017 <a href="http://www.itcast.cn">研究院研发部</a>.</strong> All rights reserved.
    </footer>
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
<script src="../plugins/paging.js"></script>
<script>

    var no;

    // 设置激活菜单
    function setSidebarActive(tagUri) {
        var liObj = $("#" + tagUri);
        if (liObj.length > 0) {
            liObj.parent().parent().addClass("active");
            liObj.addClass("active");
        }
    }


    $(document).ready(function () {

        // 激活导航位置
        setSidebarActive("order-manage");

        // 列表按钮
        $("#dataList td #ids[type='checkbox']").iCheck({
            checkboxClass: 'icheckbox_square-blue',
            increaseArea: '20%'
        });
        // 全选操作
        $("#selall").click(function () {
            var clicks = $(this).is(':checked');
            if (!clicks) {
                $("#dataList td #ids[type='checkbox']").iCheck("uncheck");
            } else {
                $("#dataList td #ids[type='checkbox']").iCheck("check");
            }
            $(this).data("clicks", !clicks);
        });

        /**
         * ajax 请求保存权限信息
         * */
        $("#submit_per").click(function () {
            // 用于存放选中的值
            var sel_roles = [];
            // 获取工号
            console.log(no);
            var count = 0;
            // 获取复选框状态
            $("input:checked").each(function (i) {
                sel_roles[i] = $(this).val();
            });

            $.ajax({
                url: "${pageContext.request.contextPath}/teacher/addRoles.do",
                data: {sel_roles: sel_roles, no: no},
                type: "POST",
                traditional: true,
                success: function (data, textStatus) {
                    if (data === "true") {
                        alert("保存成功!");
                        location.href="${pageContext.request.contextPath}/teacher/findAll.do";
                    } else {
                        alert("修改失败!");
                    }
                }
            })
        });
        load(${pageInfo.currentPage}, ${pageInfo.pageSize}, ${pageInfo.totalPage}, "${pageContext.request.contextPath}/teacher/findAll.do");
    });

    /**
     * 要求用户必须至少有一种角色
     *      1. 用户、管理员角色
     *      2. 用户角色
     * */
    function showRoles(jobNo, role_1, role_2) {
        no = jobNo;
        // 如果两个角色都有
        if (role_1 !== "" && role_2 !== ""){
            $("#role_user").prop("checked", true);
            $("#role_admin").prop("checked", true);
        } else {
            console.log("只有一个角色");
            // 只有一个角色，一定是用户角色
            $("#role_user").prop("checked", true);
        }
    }

    /**
     * “用户”角色 为必选项
     * */
    function checkUser() {
        alert("用户角色为必选项!")
        $("#role_user").prop("checked", true);
    }



</script>
</body>

</html>