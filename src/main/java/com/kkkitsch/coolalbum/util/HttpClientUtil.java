package com.kkkitsch.coolalbum.util;

import java.io.InputStream;
import java.net.URI;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.net.ssl.SSLContext;

import java.util.Set;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;

import com.alibaba.fastjson.JSON;

public class HttpClientUtil {

	public static String invoke(Map<String, Integer> urlConfig) throws Exception {
		// 客户端对象
		CloseableHttpClient httpclient = HttpClients.createDefault();
		// 创建请求uri
		URIBuilder uriBuilder = new URIBuilder().setScheme("http").setHost("api.avatardata.cn")
				.setPath("/HistoryToday/LookUp").setParameter("key", "938b6f475f67483fa0b6d434a0deade5");

		if (urlConfig.isEmpty()) {
			return "参数错误";
		} else {
			Set<Entry<String, Integer>> entrySet = urlConfig.entrySet();
			for (Entry<String, Integer> entry : entrySet) {
				uriBuilder.setParameter(entry.getKey(), entry.getValue().toString());
			}
		}

		URI uri = uriBuilder.build();

		// 具体请求对象
		HttpGet httpget = new HttpGet(uri);

		// 设置请求连接时限和超时时限
		RequestConfig config = RequestConfig.custom().setConnectTimeout(5000).setSocketTimeout(5000).build();
		httpget.setConfig(config);

		// 执行请求
		CloseableHttpResponse response = httpclient.execute(httpget);
		try {

			response.setHeader("Content-Type", "text/html;charset=UTF-8");

			HttpEntity httpEntity = response.getEntity();

			// 确保不为空
			if (null != httpEntity) {

				InputStream content = httpEntity.getContent();

				// 返回文本长度的字节数：在UTF-8下，一个中文字符占用三个字节
				int contentLength = (int) httpEntity.getContentLength();

				byte[] b = new byte[contentLength];
				int read = content.read(b);
				String str = new String(b);

				// 返回响应头参数：contentType
				Header contentType = httpEntity.getContentType();

				System.out.println("执行完成！");
				System.out.println("读取到的字节数：" + read);
				System.out.println("返回的结果：" + str);
				System.out.println("contentLength=" + contentLength);
				System.out.println("contentType=" + contentType);

				// 确保资源被关闭
				content.close();

				return str;
			}
		} finally {
			response.close();
		}
		return null;
	}

	public static boolean validContent(String validContent) throws Exception {

		// 客户端对象
		CloseableHttpClient httpclient = null;
		try {
			SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
				public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
					return true;
				}
			}).build();
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);
			// 创建一个可以访问https的请求对象
			httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		// 创建请求uri，表单提交总不能请求uri中带着参数吧
		URIBuilder uriBuilder = new URIBuilder().setScheme("https").setHost("aip.baidubce.com")
				.setPath("/rest/2.0/antispam/v2/spam");
		URI uri = uriBuilder.build();
		HttpPost httpPost = new HttpPost();
		httpPost.setURI(uri);

		List<BasicNameValuePair> nameValuePairlist = new ArrayList<BasicNameValuePair>();
		nameValuePairlist.add(new BasicNameValuePair("access_token",
				"24.0c290515f30e8f696400ac125aebec74.2592000.1555658597.282335-15803646"));
		nameValuePairlist.add(new BasicNameValuePair("command_no", "500071"));
		nameValuePairlist.add(new BasicNameValuePair("content", validContent));
		HttpEntity httpEntity = new UrlEncodedFormEntity(nameValuePairlist);

		httpPost.setEntity(httpEntity);

		CloseableHttpResponse response = httpclient.execute(httpPost);
		HttpEntity entity = response.getEntity();
		InputStream content = entity.getContent();
		byte[] b = new byte[1024];
		content.read(b);
		String str = new String(b);
		String jsonString = JSON.toJSONString(str);
		String substring = jsonString.substring(jsonString.indexOf("spam"), jsonString.indexOf("spam") + 10);

		if (substring.contains("0")) {
			return true;
		} else {
			return false;
		}
	}
}
