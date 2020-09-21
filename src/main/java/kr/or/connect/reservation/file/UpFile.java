package kr.or.connect.reservation.file;

public class UpFile {
	
	private int id;
	private String fileName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "File [id=" + id + ", fileName=" + fileName + "]";
	}

}


