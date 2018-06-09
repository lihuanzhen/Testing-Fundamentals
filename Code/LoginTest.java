package com.chuanghui.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTest {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.firefox.bin", "D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");

	System.setProperty("webdriver.gecko.driver", "D://demo//geckodriver.exe");
		
	WebDriver driver = new FirefoxDriver();
	//打开页面
	driver.get("http://main.test.119xiehui.com/Login/Index");
	driver.navigate().to("http://main.test.119xiehui.com/Login/Index");
	
	//浏览器回退
	driver.navigate().back();
	//浏览器向前
	driver.navigate().forward();
	//浏览器刷新
	driver.navigate().refresh();
	//查找元素，并输入
	driver.findElement(By.id("loginname")).sendKeys("18230416766");
	driver.findElement(By.id("loginpwd")).sendKeys("12345678");
	//查找元素，并点击
	driver.findElement(By.xpath("//input[@value='登录']")).click();
	//浏览器退出，结束浏览器进程
	driver.quit();
   //关闭当前页面
	driver.close();
//	也可以这样创建浏览器
//	FirefoxDriver driver = new FirefoxDriver();
	


	
	}

}
