package lms.view;

import lms.access.LmsAccess;
import lms.access.LmsDAO;
import lms.access.LmsDAO2;
import lms.access.Lms_subAccess;
import lms.model.LmsDTO;
import lms.util.ScannerUtil;

public class StudentLoginApp { // 학생전용

	LmsAccess LmsList = new LmsDAO();
	Lms_subAccess LmsList2 = new LmsDAO2(); // 데이터베이스 입출력 처리하세요.

	public void st(String b) { // st(a) ==> 매개변수 a을 넣어 계속사용
		int menuNum;
		do {
			menuTitle();
			menuNum = ScannerUtil.readInt("입력");
			switch (menuNum) {
			case 1:
				selectS(b);
				break;
			case 2:
				selectGP(b);
				break;
			case 3:
				selectInfo(b);
				break;
			}
		} while (menuNum != 0);

	}

	private void selectS(String b) {
		LmsList2.selectSubject(b);
	}

	private void selectGP(String b) {
		LmsList2.selectGradeStudent(b);
	}

	private void selectInfo(String b) {
		System.out.println("==   정보관리    ==");
		System.out.println("==  1. 정보조회  ==");
		System.out.println("==  2. 정보변경  ==");
		System.out.println("==  0. 상위메뉴  ==");
		System.out.println("=================");
		System.out.println("입력>");
		int num = ScannerUtil.readInt();
		if (num == 1) {
			LmsList.findByID(b);
		} else if (num == 2) {
			LmsDTO dto = new LmsDTO();
			dto.setId(b);
			System.out.println("비밀번호 입력>");
			dto.setPw(ScannerUtil.readStr());
			System.out.println("이메일 수정>");
			dto.setEmail(ScannerUtil.readStr());
			System.out.println("전화번호 수정>");
			dto.setTel(ScannerUtil.readStr());
			LmsList.update(dto);

		} else if (num == 0) {
			return;
		}
	}

	private void menuTitle() {
		System.out.println("==   학생 시스템  ==");
		System.out.println("==   1. 과목조회  ==");
		System.out.println("==   2. 성적조회  ==");
		System.out.println("==   3. 정보조회  ==");
		System.out.println("==   0. 상위메뉴  ==");
		System.out.println("==================");

	}

}
