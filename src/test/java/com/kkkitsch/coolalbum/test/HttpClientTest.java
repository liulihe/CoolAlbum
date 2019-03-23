package com.kkkitsch.coolalbum.test;

import java.io.InputStream;
import java.net.URI;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.net.ssl.SSLContext;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;
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
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class HttpClientTest {

	@Test
	public void test1() throws Exception {

		// 客户端对象
		CloseableHttpClient httpclient = HttpClients.createDefault();

		// 创建请求uri

		// 历史上的今天接口：http://api.avatardata.cn/HistoryToday/LookUp?key=938b6f475f67483fa0b6d434a0deade5&yue=1&ri=1&type=1&page=1&rows=5
		URIBuilder uriBuilder = new URIBuilder().setScheme("http").setHost("api.avatardata.cn")
				.setPath("/HistoryToday/LookUp").setParameter("key", "938b6f475f67483fa0b6d434a0deade5")
				.setParameter("yue", "1").setParameter("ri", "1").setParameter("type", "1").setParameter("page", "1")
				.setParameter("rows", "20");
		URI uri = uriBuilder.build();

		System.out.println("uriBuilder=" + uriBuilder);
		System.out.println("uri=" + uri);

		// 具体请求对象
		HttpGet httpget = new HttpGet(uri);

		// 设置请求连接时限和超时时限
		RequestConfig config = RequestConfig.custom().setConnectTimeout(5000).setSocketTimeout(5000).build();
		httpget.setConfig(config);

		// 执行请求
		CloseableHttpResponse response = httpclient.execute(httpget);
		try {

			response.setHeader("Content-Type", "text/html;charset=UTF-8");

			Header[] allHeaders = response.getAllHeaders();
			for (Header header : allHeaders) {
				System.out.println(header);
			}
			System.out.println("========================");

			Locale locale = response.getLocale();
			System.out.println("locale=" + locale);

			ProtocolVersion protocolVersion = response.getProtocolVersion();
			System.out.println("protocolVersion" + protocolVersion);

			StatusLine statusLine = response.getStatusLine();
			System.out.println("statusLine=" + statusLine);

			HttpEntity httpEntity = response.getEntity();

			// 确保不为空
			if (null != httpEntity) {
				Class<? extends HttpEntity> class1 = httpEntity.getClass();

				InputStream content = httpEntity.getContent();

				byte[] b = new byte[1024];
				int read = content.read(b);
				String str = new String(b);

				Header contentEncoding = httpEntity.getContentEncoding();

				// 返回文本长度的字节数：在UTF-8下，一个中文字符占用三个字节
				long contentLength = httpEntity.getContentLength();

				// 返回响应头参数：contentType
				Header contentType = httpEntity.getContentType();

				System.out.println("执行完成！");
				System.out.println("class1=" + class1);
				System.out.println("read=" + read);
				System.out.println("str=" + str);
				System.out.println("contentEncoding=" + contentEncoding);
				System.out.println("contentLength=" + contentLength);
				System.out.println("contentType=" + contentType);

				try {
					// 使用工具类
					String string = EntityUtils.toString(httpEntity, "UTF-8");
					System.out.println(string);
					System.out.println("llllllllllllllllllll=============================");

				} catch (Exception e) {
				} finally {
					// 确保低级资源被关闭
					content.close();
				}

			}

		} finally {
			response.close();
		}
	}

	public void test2() throws Exception {
		// 客户端对象
		CloseableHttpClient httpclient = HttpClients.createDefault();

		// 创建请求uri

		URIBuilder uriBuilder = new URIBuilder().setScheme("http").setHost("route.showapi.com/9-2")
				.setPath("/HistoryToday/LookUp");

		uriBuilder.setParameter("", "");
		uriBuilder.setParameter("", "");
		uriBuilder.setParameter("", "");
		uriBuilder.setParameter("", "");
		uriBuilder.setParameter("", "");
		uriBuilder.setParameter("", "");
		uriBuilder.setParameter("", "");
		uriBuilder.setParameter("", "");
		uriBuilder.setParameter("", "");

		URI uri = uriBuilder.build();

		System.out.println("uriBuilder=" + uriBuilder);
		System.out.println("uri=" + uri);

		// 具体请求对象
		HttpGet httpget = new HttpGet(uri);

		// 设置请求连接时限和超时时限
		RequestConfig config = RequestConfig.custom().setConnectTimeout(5000).setSocketTimeout(5000).build();
		httpget.setConfig(config);

		// 执行请求
		CloseableHttpResponse response = httpclient.execute(httpget);
		try {

			response.setHeader("Content-Type", "text/html;charset=UTF-8");

			Header[] allHeaders = response.getAllHeaders();
			for (Header header : allHeaders) {
				System.out.println(header);
			}
			System.out.println("========================");

			HttpEntity httpEntity = response.getEntity();

			// 确保不为空
			if (null != httpEntity) {
				Class<? extends HttpEntity> class1 = httpEntity.getClass();

				InputStream content = httpEntity.getContent();

				byte[] b = new byte[1024];
				int read = content.read(b);
				String str = new String(b);

				Header contentEncoding = httpEntity.getContentEncoding();

				// 返回文本长度的字节数：在UTF-8下，一个中文字符占用三个字节
				long contentLength = httpEntity.getContentLength();

				// 返回响应头参数：contentType
				Header contentType = httpEntity.getContentType();

				System.out.println("执行完成！");
				System.out.println("class1=" + class1);
				System.out.println("read=" + read);
				System.out.println("str=" + str);
				System.out.println("contentEncoding=" + contentEncoding);
				System.out.println("contentLength=" + contentLength);
				System.out.println("contentType=" + contentType);

				try {
					// 使用工具类
					String string = EntityUtils.toString(httpEntity, "UTF-8");
					System.out.println(string);
					System.out.println("llllllllllllllllllll=============================");

				} catch (Exception e) {
				} finally {
					// 确保低级资源被关闭
					content.close();
				}
			}

		} finally {
			response.close();
		}
	}

	/**
	 * HttpPost模拟表单提交
	 */
	@Test
	public void testPostRequest() throws Exception {
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
		}

		// 创建请求uri，表单提交总不能请求uri中带着参数吧 https://aip.baidubce.com/oauth/2.0/token?
		URIBuilder uriBuilder = new URIBuilder().setScheme("https").setHost("aip.baidubce.com")
				.setPath("/oauth/2.0/token");
		URI uri = uriBuilder.build();

		HttpPost httpPost = new HttpPost();
		httpPost.setURI(uri);

		List<BasicNameValuePair> nameValuePairlist = new ArrayList<BasicNameValuePair>();
		nameValuePairlist.add(new BasicNameValuePair("grant_type", "client_credentials"));
		nameValuePairlist.add(new BasicNameValuePair("client_id", "vRGoLWLXpmYtohLaDzks7nzx"));
		nameValuePairlist.add(new BasicNameValuePair("client_secret", "DKAhZiLfGK7Z0DrkwOU9z0wdb4sPOTF7"));
		HttpEntity httpEntity = new UrlEncodedFormEntity(nameValuePairlist);

		httpPost.setEntity(httpEntity);

		CloseableHttpResponse response = httpclient.execute(httpPost);
		try {
			HttpEntity entity = response.getEntity();
			InputStream content = entity.getContent();
			byte[] b = new byte[1024];
			int read = content.read(b);
			String str = new String(b);
			System.out.println(read + " ============ " + str);
		} finally {
			response.close();
		}
	}

}
