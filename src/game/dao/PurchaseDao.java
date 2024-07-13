package game.dao;

import java.util.List;

import game.bean.Purchase;

public interface PurchaseDao extends Dao{
	// 查询所有购买记录
	List<Purchase> queryAllPurchase() throws Exception;

	// 查询某用户购买记录
	List<Purchase> queryPurchaseByUid(String uid) throws Exception;

	// 查询某游戏被购买记录
	List<Purchase> queryPurchaseByGid(String gid) throws Exception;

	// 查询单条购买记录
	Purchase queryOnePurchase(String uid,String gid) throws Exception;

	// 插入购买记录
	String insertPurchase(String gid,String uid,String otime) throws Exception;

	// 删除购买记录
	int deletePurchaseByOnumber(String onumber) throws Exception;
}
