package game.dao;


import java.util.List;

import game.bean.Comment;

public interface CommentDao extends Dao{
	//查询某游戏的评论总数
	int queryCommentNum(String gid)throws Exception;
	
	//查询某游戏的所有评论
	List<Comment> queryAllCommentByGid(String gid) throws Exception;
	
	//插入评论记录
	Comment insertComment(Comment comment)throws Exception;
	
	//删除评论记录（备用）
	int deleteCommentByCid(String cid)throws Exception;
	
	//更新（点赞/取消赞，或者考虑评论内容修改）
	int updateComment(Comment comment) throws Exception;
	

}
