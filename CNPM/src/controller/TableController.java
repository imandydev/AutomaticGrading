package controller;

import java.util.List;

import DTO.TableDTO;
import model.TableDAO;

public class TableController {
	public boolean checkTableByName(String nameTable) {
		return TableDAO.checkTableExist(nameTable);	
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
	
	//tim table theo id
		public TableDTO findTableById(int tableId) {
			return TableDAO.findTableById(tableId);
		}


	public boolean removeTableManagerByID(int tableId) {
		return TableDAO.removeTableManagerByID(tableId);
	}
}
