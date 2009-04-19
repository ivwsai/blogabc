/**
 * BLOGABC system 1.0
 * 
 * This is an open source system for studying spring framework and hibernate.
 * You can use it anywhere and you can ask your question or update your good idea. 
 * author: ericHan1979@gmail.com
 * date: 2009-3-30
 */
package blogabc.tool;

public class StringUtility {

	public static String setBR(String content, int defineLineLen) {
		StringBuffer sf = new StringBuffer();

		int endIndex = defineLineLen;
		int beginIndex = 0;
		while (endIndex < content.length()) {
			sf.append(content.substring(beginIndex, endIndex-1) + "<br/>");
			beginIndex = endIndex;
			endIndex += defineLineLen;
		}
		sf.append(content.substring(beginIndex, content.length()));
		
		return sf.toString();
	}
}
