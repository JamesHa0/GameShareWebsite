package crf.system.entity;

import crf.common.CommonConstants;

public class Actor {
	private Long id;
	private String actor_no;
	private String actor_name;
	private String actor_desc;
	private String actor_seq;
	private String is_enable;
	private String createid;
	private String createtime;
	
	//非数据库字段
	private String is_enable_desc;
	private String createname;
	
	public String getCreatename() {
		return createname;
	}
	public void setCreatename(String createname) {
		this.createname = createname;
	}
	public String getCreateid() {
		return createid;
	}
	public void setCreateid(String createid) {
		this.createid = createid;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getIs_enable_desc() {
		return is_enable_desc;
	}
	public void setIs_enable_desc(String is_enable_desc) {
		this.is_enable_desc = is_enable_desc;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getActor_no() {
		return actor_no;
	}
	public void setActor_no(String actor_no) {
		this.actor_no = actor_no;
	}
	public String getActor_name() {
		return actor_name;
	}
	public void setActor_name(String actor_name) {
		this.actor_name = actor_name;
	}
	public String getActor_desc() {
		return actor_desc;
	}
	public void setActor_desc(String actor_desc) {
		this.actor_desc = actor_desc;
	}
	public String getActor_seq() {
		return actor_seq;
	}
	public void setActor_seq(String actor_seq) {
		this.actor_seq = actor_seq;
	}
	public String getIs_enable() {
		return is_enable;
	}
	public void setIs_enable(String is_enable) {
		this.is_enable = is_enable;
		this.is_enable_desc = CommonConstants.getCommonIsEnableMap().get(is_enable);
	}
	
	
}
