<%@ page contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<div id="sidebar1">
	<h3>
		导航
	</h3>
	<p>
		<a href="<%=basePath%>/index.do">返回首页</a>
	</p>
	<p>
		<a href="<%=basePath%>/user/register.do">注册</a>
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
		<a href="<%=basePath%>/user/login.do">登录</a>
		<%
			} else {
		%>
	
	<p>
		<a href="<%=basePath%>/user/logout.do">登出</a>
	</p>
	<a href="<%=basePath%>/user/toedit.do?id=<%=userId%>">修改信息</a>
	<%
		}
	%>
	</p>
	<p>
		<a href="<%=basePath%>/talk/talkList.do">查看专题</a>
	</p>
	<p>
		<a href="<%=basePath%>/user/user.do">我的BLOG</a>
	</p>
	<!-- end #sidebar1 -->
</div>