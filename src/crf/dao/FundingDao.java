package crf.dao;

import java.util.List;
import java.util.Map;

import crf.invest.entity.Funding;

public interface FundingDao {
	public long getObListCount(Map<String,Object> map)throws Exception;

	public List<Funding> queryObListTable(Map<String, Object> map)throws Exception;

	public Double getObSumMoney(Map<String, Object> map)throws Exception;

}
