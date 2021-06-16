package lms.view;

import lms.access.LmsAccess;
import lms.access.LmsDAO;
import lms.model.LmsDTO;
import lms.util.ScannerUtil;

public class LmsCliApp { // 첫 시작 화면

	LmsAccess LmsList = new LmsDAO(); // 데이터베이스 입출력 처리하세요.
	ProfessorLoginApp prof = new ProfessorLoginApp();
	StudentLoginApp st = new StudentLoginApp();

	public void start() {
		int menuNum;

		do {
			menuTitle();
			menuNum = ScannerUtil.readInt("입력");
			switch (menuNum) {
			case 1:
				login();
				break;
			case 2:
				insert();
				break;
			case 3:
				findId();
				break;
			}
		} while (menuNum != 0);
		System.out.println("프로그램 종료.");
	}

	private void findId() {
		System.out.println("이름>");
		String name = ScannerUtil.readStr();
		System.out.println("이메일>");
		String email = ScannerUtil.readStr();
		LmsList.findId(name, email);
	}

	// 로그인
	private void login() {
		System.out.println("<로그인>");
		System.out.println("id>");
		String id = ScannerUtil.readStr();
		System.out.println("password>");
		String pass = ScannerUtil.readStr();
		if (LmsList.login(id, pass)) {
			// getInfo 메소드 값을 넣어 st(),prof()에 매개변수를 입력 후 계속 사용
			String b = member(id);
			if (id.matches("1000(.*)")) {
				System.out.println("로그인 성공");
				st.st(b); // () 안에 member 타입의 매개변수 넣을것
			} else if (id.matches("2000(.*)")) {
				System.out.println("로그인 성공");
				prof.prof(b);
			}
		} else {
			System.out.println("로그인 실패");
		}

	}

	// 회원가입
	private void insert() {
		LmsDTO lms = ScannerUtil.readLms();
		LmsList.insert(lms);
	}

	private void menuTitle() {
		System.out.println("====  학사관리 시스템  ====");
		System.out.println("==   1. 로그인         ==");
		System.out.println("==   2. 회원가입       ==");
		System.out.println("==   3. 학번(ID) 찾기  ==");
		System.out.println("==      0. 종료       ==");
		System.out.println("=======================");

	}

	public String member(String id) {
		return id;
	}

}
