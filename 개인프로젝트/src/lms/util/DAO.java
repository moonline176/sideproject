package lms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO { //db와 연결하기위한 클래스
	public static Connection conn;
	
	public DAO(){
		String url = "jdbc:sqlite:\\\\192.168.0.83\\학생공유\\이광호/Lee.db";
		try {
			conn = DriverManager.getConnection(url); // db와 연결
			System.out.println("connected");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
