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
                result = result.substring(10);  
            } else if (result.startsWith("file")) {  
                result = result.substring(6);  
            }  
            String os = System.getProperty("os.name");  
            if (os.indexOf("Windows") >= 0)  
                return result;  
            else  
                return "/" + result;  
        } catch (Exception e) {  
            return "";  
        }  
    }  
  
    public String getRootPath() {  
        String result = BlogabcApplication.class.getResource("BlogabcApplication.class").toString();  
        int index = result.indexOf("WEB-INF");  
        if (index == -1) {  
            index = result.indexOf("bin");  
        }  
        result = result.substring(0, index);  
        if (result.startsWith("jar")) {  
            result = result.substring(10);  
        } else if (result.startsWith("file")) {  
            result = result.substring(6);  
        }  
        String os = System.getProperty("os.name");  
        if (os.indexOf("Windows") >= 0)  
            return result;  
        else  
            return "/" + result;  
    }  
}  
