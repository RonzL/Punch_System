<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Ronz
  Date: 2020/7/22
  Time: 11:48
  To change this template use File | Settings | File Templates.
--%>



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

            <li id="admin-index"><a href="${pageContext.request.contextPath}/user/getMain.do"><i class="fa fa-dashboard"></i> <span>首页</span></a></li>

            <!-- 菜单 -->


            <li class="treeview">
                <a href="${pageContext.request.contextPath}/pages/punch.jsp">
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

                    <li id="order-manage">
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