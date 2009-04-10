<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Login Form</title>
<style type="text/css"> 
<!-- 
body  {
	background: #666666;
	margin: 0; /* 最好将 body 元素的边距和填充设置为 0 以覆盖不同的浏览器默认值 */
	padding: 0;
	text-align: center; /* 在 IE 5* 浏览器中，这会将容器居中。文本随后将在 #container 选择器中设置为默认左对齐 */
	color: #006699;
	font-size: 14px;
}
.button {
	PADDING-LEFT: 2px;
	PADDING-RIGHT: 2px;
	PADDING-TOP: 2px;
	FONT-SIZE: 12px;
	font-style:normal;
	color:#006666;
	BORDER-LEFT: #7b9ebd 1px solid;
	BORDER-RIGHT: #7b9ebd 1px solid;
	BORDER-TOP: #7b9ebd 1px solid;
	BORDER-BOTTOM: #7b9ebd 1px solid;
	CURSOR: hand;
	FILTER: progid:DXImageTransform.Microsoft.Gradient(GradientType=0, StartColorStr=#ffffff, EndColorStr=#cecfde); 
	width: 50px;
	height: 20px;
}
.marsCss1 #container { 
	width: 780px;  /* 使用比最大宽度 (800px) 小 20px 的宽度可显示浏览器界面元素，并避免出现水平滚动条 */
	background: #FFFFFF;
	margin: 0 auto; /* 自动边距（与宽度一起）会将页面居中 */
	border: 1px solid #000000;
	text-align: left; /* 这将覆盖 body 元素上的“text-align: center”。 */
} 
.marsCss1 #header { 
	background: #DDDDDD; 
	padding: 0 10px 0 20px;  /* 此填充会将出现在它后面的 div 中的元素左对齐。如果 #header 中使用的是图像（而不是文本），您最好删除填充。 */
} 
.marsCss1 #header h1 {
	margin: 0; /* 将 #header div 中最后一个元素的边距设置为零将避免边距重叠（即 div 之间出现的无法解释的空白）。如果 div 周围有边框，则不必将边距设置为零，因为边框也会避免边距重叠 */
	padding: 10px 0; /* 使用填充而不使用边距将可以使元素远离 div 的边缘 */
}
.marsCss1 #sidebar1 {
	float: left; /* 由于此元素是浮动的，因此必须指定宽度 */
	width: 200px; /* 在符合标准的浏览器中或者在 Internet Explorer 中的标准模式下，此 div 的实际宽度除了包括宽度外，还包括填充和边框 */
	background: #EBEBEB; /* 将显示背景色，其宽度等于栏中内容的长度，*/
	padding: 15px 10px 15px 20px;
}
.marsCss1 #mainContent { 
	margin: 0 0 0 250px; /* 此 div 元素的左边距会在页面的左下方创建栏 — 无论 sidebar1 div 中包含多少内容，都将保留栏空白。如果您希望在 #sidebar1 中的内容结束时，用 #mainContent div 的文本填充 #sidebar1 空白，则可以删除此边距。 */
	padding: 0 20px; /* 请记住，填充是 div 方块内部的空间，边距则是 div 方块外部的空间 */
} 
.marsCss1 #footer { 
	padding: 0 10px 0 20px; /* 此填充会将它上面 div 中的所有元素左对齐。 */
	background:#DDDDDD; 
} 
.marsCss1 #footer p {
	margin: 0; /* 将脚注中第一个元素的边距设置为零将避免出现可能的边距重叠（即 div 之间出现的空白）*/
	padding: 10px 0; /* 就像边距会产生空白一样，此元素上的填充也将产生空白，但不会出现边距重叠问题 */
}
.fltrt { /* 此类可用来使页面中的元素向右浮动。浮动元素必须位于页面上要与之相邻的元素之前。 */
	float: right;
	margin-left: 8px;
}
.fltlft { /* 此类可用来使页面上的元素向左浮动 */
	float: left;
	margin-right: 8px;
}
.clearfloat { /* 此类应当放在 div 或 break 元素上，而且该元素应当是完全包含浮动的容器关闭之前的最后一个元素 */
	clear:both;
    height:0;
    font-size: 1px;
    line-height: 0px;
}
--> 
</style>
<!--[if IE 5]>
<style type="text/css"> 
/* 将 IE 5* 的 css 方块模型修正放在这个条件注释中 */
.marsCss1 #sidebar1 { width: 230px; }
</style>
<![endif]--><!--[if IE]>
<style type="text/css"> 
/* 请将所有版本的 IE 的 css 修复放在这个条件注释中 */
.marsCss1 #sidebar1 { padding-top: 30px; }
.marsCss1 #mainContent { zoom: 1; }
/* 上面的专用 zoom 属性为 IE 提供避免错误所需的 hasLayout */
</style>
<![endif]-->
</head>

<body class="marsCss1">

<div id="container">
  <div id="header">
<h1>blogabc</h1>
  <!-- end #header --></div>
  <div id="sidebar1">
<h3>导航</h3>
<p>返回首页</p>
<p>查看专题</p>
<p>查看热文</p>
<p>查看新闻</p>
<p>我的BLOG</p>
<!-- end #sidebar1 --></div>
  <div id="mainContent">
<h1>登录</h1>
<p>&nbsp;</p>
 <form name="loginform" action="login.do" method="POST"> 
    <p>用户名 <input type="text" name="username"></p>    
    <br/>
    <p>密码&nbsp;&nbsp;&nbsp;&nbsp;<input type="password" name="password"></p>
    <p>
      <input class="button" type="submit" name="button2" id="button2" value="登录">
      <input class="button" type="submit" name="button4" id="button4" value="重置">
    </p>
</form>  
  <!-- end #mainContent --></div>
	<p>
	  <!-- 这个用于清除浮动的元素应当紧跟 #mainContent div 之后，以便强制 #container div 包含所有的子浮动 -->
  </p>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
	<p>&nbsp;</p>
  <div id="footer">
<p>脚注</p>
  <!-- end #footer --></div>
<!-- end #container --></div>
</body>
</html>
