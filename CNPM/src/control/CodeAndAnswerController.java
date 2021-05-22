package control;

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
			CodeDTO codeDTO = new CodeDTO(0, 0, code, 0);
			checkCode = CodeDAO.insertCode(codeDTO);
			if (checkCode) {
				codeDTO = CodeDAO.getCodeNewInsert();
				AnswerDTO answerDTO = new AnswerDTO(codeDTO.getCode(), listAnswers);
				return AnswerDAO.insertAnswer(answerDTO);
			}
			return false;
		} else
			return false; 
    }
}
