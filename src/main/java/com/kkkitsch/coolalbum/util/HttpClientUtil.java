package com.kkkitsch.coolalbum.util;

import java.io.InputStream;
import java.net.URI;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpClientUtil {

	public static String invoke(Map<String, Integer> urlConfig) throws Exception {
		// 客户端对象
		CloseableHttpClient httpclient = HttpClients.createDefault();
		// 创建请求uri
		// 历史上的今天接口：http://api.avatardata.cn/HistoryToday/LookUp?key=938b6f475f67483fa0b6d434a0deade5&yue=1&ri=1&type=1&page=1&rows=5
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

}
