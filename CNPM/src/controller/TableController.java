package controller;

import java.util.List;

import DTO.TableDTO;
import DTO.UserDTO;
import model.TableDAO;

public class TableController {
	public boolean checkTableByName(String nameTable, int userId) {
		return TableDAO.checkTableExist(nameTable, userId);
	}

	public int insertTable(TableDTO tableDTO) {
		boolean check = checkTableByName(tableDTO.getTableName(), tableDTO.getUserId());
		if (!check) {
			return TableDAO.insertTable(tableDTO);
		} else {
			return -1;
		}
	}

	public List<TableDTO> findListTableAllByHide(int userId) {
		return TableDAO.findListTableAllByHide(userId);
	}

	// tim table theo id
	public TableDTO findTableById(int tableId) {
		return TableDAO.findTableById(tableId);
	}

	public boolean removeTableManagerByID(int tableId) {
		return TableDAO.removeTableManagerByID(tableId);
	}
}
