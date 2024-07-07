package crf.util;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

//import common.util.web.Base;

/**
 * 
 * @项目名称:xiaotuan
 * @类名称:SecondSMS
 * @类描述:发送短信;
 * @创建人:苗有虎
 * @创建时间:Sep 18, 20103:04:52 PM
 * @修改人:Administrator
 * @修改时间:Sep 18, 20103:04:52 PM
 * @修改备注:
 * @version
 */
public class SendSMS {
	 
	private String encode = "GBK";
	public String getEncode() {
		return encode;
	}

	public void setEncode(String encode) {
		this.encode = encode;
	}

	// 服务器地址(需要加密);
	private String servicesHost = "";
	// 服务器请求地址(需要加密);
	private String servicesRequestAddRess = "";
	// 登录的用户名(需要加密);
	private String username = "";
	// 登录的密码(需要加密);
	private String password = "";
	// 短信发送方式;
	private int smstype = 1;
	// 短信发送是否定时;
	private int timerflag = 0;
	// 短信发送定时时间;
	private String timervalue;
	// 短信发送定时的类型;
	private int timertype = 1;
	// 短信发送的编号(需要加密);
	private String timerid;
	// 发送的手机号码(需要加密);
	private String mobiles;
	// 发送的内容(需要加密);
	private String message;

	public String getServicesHost() {
		return servicesHost;
	}

	public void setServicesHost(String servicesHost) {
		this.servicesHost = servicesHost;//Base.base64Decode(servicesHost);
	}

	public String getServicesRequestAddRess() {
		return servicesRequestAddRess;
	}

	public void setServicesRequestAddRess(String servicesRequestAddRess) {
		this.servicesRequestAddRess = servicesRequestAddRess; //Base.base64Decode(servicesRequestAddRess);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username; //Base.base64Decode(username);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;//Base.base64Decode(password);
	}

	public int getSmstype() {
		return smstype;
	}

	public void setSmstype(int smstype) {
		this.smstype = smstype;
	}

	public int getTimerflag() {
		return timerflag;
	}

	public void setTimerflag(int timerflag) {
		this.timerflag = timerflag;
	}

	public String getTimervalue() {
		return timervalue;
	}

	public void setTimervalue(String timervalue) {
		this.timervalue = timervalue;
	}

	public int getTimertype() {
		return timertype;
	}

	public void setTimertype(int timertype) {
		this.timertype = timertype;
	}

	public String getTimerid() {
		return timerid;
	}

	public void setTimerid(String timerid) {
		this.timerid = timerid;//Base.base64Decode(timerid);
	}

	public String getMobiles() {
		return mobiles;
	}

	public void setMobiles(String mobiles) {
		this.mobiles = mobiles;//Base.base64Decode(mobiles);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		try {
			this.message = URLEncoder.encode(message, this.getEncode());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		//this.message = message; //Base.base64Decode(message);
	}

	// 发送短信;
	public Map<String, String> sendSMS() {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(true);
		Document doc;
		Map<String, String> result = new LinkedHashMap<String, String>();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			InputStream is = getSoapInputStream(this
					.getRequestAddRess().toString(), this.servicesHost);
			doc = db.parse(is);
			result.put("errorcode", doc.getElementsByTagName("errorcode").item(
					0).getFirstChild().getNodeValue());
			result.put("errordescription", doc.getElementsByTagName(
					"errordescription").item(0).getFirstChild().getNodeValue());
			result.put("time", doc.getElementsByTagName("time").item(0)
					.getFirstChild().getNodeValue());
			result.put("msgcount", doc.getElementsByTagName("msgcount").item(0)
					.getFirstChild().getNodeValue());
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("发送短信失败!");
		}
		return result;
	}

	// 拼接参数;
	private StringBuffer getRequestAddRess() {
		StringBuffer requestAddRess = new StringBuffer();
		requestAddRess.append(this.servicesHost);
		requestAddRess.append(this.servicesRequestAddRess);
		requestAddRess.append("?func=sendsms&username=");
		requestAddRess.append(this.username);
		requestAddRess.append("&password=");
		requestAddRess.append(password);
		requestAddRess.append("&smstype=");
		requestAddRess.append(smstype);
		requestAddRess.append("&timerflag=");
		requestAddRess.append(this.timerflag);
		if (this.timerflag != 0) {
			requestAddRess.append("&timervalue=");
			requestAddRess.append(this.timervalue);
		}
		requestAddRess.append("&timertype=");
		requestAddRess.append(this.timertype);
		requestAddRess.append("&timerid=");
		requestAddRess.append(this.timerid);
		requestAddRess.append("&mobiles=");
		requestAddRess.append(this.mobiles);
		requestAddRess.append("&message=");
		requestAddRess.append(this.message);
		
		return requestAddRess;
	}
	public static InputStream getSoapInputStream(String requestAddress,String servicesHost) {
		InputStream is = null;
		try {
			URL U = new URL(requestAddress);
			URLConnection conn = U.openConnection();
			conn.setRequestProperty("Host", servicesHost);
			conn.connect();
			is = U.openStream();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return is;
	}
}
