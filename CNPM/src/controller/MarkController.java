package controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

import DTO.MarkDTO;
import model.AnswerDAO;
import model.CodeDAO;
import model.MarkDAO;

public class MarkController {
	static ImageProcess imgProcess = new ImageProcess();

	public boolean checkImage(File file) {
		return (file.getAbsolutePath().endsWith("jpg") || file.getAbsolutePath().endsWith("jpeg")
				|| file.getAbsolutePath().endsWith("png"));
	}

//	File lÃ  áº£nh cáº§n cháº¥m Ä‘iá»ƒm truyá»�n vÃ o, numberQuestionUse lÃ  sá»‘ cÃ¢u muá»‘n cháº¥m báº¯t Ä‘áº§u tá»« 1
	public boolean mark(int tableID, int numberQuestionUse, File img) throws Exception {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		Mat s = Imgcodecs.imread(img.getAbsolutePath());
		try {
			imgProcess.scan(s, numberQuestionUse);

			// Láº¥y ra mssv tá»« file hÃ¬nh áº£nh
			String imgStudentID = imgProcess.getMssv().trim();
			System.out.println("MSSV Ä‘Æ°á»£c tÃ´: " + imgStudentID);

			// Láº¥y ra mÃ£ Ä‘á»� cá»§a file hÃ¬nh áº£nh
			String imgCode = imgProcess.getCode().trim();
			System.out.println("MÃ£ Ä‘á»� Ä‘Æ°á»£c tÃ´: " + imgCode);

			// Kiá»ƒm tra sinh viÃªn tÃ´ mÃ£ Ä‘á»� cÃ³ há»£p lá»‡ hay khÃ´ng
			if (imgCode.contains("-")) {
				MarkDTO mark = new MarkDTO(0, tableID, 0, imgCode, imgStudentID, img.getAbsolutePath(), 0, 0);
				System.out.println(mark.toString());
				MarkDAO.insertMark(mark);
			} else {
				// TÃ¬m kiáº¿m mÃ£ Ä‘á»� trong BD tá»« mÃ£
				int codeID = CodeDAO.findCodeID(tableID, Integer.parseInt(imgCode));
				System.out.println("CodeID: " + codeID);

				// TrÆ°á»�ng há»£p khÃ´ng tÃ¬m tháº¥y mÃ£ Ä‘á»� trong DB
				if (codeID == 0) {
					MarkDTO mark = new MarkDTO(0, tableID, 0, imgCode, imgStudentID, img.getAbsolutePath(), 0, 0);
					System.out.println(mark.toString());
					MarkDAO.insertMark(mark);
				} else {
					HashMap<Integer, String> listAnswerImg = (HashMap<Integer, String>) imgProcess.getAnswer();
					System.out.println("Ä�Ã¡p Ã¡n: " + listAnswerImg);
					int numberAnswerCorrect = AnswerDAO.getNumberAnswerCorrect(listAnswerImg, codeID);
					System.out.println("Sá»‘ cÃ¢u Ä‘Ãºng: " + numberAnswerCorrect);
					System.out.println("Tá»•ng sá»‘ cÃ¢u: " + numberQuestionUse);

					double grade = (double) numberAnswerCorrect / numberQuestionUse * 10;
					grade = Math.ceil(grade * 100) / 100; // lÃ m trÃ²n Ä‘iá»ƒm: láº¥y 2 chá»¯ sá»‘ tháº­p phÃ¢n
					System.out.println("Ä�iá»ƒm: " + grade);

					MarkDTO mark = new MarkDTO(0, tableID, numberAnswerCorrect, imgCode, imgStudentID,
							img.getAbsolutePath(), grade, 0);
					MarkDAO.insertMark(mark);
				}
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	//tim tat ca cac bai da cham
		public List<MarkDTO> findListMarkAllByTableId(int tableId) {
			return MarkDAO.findListMarkAllByTableId(tableId);
		}
		
		// xoa
		public boolean removeMarkByID(int markId) {
			return MarkDAO.removeMarkByID(markId);
		}

}
