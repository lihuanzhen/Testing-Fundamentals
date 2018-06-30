package com.ch.demo1;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.client.ClientProtocolException;
import org.junit.Assert;
import org.junit.Test;


public class MiniBlogLoginTest extends BaseTest {
	
	@Test
	public void baidu() throws ClientProtocolException, IOException, URISyntaxException{
		this.get("http://main.test.119xiehui.com/Login/Index");
	}
	
	@Test
	public void miniLoginSuccess() throws ClientProtocolException, URISyntaxException, IOException{
		String result=this.postDemo("http://study-miniblog-new.qa.netease.com/ajax/user/login", 
				"username=lihuanzhen&password=123456");
		Assert.assertTrue(result.contains("200"));
	}

}
