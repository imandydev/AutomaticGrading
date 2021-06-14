package controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

import DTO.MarkDTO;
import config.AllSetting;
import model.AnswerDAO;
import model.CodeDAO;
import model.MarkDAO;

public class MarkController {
	static ImageProcess imgProcess = new ImageProcess();

	public boolean checkImage(File file) {
		return (file.getAbsolutePath().endsWith("jpg") || file.getAbsolutePath().endsWith("jpeg")
				|| file.getAbsolutePath().endsWith("png"));
	}
//	lay ra thu muc chua file jar chay chuong trinh
	public String getLocationFile() {
		return ClassLoader.getSystemClassLoader().getResource(".").getPath();
	}
	
//	File là ảnh cần chấm điểm truyền vào, numberQuestionUse là số câu muốn chấm bắt đầu từ 1
	public boolean mark(int tableID, int numberQuestionUse, File img) throws Exception {
//		vi tri thu vien opencv, dung khi nen file jar
//		String location = getLocationFile()+AllSetting.direcOpenCV+"/";
//		System.load(location + Core.NATIVE_LIBRARY_NAME +".dll");
//		dung khi chạy eclipse
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		Mat s = Imgcodecs.imread(img.getAbsolutePath());
		try {
			imgProcess.scan(s, numberQuestionUse);

			// Lấy ra mssv từ file hình ảnh
			String imgStudentID = imgProcess.getMssv().trim();
			System.out.println("MSSV được tô: " + imgStudentID);

			// Lấy ra mã đề của file hình ảnh
			String imgCode = imgProcess.getCode().trim();
			System.out.println("Mã đề được tô: " + imgCode);

			// Kiểm tra sinh viên tô mã đề có hợp lệ hay không
			if (imgCode.contains("-")) {
				MarkDTO mark = new MarkDTO(0, tableID, 0, imgCode, imgStudentID, img.getAbsolutePath(), 0, 0);
				System.out.println(mark.toString());
				MarkDAO.insertMark(mark);
			} else {
				// Tìm kiếm mã đề trong BD từ mã
				int codeID = CodeDAO.findCodeID(tableID, Integer.parseInt(imgCode));
				System.out.println("CodeID: " + codeID);

				// Trường hợp không tìm thấy mã đề trong DB
				if (codeID == 0) {
					MarkDTO mark = new MarkDTO(0, tableID, 0, imgCode, imgStudentID, img.getAbsolutePath(), 0, 0);
					System.out.println(mark.toString());
					MarkDAO.insertMark(mark);
				} else {
					HashMap<Integer, String> listAnswerImg = (HashMap<Integer, String>) imgProcess.getAnswer();
					System.out.println("Đáp án: " + listAnswerImg);
					int numberAnswerCorrect = AnswerDAO.getNumberAnswerCorrect(listAnswerImg, codeID);
					System.out.println("Số câu đúng: " + numberAnswerCorrect);
					System.out.println("Tổng số câu: " + numberQuestionUse);

					double grade = (double) numberAnswerCorrect / numberQuestionUse * 10;
					grade = Math.ceil(grade * 100) / 100; // làm tròn điểm: lấy 2 chữ số thập phân
					System.out.println("Điểm: " + grade);

					MarkDTO mark = new MarkDTO(0, tableID, numberAnswerCorrect, imgCode, imgStudentID,
							img.getAbsolutePath(), grade, 0);
					MarkDAO.insertMark(mark);
				}
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}	//tim tat ca cac bai da cham
		public List<MarkDTO> findListMarkAllByTableId(int tableId) {
			return MarkDAO.findListMarkAllByTableId(tableId);
		}
		
		// xoa
		public boolean removeMarkByID(int markId) {
			return MarkDAO.removeMarkByID(markId);
		}

}
