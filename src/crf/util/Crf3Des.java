package crf.util;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

@SuppressWarnings("unused")
public class Crf3Des {
	private static final String KEY24 = "wang.h.6801G6922.xef.XEF";

	/**
	 * 生成3DES密钥.
	 * 
	 * @param key_byte
	 *            seed key
	 * @throws Exception
	 * @return javax.crypto.SecretKey Generated DES key
	 */
	private static javax.crypto.SecretKey genDESKey(byte[] key_byte) throws Exception {
		//
		SecretKey k = null;
		k = new SecretKeySpec(key_byte, "DESede");
		return k;
	}

	/**
	 * 3DES 解密(byte[]).
	 * 
	 * @param key
	 *            SecretKey
	 * @param crypt
	 *            byte[]
	 * @throws Exception
	 * @return byte[]
	 */
	private static byte[] desDecrypt(javax.crypto.SecretKey key, byte[] crypt) throws Exception {
		javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("DESede");
		cipher.init(javax.crypto.Cipher.DECRYPT_MODE, key);
		return cipher.doFinal(crypt);
	}

	/**
	 * 3DES 解密(String).
	 * 
	 * @param key
	 *            SecretKey
	 * @param crypt
	 *            byte[]
	 * @throws Exception
	 * @return byte[]
	 */
	private static String desDecrypt(javax.crypto.SecretKey key, String crypt) throws Exception {
		return new String(desDecrypt(key, crypt.getBytes()));
	}

	/**
	 * 3DES加密(byte[]).
	 * 
	 * @param key
	 *            SecretKey
	 * @param src
	 *            byte[]
	 * @throws Exception
	 * @return byte[]
	 */
	private static byte[] desEncrypt(javax.crypto.SecretKey key, byte[] src) throws Exception {
		javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("DESede");
		cipher.init(javax.crypto.Cipher.ENCRYPT_MODE, key);
		return cipher.doFinal(src);
	}

	/**
	 * 3DES加密(String).
	 * 
	 * @param key
	 *            SecretKey
	 * @param src
	 *            byte[]
	 * @throws Exception
	 * @return byte[]
	 */
	private static String desEncrypt(javax.crypto.SecretKey key, String src) throws Exception {
		return new String(desEncrypt(key, src.getBytes()));
	}

	/**
	 * BASE64 编码(byte[]).
	 * 
	 * @param src
	 *            byte[] inputed string
	 * @return String returned string
	 */
	private static String base64Encode(byte[] src) {
		sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();

		return encoder.encode(src);
	}

	/**
	 * BASE64 解码(to byte[]).
	 * 
	 * @param src
	 *            String inputed string
	 * @return String returned string
	 */
	private static byte[] base64DecodeToBytes(String src) {
		sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();

		try {
			return decoder.decodeBuffer(src);
		} catch (Exception ex) {
			return null;
		}

	}

	
	/**
	 * CDS加密程序
	 * 
	 * @param src
	 * @return String
	 */
	public static String cdsEncrypt(String src) {
		SecretKey deskey;
		byte[] keyByte = null;
		String result = null;
		try {

			if ("".equals(src) || src == null) {
				return src;
			}

			keyByte = KEY24.getBytes("UTF-8");

			byte[] src_byte = src.getBytes("UTF-8");
			deskey = genDESKey(keyByte);
			byte[] encrypt = desEncrypt(deskey, src_byte);
			result = base64Encode(encrypt);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * CDS解密程序
	 * 
	 * @param crypt
	 * @return String
	 */
	public static String cdsDecrypt(String crypt) {
		SecretKey deskey;
		byte[] keyByte = null;
		String result = null;
		try {
			if ("".equals(crypt) || crypt == null) {
				return crypt;
			}
			keyByte = KEY24.getBytes("UTF-8");
			byte[] src_byte = base64DecodeToBytes(crypt);
			deskey = genDESKey(keyByte);

			byte[] decrypt = desDecrypt(deskey, src_byte);

			result = new String(decrypt, "UTF-8");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 已测试..ok
	 * 
	 * @param args
	 */
	@SuppressWarnings({ "static-access" })
	public static void main(String[] args) {
		try {
			String str = "<?xml version=\'1.0\' encoding=\"UTF-8\"?><ROWS><ROW name=\"LOAN_CONTRACT_NO\" desc=\"合同编号\">HF0122435465934</ROW><ROW name=\"LOAN_CONTRACT_NO\" desc=\"约定罚息金额\">HF0122435465934</ROW><ROW name=\"LOAN_CONTRACT_NO\" desc=\"约定还款日\">2012-12-29</ROW><ROW name=\"LOAN_CONTRACT_NO\" desc=\"查询人\">王立军 </ROW><ROW name=\"LOAN_CONTRACT_NO\" desc=\"查询日期\">2012-12-20</ROW></ROWS>";

			Crf3Des des = new Crf3Des();
			//加密前
			System.out.println(str);
			//加密后
			String strdes = des.cdsEncrypt(str);
			System.out.println(strdes);
			//解密后
			System.out.println(des.cdsDecrypt(strdes));

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}