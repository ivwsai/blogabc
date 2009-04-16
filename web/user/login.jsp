<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"
	errorPage="/error/error.jsp"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>_blogabc_登录</title>
		<link href="../css/blog.css" rel="stylesheet" type="text/css" />
		<script language="javascript" src="../script/prototype.js"></script>
		<script language="javascript" src="../script/buffalo.js"></script>
		<script language="javascript">
function clean(){
	$("username").value='';
	$("password").value='';
}
</script>
<style type="text/css"> 
<!-- 
.myInput{border:0 #FFFFFF; border-bottom:#000000 solid 1px;background-color:#D9E6D2; size:40; width:160} 
--> 
</style> 
</head>

	<body class="marsCss1">

		<div id="container">
			<%@ include file="/include/head.jsp"%>
			<%@ include file="/include/left.jsp"%>
			<div id="mainContent">
				<h1>
					登录
				</h1>
				<p>&nbsp;
					
				</p>
				<form name="loginform" action="login.do" method="POST">
					<table width="466" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td width="86">
								用户名
							</td>
							<td width="380">
								<input name="username" type="text" class="myInput">
							</td>
						</tr>
						<tr>
							<td>
								密码
							</td>
							<td width="380">
								<input name="password" type="password" class="myInput">
							</td>
						</tr>
					</table>
					<p>
						<input class="button" type="submit" name="button2" id="button2"
							value="登录">
						<input class="button" type="button" name="button3" id="button3"
							value="重置" onClick="clean()">
					</p>
				</form>
				<!-- end #mainContent -->
			</div>
			<p>
				<!-- 这个用于清除浮动的元素应当紧跟 #mainContent div 之后，以便强制 #container div 包含所有的子浮动 -->
			</p>
			<p>&nbsp;
				
			</p>
			<p>&nbsp;
				
			</p>
			<p>&nbsp;
				
			</p>
			<p>&nbsp;
				
			</p>
			<%@ include file="/include/foot.jsp"%>
			<!-- end #container -->
		</div>
	</body>
</html>
