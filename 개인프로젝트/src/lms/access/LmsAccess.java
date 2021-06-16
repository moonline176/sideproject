package lms.access;

import lms.model.LmsDTO;

public interface LmsAccess {
	// 회원가입
	public void insert(LmsDTO lms);

	// 정보 변경
	public void update(LmsDTO lms);

	// 로그인
	public boolean login(String id, String pw);

	// 정보조회
	public void findByID(String id);

	// Id(학번)찾기
	public void findId(String name, String email);

}
