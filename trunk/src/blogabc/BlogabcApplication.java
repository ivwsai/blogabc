package blogabc;

public class BlogabcApplication {

	private BlogabcApplication() {

	}

	public static BlogabcApplication getInstance() {
		return new BlogabcApplication();
	}

	public String getClassRootPath() {
		try {
			String result = BlogabcApplication.class.getResource("BlogabcApplication.class").toString();
			int index = result.indexOf("classes");
			result = result.substring(0, index) + "classes";
			if (result.startsWith("jar")) {
				// 当class文件在jar文件中时，返回"jar:file:/F:/ …"样的路径
				result = result.substring(10);
			} else if (result.startsWith("file")) {
				// 当class文件在jar文件中时，返回"file:/F:/ …"样的路径
				result = result.substring(6);
			}
			return result;
		} catch (Exception e) {
			return "";
		}
	}

	public String getRootPath() {
		// 因为类名为”Application”，因此” Application.class”一定能找到
		String result = BlogabcApplication.class.getResource("BlogabcApplication.class").toString();
		int index = result.indexOf("WEB-INF");
		if (index == -1) {
			index = result.indexOf("bin");
		}
		result = result.substring(0, index);
		if (result.startsWith("jar")) {
			// 当class文件在jar文件中时，返回"jar:file:/F:/ …"样的路径
			result = result.substring(10);
		} else if (result.startsWith("file")) {
			// 当class文件在jar文件中时，返回"file:/F:/ …"样的路径
			result = result.substring(6);
		}
		return result;
	}
}