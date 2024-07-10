package game.bean;
/**
 * User实体类
 */

/*
uid     
uname   
utel    
uemail  
urole   
ugender 
uaddress
upsw    
*/

public class User {
	private String uid;
	private String uname; 
	private String utel;
	private String uemail;
	private String urole;
	private String ugender;
	private String uaddress;
	private String upsw;
	
	
	public User() {
		super();
	}
	
	public User(String uid, String uname, String utel, String uemail, String urole, String ugender, String uaddress,
			String upsw) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.utel = utel;
		this.uemail = uemail;
		this.urole = urole;
		this.ugender = ugender;
		this.uaddress = uaddress;
		this.upsw = upsw;
	}
	
	//不带uid参数：（用于数据库自增）
	public User(String uname, String utel, String uemail, String urole, String ugender, String uaddress,
			String upsw) {
		super();
		this.uname = uname;
		this.utel = utel;
		this.uemail = uemail;
		this.urole = urole;
		this.ugender = ugender;
		this.uaddress = uaddress;
		this.upsw = upsw;
	}

	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUtel() {
		return utel;
	}
	public void setUtel(String utel) {
		this.utel = utel;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getUrole() {
		return urole;
	}
	public void setUrole(String urole) {
		this.urole = urole;
	}
	public String getUgender() {
		return ugender;
	}
	public void setUgender(String ugender) {
		this.ugender = ugender;
	}
	public String getUaddress() {
		return uaddress;
	}
	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}
	public String getUpsw() {
		return upsw;
	}
	public void setUpsw(String upsw) {
		this.upsw = upsw;
	}
	
	
	
	
}
