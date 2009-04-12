<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" errorPage="/error/error.jsp"%>


<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<title>无标题文档</title>
<style type="text/css"> 
<!-- 
body  {
	margin: 0; /* 最好将 body 元素的边距和填充设置为 0 以覆盖不同的浏览器默认值 */
	padding: 0;
	text-align: center; /* 在 IE 5* 浏览器中，这会将容器居中。文本随后将在 #container 选择器中设置为默认左对齐 */
	color: #003366;
	font-size: 14px;
	font-style: normal;
}
.thrColAbsHdr #container { 
	position: relative; /* 添加“position: relative”允许您将两个侧栏相对于此容器放置 */
	width: 780px;  /* 使用比最大宽度 (800px) 小 20px 的宽度可显示浏览器界面元素，并避免出现水平滚动条 */
	background: #FFFFFF;
	margin: 0 auto; /* 自动边距（与宽度一起）会将页面居中 */
	border: 1px solid #000000;
	text-align: left; /* 这将覆盖 body 元素上的“text-align: center”。 */
} 

/* 具有标题和脚注的绝对定位侧栏的提示：
1. 必须为绝对定位 (AP) 元素指定顶部边距和侧边距（左边距或右边距）。默认情况下，如果未指定顶部边距，则 AP 元素将紧跟页面源代码中的前一个元素之后出现。这意味着，如果在文档的源代码顺序中，侧栏是 #container 中的第一个元素，那么，即使未提供顶部边距值，侧栏也将出现在 #container 的顶端。但是，如果它们的源代码顺序之后由于任何原因而移动，就需要具有顶部边距值，才能显示在所需的位置。
2. 绝对定位 (AP) 元素已从文档流中去除。这意味着绝对定位元素周围的元素不知道它们是否存在，在占据合理的页面空间时不会考虑它们。因此，如果您确信大部分内容将总是包含在中间的 #mainContent div 中，则只应当将 AP div 用作侧栏。如果任一侧栏中将包含更多的内容，则该侧栏将超出父 div（在本例中父 div 同时还为脚注）的底部，此时侧栏会看起来没有被完全包含进来。
3. 如果满足了上述要求，则可以使用绝对定位侧栏来方便地控制文档的源代码顺序。
4. 如果源代码顺序发生变化，则顶部边距值应当等于标题的高度，因为这将使得这些栏与标题在视觉上对齐。
*/
.thrColAbsHdr #header { 
	height: 60px; /* 如果要更改栏的源代码顺序，则可能需要使用标题的高度，以便可以为栏提供可预测的顶部边距值 */
	background: #DDDDDD; 
	padding: 0 10px 0 20px;  /* 此填充会将出现在它后面的 div 中的元素左对齐。如果 #header 中使用的是图像（而不是文本），您最好删除填充。 */
} 
.thrColAbsHdr #header h1 {
	margin: 0; /* 将 #header div 中最后一个元素的边距设置为零将避免边距重叠（即 div 之间出现的无法解释的空白）。如果 div 周围有边框，则不必将边距设置为零，因为边框也会避免边距重叠 */
	padding: 10px 0; /* 使用填充而不使用边距将可以使元素远离 div 的边缘 */
}
.thrColAbsHdr #sidebar1 {
	position: absolute;
	top: 60px;
	left: 0;
	width: 150px; /* 在符合标准的浏览器中或者在 Internet Explorer 中的标准模式下，此 div 的实际宽度除了包括宽度外，还包括填充和边框 */
	background: #EBEBEB; /* 将显示背景色，其宽度等于栏中内容的长度，*/
	padding: 15px 10px 15px 20px; /* 填充使 div 的内容与边缘保持一定的距离 */
}
.thrColAbsHdr #sidebar2 {
	position: absolute;
	top: 60px;
	right: 0;
	width: 160px; /* 在符合标准的浏览器中或者在 Internet Explorer 中的标准模式下，此 div 的实际宽度除了包括宽度外，还包括填充和边框 */
	background: #EBEBEB; /* 将显示背景色，其宽度等于栏中内容的长度，*/
	padding: 15px 10px 15px 20px; /* 填充使 div 的内容与边缘保持一定的距离 */
}
.thrColAbsHdr #mainContent { 
	margin: 0 200px; /* 此 div 元素的左边距和右边距会在页面两侧上创建两个外部栏。无论侧栏 div 中包含多少内容，栏内的空间都将保留。 */
	padding: 0 10px; /* 请记住，填充是 div 方块内部的空间，边距则是 div 方块外部的空间 */
}
.thrColAbsHdr #footer { 
	padding: 0 10px 0 20px; /* 此填充会将它上面 div 中的所有元素左对齐。 */
	background:#DDDDDD;
} 
.thrColAbsHdr #footer p {
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
--> 
</style>
</head>

<body class="thrColAbsHdr">

<div id="container">
  <div id="header">
<h1>的博客</h1>
  <!-- end #header --></div>
  <div id="sidebar1">
<h3>导航</h3>
<p>此 div 上所显示的背景色刚好与内容等宽。如果您喜欢改用分界线，而且 #mainContent div 将始终包含较多的内容，请在 #mainContent div 的左边缘放置一个边框。 </p>
    <p>Donec eu mi sed turpis feugiat feugiat. Integer turpis arcu, pellentesque  eget, cursus et, fermentum ut, sapien. </p>
  <!-- end #sidebar1 --></div>
  <div id="sidebar2">
<h3>个人中心</h3>
<p>我的收藏<!-- end #sidebar2 --></p>
</div>
  <div id="mainContent">
<h1> 主要内容 </h1>
    <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Praesent aliquam,  justo convallis luctus rutrum, erat nulla fermentum diam, at nonummy quam  ante ac quam. Maecenas urna purus, fermentum id, molestie in, commodo  porttitor, felis. Nam blandit quam ut lacus. Quisque ornare risus quis  ligula. Phasellus tristique purus a augue condimentum adipiscing. Aenean  sagittis. Etiam leo pede, rhoncus venenatis, tristique in, vulputate at,  odio. Donec et ipsum et sapien vehicula nonummy. Suspendisse potenti. </p>
    <h2>H2 级别的标题 </h2>
    <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Praesent aliquam,  justo convallis luctus rutrum, erat nulla fermentum diam, at nonummy quam  ante ac quam. Maecenas urna purus, fermentum id, molestie in, commodo  porttitor, felis. Nam blandit quam ut lacus. Quisque ornare risus quis  ligula. Phasellus tristique purus a augue condimentum adipiscing. Aenean  sagittis. Etiam leo pede, rhoncus venenatis, tristique in, vulputate at, odio.</p>
	<!-- end #mainContent --></div>
  <div id="footer">
<p>脚注</p>
  <!-- end #footer --></div>
<!-- end #container --></div>
</body>
</html>
