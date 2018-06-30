package com.ch.demo1;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
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

public class GetDemo {
	CloseableHttpClient httpClient=null;
	CloseableHttpResponse response=null;
	HttpGet get =null;
	HttpPost post =null;
	HttpEntity entity=null;
	
	@Before
	public void startHttpClient(){
		httpClient = HttpClients.createDefault();
		 get = new HttpGet();
		 post = new HttpPost();
	}
	@After 
	public void teardownHttpClient() throws IOException{
		EntityUtils.consume(entity);
		response.close();
		httpClient.close();
	}
	@Test
	public void getDemo1() throws ClientProtocolException, IOException, URISyntaxException{
		
		URI u= new URI
				("http://127.0.0.1:8080/Supermarket/analysis/lookupprice?goodsCode=");
		get.setURI(u);
		response=httpClient.execute(get);
		System.out.println(response.getStatusLine());
		entity=response.getEntity();
		System.out.println(EntityUtils.toString(entity));
		
		
	}
	
	@Test
	public void getDemo2() throws URISyntaxException, ClientProtocolException, IOException{
		String para=URLEncoder.encode("{\"pId\":\"123457\"}","utf-8");
		URI u= new URI
				("http://127.0.0.1:8080/Supermarket/analysis/lookupprice?goodsCode="+para);
		get.setURI(u);
		response=httpClient.execute(get);
		System.out.println(response.getStatusLine());
		entity=response.getEntity();
		System.out.println(EntityUtils.toString(entity));
		
		
	}
	
	@Test
	public void postDemo() throws URISyntaxException, ClientProtocolException, IOException{
		URI uri= new URI("http://127.0.0.1:8080/Supermarket/analysis/palceoreder");
		//设置访问的URI
		post.setURI(uri);
		
		post.setHeader("Content-Type","application/x-www-form-urlencoded");
		//设置post的请求体body
		StringEntity paraEntity = new StringEntity("checkout={\"total\":\"2\",\"record\":[{\"pNum\":1,\"pId\":\"123456\"},{\"pNum\":1,\"pId\":\"123457\"}],\"oSum\":11}");
		post.setEntity(paraEntity);
		//执行post请求，得到响应
		response=this.httpClient.execute(post);
		 entity=response.getEntity();
		System.out.println(EntityUtils.toString(entity,"utf-8"));
		
	}

}
