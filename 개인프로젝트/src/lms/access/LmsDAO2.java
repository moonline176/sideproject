package lms.access;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import lms.model.LmsDTO2;
import lms.util.DAO;

public class LmsDAO2 extends DAO implements Lms_subAccess {
	static PreparedStatement psmt;
	static ResultSet rs;
	String sql;

	@Override // 과목조회
	public LmsDTO2 selectSubject(String id) {
		String sql = "select * from Lms_sub where id = ?";
		LmsDTO2 d = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			while (rs.next()) {
				d = new LmsDTO2();
				d.setSubject(rs.getString("subject"));
				d.printS();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return d;
	}

	@Override // 성적조회
	public LmsDTO2 selectGradeStudent(String id) { // join문 사용
		String sql = "select * from Lms_sub where id = ? ";
		LmsDTO2 d = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			while (rs.next()) {
				d = new LmsDTO2();
				d.setSubject(rs.getString("subject"));
				d.setGrade(rs.getString("grade"));
				d.printSG();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return d;
	}

	@Override // 과목등록
	public void insertSubject(LmsDTO2 lms) {
		String sql = "insert into Lms_sub (subject , name , date) values (?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, lms.getSubject());
			psmt.setString(2, lms.getName());
			psmt.setString(3, lms.getDate());
			psmt.executeUpdate(); // insert, update, delete 할 때 execute사용
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override // 과목 삭제
	public void deleteSubject(String subject) {
		String sql = "delete from Lms_sub where subject = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, subject);
			int r = psmt.executeUpdate();
			if (r == 0) {
				System.out.println("과목 삭제 실패");
			} else {
				System.out.println("과목 삭제 성공");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override // 성적등록
	public void insertGrade(LmsDTO2 lms) {
		String sql = "insert into Lms_sub (date,grade,subject,name) values (?,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, lms.getDate());
			psmt.setString(2, lms.getGrade());
			psmt.setString(3, lms.getSubject());
			psmt.setString(4, lms.getName());
			int r = psmt.executeUpdate(); // insert, update, delete 할 때 execute사용
			System.out.println(r + "건 입력.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override // 성적변경
	public void updateGrade(LmsDTO2 lms) {
		try {

			String sql = "update Lms_sub set grade=? where name = ? and subject = ?";

			psmt = conn.prepareStatement(sql);

			psmt.setString(1, lms.getGrade());

			psmt.setString(2, lms.getName());

			psmt.setString(3, lms.getSubject());

			psmt.executeUpdate();

		} catch (Exception e) {

			System.out.println(e.toString());

		}
	}

	@Override // 교수 과목 조회 (과목: / 학생이름: / 학번: /)
	public LmsDTO2 selectSubjectp(String subject) {
		String sql = "select * from Lms_sub where subject = ? ";
		LmsDTO2 d = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, subject);
			rs = psmt.executeQuery();
			while (rs.next()) {
				d = new LmsDTO2();
				d.setSubject(rs.getString("subject"));
				d.setName(rs.getString("name"));
				d.setId(rs.getString("id"));
				d.printSp();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return d;
	}

	@Override // 교수 성적 전체 조회
	public LmsDTO2 selectGradep(String subject) {

		String sql = "select * from Lms_sub where subject = ?";
		LmsDTO2 d = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, subject);
			rs = psmt.executeQuery();
			while (rs.next()) {
				if (rs.getString("id").startsWith("1")) { // 학번이 1로 시작하는 조건
					d = new LmsDTO2();
					d.setSubject(rs.getString("subject"));
					d.setName(rs.getString("name"));
					d.setId(rs.getString("id"));
					d.setGrade(rs.getString("grade"));
					d.printSp2();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return d;
	}

}
