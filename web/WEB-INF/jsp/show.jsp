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
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0" />
    <meta name="apple-mobile-web-app-capable" content="yes" />
    <meta name="format-detection" content="telephone=no" />

    <link rel="stylesheet" type="text/css" href="css/base.css">
    <link rel="shortcut icon" href="img/btv.ico" />

</head>

<body>
    <div id="head">
        <a id="title">LD FAM</a>
    </div>
    <br/>

    <div id="content">
        <a href="/push_message/logout" id="logout">Logout</a><br/><br/><br/>
        <a href="/push_message/edit" id="add">Add</a>
        <br/><br/><br/>
        <table border="1" cellpadding="0" cellspacing="0" width="100%">
            <thead>
                <tr align="center"><td>Time</td><td>Message</td><td>Image</td><td>Update</td><td>Delete</td></tr>
            </thead>
            <tbody>
                <s:iterator value="pushMessageInfoList">
                <tr>
                    <td width="20%%">${time}</td>
                    <td width="20%">${message}</td>
                    <td width="20%" align="center"><a href="${img1}" target="_blank"><img src="${img1}" class="img"/></a></td>
                    <td width="20%" align="center"><a href="/push_message/edit?id=${id}">Update</a></td>
                    <td width="20%" align="center"><a href="/push_message/delete?id=${id}">Delete</a></td>
                </tr>
                </s:iterator>
            </tbody>
        </table>
    </div>

    <div id="foot">
        <a id="copyright">POWERED BY LD Copyright © 2017 LD All Rights Reserved</a>
    </div>

</body>
</html>
