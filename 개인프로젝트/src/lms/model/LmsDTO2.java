package lms.model;

// 학사관련 필요 요소 필드 선언
public class LmsDTO2 {
	protected String date;
	protected String grade;
	protected String subject;
	protected String name;
	protected String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LmsDTO2() {
	}

	public LmsDTO2(String date, String grade, String subject, String name) {
		super();
		this.date = date;
		this.grade = grade;
		this.subject = subject;
		this.name = name;
	}

	public void printS() {
		System.out.println("과목: " + this.subject);
	}

	public void printSG() {
		System.out.println("과목: " + this.subject + "/ 성적: " + this.grade);
	}

	public void printSp() {
		System.out.println("과목: " + this.subject + "/ 이름: " + this.name + "/ 학번: " + this.id);
	}

	public void printSp2() {
		System.out.println("과목: " + this.subject + "/ 이름: " + this.name + "/ 학번: " + this.id + "/ 성적: " + this.grade);
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
