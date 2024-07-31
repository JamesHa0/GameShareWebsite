package game.dao;


import java.util.List;

import game.bean.Comment;

public interface CommentDao extends Dao{
	//查询评论总数
	int queryCommentNum(String gid)throws Exception;
	
	//查询某游戏的所有评论
	List<Comment> queryAllCommentByGid(String gid) throws Exception;
	
	//插入评论记录
	int insertComment(Comment comment)throws Exception;
	
	//删除评论记录
	int deleteCommentByUidAndGid(String uid,String gid)throws Exception;

}
