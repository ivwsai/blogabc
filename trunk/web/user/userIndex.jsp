<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"
	errorPage="/error/error.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>_blogabc_用户首页</title>
		<link href="../css/blog.css" rel="stylesheet" type="text/css" />
		<style type="text/css">
<!--
.STYLE2 {
	font-size: xx-large
}
-->
</style>
	</head>

	<body class="marsCss1">
		<div id="container">
			<%@ include file="/include/head.jsp"%>
			<%@ include file="/include/left.jsp"%>
			<%@ include file="/include/right.jsp"%>
			<table align="left" width="320" border="0" cellpadding="0"
				cellspacing="0" bordercolor="#006699">
				<tr>
					<td rowspan="7" align="left" valign="top">
						<div align="left">
							<c:choose>
								<c:when test="${url==null}">
									<img src="../image/part.jpg" alt="" width="160" height="160"
										border="1">
								</c:when>
								<c:otherwise>
									<img src="${url}" alt="" width="160" height="160" border="1">
								</c:otherwise>
							</c:choose>
						</div>
					</td>
					<td width="160">
						<p align="left">
							姓名
						</p>
					</td>
				</tr>
				<tr>
					<td>
						<div align="left">
							<strong>${userName} </strong>
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<div align="left">
							电话
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<div align="left">
							<strong>${mobile} </strong>
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<div align="left">
							邮箱
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<div align="left">
							<strong>${email}</strong>
						</div>
					</td>
				</tr>
				<tr>
					<td>
						积分：
						<span class="STYLE2">${point}</span>
					</td>
				</tr>

				<tr>
					<td height="37" colspan="2">
						<strong>个人简介</strong>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						${des}
					</td>
				</tr>
			</table>
		</div>


		<!-- 这个用于清除浮动的元素应当紧跟 #mainContent div 之后，以便强制 #container div 包含所有的子浮动 -->
		<br class="clearfloat" />
		<%@ include file="/include/foot.jsp"%>
		</div>
	</body>
</html>
