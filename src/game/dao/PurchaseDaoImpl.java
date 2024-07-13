package game.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import game.bean.Purchase;

public class PurchaseDaoImpl implements PurchaseDao{
	// 查询所有
	@Override
	public List<Purchase> queryAllPurchase() throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Purchase> list = new ArrayList<>();

		try {
			conn = getConnection();
			String sql = "select * from Purchase where 1=1";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				String gid = rs.getString("gid");
				String uid = rs.getString("uid");
				String onumber = rs.getString("onumber");
				String otime = rs.getString("otime");

				Purchase purchase = new Purchase(gid, onumber, uid, otime);
				list.add(purchase);
			}
		} finally {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
		}

		return list;
	}
	
	//查询用户购买的所有游戏
	@Override // by uid:
	public List<Purchase> queryPurchaseByUid(String uid) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Purchase> list = new ArrayList<>();

		try {
			conn = getConnection();
			String sql = "select * from purchase where uid=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, uid);
			rs = ps.executeQuery();

			while (rs.next()) {
				String gid = rs.getString("gid");
				String onumber = rs.getString("onumber");
				String otime = rs.getString("otime");

				Purchase purchase = new Purchase(gid, onumber, uid, otime);
				list.add(purchase);
			}
		} finally {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
		}

		return list;
	}
	
	
	
	
	//查询游戏被哪些用户购买
		@Override // by gid:
		public List<Purchase> queryPurchaseByGid(String gid) throws Exception {
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			List<Purchase> list = new ArrayList<>();

			try {
				conn = getConnection();
				String sql = "select * from purchase where gid=?";
				ps = conn.prepareStatement(sql);
				ps.setString(1, gid);
				rs = ps.executeQuery();

				while (rs.next()) {
					String uid = rs.getString("uid");
					String onumber = rs.getString("onumber");
					String otime = rs.getString("otime");

					Purchase purchase = new Purchase(gid, onumber, uid, otime);
					list.add(purchase);
				}
			} finally {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();
			}

			return list;
		}
	

	// 查询单条

	// **************************************************************query:
	@Override // by uid and gid:
	public Purchase queryOnePurchase(String uid,String gid) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Purchase purchase = null;

		try {
			conn = getConnection();
			String sql = "select * from purchase where uid=? and gid=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, uid);
			ps.setString(2, gid);
			rs = ps.executeQuery();

			if (rs.next()) {
				String onumber = rs.getString("onumber");
				String otime = rs.getString("otime");

				purchase = new Purchase(gid, onumber, uid, otime);
			}
		} finally {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
		}

		return purchase;
	}

	

	// ************************************************************************8

	// 插入
	@Override
	public String insertPurchase(String gid,String uid,String otime) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		int affectedRows = 0;
		String onumber = uid+gid+System.currentTimeMillis();
		System.out.println("onumber="+onumber);
		try {
			conn = getConnection();
			String sql = "insert into purchase(gid,uid,onumber,otime) values (?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, gid);
			ps.setString(2, uid);
			ps.setString(3, onumber);
			ps.setString(4, otime);
			affectedRows = ps.executeUpdate();
		} finally {
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
		}
		if(affectedRows > 0) {
			return onumber;
		}else {
			return null;
		}
	}


	// 删除
	@Override
	public int deletePurchaseByOnumber(String onumber) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		int affectedRows = 0;

		try {
			conn = getConnection();
			String sql = "delete from purchase where onumber=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, onumber);
			affectedRows = ps.executeUpdate();
		} finally {
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
		}

		return affectedRows;
	}

}
