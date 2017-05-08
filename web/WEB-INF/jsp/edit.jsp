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

    <title>LD FAM</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <meta http-equiv="charset" content="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0" />
    <meta name="apple-mobile-web-app-capable" content="yes" />
    <meta name="format-detection" content="telephone=no" />

    <link rel="stylesheet" type="text/css" href="css/base.css">

</head>

<body>
    <div id="head">
        <a id="title">LD FAM</a>
    </div>
    <br/>

    <div id="content">
        please select image:
        <table width="100%" border="1" cellpadding="1px" cellspacing="0px">
            <tr>
                <td width="50%">
                    <a href="${pushMessageInfo.img1}"><img src="${pushMessageInfo.img1}" alt="img1" class="img"/></a>
                </td>
            </tr>
            <tr>
                <td width="100%">
                    <s:form method="POST" action="upload" namespace="/" enctype="multipart/form-data" theme="simple">
                        <s:hidden name="id"/>
                        <s:file name="file" class="input1"/><br/><br/>
                        <s:submit value="Upload" class="bt_login1"/>
                    </s:form>
                    <s:property value="uploadStatus"/>
                </td>
            </tr>
        </table>
        <br/>
        <br/>
        please input content:
        <s:form method="POST" action="update" namespace="/" theme="simple">
            <s:hidden name="id"/>
            <s:hidden name="pushMessageInfo.img1"/>
            <s:hidden name="pushMessageInfo.img2"/>
            <s:textarea name="pushMessageInfo.message" class="input" size="100" rows="3"/>
            <br/><br/>
            <s:submit value="Confirm" class="bt_login"/>
        </s:form>
    </div>
    <div id="foot">
        <a id="copyright">POWERED BY LD Copyright © 2017 LD All Rights Reserved</a>
    </div>
</body>
</html>
