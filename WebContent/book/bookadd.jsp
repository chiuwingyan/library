<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta charset="UTF-8">
    <title>图书借记管理系统</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
    <script type="text/javascript" src="js/libs/modernizr.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/bootstrap/js/jquery-3.2.0.min.js"></script>
    <script type="text/javascript">
	function checkForm(){
		var isbn=document.getElementById("isbn").value;
		var bookname=document.getElementById("bookname").value;
		var publish=document.getElementById("publish").value;
		var author=document.getElementById("author").value;
		var booktype=document.getElementById("booktype").value;
		var count=document.getElementById("count").value;
		var count1=parseInt(count);
		var reg = new RegExp("^[0-9]*$");
		
		if(isbn==""||bookname==""||publish==""||author==""||booktype==""||count==""){
			alert("信息填写不完整！");
			return false;
		} else if(!reg.test(count1)){
		
			alert("数量请输入数字！");
		   	 return false;
		   	 }
		return true;
	}
	</script>
</head>
<body>
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            
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
                        <li><a href="${pageContext.request.contextPath }/booklist_btlist.action"><i class="icon-font">&#xe008;</i>添加图书</a></li>
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
            <div class="crumb-list"><i class="icon-font"></i><a href="../index.jsp">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="#">图书管理</a><span class="crumb-step">&gt;</span><span>添加图书</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
    

        <form action="${pageContext.request.contextPath }/booklist_add.action" method="post" id="myform" name="myform" enctype="multipart/form-data" onsubmit="return checkForm()"/>
                    <table class="insert-tab" width="100%">
                        <tbody>
                                <th><i class="require-red">*</i>ISBN：</th>
                                <td>
                                    <input class="common-text required" value="${book.isbn }" id="isbn" name="isbn" size="50" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>图书名称：</th>
                                <td><input class="common-text" name="bookname" value="${book.bookname }" id="bookname" size="50" type="text"></td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>作者：</th>
                                <td><input class="common-text" value="${book.author }" name="author" id="author" size="50"  type="text"></td>
                            </tr>
                             <tr>
                                <th><i class="require-red">*</i>数量：</th>
                                <td><input class="common-text" name="count" value="${book.count }" id="count" size="50" type="text"></td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>出版社：</th>
                                <td><input class="common-text" name="publish" id="publish" value="${book.publish }" size="50"  type="text"></td>
                            </tr>
                            <tr>
                            <th width="120"><i class="require-red">*</i>图书类型：</th>
                            <td>
                                <select name="booktype" id="booktype" class="required">
                                <option value="">请选择...</option>
                                <c:forEach var="Booktype" items="${btlist }">
						<option value="${Booktype.booktype }" ${Booktype.booktype eq book.booktype?'selected':''} >${Booktype.booktype}</option>
					</c:forEach>
                                </select>
                            </td>
                        </tr>
								<tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
                                    <input class="btn btn6" onclick="history.go(-1)" value="返回" type="button">
                                </td>
                            </tr>
							<tr>
                                <font id="error" color="red">${error }</font>
                            </tr>	
                        </tbody></table>
                </form>
            </div>
        </div>

    </div>
    <!--/main-->
</div>
</body>
</html>