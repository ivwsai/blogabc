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
<table>
 			<tr>
              <td valign="top"><b>发起人</b></td>
            </tr>
            <tr>
              <td><c:out value="${talk.persons}"/></td>
            </tr>
            <tr>
              <td valign="top"><b>引入[why]</b></td>
            </tr>
            <tr>
              <td><c:out value="${talk.introduction}"/></td>
            </tr>
            <tr>
              <td><b>介绍[what&how]</b></td>
            </tr>
            <tr>
              <td><c:out value="${talk.howto}"/></td>
            </tr>
            <tr>
              <td><b>附件</b></td>
            </tr>
            <tr>
              <td>              
              <c:forEach items="${attachments}" var="attachment" varStatus="status">
				<a href="${attachment}">
                    <c:out value="${attachment}"/>
                </a>
              </c:forEach>              
              </td>
            </tr>
            <tr>
              <td><b>作业</b></td>
            </tr>
            <tr>
              <td><c:out value="${talk.exercise}"/></td>
            </tr>
            
           <tr>
              <td><b>回复列表</b></td>
            </tr>
            <tr>
              <td>              
              <c:forEach items="${feedbacks}" var="feedback" varStatus="status">				
                   回复人：<c:out value="${feedback.userId}"/></br>
                <c:out value="${feedback.content}"/></br></br>
              </c:forEach>              
              </td>
            </tr>
            <tr>
             <td>
             <a href="<%=basePath%>/talk/feedbackTalk.do?tid=${talk.id}">回复专题</a>
             </td>
            </tr>
</table>
			</div>
			<br class="clearfloat" />
			<%@ include file="/include/foot.jsp"%>
		</div>
	</body>
</html>