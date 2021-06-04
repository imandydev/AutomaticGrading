package controller;

import java.util.HashMap;

import DTO.AnswerDTO;
import DTO.CodeDTO;
import DTO.TableDTO;
import DTO.UserDTO;
import model.AnswerDAO;
import model.CodeDAO;

public class CodeAndAnswerController {
    public boolean checkCode(int code, UserDTO user, TableDTO table, HashMap<Integer, String> listAnswers) {
    	boolean checkCode= CodeDAO.checkCodeExist(code, table);
    	if (checkCode) {
    		// table.id
			CodeDTO codeDTO =  CodeDAO.insertCode(new CodeDTO(0,table.getId(),code,0));
			if (codeDTO == null)
				return false;
			AnswerDTO answerDTO = new AnswerDTO(codeDTO.getCode(), listAnswers);
			return AnswerDAO.insertAnswer(answerDTO);
		} else
			return false; 
    }
}
