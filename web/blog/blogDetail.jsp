<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"
	errorPage="/error/error.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">

		<title>_blogabc_博文首页</title>
		<link href="../css/blog.css" rel="stylesheet" type="text/css" />
		<style type="text/css">
		<!--
		.STYLE2 {font-size:x-large}
		-->
        </style>     
		</head>

	<body class="marsCss1">    			
		<div id="container">	
		<%@ include file="/include/head.jsp"%>
		<%@ include file="/include/left.jsp"%>
        <div id="mainContent12">
        <table height="450" border="1" cellpadding="1" cellspacing="1" bordercolor="#006699">
			<tr valign="top">
                <td width="410"><label id="down" class="STYLE2">${article.title}</label>
                <br><fmt:formatDate value="${article.createTime}" pattern ="yyyy-MM-dd"/>
                </td>
       		  	<td width="20"><input class="button" type="button" id="button" value="顶" 
                onClick="location.href='<%=request.getContextPath()%>/blog/blogCount.do?action=up&&id=${article.id}'">
                <label id="up" class="STYLE2">${article.up}</label>
                </td>
       		  	<td width="20"><input class="button" type="button" id="button" value="踩" 
        		onClick="location.href='<%=request.getContextPath()%>/blog/blogCount.do?action=down&&id=${article.id}'">
                <label id="down" class="STYLE2">${article.down}</label>
                </td>
          	</tr>
            <tr>
                <td height="327" colspan="3" valign="top">${article.content}</td>
            </tr>
           <%if(null!=userId){ %> 
           <tr align="right" valign="bottom">
                <td colspan="3" height="7"><a href="<%=basePath%>/blog/blog.do?id=${userId}">返回列表</a></td>
       	  </tr>
         	<%} %>
          </table>
        </div>
		  <br class="clearfloat" />
			<%@ include file="/include/foot.jsp"%>
	</div>
	</body>
</html>