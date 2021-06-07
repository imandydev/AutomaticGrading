package DTO;

public class MarkDTO {
	private int markID;
	private int tableID;
	private int numberAnswerCorrect;
	private String imgCode;
	private String imgStudentID;
	private String imgFull;
	private double grade;
	private int hide;

	public MarkDTO(int markID, int tableID, int numberAnswerCorrect, String imgCode, String imgStudentID,
			String imgFull, double grade, int hide) {
		super();
		this.markID = markID;
		this.tableID = tableID;
		this.numberAnswerCorrect = numberAnswerCorrect;
		this.imgCode = imgCode;
		this.imgStudentID = imgStudentID;
		this.imgFull = imgFull;
		this.grade = grade;
		this.hide = hide;
	}
	

	public MarkDTO() {
		
	}


	public int getMarkID() {
		return markID;
	}

	public void setMarkID(int markID) {
		this.markID = markID;
	}

	public int getTableID() {
		return tableID;
	}

	public void setTableID(int tableID) {
		this.tableID = tableID;
	}

	public int getNumberAnswerCorrect() {
		return numberAnswerCorrect;
	}

	public void setNumberAnswerCorrect(int numberAnswerCorrect) {
		this.numberAnswerCorrect = numberAnswerCorrect;
	}

	public String getImgCode() {
		return imgCode;
	}

	public void setImgCode(String imgCode) {
		this.imgCode = imgCode;
	}

	public String getImgStudentID() {
		return imgStudentID;
	}

	public void setImgStudentID(String imgStudentID) {
		this.imgStudentID = imgStudentID;
	}

	public String getImgFull() {
		return imgFull;
	}

	public void setImgFull(String imgFull) {
		this.imgFull = imgFull;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public int getHide() {
		return hide;
	}

	public void setHide(int hide) {
		this.hide = hide;
	}

}
