package com.ch.demo1;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BaseTest {
	CloseableHttpClient httpClient = null;
	CloseableHttpResponse response = null;
	HttpGet get = null;
	HttpPost post = null;
	HttpEntity entity = null;

	@Before
	public void startHttpClient() {
		httpClient = HttpClients.createDefault();
		get = new HttpGet();
		post = new HttpPost();
	}

	@After
	public void teardownHttpClient() throws IOException {
		EntityUtils.consume(entity);
		response.close();
		httpClient.close();
	}

	public void get(String url) throws ClientProtocolException, IOException, URISyntaxException {

		get.setURI(new URI(url));
		response = httpClient.execute(get);
		entity = response.getEntity();
		System.out.println(EntityUtils.toString(entity,"utf-8"));

	}

	public void getByEncode(String url, String paraString)
			throws URISyntaxException, ClientProtocolException, IOException {
		String para = URLEncoder.encode(paraString, "utf-8");
		get.setURI(new URI(url + para));
		response = httpClient.execute(get);
		entity = response.getEntity();
		System.out.println(EntityUtils.toString(entity));

	}


	public String postDemo(String url,String para) throws URISyntaxException, ClientProtocolException, IOException {
		post.setURI(new URI(url));
		post.setHeader("Content-Type", "application/x-www-form-urlencoded");
		// 设置post的请求体body
		StringEntity paraEntity = new StringEntity(para);
		post.setEntity(paraEntity);
		// 执行post请求，得到响应
		response = this.httpClient.execute(post);
		entity = response.getEntity();
		String result=EntityUtils.toString(entity, "utf-8");
		return result;
	}

}
