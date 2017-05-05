package mil.jtaspect.entity;



public class Student {
	protected String sid;
	protected String spass;
	public Student(String sid, String spass) {
		super();
		this.sid = sid;
		this.spass = spass;
	}
	public Student() {
		super();
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSpass() {
		return spass;
	}
	public void setSpass(String spass) {
		this.spass = spass;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", spass=" + spass + "]";
	}
	
}
