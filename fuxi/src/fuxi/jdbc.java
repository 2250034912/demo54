package fuxi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbc {
public static void jia(int eno, String ename) throws ClassNotFoundException, SQLException {
		
		//��������forname(����������·������ȫ�޶���)
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//��������
		String url = "jdbc:oracle:thin:@//127.0.0.1:1521/orcl";
		String user = "system";
		String password = "a";
		Connection conn = DriverManager.getConnection(url, user, password);
		//�������
		String sql = "insert into emp (empno,ename)values(?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		//ִ�����
		//���ò�ѯ����
		ps.setInt(1, eno);
		ps.setString(2, ename);
		int count = ps.executeUpdate();
		conn.close();
		
	}
	public static void cha(String ename) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@//127.0.0.1:1521/orcl";
		String user = "system";
		String password = "a";
		Connection conn = DriverManager.getConnection(url, user, password);
		String sql = "select * from emp where ename = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "ename");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			System.out.print(rs.getString("ENAME")+"/t");
		}
	}

}
