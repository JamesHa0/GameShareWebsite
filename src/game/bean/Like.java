package game.bean;
/**
 * Like实体类
 */

/*    
lid,
uid,
gid,
ltime
*/  

public class Like {
	private String lid;//like id
	private String uid; //user id
	private String gid; //game id
	private String ltime;//like time
	
	
	
	
	
	//全4参
	public Like(String lid, String uid, String gid, String ltime) {
		super();
		this.lid = lid;
		this.uid = uid;
		this.gid = gid;
		this.ltime = ltime;
	}

	//3参（除lid。用于插入数据）
	public Like(String uid, String gid, String ltime) {
		super();
		this.uid = uid;
		this.gid = gid;
		this.ltime = ltime;
	}




	public String getLid() {
		return lid;
	}
	public void setLid(String lid) {
		this.lid = lid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
	}
	public String getLtime() {
		return ltime;
	}
	public void setLtime(String ltime) {
		this.ltime = ltime;
	}

	@Override
	public String toString() {
		return "Like [lid=" + lid + ", uid=" + uid + ", gid=" + gid + ", ltime=" + ltime + "]";
	}
	
	
}
