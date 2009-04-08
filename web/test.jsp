<html>
<head>
<meta http-equiv="Content-Type" content="text/html">
<title>Example::Hello</title>
<script language="javascript" src="script/prototype.js"></script>
<script language="javascript" src="script/buffalo.js"></script>
<script language="javascript">
var END_POINT="<%=request.getContextPath()%>/bfapp";
var buffalo = new Buffalo(END_POINT);
function hello() {
    var p1 = $("myname").value;
    buffalo.remoteCall("helloService.hello",[p1], function(reply) {
        alert(reply.getResult());
    });
}
</script>
</head>
<body>
    <p>Buffalo Hello World</p>
    <p>&nbsp;</p>
    <form name="form1" method="post" action="">
      Your name: 
      <input name="myname" type="text" id="myname">
      <input type="button" name="Submit" value="Hello" onclick="hello()">
    </form>
</body>
</html>