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
    <link rel="shortcut icon" href="img/btv.ico" />

</head>

<body>
    <div id="head">
        <a id="title">Push Message</a>
    </div>
    <br/>

    <div id="content">
        <a href="/push_message/edit" id="add">add</a>
        <br/>
        <table border="1" cellpadding="0" cellspacing="0" width="100%">
            <thead>
                <tr align="center"><td>Time</td><td>Message</td><td>Image1</td><td>Image2</td><td>Update</td><td>Delete</td></tr>
            </thead>
            <tbody>
                <s:iterator value="pushMessageInfoList">
                <tr>
                    <td width="100">${time}</td>
                    <td width="600">${message}</td>
                    <td width="150" align="center"><a href="${img1}" target="_blank"><img src="${img1}" class="img"/></a></td>
                    <td width="150" align="center"><a href="${img2}" target="_blank"><img src="${img2}" class="img"/></a></td>
                    <td width="70" align="center"><a href="/push_message/edit?id=${id}">Update</a></td>
                    <td width="70" align="center"><a href="/push_message/delete?id=${id}">Delete</a></td>
                </tr>
                </s:iterator>
            </tbody>
        </table>
    </div>

</body>
</html>
