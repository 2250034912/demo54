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


public class Utils {
	//Object...数组名 - 》是叫做参数数组。
	/*
	 * Class.forName("oracle.jdbc.driver.OracleDriver");
	 * Class.forName("oracle.jdbc.driver.OracleDriver");
	 * Class.forName("oracle.jdbc.driver.OracleDriver");*/
	public static void upDate (String sql ,Object...array) throws ClassNotFoundException, SQLException {
		//加载驱动
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//获取连接
		String url = "jdbc:oracle:thin:@//127.0.0.1:1521/orcl";
		String user = "system";
		String password = "a";
		Connection conn =  DriverManager.getConnection(url, user, password);
		//获得预编译对象
		PreparedStatement ps = conn.prepareStatement(sql);
		//添加索引
		for(int i=1;i<array.length;i++) {
			ps.setObject(i, array[i]);
		}
		//运行
		ps.executeQuery();
		//最后记住一定要关闭连接
		conn.close();
		
	}
	public static List<Map<String,Object>> query (String sql ,Object...array) 
				throws ClassNotFoundException, SQLException{
		//1
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//2
		String url = "jdbc:oracle:thin:@//127.0.0.1:1521/orcl";
		String user = "system";
		String password = "a";
		Connection conn = DriverManager.getConnection(url, user, password);
		//3
		PreparedStatement ps = conn.prepareStatement(sql);
		//4
		for(int i=0;i<array.length;i++) {
			ps.setObject(i+1, array[i]);
		}
		
		ResultSet rs = ps.executeQuery();//获取结果集
		ResultSetMetaData md  = rs.getMetaData();//获取结果集元数据
		int count = md.getColumnCount();//获取总列数
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		while(rs.next()) {
			for(int i = 0; i< count;i++) {
				Map<String,Object> map = new HashMap<String,Object>();
				String s =  md.getColumnName(i);
				Object r = rs.getObject(i);
				map.put(s, r);
				list.add(map);
			}
		}
		//关闭连接
		conn.close();
		return list;
	}
	
	public static List<Map<String,Object>>  select(String sql,Object...array) 
			throws ClassNotFoundException, SQLException{
		//1
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//2
		String url = "jdbc:oracle:thin:@//127.0.0.1:1521/orcl";
		String user = "system";
		String password = "a";
		Connection conn = DriverManager.getConnection(url, user, password);
		//3
		PreparedStatement ps = conn.prepareStatement(sql);
		//4
		for(int i=0;i<array.length;i++) {
			ps.setObject(i+1, array[i]);
		}
		ResultSet rs = ps.executeQuery();
		ResultSetMetaData md = rs.getMetaData();
		int count = md.getColumnCount();
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		while(rs.next()) {
			
		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
