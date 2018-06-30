package com.ch.demo1;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class Demo2 {

	//实现了登录
	@Test
	public void test2() throws ClientProtocolException, IOException{
		this.post("http://main.test.119xiehui.com/Login/LoginIndex", "loginname=18230416766&loginpwd=12345678");
	}
	//实现了添加日志
	@Test
	public void addlog() throws ClientProtocolException, IOException{
		this.post("http://main.test.119xiehui.com/Base/Dept/AddDept", "DeptName=\"123\"&DeptNameAlias=\"345\"&ParentDeptId=\"1111\"&DeptId=");
	}
	
	public void post(String url,String para) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
//		1、创建httpClient
		httpClient = HttpClients.createDefault();
//2、创建post对象
		HttpPost post = new HttpPost(url);

		post.setHeader("Content-Type", "application/x-www-form-urlencoded");
//	3、设置请求体
		StringEntity paraEntity = new StringEntity(para, "utf-8");
		post.setEntity(paraEntity);

//		4、执行请求，得到响应
		response = httpClient.execute(post);
		
//		5、得到响应的实体
		HttpEntity entity = response.getEntity();
		System.out.println(EntityUtils.toString(entity));

//		6、释放资源
		EntityUtils.consume(entity);
		
//		7、关闭httpClient
		response.close();
		httpClient.close();

	}
	@Test
	public void testLoginSuccess() throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse response = null;
//		1、创建httpClient
		httpClient = HttpClients.createDefault();
//2、创建post对象
		HttpPost post1 = new HttpPost("http://main.test.119xiehui.com/Login/LoginIndex");

		post1.setHeader("Content-Type", "application/x-www-form-urlencoded");
//	3、设置请求体
		StringEntity paraEntity = new StringEntity("loginname=18230416766&loginpwd=12345678", "utf-8");
		post1.setEntity(paraEntity);

//		4、执行请求，得到响应
		response = httpClient.execute(post1);
		
//		5、得到响应的实体
		HttpEntity entity1 = response.getEntity();
		System.out.println(EntityUtils.toString(entity1));
		
		HttpPost post2 = new HttpPost("http://main.test.119xiehui.com/Base/Dept/AddDept");
		post2.setHeader("Content-Type", "application/x-www-form-urlencoded");

		StringEntity paraEntity1 = new StringEntity("DeptName=\"123\"&DeptNameAlias=\"345\"&ParentDeptId=\"1111\"&DeptId=", "utf-8");
		post2.setEntity(paraEntity1);

//		4、执行请求，得到响应
		response = httpClient.execute(post2);
		
//		5、得到响应的实体
		HttpEntity entity2 = response.getEntity();
		System.out.println(EntityUtils.toString(entity2));
		
//		6、释放资源
		EntityUtils.consume(entity2);
		
		
		
		
//		7、关闭httpClient
		response.close();
		httpClient.close();

	}
}
