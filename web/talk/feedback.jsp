<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"	errorPage="/error/error.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<script language="JavaScript" type="text/javascript"
			src="../script/cbrte/html2xhtml.js"></script>
		<script language="JavaScript" type="text/javascript"
			src="../script/cbrte/richtext_compressed.js"></script>
		<title>_blogabc_发起专题</title>
		<link href="../css/blog.css" rel="stylesheet" type="text/css" />
        <style type="text/css">
<!--
#back{
margin: 0 0 0 100px;
padding: 0 20px; 
}
-->
        </style>
	</head>

	<body class="marsCss1">
		<div id="container11">
			<%@ include file="/include/head.jsp"%>
			<%@ include file="/include/left.jsp"%>
			<div id="back">
	 
<form name="marsform" action="<%=basePath%>/talk/addfeedbackTalk.do" method="post">
  <p>
  <input name="talkId" id="talkId" type="hidden" value="<c:out value="${talkId}"/>" />
  <textarea name="content" id="content" cols="80" rows="20"></textarea>
  </p>
  <p>
    <input name="input" type="submit" value="提交" />
  </p>
</form>
	 		
			</div>
			<br class="clearfloat" />
			<%@ include file="/include/foot.jsp"%>
		</div>
	</body>
</html>