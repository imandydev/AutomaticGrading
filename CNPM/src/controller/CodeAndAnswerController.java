package controller;

import java.util.HashMap;
import java.util.List;

import DTO.AnswerDTO;
import DTO.CodeDTO;
import DTO.TableDTO;
import DTO.UserDTO;
import model.AnswerDAO;
import model.CodeDAO;

public class CodeAndAnswerController {
//	them ma de va dap an
	public boolean insertCodeAndAnswer(int code, TableDTO table, HashMap<Integer, String> listAnswers) {
//		kiem tra ma de ton tai ?
		boolean checkCode = CodeDAO.checkCodeExist(code, table);
		if (!checkCode) {
//			insert ma de
			CodeDTO codeDTO = CodeDAO.insertCode(new CodeDTO(0, table.getId(), code, 0));
//			insert that bai
			if (codeDTO == null) {
				return false;
			} else {
//				insert dap an
				AnswerDTO answerDTO = new AnswerDTO(codeDTO.getCodeID(), listAnswers);
				boolean checkInsertAns = AnswerDAO.insertAnswer(answerDTO);
//				insert dap an that bai
				if (!checkInsertAns) {
					CodeDAO.removeCodeByID(codeDTO.getCodeID());
					return false;
				} else
				return true;
			}
		} else
			return false;
	}
	public List<CodeDTO> loadListCodeByIDTable(TableDTO table) {
		return CodeDAO.loadCodeByIDTable(table);
	}
}
