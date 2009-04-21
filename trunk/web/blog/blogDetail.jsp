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
		.STYLE2 {font-size: xx-large}
		-->
        </style>     
		</head>

	<body class="marsCss1">    			
		<div id="container">	
		<%@ include file="/include/head.jsp"%>
		<%@ include file="/include/left.jsp"%>
        <div id="mainContent">
        <table width="500" height="503" border="0" cellpadding="0" cellspacing="0" bordercolor="#006699">
<tr valign="top">
                <td width="300" height="30" valign="middle"><strong>${article.title}</strong></td>
        <td width="100"><fmt:formatDate value="${article.createTime}" pattern ="yyyy-MM-dd"/></td>
                <td width="50"><input class="button" type="button" id="button" value="顶" 
                onClick="location.href='<%=request.getContextPath()%>/blog/blogCount.do?action=up&&id=${article.id}'">
                <label id="up" class="STYLE2">${article.up}</label>                </td>
        		<td width="50"><input class="button" type="button" id="button" value="踩" 
        		onClick="location.href='<%=request.getContextPath()%>/blog/blogCount.do?action=down&&id=${article.id}'">
                <label id="down" class="STYLE2">${article.down}</label>                </td>
              </tr>
              <tr>
                <td height="327" colspan="4" valign="top">${article.content}</td>
<!--<script language="JavaScript" type="text/javascript">
//Usage: initRTE(imagesPath, includesPath, cssFile, genXHTML, encHTML)
initRTE("../script/cbrte/images/", "../script/cbrte/", "", true);
</script>
<script language="JavaScript" type="text/javascript">
var rte1 = new richTextEditor('rte1');
rte1.html = '${article.content}';
rte1.toggleSrc = false;
rte1.build();
</script>                
				</td>-->
              </tr>
              <tr align="right" valign="bottom">
                <td colspan="4" height="7"><a href="<%=basePath%>/blog/blog.do?id=${userId}">返回列表</a></td>
          </tr>
            </table>
        </div>
		  <br class="clearfloat" />
			<%@ include file="/include/foot.jsp"%>
	</div>
	</body>
</html>
