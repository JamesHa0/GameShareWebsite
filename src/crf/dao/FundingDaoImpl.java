package crf.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import crf.invest.entity.Funding;

public class FundingDaoImpl implements FundingDao {
	String driver = "com.mysql.jdbc.Driver";
	String url="jdbc:mysql://127.0.0.1:3306/aaa?characterEncoding=utf-8";
	String username="root";
	String password="22023237";
	//获得连接
	public Connection getConnection() throws Exception {
		Class.forName(driver);
		return DriverManager.getConnection(url, username, password);
	}
	@Override
	public long getObListCount(Map<String, Object> map) throws Exception {
		Connection conn = getConnection();
		Statement state = conn.createStatement();
		String sql="select count(*) from fm_funding a  " + 
				"left join fm_user b on a.fund_f_user_id=b.user_id " + 
				"left join fm_product c on a.fund_f_pro_id=c.pro_id " + 
				"where  a.fund_create_time>='"+map.get("startTime")+"'  " + 
				"and a.fund_create_time<='"+map.get("endTime")+"' ";
				if (map.get("fundPhoneNo")!="") {
					sql+="and b.user_phone_no=''";
				}
				sql+=" order by a.fund_create_time";
				System.out.println(sql);
		ResultSet rs = state.executeQuery(sql);	
		if (rs.next()) {
			return rs.getInt(1);
		}
		rs.close();
		state.close();
		conn.close();
		return 0;
	}
	@Override
	public List<Funding> queryObListTable(Map<String, Object> map) throws Exception {
		Connection conn = getConnection();
		Statement state = conn.createStatement();
		String sql="select a.*,b.user_phone_no,b.user_name,b.user_id_card,c.pro_name from fm_funding a  " + 
				"left join fm_user b on a.fund_f_user_id=b.user_id " + 
				"left join fm_product c on a.fund_f_pro_id=c.pro_id " + 
				"where  a.fund_create_time>='"+map.get("startTime")+"'  " + 
				"and a.fund_create_time<='"+map.get("endTime")+"' ";
				if (map.get("fundPhoneNo")!="") {
					sql+="and b.user_phone_no='"+map.get("fundPhoneNo")+"'";
				}
				sql+=" and a.fund_state='1' order by a.fund_create_time";
				System.out.println(sql);
		ResultSet rs = state.executeQuery(sql);	
		List<Funding> list = new ArrayList<Funding>();
		while(rs.next()) {
			Funding f = new Funding();
			String fund_id = rs.getString("fund_id");
			String fund_money = rs.getString("fund_money");
			String fund_create_time = rs.getString("fund_create_time");
			String fund_state = rs.getString("fund_state");
			String fund_frost_time = rs.getString("fund_frost_time");
			String user_phone_no = rs.getString("user_phone_no");
			String user_name = rs.getString("user_name");
			String user_id_card = rs.getString("user_id_card");
			String pro_name = rs.getString("pro_name");
			String fund_req_state = rs.getString("fund_req_state");
			String fund_deduct_time = rs.getString("fund_deduct_time");
			f.setFundId(Long.parseLong(fund_id));
			f.setFundMoney(fund_money);
			SimpleDateFormat fom = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date fundCreateTime = fom.parse(fund_create_time);
			f.setFundCreateTime(fundCreateTime);
			f.setFundPhoneNo(user_phone_no);
			f.setFundIdCard(user_id_card);
			f.setFundProName(pro_name);
			f.setFundState(fund_state);
			f.setFundFrostTime(fom.parse(fund_frost_time));
			f.setFundDeductTime(fom.parse(fund_deduct_time));
			list.add(f);
		}
		rs.close();
		state.close();
		conn.close();
		return list;
	}
	@Override
	public Double getObSumMoney(Map<String, Object> map) throws Exception {
		Connection conn = getConnection();
		Statement state = conn.createStatement();
		String sql="select sum(fund_money) as sumMoney from fm_funding a  " + 
				"left join fm_user b on a.fund_f_user_id=b.user_id " + 
				"left join fm_product c on a.fund_f_pro_id=c.pro_id " + 
				"where  a.fund_create_time>='"+map.get("startTime")+"'  " + 
				"and a.fund_create_time<='"+map.get("endTime")+"' ";
				if (map.get("fundPhoneNo")!="") {
					sql+="and b.user_phone_no='"+map.get("fundPhoneNo")+"'";
				}
				sql+=" and a.fund_state='1' order by a.fund_create_time";
				System.out.println(sql);
		ResultSet rs = state.executeQuery(sql);	
		if (rs.next()) {
			return Double.parseDouble(rs.getString("sumMoney"));
		}
		return 0.0;
	}

}
