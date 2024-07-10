package game.dao;

import java.util.List;

import game.bean.Game;

public interface GameDao extends Dao{
	//查询所有游戏
	List<Game> queryAllGame()throws Exception;
	//查询单个游戏
	Game queryGameByGid(String gid)throws Exception;
	Game queryGameByGname(String gname)throws Exception;
	
	//插入游戏
	int insertGame(Game game)throws Exception;
	//更新游戏信息
	int updateGameByGId(Game game)throws Exception;
	//删除游戏
	int deleteGameByGId(String gid)throws Exception;

}
