package lms.util;

import java.util.Scanner;

import lms.model.LmsDTO;
import lms.model.LmsDTO2;

public class ScannerUtil {
	static Scanner scanner = new Scanner(System.in);

	// 입력받은 값들을 리턴 DateUtil참고
	public static int readInt(String prompt) {
		System.out.println(prompt + ">");
		return readInt();
	}

	public static int readInt() { // 숫자
		int result = 0;
		while (true) {
			try {
				String temp = scanner.next();
				result = Integer.parseInt(temp);
				break;
			} catch (Exception e) {
				System.out.println("숫자 형식이 아닙니다.");
			}
		}
		return result;
	}

	public static String readStr() { // 문자
		String result = "";
		try {
			result = scanner.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static LmsDTO2 readLs() { // 성적 입력
		System.out.println("날짜,성적,과목,이름>");
		String f = scanner.next();
		String[] arr = f.split(",");
		LmsDTO2 lms = new LmsDTO2(arr[0], arr[1], arr[2], arr[3]);
		return lms;
	}

	static boolean isNumber(String s) { // 정수 판별 함수
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) { // 문자열이 나타내는 숫자와 일치하지 않는 타입의 숫자로 변환 시 발생
			System.out.println("숫자 형식이 아닙니다.");
			return false;
		}
	}

	public static LmsDTO readLms() {// 회원 가입시 여러 정보 입력
		System.out.println("ID,패스워드,이름,학과,성별,생년월일,이메일,주소,전화번호,구분>");
		String f = scanner.next();
		String[] arr = f.split(",");
		LmsDTO lms = null;
		// 회원 가입 시 몇몇 조건들 충족 요구 ( ex)학번:숫자 8자리, 생년월일: 숫자 6자리)
		if (isNumber(arr[0]) == true && arr[0].length() == 8 && isNumber(arr[5]) == true && arr[5].length() == 6
				&& arr[6].contains("@") && ((arr[4].equals("남")) || (arr[4].equals("여")))) {
			lms = new LmsDTO(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[7], arr[8], arr[9]);
		} else {
			System.out.println("가입 실패");
		}
		return lms;

	}

}
