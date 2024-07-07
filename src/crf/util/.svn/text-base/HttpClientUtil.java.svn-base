package crf.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class HttpClientUtil {

	static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

	/**
	 * post方式 王浩 @2015-5-14 功能:超时和编码 timeout:超时(毫秒) encoding:编码
	 */
	@SuppressWarnings("deprecation")
	public static String postWay(String url, Map<String, String> map,
			int timeout, String encoding) {
		String result = "";
		PostMethod postMethod = null;
		try {
			// 读取内容
			HttpClient httpClient = new HttpClient();
			// 设置超时
			httpClient.setConnectionTimeout(timeout);
			if (encoding != null && !"".equals(encoding)) {
				// 设置编码
				httpClient.getParams().setParameter(
						HttpMethodParams.HTTP_CONTENT_CHARSET, encoding);
			}
			postMethod = new PostMethod(url);
			postMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
					new DefaultHttpMethodRetryHandler());
			// 参数
			if (map != null && map.size() != 0) {
				int i = map.size();
				NameValuePair[] params = new NameValuePair[i];
				int k = 0;
				for (String key : map.keySet()) {
					params[k] = new NameValuePair(key, map.get(key));
					k++;
				}
				postMethod.setRequestBody(params);
			}
			httpClient.executeMethod(postMethod);
			// 第一种方式
			result = postMethod.getResponseBodyAsString();
		} catch (Exception e) {
			logger.error("httpclient请求异常", e);
		} finally {
			postMethod.releaseConnection();
		}
		return result;
	}

	/**
	 * post请求获取返回结果集
	 * 
	 * @author cuisongjie
	 * @param url
	 * @return
	 */
	public static String postWay(String url) {
		String result = "";
		PostMethod postMethod = null;
		try {
			HttpClient httpClient = new HttpClient();
			postMethod = new PostMethod(url);
			httpClient.executeMethod(postMethod);
			result = postMethod.getResponseBodyAsString();
		} catch (Exception e) {
			logger.error("httpclient请求异常", e);
		} finally {
			postMethod.releaseConnection();
		}
		return result;
	}

	/**
	 * get方式 王浩 @2015-5-14 功能:
	 */
	public static String getWay(String url) {
		String result = "";
		GetMethod getMethod = null;
		try {
			// 读取内容
			HttpClient httpClient = new HttpClient();
			getMethod = new GetMethod(url);
			httpClient.executeMethod(getMethod);
			result = getMethod.getResponseBodyAsString();
		} catch (Exception e) {
			logger.error("httpclient请求异常", e);
		} finally {
			getMethod.releaseConnection();
		}
		return result;
	}
	/**
	 * 	功能:发起https请求
	 *	王浩  @2015-7-27
	 */
	public static JSONObject httpRequest(String requestUrl, String requestMethod, String outputStr) {
		JSONObject jsonObject = null;
		StringBuffer buffer = new StringBuffer();
		try {
			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();

			URL url = new URL(requestUrl);
			HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
			httpUrlConn.setSSLSocketFactory(ssf);
			httpUrlConn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);
			// 设置请求方式（GET/POST）
			httpUrlConn.setRequestMethod(requestMethod);

			if ("GET".equalsIgnoreCase(requestMethod))
				httpUrlConn.connect();

			// 当有数据需要提交时
			if (null != outputStr) {
				OutputStream outputStream = httpUrlConn.getOutputStream();
				// 注意编码格式，防止中文乱码
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}

			// 将返回的输入流转换成字符串
			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			// 释放资源
			inputStream.close();
			inputStream = null;
			httpUrlConn.disconnect();
			jsonObject = JSONObject.fromObject(buffer.toString());
		} catch (ConnectException ce) {
			logger.error("server connection timed out.");
		} catch (Exception e) {
			logger.error("https request error:{}", e);
		}
		return jsonObject;
	}
	/**
	 * 	功能:素材上传至微信服务器
	 *	王浩  @2015-7-26
	 */
	public static JSONObject uploadFile(String accessToken,MultipartFile file,String url) {
		JSONObject jsonObject = null;
		// 拼装请求地址
		String uploadMediaUrl = url;

		// 定义数据分隔符
		String boundary = "------------7da2e536604c8";
		try {
			URL uploadUrl = new URL(uploadMediaUrl);
			HttpURLConnection uploadConn = (HttpURLConnection) uploadUrl.openConnection();
			uploadConn.setDoOutput(true);
			uploadConn.setDoInput(true);
			uploadConn.setRequestMethod("POST");
			// 设置请求头Content-Type
			uploadConn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
			// 获取媒体文件上传的输出流（往微信服务器写数据）
			OutputStream outputStream = uploadConn.getOutputStream();

			// 从请求头中获取内容类型
			String contentType = file.getContentType();
			// 根据内容类型判断文件扩展名
			String fileExt = "."+FileUtil.getExtensionName(file.getOriginalFilename());
			// 请求体开始
			outputStream.write(("--" + boundary + "\r\n").getBytes());
			outputStream.write(String.format("Content-Disposition: form-data; name=\"media\"; filename=\"file1%s\"\r\n", fileExt).getBytes());
			outputStream.write(String.format("Content-Type: %s\r\n\r\n", contentType).getBytes());

			// 获取媒体文件的输入流（读取文件）
			BufferedInputStream bis = new BufferedInputStream(file.getInputStream());
			byte[] buf = new byte[8096];
			int size = 0;
			while ((size = bis.read(buf)) != -1) {
				// 将媒体文件写到输出流（往微信服务器写数据）
				outputStream.write(buf, 0, size);
			}
			// 请求体结束
			outputStream.write(("\r\n--" + boundary + "--\r\n").getBytes());
			outputStream.close();
			bis.close();

			// 获取媒体文件上传的输入流（从微信服务器读数据）
			InputStream inputStream = uploadConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			StringBuffer buffer = new StringBuffer();
			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			// 释放资源
			inputStream.close();
			inputStream = null;
			uploadConn.disconnect();

			// 使用JSON-lib解析返回结果
			jsonObject = JSONObject.fromObject(buffer.toString());
		} catch (Exception e) {
			String error = String.format("上传媒体文件失败：%s", e);
			logger.info(error);
		}
		return jsonObject;
	} 

	public static void main(String[] args) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("1", "1");
		paramMap.put("2", "2");
		paramMap.put("3", "3");
		System.out.println(paramMap.size());
	}
}