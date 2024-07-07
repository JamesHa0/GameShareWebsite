package crf.invest.entity;

/**
 * <p>
 * Title: app资讯实体类
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company: 上海信而富金融信息服务有限公司
 * </p>
 * 
 * @author ltf
 * @date 2016-7-20
 */
public class AppInformation {
	private Long new_id;// '资讯ID'
	private String title;// '资讯名称',
	private String ndesc;// '资讯描述',
	private String img_url;// '图片的url地址',
	private String click_url;// '单击跳转地址',
	private String source;// '来源',
	private String create_time;// '活动创建时间',
	private Long create_id;// '资讯创建人ID',
	private Long state;// '资讯状态 0 正常 1 关闭 默认为0'

	private String create_name;

	public Long getNew_id() {
		return new_id;
	}

	public void setNew_id(Long new_id) {
		this.new_id = new_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNdesc() {
		return ndesc;
	}

	public void setNdesc(String ndesc) {
		this.ndesc = ndesc;
	}

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

	public String getClick_url() {
		return click_url;
	}

	public void setClick_url(String click_url) {
		this.click_url = click_url;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public Long getCreate_id() {
		return create_id;
	}

	public void setCreate_id(Long create_id) {
		this.create_id = create_id;
	}

	public Long getState() {
		return state;
	}

	public void setState(Long state) {
		this.state = state;
	}

	public String getCreate_name() {
		return create_name;
	}

	public void setCreate_name(String create_name) {
		this.create_name = create_name;
	}

	
	
}