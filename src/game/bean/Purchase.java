package game.bean;

public class Purchase {
	private String gid;
	private String onumber;
	private String uid;
	private String otime;
	public Purchase() {
		super();
	}
	public Purchase(String gid, String onumber, String uid, String otime) {
		super();
		this.gid = gid;
		this.onumber = onumber;
		this.uid = uid;
		this.otime = otime;
	}
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
	}
	public String getOnumber() {
		return onumber;
	}
	public void setOnumber(String onumber) {
		this.onumber = onumber;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getOtime() {
		return otime;
	}
	public void setOtime(String otime) {
		this.otime = otime;
	}
	
	
	
}
