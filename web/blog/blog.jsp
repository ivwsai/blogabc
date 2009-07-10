<%@ page language="java" pageEncoding="UTF-8" import="net.fckeditor.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<title>_blogabc_博文首页</title>
		<link href="../css/blog.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript">
			function FCKeditor_OnComplete(editorInstance) {
				window.status = editorInstance.Description;
			}
		</script>
	</head>
	<%
		FCKeditor fckEditor = new FCKeditor(request, "marsEditor");
	%>
	<body class="marsCss1">
		<div id="container11">
			<%@ include file="/include/head.jsp"%>
			<%@ include file="/include/left.jsp"%>
			<div id="mainContent11">
				<form name="blogform" action="<%=basePath%>/blog/publish.do"
					method="POST">

					<input name="userId" type="hidden" value="${userId}">

					<input name="title" type="text" size="70">
					<br>
					<select name="classifyId">
						<c:forEach items="${classifies}" var="classify">
							<option value="${classify.id}">
								${classify.name}
							</option>
						</c:forEach>
					</select>
					<br>
					<%
						fckEditor.setWidth("700");
						fckEditor.setHeight("550");
						fckEditor.setValue("");
						out.println(fckEditor);
					%>
					<br>
					<input class="button" type="submit" name="button2" id="button2" value="发布">
					<input class="button" type="button" name="button3" id="button3" value="取消">

				</form>
			</div>
			<br class="clearfloat" />
			<%@ include file="/include/foot.jsp"%>
		</div>
	</body>
</html>
