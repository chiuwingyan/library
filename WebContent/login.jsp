<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
 <%@ taglib prefix="s" uri="/struts-tags" %>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
<html>
<head>
<title>图书借记管理系统</title>
<link rel="stylesheet" type="text/css" href="css/Login_style.css" />

<script type="text/javascript" src="Javascript/Login_javascript.js"></script>
</head>
<script>
<s:if test="erro=='yes'">
alert("用户名或密码错误！");
</s:if>
<s:else>

</s:else>  	 

</script>
<body>
<h2 align="center">图书借记管理系统</h2>
<div class="login_frame"></div>
<div class="LoginWindow">
  <div>
    <form method="post" action="${pageContext.request.contextPath }/admin_login.action" onsubmit="return user_input()" class="login">
    <p>
      <label for="login">帐号:</label>
      <input type="text" name="username" id="username" value="">
    </p>

    <p>
      <label for="password">密码 :</label>
      <input type="password" name="password" id="password" value="">
    </p>

    <p class="login-submit">
      <button type="submit" class="login-button">登录</button>
    </p>

    </form>
   
  </div>
</div>

<div id="timeArea"><script> LoadBlogParts();</script></div>

<div style="text-align:center;">

</div>

</body>
</html>