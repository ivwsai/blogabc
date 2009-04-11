package blogabc.tool;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class UploadUtility {
	public static void updateFile(byte[] contents, String storedPath) throws FileNotFoundException, IOException {
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(storedPath));
		bufferedOutputStream.write(contents);
		bufferedOutputStream.close();
	}
}
