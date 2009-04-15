package blogabc.form;

public class FileForm {
	private String name;

	private byte[] contents;

	public void setName(String name) {
		this.name = name;
	}

	public void setContents(byte[] contents) {
		this.contents = contents;
	}

	public String getName() {
		return name;
	}

	public byte[] getContents() {
		return contents;
	}
}
