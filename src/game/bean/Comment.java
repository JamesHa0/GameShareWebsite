package game.bean;
/**
 * Comment实体类
 */

/*    
cid,uid,gid,uname,ctime,`comment`,clike,cparentid,cpath
*/  

//9参
public class Comment {
	private String cid;//自增
	private String uid;
	private String gid;
	private String uname;
	private String ctime;
	private String comment;
	private String clike;
	private String cparentid;
	private String cpath;//辅助属性
	
	public Comment() {
		super();
	}
	
	//全9参（用于query servlet）
	public Comment(String cid, String uid, String gid, String uname, String ctime, String comment, String clike,
			String cparentid, String cpath) {
		super();
		this.cid = cid;
		this.uid = uid;
		this.gid = gid;
		this.uname = uname;
		this.ctime = ctime;
		this.comment = comment;
		this.clike = clike;
		this.cparentid = cparentid;
		this.cpath = cpath;
	}
	
	//8参（除cid，用于写评论入库servlet）
	public Comment(String uid, String gid, String uname, String ctime, String comment, String clike, String cparentid,
			String cpath) {
		super();
		this.uid = uid;
		this.gid = gid;
		this.uname = uname;
		this.ctime = ctime;
		this.comment = comment;
		this.clike = clike;
		this.cparentid = cparentid;
		this.cpath = cpath;
	}



	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
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

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getCtime() {
		return ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getClike() {
		return clike;
	}

	public void setClike(String clike) {
		this.clike = clike;
	}

	public String getCparentid() {
		return cparentid;
	}

	public void setCparentid(String cparentid) {
		this.cparentid = cparentid;
	}

	public String getCpath() {
		return cpath;
	}

	public void setCpath(String cpath) {
		this.cpath = cpath;
	}

	@Override
	public String toString() {
		return "Comment [cid=" + cid + ", uid=" + uid + ", gid=" + gid + ", uname=" + uname + ", ctime=" + ctime
				+ ", comment=" + comment + ", clike=" + clike + ", cparentid=" + cparentid + ", cpath=" + cpath + "]";
	}
	
	
	
	
	
	
}
