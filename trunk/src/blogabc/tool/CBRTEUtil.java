package blogabc.tool;

public class CBRTEUtil {
	
	//rte1 = "here's the " + (char)13 + "\"preloaded <b>content</b>\"";
	//rte1 = rteSafe(rte1);
	public static String rteSafe(String strText) {
		// returns safe code for preloading in the RTE
		String tmpString = strText;

		// convert all types of single quotes
		tmpString = tmpString.replace((char) 145, (char) 39);
		tmpString = tmpString.replace((char) 146, (char) 39);
		tmpString = tmpString.replace("'", "&#39;");

		// convert all types of double quotes
		tmpString = tmpString.replace((char) 147, (char) 34);
		tmpString = tmpString.replace((char) 148, (char) 34);
		// tmpString = tmpString.replace("\"", "\"");

		// replace carriage returns & line feeds
		tmpString = tmpString.replace((char) 10, (char) 32);
		tmpString = tmpString.replace((char) 13, (char) 32);

		return tmpString;
	}
}
