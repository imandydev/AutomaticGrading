package controller;

import java.io.File;
import java.io.ObjectInputStream.GetField;
import java.util.HashMap;
import java.util.Map;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

import DAO.AnswerDAO;
import DAO.CodeDAO;
import DAO.MarkDAO;
import imageProccess.ImageProcess;
import model.MarkDTO;

public class MarkController {
	static ImageProcess imgProcess = new ImageProcess();

	public boolean checkImage(File file) {
		return (file.getAbsolutePath().endsWith("jpg") || file.getAbsolutePath().endsWith("jpeg")
				|| file.getAbsolutePath().endsWith("png"));
	}

//	File là ảnh cần chấm điểm truyền vào, numberQuestionUse là số câu muốn chấm bắt đầu từ 1
//	public void mark(int tableID, int numberQuestionUse, File img) throws Exception {
//		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//		Mat s = Imgcodecs.imread(img.getAbsolutePath());
//		imgProcess.scan(s, numberQuestionUse);
//
//		// Lấy ra mssv từ file hình ảnh
//		String imgStudentID = imgProcess.getMssv().trim();
//		System.out.println("MSSV: " + imgStudentID);
//
//		// Lấy ra mã đề của file hình ảnh
//		String imgCode = imgProcess.getCode().trim();
//		System.out.println("Mã đề: " + imgCode);
//
//		// Tìm kiếm mã đề trong BD từ mã
//		int codeID = CodeDAO.findCodeID(tableID, Integer.parseInt(imgCode));
//		System.out.println("CodeID: " + codeID);
//		if (codeID == 0) {
//			MarkDTO mark = new MarkDTO(0, tableID, codeID, 0, imgCode, imgStudentID, img.getName(), 0, 0);
//			MarkDAO.insertMark(mark);
//		} else {
//			HashMap<Integer, String> listAnswerImg = (HashMap<Integer, String>) imgProcess.getAnswer();
//			System.out.println("Đáp án: " + listAnswerImg);
//			int numberAnswerCorrect = AnswerDAO.getNumberAnswerCorrect(listAnswerImg, codeID);
//			System.out.println("Số câu đúng: " + numberAnswerCorrect);
//			double grade = numberAnswerCorrect / numberQuestionUse;
//			System.out.println("Điểm: " + grade);
//			MarkDTO mark = new MarkDTO(0, tableID, codeID, numberAnswerCorrect, imgCode, imgStudentID, img.getName(),
//					grade, 0);
//			MarkDAO.insertMark(mark);
//		}
//
//	};

//	File là ảnh cần chấm điểm truyền vào, numberQuestionUse là số câu muốn chấm bắt đầu từ 1
//	public  void scan(File file, int numberQuestionUse) throws Exception {
//		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//		Mat s = Imgcodecs.imread(file.getAbsolutePath());
//		imgProcess.scan(s, numberQuestionUse);
//	}
}
