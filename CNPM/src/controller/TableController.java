package controller;

import java.util.List;

import DTO.TableDTO;
import model.TableDAO;

public class TableController {
	public boolean checkTableByName(String nameTable) {
		boolean exist = TableDAO.checkTableExist(nameTable);
		if (exist) {
			return true;
		} else {
			return false;
		}
	}

	public int insertTable(TableDTO tableDTO) {
		boolean check = checkTableByName(tableDTO.getTableName());
		if (!check) {
			return TableDAO.insertTable(tableDTO);
		} else {
			return 0;
		}
	}

	public List<TableDTO> findListTableAllByHide() {
		return TableDAO.findListTableAllByHide();
	}

	public boolean removeTableManagerByID(int tableId) {
		return TableDAO.removeTableManagerByID(tableId);
	}
}
