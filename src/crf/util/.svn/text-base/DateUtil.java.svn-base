package crf.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具类
 * @author cuisongjie
 * @date 2015-05-28
 */
public class DateUtil {
	
	/**
	 * 获取yyyy-MM-dd格式的当前时间字符串
	 * @author cuisongjie
	 * @date 2015-05-28
	 * @return
	 */
	public static String getDate(){
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	}
	
	/**
	 * 获取yyyy-MM-dd HH:mm:ss格式的当前时间字符串
	 * @author cuisongjie
	 * @date 2015-05-28
	 * @return
	 */
	public static String getDateTime(){
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}
	/**
	 * StringToDateTime
	 *王浩  @2015-5-29 功能:
	 */
	public static Date stringToDateTime(String date){
		Date d=null;
		try {
			d =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}

	/**
	 * long转换为时间
	 *王浩  @2015-5-28 功能:
	 */
	public static String longToDateTime( Long millSec) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(millSec);
		return sdf.format(date);
	}
	
	/**
	 * 获取自定义格式日期
	 * @author cuisongjie
	 * @date 2015-05-28
	 * @return
	 */
	public static String getDateFormat(String format){
		return new SimpleDateFormat(format).format(new Date());
	}
	/**
	 * 将日期转化特定格式的日期字符串
	 * @verson v1.0
	 * @date 2015年3月10日
	 * @param date Date 日期
	 * @param format String 转化格式
	 * @return String
	 */
	public static String dateToStr(Date date, String format) {
		String dateStr = "";
		if(date != null){
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			dateStr = sdf.format(date);
		}
		return dateStr;
	}
}
