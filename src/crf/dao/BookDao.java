package crf.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import crf.invest.entity.Book;

public interface BookDao {

	long getBookListCount(String bookname)throws Exception;

	List<Book> queryBookListTable(Map<String, Object> map)throws Exception;

	Book queryBookById(String id)throws Exception;

	int insertBook(HashMap<String, Object> map)throws Exception;

	int updateBookById(HashMap<String, Object> map)throws Exception;

	int deleteBookById(String id)throws Exception;

}
