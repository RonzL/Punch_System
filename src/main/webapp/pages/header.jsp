<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>

<!-- 页面头部 -->
<header class="main-header">


    <!-- Logo -->
    <a href="#" class="logo">
        <!-- mini logo for sidebar mini 50x50 pixels -->
        <span class="logo-mini"><b>系统</b></span>
        <!-- logo for regular state and mobile devices -->
        <span class="logo-lg">健康信息上报系统</span>
    </a>


    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
        <!-- Sidebar toggle button-->
        <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
            <span class="sr-only">Toggle navigation</span>
        </a>


        <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">

                <li class="dropdown user user-menu">
                    <div class="pull-right">
                        <a href="${pageContext.request.contextPath}/logout.do"
                           class="btn btn-default btn-flat">退出登录</a>
                    </div>
                </li>
            </ul>
        </div>

    </nav>
</header>
<!-- 页面头部 /-->
