<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!-- 内容区域 -->
<!-- 正文区域 -->
<!-- Main content -->
<section class="content">

    <div class="row">
        <div class="col-md-3">

            <!-- Profile Image -->
            <div class="box box-primary">
                <div class="box-body box-profile">
                    <img class="profile-user-img img-responsive img-circle" src="../img/user4-128x128.jpg" alt="User profile picture">

                    <h3 class="profile-username text-center">Nina Mcintire</h3>

                    <p class="text-muted text-center">Software Engineer</p>

                    <ul class="list-group list-group-unbordered">
                        <li class="list-group-item">
                            <b>今日状态</b> <a class="pull-right">
                            <c:if test="${info.status.equals('Y')}">
                                <span style="color: green; ">正常</span>
                            </c:if>
                            <c:if test="${info.status.equals('N')}">
                                <span style="color: dimgrey">未打卡</span>
                            </c:if>
                            <c:if test="${info.status.equals('S')}">
                                <span style="color: red;">${info.punches.get(0).physical_state}</span>
                            </c:if>



                        </a>
                        </li>
                        <li class="list-group-item">
                            <b>打卡天数</b> <a class="pull-right">${info.days}</a>
                        </li>
                    </ul>

                </div>
                <!-- /.box-body -->
            </div>
            <!-- /.box -->
        </div>
        <!-- /.col -->
        <div class="col-md-9">
            <div class="nav-tabs-custom">

                <div class="tab-content">
                    <div class="tab-pane active" id="settings">
                        <form id="form" method="post" action="${pageContext.request.contextPath}/teacher/saveInfo.do" class="form-horizontal">
                            <div class="form-group">
                                <label for="no" class="col-sm-2 control-label">工号</label>

                                <div class="col-sm-10">
                                    <input type="number" class="form-control" name="no" id="no" value="${info.no}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="name" class="col-sm-2 control-label">姓名</label>

                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="name" id="name" value="${info.name}">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="sex" class="col-sm-2 control-label">性别</label>

                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="sex" name="sex" value="${info.sex}">
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="email" class="col-sm-2 control-label">邮箱</label>

                                <div class="col-sm-10">
                                    <input class="form-control" name="email" id="email" value="${info.email}"/>
                                </div>
                            </div>

                            <input id="flag" name="flag" value="${flag}" hidden="hidden">

                            <div align="center">
                                <button type="submit" style="width: 15%;" class="btn btn-block btn-primary">保存修改</button>
                            </div>

                        </form>
                    </div>
                    <!-- /.tab-pane -->
                </div>


                <!-- /.tab-content -->
            </div>
            <!-- /.nav-tabs-custom -->
        </div>
        <!-- /.col -->
    </div>
    <!-- /.row -->

</section>
<!-- /.content -->
<!-- 正文区域 /-->
