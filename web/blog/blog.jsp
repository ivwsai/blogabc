<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"
	errorPage="/error/error.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
	<script language="JavaScript" type="text/javascript" src="../script/cbrte/html2xhtml.js"></script>
	<script language="JavaScript" type="text/javascript" src="../script/cbrte/richtext_compressed.js"></script>
		<title>_blogabc_博文首页</title>
		<link href="../css/blog.css" rel="stylesheet" type="text/css" />
		</head>

	<body class="marsCss1">    			
		<div id="container">	
		<%@ include file="/include/head.jsp"%>
		<%@ include file="/include/left.jsp"%>
        <div id="mainContent">
        <form name="loginform" action="<%=basePath%>/user/login.do" method="POST">
  <p>
    <input name="title" type="text" size="70">
    </p>
  <p>
    <select name="classify">
    </select>
      <script language="JavaScript" type="text/javascript">
//Usage: initRTE(imagesPath, includesPath, cssFile, genXHTML, encHTML)
initRTE("../script/cbrte/images/", "../script/cbrte/", "", true);
    </script>
      <noscript>
      </noscript>
  </p>
  <noscript><p><b>Javascript must be enabled to use this form.</b></p></noscript>

  <p>
    <script language="JavaScript" type="text/javascript">
<!--
//build new richTextEditor
var rte1 = new richTextEditor('rte1');
rte1.build();
//-->
  </script>    
  </p>
  </form>
        </div>
		  <br class="clearfloat" />
			<%@ include file="/include/foot.jsp"%>
	</div>
	</body>
</html>
