package game.dao;


import game.bean.Like;

public interface LikeDao extends Dao{
	//查询赞的总数
	int queryLikeNum(String gid)throws Exception;
	
	//查询指定uid，gid是否点过赞
	boolean queryIsLikedByUidAndGid(String uid,String gid)throws Exception;
	
	//插入赞的记录
	int insertLike(Like like)throws Exception;
	//删除赞的记录
	int deleteLikeByUidAndGid(String uid,String gid)throws Exception;

}
