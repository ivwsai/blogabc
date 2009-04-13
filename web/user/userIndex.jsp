<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" errorPage="/error/error.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>_blogabc_用户首页</title>
		<link href="../css/blog.css" rel="stylesheet" type="text/css" />
		<script language="javascript" src="../script/prototype.js"></script>
		<script language="javascript" src="../script/buffalo.js"></script>
		<script language="javascript">
var END_POINT="<%=request.getContextPath()%>/bfapp";
var buffalo = new Buffalo(END_POINT);

function checkName() {
	alert("1");
    var p1 = $("username").value;
    buffalo.remoteCall("userBusiness.isExist",[p1], function(reply) {
	boolean isExist=reply.getResult();
	if(isExist)
		$("nameResult").value="不可用";
	else
       $("nameResult").value="可用";
    });
}
</script>
	    <style type="text/css">
<!--
.STYLE2 {font-size: xx-large}
-->
        </style>
</head>

	<body class="marsCss1">
		<div id="container">
			<%@ include file="/include/head.jsp"%>
			<%@ include file="/include/left.jsp"%>
			<div id="mainContent">
				<h1 align="right">
					欢迎您 ${user}
				</h1>
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
				<br>

				<p align="left">
					姓名： ${name}
					<br>
					电话：${mobile}
					<br>
					邮箱：${email}
					<br>
				</p>
				<p align="left">
					积分：
					<span class="STYLE2">${point}</span>				</p>
</p>
				<p>&nbsp;				</p>
				<table width="477" height="228" border="1" cellpadding="0"
					cellspacing="0" bordercolor="#0000FF" class="marsCss1">
<tr>
						<td height="37">
							<p>
								个人简介
							</p>
		</td>
				  </tr>
					<tr>
						<td height="181">
							<p align="left">
								${des}
							</p>
							<p>&nbsp;
								
						  </p>
							<p>&nbsp;
								
						  </p>
							<p>&nbsp;
								
						  </p>
						</td>
					</tr>
			  </table>
<p>&nbsp;
					


				</p>
				<p>&nbsp;
					


				</p>
				<!-- end #mainContent -->
			</div>
			<!-- 这个用于清除浮动的元素应当紧跟 #mainContent div 之后，以便强制 #container div 包含所有的子浮动 -->
			<br class="clearfloat" />
			<%@ include file="/include/foot.jsp"%>
		</div>
	</body>
</html>
