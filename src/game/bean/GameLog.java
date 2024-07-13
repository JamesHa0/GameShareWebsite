package game.bean;

public class GameLog {
	private String gid;
	private String onumber;
	private String uid;
	private String otime;
	private String gzhname;
	private String gprice;
	public GameLog() {
		super();
	}
	public GameLog(String gid, String onumber, String uid, String otime, String gzhname, String gprice) {
		super();
		this.gid = gid;
		this.onumber = onumber;
		this.uid = uid;
		this.otime = otime;
		this.gzhname = gzhname;
		this.gprice = gprice;
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
	public String getGzhname() {
		return gzhname;
	}
	public void setGzhname(String gzhname) {
		this.gzhname = gzhname;
	}
	public String getGprice() {
		return gprice;
	}
	public void setGprice(String gprice) {
		this.gprice = gprice;
	}
	
	
	
	
	
	
}
