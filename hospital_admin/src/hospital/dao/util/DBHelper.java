package hospital.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver"; // cj가 없는건 구버전
	private static String URL = "jdbc:mysql://192.168.1.47:3306/hospitaldb"; // 내 아이피
	private static String USER = "bigdata";
	private static String PASS = "12345";

	private static Connection conn;

	private DBHelper() {
	}

	public static Connection getConnection() {
		if (conn == null) {
			try {
				Class.forName(DRIVER);
				conn = DriverManager.getConnection(URL, USER, PASS);
			} catch (ClassNotFoundException e) {
				System.out.println("드라이버 등록 실패");
			} catch (SQLException e) {
				System.out.println("커넥션 연결 실패");
			}
		}
		return conn;
	}
	
	public static void resetConnect() {
		conn = null;
		URL = "jdbc:mysql://192.168.1.47:3306/hospitaldb"; // 내 아이피
		USER = "bigdata";
		PASS = "12345";
	}
	
	public static void setConnect(String ip, String port, String dbName, String id, String pw) { // setConnect() 메소드 만들기
		conn = null;
		URL = "jdbc:mysql://" + ip + ":" + port + "/" + dbName;
		USER = id;
		PASS = pw;
	}
	
	// 매개변수 ... : 가변형 인자열이라 하며 매개변수의 갯수만큼 배열로 받아옴. 가변형 인자열은 매개변수의 제일 뒤에 위치해야 함 (앞에 다른 매개변수가 올 수 있음)
	public static void close(AutoCloseable... closer) {
		try {
			for (AutoCloseable close : closer) {
				if (close != null)
					close.close();
			}
		} catch (Exception e) {}
	}
}