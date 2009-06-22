<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"	errorPage="/error/error.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	</head>

	<body class="marsCss1">
		<div id="container11">
			<%@ include file="/include/head.jsp"%>
			<%@ include file="/include/left.jsp"%>
			<div id="mainContent11">
				<form name="marsform" action="<%=basePath%>/talk/createTalk.do" method="POST">
                    <input name="articleId" type="hidden" value="${article.id}">
					<input name="userId" type="hidden" value="${userId}">                    
					主讲人：<input name="persons" type="text" size="70">
					<br>
					引入：<br><textarea name="introduction" id="introduction" cols="80" rows="10"></textarea>
                    <br>
					介绍：<br><textarea name="howto" id="howto" cols="80" rows="10"></textarea>
                    <br>
					作业：<br><textarea name="exercise" id="exercise" cols="80" rows="10"></textarea>
					<br>
                       附件：<br>
                    <input name="attachment1" type="file" /><br>
                    <input name="attachment2" type="file" /><br>
                    <input name="attachment3" type="file" /><br>
					<input class="button" type="submit" name="button2" id="button2" value="提交">
				</form>
			</div>
			<br class="clearfloat" />
			<%@ include file="/include/foot.jsp"%>
		</div>
	</body>
</html>