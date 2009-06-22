<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" errorPage="/error/error.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>_blogabc_首页</title>
		<link href="css/blog.css" rel="stylesheet" type="text/css" />
		<style type="text/css">
<!--
.STYLE1 {
	color: #5C6321;
	font-weight: bold;
}
#blogs{
	position:relative;
	width:600px;
	z-index:1;
	left: 0px;
	top: 0px;
	margin: 0 0 0 132px;
	padding: 0 20px; 
	}
#board{
margin: 0 0 0 132px;
padding: 0 20px; 
}
.STYLE3 {
	color: #669933;
	font-weight: bold;
}
.STYLE6 {color: #FFFFFF}
.STYLE8 {color: #FFFFFF; font-weight: bold; }
.STYLE9 {color: #669933}

-->
        </style>
</head>

	<body class="marsCss1">
    <div id="container">
    <div id="header">
	<img src="image/blogabc_logo.jpg" alt="blogabc" width="145" height="60">
	</div>

<%@ include file="/include/left.jsp"%>
            
<!--div id="mainContent"-->
<div id="nothing">
        <div id="special">
          <table width="538" height="300" border="1" cellpadding="0" cellspacing="1" bordercolor="#003366">
            <tr>
              <td width="532" height="25" bgcolor="#000000"><span class="STYLE3">专题</span></td>
            </tr>
            <tr>
              <td valign="top" bgcolor="#0066CC"><span class="STYLE6">主讲人</span></td>
            </tr>
            <tr>
              <td><c:out value="${lastTalk.persons}"/>
              <p>&nbsp;</p>
              <p>&nbsp;</p></td>
            </tr>
            <tr>
              <td valign="top" bgcolor="#0066CC"><span class="STYLE6">引入[why]</span></td>
            </tr>
            <tr>
              <td><c:out value="${lastTalk.introduction}"/>
              <p>&nbsp;</p>
              <p>&nbsp;</p>
              </td>
            </tr>
            <tr>
              <td bgcolor="#0066CC"><span class="STYLE6">介绍[what&how]</span></td>
            </tr>
            <tr>
              <td><c:out value="${lastTalk.howto}"/>
              <p>&nbsp;</p>
              <p>&nbsp;</p>
			  </td>
            </tr>
            <tr>
              <td bgcolor="#0066CC"><span class="STYLE6">附件</span></td>
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
              <td bgcolor="#0066CC"><span class="STYLE6">作业</span></td>
            </tr>
            <tr>
              <td><c:out value="${lastTalk.exercise}"/>
              <p>&nbsp;</p>
              <p>&nbsp;</p>
             </td>
            </tr>
            <tr>
              <td height="25" bgcolor="#0066CC"><span class="STYLE8">最新回复</span></td>
            </tr>
            <tr>
              <td>
              <p>&nbsp;</p>
              <p>&nbsp;</p>
       		  </td>
            </tr>
          </table>
          <br>
        </div>
        <div id="blogs">
<table width="538" height="52" border="1" cellpadding="0" cellspacing="0" bordercolor="#0066CC">
<tr>
              <td width="538" height="21" bgcolor="#000000"><span class="STYLE9">最新博文</span></td>
        </tr>
            <tr>
            <td height="29" valign="top">
            <table width="528">             
              <c:forEach items="${newArticles}" var="article" varStatus="status1">
               <tr>
              <td width="40">
                <c:out value="${status1.index+1}"/>·
                </td>
              <td width="362">
					<a href="<%=basePath%>/blog/detail.do?id=${article.id}">
                    <c:out value="${article.title}"/>
                  	</a>
                </td>
              <td width="173"><fmt:formatDate value="${article.createTime}" pattern="yyyy-MM-dd"/> </td>
              </tr>
              </c:forEach>
              </table>
			</td>
        </tr>
          </table>
  <br>
        </div>
        <div id="blogs">
      <table width="538" height="52" border="1" cellpadding="0" cellspacing="0" bordercolor="#0066CC">
        <tr>
          <td width="538" height="21" bgcolor="#000000"><span class="STYLE9">热点博文</span></td>
        </tr>
        <tr>
          <td valign="top"><table width="536">
              <c:forEach items="${hotArticles}" var="article" varStatus="status">
                <tr>
                  <td width="40"><c:out value="${status.index+1}"/>
                    ·</td>
                  <td width="362">
					<a href="<%=basePath%>/blog/detail.do?id=${article.id}">
                    <c:out value="${article.title}"/>
                  	</a>
                  </td>
                  <td width="118">
                  <c:out value="${article.up}"/>
                  </td>
                </tr>
              </c:forEach>
          </table></td>
        </tr>
      </table>
    </div>
</div>
  <div id="board">
                热文榜
<table width="240" border="1" cellpadding="0" cellspacing="0" bordercolor="#FFFF99">
					<c:forEach items="${topUsersList}" var="user" varStatus="status">
						<tr>
							<td width="20">
								<c:out value="${status.index+1}" />
							</td>
							<td width="120">
								<a href="<%=basePath%>/user/user.do?id=${user.id}">
								<c:out value="${user.firstName}· ${user.lastName}"/>
								</a>
							</td>
							<td width="100">
								<span class="STYLE1"><c:out value="${user.point}" />
								</span>
							</td>
						</tr>
					</c:forEach>
  		  </table>
        </div>
  <div id="board">
        		红人榜
<table width="240" border="1" cellpadding="0" cellspacing="0" bordercolor="#FFCCFF">
			  <c:forEach items="${topUsersList}" var="user" varStatus="status">
						<tr>
							<td width="20">
								<c:out value="${status.index+1}" />
							</td>
							<td width="120">
								<a href="<%=basePath%>/user/user.do?id=${user.id}">
								<c:out value="${user.firstName}· ${user.lastName}"/>
								</a>
							</td>
							<td width="100">
								<span class="STYLE1"><c:out value="${user.point}" />
								</span>
							</td>
						</tr>
					</c:forEach>
		  		</table>
    </div>
			<br class="clearfloat" />
			<div id="footer">
				<p align="right">
					<a href="http://blogabc.googlecode.com/"><img
							src="image/part.jpg" width="26" height="27" />&copy;blogabc</a>
				</p>
			</div>
		</div>
	</body>
</html>
