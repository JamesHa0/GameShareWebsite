package crf.other;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
	public static String MD5Encoder(String password) throws NoSuchAlgorithmException {
		MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] srcBytes = password.getBytes(StandardCharsets.UTF_8);
        md5.update(srcBytes);
        byte[] resultBytes = md5.digest();
        
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : resultBytes) {
            stringBuilder.append(String.format("%02x", b)); // 将字节转换为16进制
        }
        return stringBuilder.toString();
	}
}
