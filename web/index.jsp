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

  <link rel="stylesheet" type="text/css" href="css/base.css" />
  <link rel="shortcut icon" href="img/btv.ico" />

</head>

<body style="background-color: rgba(164,157,168,0.68)">

  <div id="login">
    <s:form method="POST" namespace="/" action="login">
      <s:textfield name="managerInfo.userName" class="input"/>
      <s:textfield name="managerInfo.password" type="password" class="input"/>
      <s:submit value="Login" class="input"/>
    </s:form>
    <br/>
    <s:property value="loginStatus"/>
  </div>
</body>
</html>
