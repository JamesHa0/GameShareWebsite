package game.bean;
/**
 * Game实体类
 */
public class Game {
	private String gid;
	private String gname;
	private String gprice;
	private String gdeveloper;
	private String gpublisher;
	private String grelease_date;
	private String gdescription;
	private String gzhname;
	
	public Game() {
		super();
	}

	public Game(String gid, String gname, String gprice, String gdeveloper, String gpublisher, String grelease_date,
			String gdescription, String gzhname) {
		super();
		this.gid = gid;
		this.gname = gname;
		this.gprice = gprice;
		this.gdeveloper = gdeveloper;
		this.gpublisher = gpublisher;
		this.grelease_date = grelease_date;
		this.gdescription = gdescription;
		this.gzhname = gzhname;
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
	public String getGdeveloper() {
		return gdeveloper;
	}
	public void setGdeveloper(String gdeveloper) {
		this.gdeveloper = gdeveloper;
	}
	public String getGpublisher() {
		return gpublisher;
	}
	public void setGpublisher(String gpublisher) {
		this.gpublisher = gpublisher;
	}
	public String getGrelease_date() {
		return grelease_date;
	}
	public void setGrelease_date(String grelease_date) {
		this.grelease_date = grelease_date;
	}
	public String getGdescription() {
		return gdescription;
	}
	public void setGdescription(String gdescription) {
		this.gdescription = gdescription;
	}

	public String getGzhname() {
		return gzhname;
	}

	public void setGzhname(String gzhname) {
		this.gzhname = gzhname;
	}
	
	
	
	
	
	
	
}
