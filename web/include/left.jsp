<%@ page contentType="text/html; charset=utf-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<div id="sidebar1">
	<h3>
		导航
	</h3>
	<p>
		<a href="../index.jsp">返回首页</a>
	</p>
	<p>
		<%
			Long userId;
			try {
				userId = (Long) request.getSession().getAttribute("userId");
			} catch (Exception e) {
				userId = null;
			}
			if (userId == null) {
		%>
		<a href="../user/login.do">登录</a>
		<%
			} else {
		%>
	
	<p>
		<a href="../user/logout.do">登出</a>
	</p>
	<a href="../user/toedit.do?id=<%=userId%>">修改信息</a>
	<%
		}
	%>
	</p>
	<p>
		查看专题
	</p>
	<p>
		查看热文
	</p>
	<p>
		查看新闻
	</p>
	<p>
		我的BLOG
	</p>
	<!-- end #sidebar1 -->
</div>