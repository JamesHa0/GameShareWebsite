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
upoint
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
	private String upoint;
	
	
	public User() {
		super();
	}
	
	//9参（queryAllservlet）
	public User(String uid, String uname, String utel, String uemail, String urole, String ugender, String uaddress,
			String upsw, String upoint) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.utel = utel;
		this.uemail = uemail;
		this.urole = urole;
		this.ugender = ugender;
		this.uaddress = uaddress;
		this.upsw = upsw;
		this.upoint = upoint;
	}


	//8参，除upoint
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
		this.upsw = upsw;	//8
	}
	
	//7参，除uid,upoint
	public User(String uname, String utel, String uemail, String urole, String ugender, String uaddress,
			String upsw) {
		super();
		this.uname = uname;
		this.utel = utel;
		this.uemail = uemail;
		this.urole = urole;
		this.ugender = ugender;
		this.uaddress = uaddress;
		this.upsw = upsw;	//7
	}
	
	
	
	//6参,除uid,upoint,urole -管理员插入数据时调用：
	public User(String uname, String utel, String uemail, String ugender, String uaddress, String upsw) {
		super();
		this.uname = uname;
		this.utel = utel;
		this.uemail = uemail;
		this.ugender = ugender;
		this.uaddress = uaddress;
		this.upsw = upsw;	//6
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

	public String getUpoint() {
		return upoint;
	}

	public void setUpoint(String upoint) {
		this.upoint = upoint;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", utel=" + utel + ", uemail=" + uemail + ", urole=" + urole
				+ ", ugender=" + ugender + ", uaddress=" + uaddress + ", upsw=" + upsw + ", upoint=" + upoint + "]";
	}
	
	
	
	
}
