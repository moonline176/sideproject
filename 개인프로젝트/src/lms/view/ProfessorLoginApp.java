package lms.view;

import java.text.SimpleDateFormat;

import lms.access.LmsAccess;
import lms.access.LmsDAO;
import lms.access.LmsDAO2;
import lms.access.Lms_subAccess;
import lms.model.LmsDTO;
import lms.model.LmsDTO2;
import lms.util.ScannerUtil;

public class ProfessorLoginApp { // 교수 전용 로그인

	LmsAccess LmsList = new LmsDAO();
	Lms_subAccess LmsList2 = new LmsDAO2(); // 데이터베이스 입출력 처리하세요.
	SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	String format_time1 = format1.format(System.currentTimeMillis());

	public void prof(String b) {
		int menuNum;
		do {
			menuTitle();
			menuNum = ScannerUtil.readInt("입력");
			switch (menuNum) {
			case 1:
				subject(b);
				break;
			case 2:
				grade(b);
				break;
			case 3:
				info(b);
				break;
			}

		} while (menuNum != 0);

	}

	private void subject(String b) {
		System.out.println("==   과목관리    ==");
		System.out.println("==  1. 과목등록  ==");
		System.out.println("==2. 등록과목조회 ==");
		System.out.println("==  3. 과목인원 조회  ==");
		System.out.println("==  4. 과목삭제  ==");
		System.out.println("==  0. 상위메뉴  ==");
		System.out.println("=================");
		System.out.println("입력>");
		int num = ScannerUtil.readInt();
		LmsDTO2 lms = new LmsDTO2();
		if (num == 1) {
			System.out.println("과목 입력>");
			lms.setSubject(ScannerUtil.readStr());
			System.out.println("이름 입력>");
			lms.setName(ScannerUtil.readStr());
			lms.setId(b);
			lms.setDate(format_time1);
			LmsList2.insertSubject(lms);
		} else if (num == 2) {
			System.out.println("<담당 과목>");
			LmsList2.selectSubject(b);
		} else if (num == 3) {
			System.out.println("과목 입력>");
			String subject = ScannerUtil.readStr();
			System.out.println("<수강신청 학생목록>");
			LmsList2.selectSubjectp(subject);
		} else if (num == 4) {
			System.out.println("폐강 과목 입력>");
			String subject = ScannerUtil.readStr();
			LmsList2.deleteSubject(subject);
		} else if (num == 0) {
			prof(b);
		}

	}

	private void grade(String b) {
		System.out.println("==   성적관리    ==");
		System.out.println("==  1. 성적입력  ==");
		System.out.println("==  2. 성적변경  ==");
		System.out.println("==  3. 성적조회  ==");
		System.out.println("==  0. 상위메뉴  ==");
		System.out.println("=================");
		LmsDTO2 lms = new LmsDTO2();
		int num = ScannerUtil.readInt();
		if (num == 1) {
			lms.setDate(format_time1);
			System.out.println("성적 입력>");
			lms.setGrade(ScannerUtil.readStr());
			System.out.println("과목 입력>");
			lms.setSubject(ScannerUtil.readStr());
			System.out.println("이름 입력>");
			lms.setName(ScannerUtil.readStr());
			LmsList2.insertGrade(lms);
		} else if (num == 2) {
			System.out.println("이름 입력>");
			lms.setName(ScannerUtil.readStr());
			System.out.println("과목 입력>");
			lms.setSubject(ScannerUtil.readStr());
			System.out.println("학점 변경>");
			lms.setGrade(ScannerUtil.readStr());
			LmsList2.updateGrade(lms);
		} else if (num == 3) {
			System.out.println("과목 입력>");
			String subject = ScannerUtil.readStr();
			LmsList2.selectGradep(subject);
		} else if (num == 0) {
			prof(b);
		}
	}

	private void info(String b) {
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
			System.out.println("학번입력>");
			dto.setId(ScannerUtil.readStr());
			System.out.println("비밀번호 입력>");
			dto.setPw(ScannerUtil.readStr());
			System.out.println("이메일 수정>");
			dto.setEmail(ScannerUtil.readStr());
			System.out.println("전화번호 수정>");
			dto.setTel(ScannerUtil.readStr());
			LmsList.update(dto);
		} else if (num == 0) {
			prof(b);
		}
	}

	private void menuTitle() {
		System.out.println("==   교수 관리 시스템  ==");
		System.out.println("==    1. 과목관리     ==");
		System.out.println("==    2. 성적관리     ==");
		System.out.println("==    3. 정보관리     ==");
		System.out.println("==    0. 상위메뉴     ==");
		System.out.println("======================");

	}

}
