package crf.system.entity;

import crf.common.CommonConstants;


public class Operation {
	private Long id;
	private String operation_no;
	private String operation_name;
	private String operation_url;
	private String operation_seq;
	private String is_enable;
	private String parent_id;
	private String createid;
	private String createtime;
	
	//以下非数据库字段
	private String parent_name;
	private String is_enable_desc;
	private String createname;
	
	public Operation(){}
	public Operation(String operation_no, String operation_name,
			String operation_url, String operation_seq, String is_enable,
			String parent_id, String createid, String createtime,
			String parent_name, String is_enable_desc, String createname) {
		this.operation_no = operation_no;
		this.operation_name = operation_name;
		this.operation_url = operation_url;
		this.operation_seq = operation_seq;
		this.is_enable = is_enable;
		this.parent_id = parent_id;
		this.createid = createid;
		this.createtime = createtime;
		this.parent_name = parent_name;
		this.is_enable_desc = is_enable_desc;
		this.createname = createname;
	}




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
	
	public String getParent_name() {
		return parent_name;
	}
	public void setParent_name(String parent_name) {
		this.parent_name = parent_name;
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
	public String getOperation_no() {
		return operation_no;
	}
	public void setOperation_no(String operation_no) {
		this.operation_no = operation_no;
	}
	public String getOperation_name() {
		return operation_name;
	}
	public void setOperation_name(String operation_name) {
		this.operation_name = operation_name;
	}
	public String getOperation_url() {
		return operation_url;
	}
	public void setOperation_url(String operation_url) {
		this.operation_url = operation_url;
	}
	public String getOperation_seq() {
		return operation_seq;
	}
	public void setOperation_seq(String operation_seq) {
		this.operation_seq = operation_seq;
	}
	public String getIs_enable() {
		return is_enable;
	}
	public void setIs_enable(String is_enable) {
		this.is_enable = is_enable;
		this.is_enable_desc=CommonConstants.getCommonIsEnableMap().get(is_enable);
	}
	public String getParent_id() {
		return parent_id;
	}
	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}
}
