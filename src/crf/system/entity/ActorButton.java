package crf.system.entity;

import crf.common.CommonConstants;

public class ActorButton {
	private Long id;
	private String actor_no;
	private String button_id;
	private String createid;
	private String createtime;
	private String button_desc;
	private String is_enable;
	
	//非数据库字段
	private String actor_name;
	private String createname;
	private String is_enable_desc;
	
	public ActorButton(){}
	
	public ActorButton(Long id){
		this.id = id;
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
	public String getButton_id() {
		return button_id;
	}
	public void setButton_id(String button_id) {
		this.button_id = button_id;
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
	public String getButton_desc() {
		return button_desc;
	}
	public void setButton_desc(String button_desc) {
		this.button_desc = button_desc;
	}
	public String getActor_name() {
		return actor_name;
	}
	public void setActor_name(String actor_name) {
		this.actor_name = actor_name;
	}
	public String getCreatename() {
		return createname;
	}
	public void setCreatename(String createname) {
		this.createname = createname;
	}
	public String getIs_enable() {
		return is_enable;
	}
	public void setIs_enable(String is_enable) {
		this.is_enable = is_enable;
		this.is_enable_desc = CommonConstants.getCommonIsEnableMap().get(is_enable);
	}
	public String getIs_enable_desc() {
		return is_enable_desc;
	}
}
