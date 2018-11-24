package fuxi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbc {
public static void jia(int eno, String ename) throws ClassNotFoundException, SQLException {
		
		//加载驱动forname(驱动程序内路径：完全限定名)
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//构建连接
		String url = "jdbc:oracle:thin:@//127.0.0.1:1521/orcl";
		String user = "system";
		String password = "a";
		Connection conn = DriverManager.getConnection(url, user, password);
		//构建语句
		String sql = "insert into emp (empno,ename)values(?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		//执行语句
		//设置查询参数
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
