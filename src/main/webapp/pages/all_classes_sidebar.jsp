<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>

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
        <!-- search form -->
        <!--<form action="#" method="get" class="sidebar-form">
    <div class="input-group">
        <input type="text" name="q" class="form-control" placeholder="搜索...">
        <span class="input-group-btn">
        <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
        </button>
      </span>
    </div>
</form>-->
        <!-- /.search form -->


        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu">
            <li class="header">菜单</li>

            <li id="admin-index"><a href="${pageContext.request.contextPath}/user/getMain.do"><i class="fa fa-dashboard"></i> <span>首页</span></a></li>

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

                    <li id="order-manage">
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

        </ul>
    </section>
    <!-- /.sidebar -->
</aside>