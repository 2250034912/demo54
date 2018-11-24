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
		//第一步加载驱动
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//第二步建立连接
		String url = "jdbc:oracle:thin:@//127.0.0.1:1521/orcl";
		String user = "system";
		String password = "a";
		Connection con = DriverManager.getConnection(url, user, password);
		//第三步构建语句以及预编译对象
		String sql = "insert into from emp values(?,?,?);";
		PreparedStatement ps = con.prepareStatement(sql);
		//建立索引
		for(int i=1;i<param.length;i++) {
			ps.setObject(i, param[i]);
		}
		//运行语句
		int i = ps.executeUpdate();
		//关闭连接
		con.close();
		
		return i;
		
	}
	
	
	public static List<Map<String,Object>> cha(String sql, Object...array) 
											throws ClassNotFoundException, SQLException{
		//加载驱动
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//建立连接
		String url = "jdbc:oracle:thin:@//127.0.0.1:1521/orcl";
		String user = "system";
		String password = "a";
		Connection conn = DriverManager.getConnection(url, user, password);
		//构建语句(预编译对象)
		PreparedStatement  ps = conn.prepareStatement(sql);
		//建立索引
		for(int i=0;i<array.length;i++) {
			ps.setObject(i+1, array[i]);
		}
		//建立结果集
		ResultSet rs = ps.executeQuery();
		//结果集元数据
		ResultSetMetaData md = rs.getMetaData();
		//结果集元数据返回总列数
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
