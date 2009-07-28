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
	 
	 		 <table width="528">             
              <c:forEach items="${talkList}" var="talk" varStatus="status1">
               <tr>
              <td width="40">
                <c:out value="${status1.index+1}"/>·
              </td>
              <td width="100">
				<a href="<%=basePath%>/talk/detail.do?id=${talk.id}">
                   <c:out value="${talk.persons}"/>
                </a>
              </td>
                
              <td width="240">
                <c:out value="${talk.introduction}"/>·
              </td>
              <td width="173"><fmt:formatDate value="${talk.createTime}" pattern="yyyy-MM-dd"/> </td>
              </tr>
              </c:forEach>
              </table>
		
			</div>
			<br class="clearfloat" />
			<%@ include file="/include/foot.jsp"%>
		</div>
	</body>
</html>