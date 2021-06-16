package lms.model;

public class LmsDTO {

	// 회원가입 시 필요 요소 필드 선언

	protected String id;

	protected String pw;

	protected String name;

	protected String dept;

	protected String gender;

	protected String birth;

	protected String email;

	protected String address;

	protected String tel;

	protected String gubun;

	public LmsDTO() {
	}

	public LmsDTO(String id, String pw, String name, String dept, String gender, String birth, String email,
			String address, String tel, String gubun) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.dept = dept;
		this.gender = gender;
		this.birth = birth;
		this.email = email;
		this.address = address;
		this.tel = tel;
		this.gubun = gubun;
	}

	public String getGubun() {
		return gubun;
	}

	public void setGubun(String gubun) {
		this.gubun = gubun;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public void print() {
		System.out.println("이름 : " + this.name);
		System.out.println("학번 : " + this.id);
		System.out.println("학과 : " + this.dept);
		System.out.println("성별 : " + this.gender);
		System.out.println("이메일 : " + this.email);
		System.out.println("주소 : " + this.address);
		System.out.println("전화 : " + this.tel);
		System.out.println("구분 : " + this.gubun);
	}

	public void printId() {
		System.out.println("학번: " + this.id);
	}

}
