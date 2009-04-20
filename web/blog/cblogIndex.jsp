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
            <div id="mainContent">
			<table align="left" border="0" cellpadding="0" cellspacing="0"
				bordercolor="#006699">
				<c:forEach items="${blogModel.blogs}" var="article"
					varStatus="status">
					<tr>
						<td width="20">
							<c:out value="${status.index+1}" />
						</td>
						<td width="150">
							<fmt:formatDate value="${article.createTime}"
								pattern="yyyy-MM-dd" />
						</td>
						<td width="150">
							<a
								href="<%=basePath%>/blog/detail.do?id=${article.id}&&userId=${blogModel.belongUserId}">
								<c:out value="${article.title}" />
							</a>
						</td>
					</tr>
				</c:forEach>
			</table>		
		<br />
		<table align="right" border="0" cellpadding="0" cellspacing="0"
			bordercolor="#006699">
			<c:choose>
				<c:when test="${blogModel.index==0}">
					<c:choose>
						<c:when test="${blogModel.totalPage==0}">
						</c:when>
						<c:otherwise>
									1/<c:out value="${blogModel.totalPage}" />页 
									<a
								href="<%=basePath%>/blog/changepage1.do?id=${blogModel.belongUserId}&&index=${blogModel.index}&&count=${blogModel.count}&&action=next">
								->> </a>
						</c:otherwise>
					</c:choose>
				</c:when>
				<c:otherwise>
					<c:choose>
						<c:when test="${blogModel.totalPage>blogModel.index+1}">
							<a
								href="<%=basePath%>/blog/changepage1.do?id=${blogModel.belongUserId}&&index=${blogModel.index}&&count=${blogModel.count}&&action=prev">
								<<- </a>
							<c:out value="${blogModel.index+1}" />/<c:out
								value="${blogModel.totalPage}" />页 
											<a
								href="<%=basePath%>/blog/changepage1.do?id=${blogModel.belongUserId}&&index=${blogModel.index}&&count=${blogModel.count}&&action=next">
								->> </a>
						</c:when>
						<c:otherwise>
							<a
								href="<%=basePath%>/blog/changepage1.do?id=${blogModel.belongUserId}&&index=${blogModel.index}&&count=${blogModel.count}&&action=prev">
								<<- </a>
							<c:out value="${blogModel.index+1}" />/<c:out
								value="${blogModel.totalPage}" />页
										</c:otherwise>
					</c:choose>
				</c:otherwise>
			</c:choose>
		</table>
        </div>
		<!-- 这个用于清除浮动的元素应当紧跟 #mainContent div 之后，以便强制 #container div 包含所有的子浮动 -->
		<br class="clearfloat" />
		<%@ include file="/include/foot.jsp"%>
		</div>
	</body>
</html>
