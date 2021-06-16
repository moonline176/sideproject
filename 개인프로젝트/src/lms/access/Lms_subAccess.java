package lms.access;

import lms.model.LmsDTO2;

public interface Lms_subAccess {

	// 학생과목조회
	public LmsDTO2 selectSubject(String name);

	// 학생성적조회
	public LmsDTO2 selectGradeStudent(String id);

	// 교수 과목 조회
	public LmsDTO2 selectSubjectp(String subject);

	// 교수성적조회
	public LmsDTO2 selectGradep(String id);

	// 과목등록
	public void insertSubject(LmsDTO2 lms);

	// 과목제거
	public void deleteSubject(String subject);

	// 성적등록
	public void insertGrade(LmsDTO2 lms);

	// 성적변경
	public void updateGrade(LmsDTO2 lms);

}
