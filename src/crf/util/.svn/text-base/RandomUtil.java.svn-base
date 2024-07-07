package crf.util;
/**
 * 生成手机验证码
 * @author NSF
 * @version v1.0
 */
public class RandomUtil {
	
	public static int rdoMob(){
		int[] ret = new int[6];
		for (int i = 0; i < 6; i++) {
			int random=(int)(Math.random()*10);
			ret[i] = random;
		}
		StringBuffer sb = new StringBuffer("");
		for (int i = 0; i < ret.length; i++) {
			sb.append(ret[i]);
		}
		return Integer.parseInt(sb.toString());
	}
	 
	public static void main(String[] args) {
		int arr =  rdoMob();
		System.out.println(arr);
	}

}
