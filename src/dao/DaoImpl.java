package mil.jtaspect.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mil.jtaspect.db.DButil;
import mil.jtaspect.entity.Student;
import mil.jtaspect.entity.User;

public class DaoImpl implements Dao {
	private static Connection con=null;
	private static PreparedStatement ps=null;
	private static ResultSet rs=null;
	
	@Override
	public int add(Student stu) {
		con=DButil.connect();
		String sql="insert into stu_cookie values(?,?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, stu.getSid());
			ps.setString(2, stu.getSpass());
			int x=ps.executeUpdate();
			return x; 
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DButil.close(con, ps, null);
		}
		return 0;
	}

	@Override
	public Student sel(String id, String password) {
		Student stu=null;
		con=DButil.connect();
		String sql="select * from stu_cookie where s_user=? and s_pass=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, password);
			rs=ps.executeQuery();
			if(rs.next()){
				stu=new Student(rs.getString(1),rs.getString(2));
				return stu;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DButil.close(con, ps, rs);
		}
		return stu;
	}

	@Override
	public List<User> queryAll() {
		List<User>list=new ArrayList<User>();
		User stu=null;
		con=DButil.connect();
		String sql="select * from web_stu";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				stu=new User(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDate(4),rs.getString(5));
				list.add(stu);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean queryOne(String username) {
		con=DButil.connect();
		String sql="select * from stu_cookie where s_user=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1,username);
			rs=ps.executeQuery();
			if(rs.next()){
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DButil.close(con, ps, rs);
		}
		return false;
	}

	@Override
	public List<Student> query() {
		List<Student>list=new ArrayList<Student>();
		Student stu=null;
		con=DButil.connect();
		String sql="select * from stu_cookie";
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				stu=new Student(rs.getString(1),rs.getString(2));
				list.add(stu);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DButil.close(con, ps, rs);
		}
		return null;
	}

	@Override
	public boolean del(String username) {
		con=DButil.connect();
		String sql="delete from stu_cookie where s_user=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1,username);
			int x=ps.executeUpdate();
			if(x>0){
				return true;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DButil.close(con, ps, rs);
		}
		return false;
	}

}
