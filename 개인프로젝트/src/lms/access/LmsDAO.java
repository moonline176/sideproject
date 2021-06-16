package lms.access;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import lms.model.LmsDTO;
import lms.util.DAO;

public class LmsDAO extends DAO implements LmsAccess {
	static PreparedStatement psmt;
	static ResultSet rs;
	String sql;

	SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String format_time1 = format1.format(System.currentTimeMillis());

	// 회원가입
	@Override
	public void insert(LmsDTO lms) {
		try {

			String sql = "insert into Lms (id,pw,name,gender,birth,email,tel,dept,address,gubun,date) values (?,?,?,?,?,?,?,?,?,?,?)";
			// 항목 추가
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, lms.getId());

			psmt.setString(2, lms.getPw());

			psmt.setString(3, lms.getName());

			psmt.setString(4, lms.getGender());

			psmt.setString(5, lms.getBirth());

			psmt.setString(6, lms.getEmail());

			psmt.setString(7, lms.getTel());

			psmt.setString(8, lms.getDept());

			psmt.setString(9, lms.getAddress());

			psmt.setString(10, lms.getGubun());

			psmt.setString(11, format_time1);

			psmt.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	// 회원정보 수정
	@Override
	public void update(LmsDTO lms) {
		try {

			String sql = "update Lms set email=?, tel=? where id=? and pw=?";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, lms.getEmail());

			psmt.setString(2, lms.getTel());

			psmt.setString(3, lms.getId());

			psmt.setString(4, lms.getPw());

			psmt.executeUpdate();

		} catch (Exception e) {

			System.out.println(e.toString());

		}

	}

	// 아이디 조회
	@Override // 이름 + 이메일 ==> 아이디 출력
	public void findByID(String id) {
		LmsDTO lms = new LmsDTO();

		try {

			sql = "select * from Lms where id=?";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, id);

			rs = psmt.executeQuery();

			while (rs.next()) {

				lms.setId(rs.getString("id"));

				lms.setPw(rs.getString("pw"));

				lms.setName(rs.getString("name"));

				lms.setGender(rs.getString("gender"));

				lms.setBirth(rs.getString("birth"));

				lms.setEmail(rs.getString("email"));

				lms.setTel(rs.getString("tel"));

				lms.setDept(rs.getString("dept"));

				lms.setAddress(rs.getString("address"));

				lms.setGubun(rs.getString("gubun"));

				lms.print();

			}

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	// 로그인
	@Override
	public boolean login(String id, String pw) {

		String sql = "select * from Lms where id=? and pw=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			rs = psmt.executeQuery(); // insert, update, delete 할 때 execute사용
			if (rs.next()) { // 쿼리를 실행했을때 결과값이 존재 , 만약 같은 이름으로 여러 과목을 신청햇을경우에 while문을 써서 과목을 조회함
				// id와 pw가 중복되지 않는다는 전제 조건하에 if문 사용
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override // 학번 찾기
	public void findId(String name, String email) {
		LmsDTO lms = new LmsDTO();

		try {

			sql = "select * from Lms where name=? and email=?";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, name);

			psmt.setString(2, email);

			rs = psmt.executeQuery();

			if (rs.next()) {
				lms.setId(rs.getString("id"));
				lms.printId();
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
