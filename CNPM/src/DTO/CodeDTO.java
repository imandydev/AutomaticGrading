package DTO;

public class CodeDTO {
    private int codeID;
    private int tableID;
    private int code;
    private int hide;
	public CodeDTO(int codeID, int tableID, int code, int hide) {
		super();
		this.codeID = codeID;
		this.tableID = tableID;
		this.code = code;
		this.hide = hide;
	}
	public CodeDTO() {
		super();
	}
	public int getCodeID() {
		return codeID;
	}
	public void setCodeID(int codeID) {
		this.codeID = codeID;
	}
	public int getTableID() {
		return tableID;
	}
	public void setTableID(int tableID) {
		this.tableID = tableID;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public int getHide() {
		return hide;
	}
	public void setHide(int hide) {
		this.hide = hide;
	}
    
}
