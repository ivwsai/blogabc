<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" errorPage="/error/error.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>_blogabc_用户编辑</title>
		<link href="../css/blog.css" rel="stylesheet" type="text/css" />
		</head>

<body class="marsCss1">

<div id="container">
	<%@ include file="/include/head.jsp"%>
	<%@ include file="/include/left.jsp"%>
  <div id="mainContent">
  			<h1>修改用户信息</h1>
				<p>&nbsp;</p>
		<form name="registerForm" enctype="multipart/form-data" action="doedit.do" method="POST">
					<p>用户名*<input type="text" name="username" id="textfield" disabled="true" value="${username}"></p>
					<p>
						姓
						<input name="lastName" type="text" id="textfield4" size="10" value="${lastName}">
						名
						<input name="firstName" type="text" id="textfield5" size="10" value="${firstName}">
					</p>
					<p>
						电话
						<input type="text" name="mobile" id="textfield6" value="${mobile}">
						电子邮箱
						<input type="text" name="email" id="textfield7" value="${email}">
					</p>
					<c:choose>
					<c:when test="${url==null}">
						<p align="left">
							<img src="../image/part.jpg" alt="" width="160" height="160"
								border="1">
						</p>
					</c:when>
					<c:otherwise>
						<p align="left">
							<img src="${url}" alt="" width="160" height="160" border="1">
						</p>
					</c:otherwise>
					</c:choose>
               		<p>
						头像<input name="fileContents" type="file"/>
					</p>
					<p>
						个人描述
					</p>
					<p>
						<textarea name="description" cols="55" rows="10" id="textfield8">${des}</textarea>
					</p>
					<p>&nbsp;
						
					</p>
					<p>
						<input class="button" type="submit" name="button21" id="button21" value="注册">
						<input class="button" type="button" name="button3" id="button3"	value="重置" onClick="clean()">
						<input class="button" type="button" name="button4" id="button4"	value="取消"	onClick="location.href='<%=request.getContextPath()%>/index.jsp'">
					</p>
				</form>
	</div>
    <br class="clearfloat" />
<%@ include file="/include/foot.jsp"%>
</div>
</body>
</html>