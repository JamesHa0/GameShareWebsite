package game.bean;
/**
 * Comment实体类
 */

/*    
cid,
uid,
gid,
ctime,
comment
*/  

public class Comment {
	private String cid;//comment id
	private String uid; //user id
	private String gid; //game id
	private String ctime;//comment time
	private String comment;//comment content
	
	
	//全5参
	public Comment(String cid, String uid, String gid, String ctime, String comment) {
		super();
		this.cid = cid;
		this.uid = uid;
		this.gid = gid;
		this.ctime = ctime;
		this.comment = comment;
	}


	//4参（缺自增cid）
	public Comment(String uid, String gid, String ctime, String comment) {
		super();
		this.uid = uid;
		this.gid = gid;
		this.ctime = ctime;
		this.comment = comment;
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


	@Override
	public String toString() {
		return "Comment [cid=" + cid + ", uid=" + uid + ", gid=" + gid + ", ctime=" + ctime + ", comment=" + comment
				+ "]";
	}
	
	
	
	
}
