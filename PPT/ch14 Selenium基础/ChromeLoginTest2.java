package com.chuanghui.demo;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ChromeLoginTest2 {

	public static void main(String[] args) throws InterruptedException, AWTException {

		System.setProperty("webdriver.chrome.driver", "D://demo//chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.get("http://main.test.119xiehui.com/Login/Index");
		// 登录239  14W  225
		driver.findElement(By.id("loginname")).sendKeys("18230416766");
		driver.findElement(By.id("loginpwd")).sendKeys("12345678");
		driver.findElement(By.xpath("//input[@value='登录']")).click();
		Thread.sleep(2000);
		//点击基础数据
		driver.findElement(By.xpath("//p[contains(.,'基础数据')]")).click();
		Thread.sleep(2000);
		//点击人员信息
		driver.findElement(By.xpath("//p[contains(.,'人员信息')]")).click();
		Thread.sleep(8000);
		driver.switchTo().frame(0);
		//点击添加按钮
		driver.findElement(By.xpath("//div[@id='pagingdiv']/div[1]/div[1]")).click();
		Thread.sleep(5000);
		// 输入姓名
		// driver.findElement(By.className("textName")).sendKeys("张三");
		// 选择性别
		// driver.findElement(By.xpath("//div[contains(text(),'请选择性别(必填)')]")).click();
		// Thread.sleep(2000);
		// driver.findElement(By.xpath("//li[@data-value='1']")).click();
		// 选择日期
		// driver.findElement(By.id("Enlisttime")).sendKeys("2015-05-05");
//		选择政治面貌
		// driver.findElement(By.xpath("//div[contains(text(),'请选择政治面貌(必填)')]")).click();
		// Thread.sleep(2000);
		// driver.findElement(By.xpath("//li[@data-value='19606']")).click();
//		选择学历
		// driver.findElement(By.xpath("//div[contains(text(),'请选择学历(必填)')]")).click();
		// Thread.sleep(2000);
		// driver.findElement(By.xpath("//li[@data-value='31298']")).click();
//	联系电话
		// driver.findElement(By.className("textContactnumber")).sendKeys("13910198899");
//		入党时间
		// driver.findElement(By.id("textJoinparty")).sendKeys("2014-05");
//		JavascriptExecutor移动光标位置
		// JavascriptExecutor jse=(JavascriptExecutor)driver;
		// jse.executeScript("window.scrollBy(0,1000)");
		// jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		// driver.findElement(By.className("textWeight")).sendKeys(Keys.DOWN);
		// Thread.sleep(2000);

		Actions action = new Actions(driver);
//键盘向下键
		action.sendKeys(Keys.DOWN).build().perform();
		action.sendKeys(Keys.DOWN).build().perform();
		Thread.sleep(2000);
//		*******************************
		//进行选择部门的操作
		driver.findElement(By.xpath("//div[contains(text(),'请选择部门(必填)')]")).click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//ul[@class='department-list']/li[2]/div/div[1]/span"));
		System.out.println(element.isDisplayed());
		System.out.println(element.isEnabled());
		//当直接click没有响应，可以用js执行器来click
		jse.executeScript("arguments[0].click();", element);

		//按住左键向右移动600，向下移动200，释放左键
		action.clickAndHold().moveByOffset(600, 200).release().perform();
		Thread.sleep(2000);
		//点击键盘上的向下箭头
		action.sendKeys(Keys.DOWN).build().perform();
		Thread.sleep(2000);
		action.sendKeys(Keys.DOWN).build().perform();
		Thread.sleep(2000);
		action.sendKeys(Keys.DOWN).build().perform();
		Thread.sleep(2000);
		//点击确定按钮
		driver.findElement(By.xpath("//div[@title='选择部门']/div/div[3]/input[1]")).click();
//		*******************************
		//点击人员添加页面的“确定”按钮
		action.click();
		action.sendKeys(Keys.DOWN).build().perform();
		Thread.sleep(2000);
		action.sendKeys(Keys.DOWN).build().perform();
		Thread.sleep(2000);
		action.sendKeys(Keys.DOWN).build().perform();
		Thread.sleep(2000);
		action.sendKeys(Keys.DOWN).build().perform();
		Thread.sleep(2000);
		action.sendKeys(Keys.DOWN).build().perform();
		Thread.sleep(2000);
		action.sendKeys(Keys.DOWN).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='确定']")).click();
		// /浏览器退出，结束浏览器进程
		// driver.quit();
		// //关闭当前页面
		// driver.close();
	}

}
