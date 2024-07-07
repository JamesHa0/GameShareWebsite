package crf.util;

public class PageUtil {
	private long totalCount;//总条数
	private long currentPage;//当前页
	private long totalPage;//总页数
	public static final long pageNum=15;//每页条数
	public static final String TURN_YES= "YES";
	public static final String TURN_NO = "NO";
	
	public PageUtil(){}
	public PageUtil(String currentPage,long totalCount){
		this.currentPage=Long.parseLong(currentPage);
		this.totalCount=totalCount;
	}
	/**
	 * 得到总页数
	 *王浩  @2015-3-18 功能:
	 */
	public long getTotalPage(){
		if(totalCount/pageNum==0){
			this.totalPage=1;
		}else{
			this.totalPage=(totalCount%pageNum==0?totalCount/pageNum:totalCount/pageNum+1);
		}
		return this.totalPage;
	}
	/**
	 * 得到索引数 (crurentPage * pageNum) - pageNum
	 *王浩  @2015-3-18 功能:
	 */
	public long getIndex(){
		long index = (this.currentPage * pageNum) - pageNum;
		return index;
	}
	public long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	public long getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(long currentPage) {
		this.currentPage = currentPage;
	}
	public static long getPagenum() {
		return pageNum;
	}
	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}
}
