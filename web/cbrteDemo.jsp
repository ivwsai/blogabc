<html>
<head>
	<title>Cross-Browser Rich Text Editor (RTE)</title>
	<script language="JavaScript" type="text/javascript" src="script/cbrte/html2xhtml.js"></script>
	<script language="JavaScript" type="text/javascript" src="script/cbrte/richtext_compressed.js"></script>
</head>

<body>

<script language="JavaScript" type="text/javascript">
//Usage: initRTE(imagesPath, includesPath, cssFile, genXHTML, encHTML)
initRTE("script/cbrte/images/", "script/cbrte/", "", true);
</script>
<noscript><p><b>Javascript must be enabled to use this form.</b></p></noscript>


<script language="JavaScript" type="text/javascript">
<!--
//build new richTextEditor
var rte1 = new richTextEditor('rte1');
rte1.html = 'welcome';
//rte1.toggleSrc = false;
rte1.build();
//-->
</script>

<%!
public static String rteSafe(String strText) {
	//returns safe code for preloading in the RTE
	String tmpString = strText;
	
	//convert all types of single quotes
	tmpString = tmpString.replace((char)145, (char)39);
	tmpString = tmpString.replace((char)146, (char)39);
	tmpString = tmpString.replace("'", "&#39;");
	
	//convert all types of double quotes
	tmpString = tmpString.replace((char)147, (char)34);
	tmpString = tmpString.replace((char)148, (char)34);
//	tmpString = tmpString.replace("\"", "\"");
	
	//replace carriage returns & line feeds
	tmpString = tmpString.replace((char)10, (char)32);
	tmpString = tmpString.replace((char)13, (char)32);
	
	return tmpString;
}
%>
<!-- END Demo Code -->

</body>
</html>
