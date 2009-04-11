<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>Upload Page</title>
</head>
<body>
    <form name="uploadForm" enctype="multipart/form-data" action="upload.do" method="POST">
        上载后文件名称: <input name="name" type="text"/><br>
        选择文件: <input name="contents" type="file"/><br>
        <input type="submit" value="Submit"/>  
    </form>
</body>
</html>