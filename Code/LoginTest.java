package com.chuanghui.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTest {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.firefox.bin", "D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");

	System.setProperty("webdriver.gecko.driver", "D://demo//geckodriver.exe");
		
	WebDriver driver = new FirefoxDriver();
	//��ҳ��
	driver.get("http://main.test.119xiehui.com/Login/Index");
	driver.navigate().to("http://main.test.119xiehui.com/Login/Index");
	
	//���������
	driver.navigate().back();
	//�������ǰ
	driver.navigate().forward();
	//�����ˢ��
	driver.navigate().refresh();
	//����Ԫ�أ�������
	driver.findElement(By.id("loginname")).sendKeys("18230416766");
	driver.findElement(By.id("loginpwd")).sendKeys("12345678");
	//����Ԫ�أ������
	driver.findElement(By.xpath("//input[@value='��¼']")).click();
	//������˳����������������
	driver.quit();
   //�رյ�ǰҳ��
	driver.close();
//	Ҳ�����������������
//	FirefoxDriver driver = new FirefoxDriver();
	


	
	}

}
