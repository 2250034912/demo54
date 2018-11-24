package fuxi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class jdbcfuxi {
	public static int jia(Object...param) throws SQLException, ClassNotFoundException {
		//��һ����������
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//�ڶ�����������
		String url = "jdbc:oracle:thin:@//127.0.0.1:1521/orcl";
		String user = "system";
		String password = "a";
		Connection con = DriverManager.getConnection(url, user, password);
		//��������������Լ�Ԥ�������
		String sql = "insert into from emp values(?,?,?);";
		PreparedStatement ps = con.prepareStatement(sql);
		//��������
		for(int i=1;i<param.length;i++) {
			ps.setObject(i, param[i]);
		}
		//�������
		int i = ps.executeUpdate();
		//�ر�����
		con.close();
		
		return i;
		
	}
	
	
	public static List<Map<String,Object>> cha(String sql, Object...array) 
											throws ClassNotFoundException, SQLException{
		//��������
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//��������
		String url = "jdbc:oracle:thin:@//127.0.0.1:1521/orcl";
		String user = "system";
		String password = "a";
		Connection conn = DriverManager.getConnection(url, user, password);
		//�������(Ԥ�������)
		PreparedStatement  ps = conn.prepareStatement(sql);
		//��������
		for(int i=0;i<array.length;i++) {
			ps.setObject(i+1, array[i]);
		}
		//���������
		ResultSet rs = ps.executeQuery();
		//�����Ԫ����
		ResultSetMetaData md = rs.getMetaData();
		//�����Ԫ���ݷ���������
		int count = md.getColumnCount();
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		while(rs.next()) {
			Map<String,Object> map = new HashMap<String,Object>();
			for(int i = 0;i<count;i++) {
				String s = md.getColumnTypeName(i);
				Object o = rs.getObject(s);
				map.put(s, o);
			}
			list.add(map);			
		}
		
		return list;
		
	}

}
