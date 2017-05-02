<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>PUSH MESSAGE</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

    <link rel="stylesheet" type="text/css" href="css/base.css">

</head>

<body>
    <div id="head">
        <a id="title">Push Message</a>
    </div>
    <br/>

    <div id="content">
        <a href="${pushMessageInfo.img1}"><img src="${pushMessageInfo.img1}" alt="img1" class="img"/></a>
        <a href="${pushMessageInfo.img2}"><img src="${pushMessageInfo.img1}" alt="img2" class="img"/></a>
        <s:form method="POST" action="upload" namespace="/" enctype="multipart/form-data">
            <s:hidden name="id"/>
            <s:file name="file" label="Image1" />
            <s:file name="file" label="Image2" />
            <s:submit value="Upload"/>
        </s:form>
        <s:property value="uploadStatus"/>

        <s:form method="POST" action="update" namespace="/">
            <s:hidden name="id"/>
            <s:hidden name="pushMessageInfo.img1"/>
            <s:hidden name="pushMessageInfo.img2"/>
            <s:textfield name="pushMessageInfo.message" class="input" size="100"/>
            <s:submit value="Commit"/>
        </s:form>
    </div>
</body>
</html>
