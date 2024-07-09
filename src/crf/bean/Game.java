package crf.bean;
/**
 * Game实体类
 */
public class Game {
	private String gid;
	private String gname;
	private String gprice;
	
	
	
	public Game() {
		super();
	}
	public Game(String gid, String gname, String gprice) {
		super();
		this.gid = gid;
		this.gname = gname;
		this.gprice = gprice;
	}
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getGprice() {
		return gprice;
	}
	public void setGprice(String gprice) {
		this.gprice = gprice;
	}
	
	
	
	
	
	
	
}
