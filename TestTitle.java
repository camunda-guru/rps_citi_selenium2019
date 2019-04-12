package com.citi.banking.testingdemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestTitle {
	
	private WebDriver driver;
	private final String baseUrl="https://www.travelsupermarket.com/travel-insurance/enquiry/";
	@BeforeClass
	public void testSetUp()
	{
		System.setProperty("webdriver.chrome.driver","E:\\software\\A08\\file\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);		
	}
	
	//match expected title with actual title
	@Test
	public void testTitleMatching()
	{
		String expected="Travel Insurance Search";
		String actual = driver.getTitle();
		Assert.assertEquals(actual, expected);
		
	}
	
	//test case
	@Test(dataProvider="userdata")
	public void testLogin(User user)
	{
		
		driver.get("http://www.newtours.demoaut.com/");
		driver.findElement(By.name("userName")).sendKeys(user.getUserName());
		driver.findElement(By.name("password")).sendKeys(user.getPassword());
		driver.findElement(By.name("login")).click();
	    Assert.assertNotEquals(0, driver.findElements(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/img")).size());
		
	}
	
	
	
	
	
	//Data Provider
	@DataProvider(name="userdata")
	public Iterator<User> getData()
	{
		return getUserData();
	}
	

	//user Data
	
	public Iterator<User> getUserData()
	{
		List<User> users=new ArrayList<User>();
		User user=null;
		for(int i=0;i<10;i++)
		{
		user=new User();
		user.setUserName("user"+new Random().nextInt(100));
		user.setPassword("test@123");
		users.add(user);
		}
		
		return users.iterator();
		
	}
	
	
	
	
	
  
}
