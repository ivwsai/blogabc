<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"
	errorPage="/error/error.jsp"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>_blogabc_注册</title>
		<link href="../css/blog.css" rel="stylesheet" type="text/css" />

		<script language="javascript" src="../script/prototype.js"></script>
		<script language="javascript" src="../script/buffalo.js"></script>

		<script language="javascript">
			var END_POINT="<%=request.getContextPath()%>/bfapp";
			var buffalo = new Buffalo(END_POINT);
			
			function checkName() {	
			    var p1 = $("username").value;
			    if(p1==null||p1.length==0){
			    	alert("用户名不能为空.");
			    	return;
			    }
			    buffalo.remoteCall("userAjax.isExist",[p1], function(reply) {
			    	var isExist=reply.getResult();
					if(isExist)
						$("nameResult").value="不可用";
					else
			       		$("nameResult").value="可用";
			    });
			}
			
			function clean(){
				$("username").value='';
				$("password").value='';
				$("password2").value='';
				$("lastName").value='';
				$("firstName").value='';
				$("mobile").value='';
				$("email").value='';
				$("fileContents").value='';	
				$("description").value='';
			}
		</script>
	</head>


	<body class="marsCss1">

		<div id="container">
			<%@ include file="/include/head.jsp"%>
			<%@ include file="/include/left.jsp"%>
			<div id="mainContent">
				<h1>
					新用户注册
				</h1>
				<p>
					&nbsp;

				</p>
				<form name="registerForm" enctype="multipart/form-data"
					action="register.do" method="POST">
					<p>
						用户名*
						<input type="text" name="username" id="textfield">
						<input class="button" type="button" id="button" value="校验"
							onClick="checkName()">
						<input name="nameResult" type="text" class="marsText"
							id="textfield9" size="20" disabled="true">
					</p>
					<p>
						密码设置*
						<input name="password" type="password" id="textfield2" size="10">
						密码确认*
						<input name="password2" type="password" id="textfield3" size="10">
					</p>
					<p>
						姓
						<input name="lastName" type="text" id="textfield4" size="10">
						名
						<input name="firstName" type="text" id="textfield5" size="10">
					</p>
					<p>
						电话
						<input type="text" name="mobile" id="textfield6">
						电子邮箱
						<input type="text" name="email" id="textfield7">
					</p>
					<p>
						头像
						<input name="fileContents" type="file" />
					</p>
					<p>
						个人描述
					</p>
					<p>
						<textarea name="description" cols="55" rows="10" id="textfield8"></textarea>
					</p>
					<p>
						&nbsp;

					</p>
					<p>
						<input class="button" type="submit" name="button21" id="button21"
							value="注册">
						<input class="button" type="button" name="button3" id="button3"
							value="重置" onClick="clean()">
						<input class="button" type="button" name="button4" id="button4"
							value="取消"
							onClick="location.href='<%=request.getContextPath()%>/index.jsp'">
					</p>
				</form>
				<!-- end #mainContent -->
			</div>
			<!-- 这个用于清除浮动的元素应当紧跟 #mainContent div 之后，以便强制 #container div 包含所有的子浮动 -->
			<br class="clearfloat" />
			<%@ include file="/include/foot.jsp"%>
	</body>
</html>
