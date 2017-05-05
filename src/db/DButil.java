package mil.jtaspect.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DButil {
	private static Properties pro=new Properties();
	private static Connection con=null;
//	private static Statement stat=null;
//	private static PreparedStatement ps=null;
//	private static ResultSet rs=null;
	
	static{
		
		try {
			pro.load(DButil.class.getClassLoader().getResourceAsStream("DBDriver.properties"));
				Class.forName(pro.getProperty("oracleDriver"));
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection connect(){
		try {
			con=DriverManager.getConnection(pro.getProperty("url"),pro.getProperty("user"),pro.getProperty("password"));
			return con;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void close(Connection con,Statement stat,ResultSet rs){
		try {
			if(rs!=null)rs.close();
			if(stat!=null)stat.close();
			if(con!=null)con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
//	public static void main(String[] args) {
//		System.out.println(DButil.connect());
//	}
}
