<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <base href="<%=basePath%>">

  <title>LOGIN</title>

  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
  <meta http-equiv="expires" content="0">
  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
  <meta http-equiv="description" content="This is my page">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0" />
  <meta name="apple-mobile-web-app-capable" content="yes" />
  <meta name="format-detection" content="telephone=no" />

  <link rel="stylesheet" type="text/css" href="css/base.css" />
  <link rel="shortcut icon" href="img/btv.ico" />
  <script type="application/javascript">
    var userName = $(input_userName);
    userName.addEventListener("onblur" , function () {
      if(userName.value == null){
          alert("input error")
      }
    } ,false)

  </script>

</head>

<body style="background-color: rgba(164,157,168,0.68)">

  <div id="login">
    <s:form method="POST" namespace="/" action="login" theme="simple">
      <s:textfield name="managerInfo.userName" class="input" id="input_userName"/>

      <br/>
      <s:textfield name="managerInfo.password" type="password" class="input"/>
      <br/><br/>
      <s:submit value="Login" class="bt_login"/>
    </s:form>
    <br/>
    <s:property value="loginStatus"/>
  </div>
</body>
</html>
