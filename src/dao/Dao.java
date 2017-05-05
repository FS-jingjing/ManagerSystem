package mil.jtaspect.dao;

import java.util.List;

import mil.jtaspect.entity.Student;
import mil.jtaspect.entity.User;

public interface Dao {
	int add(Student stu);
	Student sel(String id,String password);
	List<User> queryAll();
	boolean queryOne(String username);
	List<Student> query();
	boolean del(String username);
}
