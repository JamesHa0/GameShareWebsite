package crf.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.NumberFormat;
import java.util.Random;

/**
 * <p>Title: 数字工具类</p>
 * <p>Description: </p>
 * <p>Company: 上海信而富金融信息服务有限公司</p>
 * @author zhiwang 
 * @date 2015-4-14
 */
public class NumberUtil {
	
	public static final String FORMAT_TWO="#,###.00";
	
	/**
	 * 字符串转化为特定类型的数值 long
	 * @date 2015年3月10日
	 * @param str String 
	 * @return long
	 */
	public static long nullToL(String str){
		if((str==null)||("".equals(str))){
			return 0L;
		}else{
			return (Long.parseLong(str));
		}
	}
	
	/**
	 * 字符串转化为特定类型的数值 int
	 * @date 2015年3月10日
	 * @param str String 
	 * @return int
	 */
	public static int nullToI(String str){
		if((str==null)||("".equals(str))){
			return 0;
		}else{
			return Integer.parseInt(str);
		}
	}
	
	/**
	 * 字符串转化为特定类型的数值 double
	 * @date 2015年3月10日
	 * @param str String 
	 * @return double
	 */
	public static double nullToD(String str){
		if((str==null)||("".equals(str))){
			return 0.00;
		}else{
			return Double.parseDouble(str);
		}
	}

	/**
	 * 产生给定位数的随机数字
	 * @param numsize int
	 * @return String
	 */
	public static String getRandomNum(int numsize){
		if(numsize<=0)
			return "";
		Random random = new Random();
		String result="";
		for(int i=0;i<numsize;i++){
			result+=random.nextInt(10);
		}
		return result;
	}
	
	/**
	 * double 类型比较
	 * @param d1 double
	 * @param d2 double
	 * @return -1:小于，0:等于，1:大于
	 */
	public static int compareDouble(double d1,double d2){
		BigDecimal data1 = new BigDecimal(d1); 
		BigDecimal data2 = new BigDecimal(d2); 
		
		return data1.compareTo(data2);
	}
	
	/**
	 * 多个double数据相加
	 * @param ds
	 * @return double
	 */
	public static double addDouble(double... ds){
		BigDecimal x=new BigDecimal(0.0);
		for(double d:ds){
			BigDecimal y = new BigDecimal(d);
			x=x.add(y);
		}
		return x.doubleValue();
	}
	/**
	 * 多个double相减,减数在前面，被减数在后面
	 * @param ds
	 * @return double
	 */
	public static double subtractDouble(double...ds){
		BigDecimal x=null;
		for(double d:ds){
			if(null==x){
			 x = new BigDecimal(d);
			}else{
				BigDecimal y = new BigDecimal(d);
				x=x.subtract(y);
			}
		}
		return x.doubleValue();
	}
	
	/**
	 * 多个double相乘
	 * @param ds
	 * @return double
	 */
	public static double multiplyDouble(double...ds){
		BigDecimal x=null;
		for(double d:ds){
			if(null==x){
			 x = new BigDecimal(d);
			}else{
				BigDecimal y = new BigDecimal(d);
				x=x.multiply(y);
			}
		}
		return x.doubleValue();
	}
	
	/**
	 * 多个double相除
	 * @param ds
	 * @return double
	 */
	public static double divisionDouble(double...ds){
		BigDecimal x=null;
		for(double d:ds){
			if(null==x){
			 x = new BigDecimal(d);
			}else{
				BigDecimal y = new BigDecimal(d);
				x=x.divide(y);
			}
		}
		return x.doubleValue();
		
	}
	/**
	 * double格式化
	 * @param d double数据
	 * @param precision 精度 保留的小数位数
	 * @return
	 */
	public static double formatDouble(double d,int precision){
		String format="#.";
		for(int i=0;i<precision;i++){
			format+="#";
		}
		return Double.valueOf(new DecimalFormat(format).format(d));
	}
	
	 public static String percentFormat(double d,int digits){
		  NumberFormat nf = NumberFormat.getPercentInstance(); 
		  nf.setMinimumFractionDigits(digits);// 小数点后保留几位
		  String str = nf.format(d);
		  return str;
	 }
	 
	 public static String doubleFormat(double d){
		 String str = "--";
		 try {
			Format fm=new DecimalFormat(FORMAT_TWO);
			 //小于0格式化
			 if(d<0){
				 d=d*-1; 
				 str = fm.format(d);
				 int index = str.indexOf(".");
				 if(index < 1){
					 str = "0" + str;
				 }
				 str = "-"+str;
			 }
			 //大于等于0格式化
			 else{
				 str = fm.format(d);
				 int index = str.indexOf(".");
				 if(index < 1){
					 str = "0" + str;
				 }
			 }
		} catch (Exception e) {
			str = "--";
		}
		return str;
	 }
	 
	 public static void main(String[] args) {
		 System.out.println(doubleFormat(-1));
	}
}

