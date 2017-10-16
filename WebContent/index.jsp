<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>图书借记管理系统</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
    <script type="text/javascript" src="js/libs/modernizr.min.js"></script>
</head>
<body>
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a href="index.html" class="navbar-brand">后台管理</a></h1>
            <ul class="navbar-list clearfix">
                <li><a class="on" href="index.jsp">首页</a></li>
               
            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">
                <li>欢迎您，<s:property value="#session.admin.username"/>！</a></li>
                <li><a href="${pageContext.request.contextPath }/admin/password.jsp">修改密码</a></li>
                <li><a href="javascript:if(confirm('确实要退出登录吗?'))location='login.jsp'">退出</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container clearfix">
    <div class="sidebar-wrap">
        <div class="sidebar-title">
            <h1>菜单</h1>
        </div>
        <div class="sidebar-content">
            <ul class="sidebar-list">
                <li>
                    <a ><i class="icon-font">&#xe003;</i>图书管理</a>
                    <ul class="sub-menu">
                        <li><a href="houselist/houselist.action"><i class="icon-font">&#xe008;</i>添加图书</a></li>
                        <li><a href="${pageContext.request.contextPath }/booklist_findByPage.action"><i class="icon-font">&#xe005;</i>图书列表</a></li>
       
                    </ul>
                </li>
                <li>
                    <a ><i class="icon-font">&#xe018;</i>借记管理</a>
                    <ul class="sub-menu">
                        <li><a href="${pageContext.request.contextPath }/borrow_findByPage.action"><i class="icon-font">&#xe017;</i>在借列表</a></li>
                        <li><a href="${pageContext.request.contextPath }/back_findByPage.action"><i class="icon-font">&#xe037;</i>已归还列表</a></li>
                        
                    </ul>
                </li>
                <li>
                    <a ><i class="icon-font">&#xe018;</i>黑名单管理</a>
                    <ul class="sub-menu">
                        <li><a href="${pageContext.request.contextPath }/black_findByPage.action"><i class="icon-font">&#xe017;</i>黑名单列表</a></li>
                       
                        
                    </ul>
                </li>
            </ul>
        </div>
     </div>
    <!--/sidebar-->
    <div class="main-wrap">
        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font">&#xe06b;</i><span>欢迎使用本系统！</span></div>
        </div>
        
        <div class="result-wrap">
            <div class="result-title">
                <h1>首页</h1>
            </div>
            <div class="result-content">
              <div class="sidebar-title">
            <h1>欢迎来到图书借记管理系统！</h1>
        </div>
            </div>
        </div>
        
    </div>
    <!--/main-->
</div>
</body>
</html>