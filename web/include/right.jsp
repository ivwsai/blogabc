<%@ page contentType="text/html; charset=utf-8"%>
<%
String path1 = request.getContextPath();
String basePath1 = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path1;
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<h1 align="right">${user}的博客</h1>
<div id="sidebar2">
<c:choose>
<c:when test="${isOwn}">
${isOwn}
<p><a href="<%=basePath1%>/blog/editBlog.do?id=${userId}">博文管理</a></p>
<p><a href="<%=basePath1%>/classify/editClassify.do?id=${userId}">分类管理</a></p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
</c:when>
<c:otherwise>
${isOwn}
<p><a href="<%=basePath1%>/blog/blog.do?id=${userId}">${user}的博文</a></p>
<p><a href="<%=basePath1%>/classify/classify.do?id=${userId}">${user}的分类</a></p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
</c:otherwise>
</c:choose>
 
</div>