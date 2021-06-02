/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Administrator
 */
public class TableDTO {
	private int id;
	private int userId;
	private String tableName;
	private int numberQuestionUse;
	private int hide;

	public TableDTO(int id, UserDTO userDTO, String tableName, int numberQuestionUse, int hide) {
		super();
		this.id = id;
		this.userId = userDTO.getId();
		this.tableName = tableName;
		this.numberQuestionUse = numberQuestionUse;
		this.hide = hide;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public int getNumberQuestionUse() {
		return numberQuestionUse;
	}

	public void setNumberQuestionUse(int numberQuestionUse) {
		this.numberQuestionUse = numberQuestionUse;
	}

	public int getHide() {
		return hide;
	}

	public void setHide(int hide) {
		this.hide = hide;
	}

}
