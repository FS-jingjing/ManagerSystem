package mil.jtaspect.entity;

import java.sql.Date;

public class User {
	private int id;
	private String name;
	private int sex;
	private Date birthday;
	private String address;
	public User(int id, String name, int sex, Date birthday, String address) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		this.address = address;
	}
	public User(String name, int sex, Date birthday, String address) {
		super();
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", sex=" + sex + ", birthday=" + birthday + ", address=" + address
				+ "]";
	}
	
}
