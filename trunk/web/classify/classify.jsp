<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"
	errorPage="/error/error.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        
        <title>_blogabc_分类首页</title>
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
         <p>&nbsp;</p>
         <form name="classifyform" method="post" action="${action}">
           <label>
          	 <input name="classifyId" type="hidden" value="${classifyId}">
           	 <input name="userId" type="hidden" value="${userId}">
             <input name="action" type="hidden" value="${actiontype}">
             <c:choose>
				<c:when test="${cName==null}">
             <input type="text" name="name" id="textfield" class="myInput">
            	</c:when>
				<c:otherwise>
			<input type="text" name="name" id="textfield" class="myInput" value="${cName}">
				</c:otherwise>
			</c:choose>
           </label>
           <label>
           <input class="button" type="submit" name="button" id="button" value="O K">
           </label>
         </form>
         <p>&nbsp;</p>
      </div>
       <br/>
			<!-- 这个用于清除浮动的元素应当紧跟 #mainContent div 之后，以便强制 #container div 包含所有的子浮动 -->
			<br class="clearfloat" />
			<%@ include file="/include/foot.jsp"%>
		</div>
	</body>
</html>
