package DTO;

import java.util.HashMap;

public class AnswerDTO {
    private int codeID;
    private HashMap<Integer, String> listAnswerByCode;
	public AnswerDTO(int codeID, HashMap<Integer, String> listAnswerByCode) {
		super();
		this.codeID = codeID;
		this.listAnswerByCode = listAnswerByCode;
	}
	public AnswerDTO() {
		super();
	}
	public int getCodeID() {
		return codeID;
	}
	public void setCodeID(int codeID) {
		this.codeID = codeID;
	}
	public HashMap<Integer, String> getListAnswerByCode() {
		return listAnswerByCode;
	}
	public void setListAnswerByCode(HashMap<Integer, String> listAnswerByCode) {
		this.listAnswerByCode = listAnswerByCode;
	}
    
}
