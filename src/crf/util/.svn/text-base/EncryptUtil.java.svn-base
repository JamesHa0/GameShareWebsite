package crf.util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptUtil {

	public static void main(String[] args) {
		//md5加密测试
		String md5_1 = md5("1");
		String md5_2 = md5("1");
		System.out.println(md5_1 + "\n" + md5_2);
		System.out.println("md5 length: " + md5_1.length());
		//sha加密测试
		String sha_1 = sha("123");
		String sha_2 = sha("abc");
		System.out.println(sha_1 + "\n" + sha_2);
		System.out.println("sha length: " + sha_1.length());
	}

	// md5加密
	public static String md5(String inputText) {
		return encrypt(inputText, "md5");
	}

	// sha加密
	public static String sha(String inputText) {
		return encrypt(inputText, "sha-1");
	}

	/**
	 * md5或者sha-1加密
	 * 
	 * @param inputText
	 *            要加密的内容
	 * @param algorithmName
	 *            加密算法名称：md5或者sha-1，不区分大小写
	 * @return
	 */
	private static String encrypt(String inputText, String algorithmName) {
		if (inputText == null || "".equals(inputText.trim())) {
			throw new IllegalArgumentException("请输入要加密的内容");
		}
		if (algorithmName == null || "".equals(algorithmName.trim())) {
			algorithmName = "md5";
		}
		String encryptText = null;
		try {
			MessageDigest m = MessageDigest.getInstance(algorithmName);
			m.update(inputText.getBytes("UTF8"));
			byte s[] = m.digest();
			// m.digest(inputText.getBytes("UTF8"));
			return hex(s);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return encryptText;
	}

	// 返回十六进制字符串
	private static String hex(byte[] arr) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < arr.length; ++i) {
			sb.append(Integer.toHexString((arr[i] & 0xFF) | 0x100).substring(1,
					3));
		}
		return sb.toString();
	}
	/**
	 * 	功能:信而富MD5加密
	 *	王浩  @2015-9-22
	 */
	public static String MD5(String input) {
		return MD5(input, Charset.defaultCharset());
	}
	
	/**
	 * MD5 摘要
	 * 
	 * @param input
	 * @param charset
	 * @return
	 */
	public static String MD5(String input, Charset charset) {
		MessageDigest md = null;

		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
	         System.out.println("md5加密异常");
		}

		md.update(input.getBytes());
		
		char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',  'e', 'f'}; 
		byte tmp[] = md.digest();
		char str[] = new char[16 * 2];

		int k = 0;
		for (int i = 0; i < 16; i++) {
			byte byte0 = tmp[i];
			str[k++] = hexDigits[byte0 >>> 4 & 0xf];
			str[k++] = hexDigits[byte0 & 0xf];
		}
		
		String result = new String(str);

		return result;
	}
}
