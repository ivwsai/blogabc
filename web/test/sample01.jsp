<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="net.fckeditor.*" %>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK" %>
<html>
	<head>
		<title>FCKeditor - JSP Sample</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="robots" content="noindex, nofollow" />
		<link href="../sample.css" rel="stylesheet" type="text/css" />
		<link rel="shortcut icon" href="../fckeditor.gif" type="image/x-icon" />
		<script type="text/javascript">
			function FCKeditor_OnComplete(editorInstance) {
				window.status = editorInstance.Description;
			}
		</script>
	</head>
	<%
		FCKeditor fckEditor = new FCKeditor(request, "EditorDefault");
	%>
	<body>
		<form action="sampleposteddata.jsp" method="post" target="_blank">
		<%
			fckEditor.setValue("");
			out.println(fckEditor);
		%>
		<br />
		<input type="submit" value="Submit" /></form>
	</body>
</html>