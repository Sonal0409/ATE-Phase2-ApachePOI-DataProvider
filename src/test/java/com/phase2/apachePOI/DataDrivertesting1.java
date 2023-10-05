package com.phase2.apachePOI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivertesting1 {
	
	
	WebDriver driver;

	@BeforeMethod
	public void setup()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://en.wikipedia.org/w/index.php?title=Special:CreateAccount&returnto=Special%3ASearch&returntoquery=search%3D%26go%3DGo");
	}
	
	
	@Test(dataProvider = "testdata")
	public void createaccountTest(String uname, String pwd, String rpwd, String em) throws InterruptedException
	
	{

    driver.findElement(By.xpath("//*[@id='userlogin2']/descendant::input[2]")).clear();
    driver.findElement(By.xpath("//*[@id='userlogin2']/descendant::input[2]"))
    .sendKeys(uname);
    driver.findElement(By.xpath("//*[@id='userlogin2']/descendant::input[3]")).clear();
    driver.findElement(By.xpath("//*[@id='userlogin2']/descendant::input[3]"))
    .sendKeys(pwd);
    driver.findElement(By.xpath("//*[@id='userlogin2']/descendant::input[4]")).clear();
    driver.findElement(By.xpath("//*[@id='userlogin2']/descendant::input[4]"))
    .sendKeys(rpwd);
    driver.findElement(By.xpath("//*[@id='userlogin2']/descendant::input[5]")).clear();
    driver.findElement(By.xpath("//*[@id='userlogin2']/descendant::input[5]"))
    .sendKeys(em);
    
    Thread.sleep(3000);
	
	}

	
	@DataProvider(name="testdata")
	public Object[][] datasupplier()
	{
		Object[][] data = {{"admin","admin@123","admin@123","email1@gmail.com"},{"admin12","admin@12","admin@12","email12@gmail.com"}};
		return data;
	}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
}
