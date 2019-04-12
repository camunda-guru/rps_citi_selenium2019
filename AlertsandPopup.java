package com.citi.banking;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsandPopup {

	public static void main(String[] args) throws AWTException, InterruptedException {
		// TODO Auto-generated method stub
		//Launching the site.			
		 System.setProperty("webdriver.chrome.driver","E:\\software\\A08\\file\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			 driver.get("file:///G:\\Local disk\\selenium\\apr2019\\demopage.html");	
        
        driver.findElement(By.xpath("//button[contains(text(),'Try it')]")).click();
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // accepting javascript alert
        Alert alert = driver.switchTo().alert();
        alert.accept();

        // clicking on try it button
        driver.findElement(By.xpath("//button[contains(text(),'Try it')]")).click();
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // accepting javascript alert
        driver.switchTo().alert().dismiss();

        // clicking on try it button
        driver.findElement(By.xpath("//button[contains(text(),'Try it')]")).click();
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // accepting javascript alert
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        
        driver.get("https://gmail.com");
        driver.manage().window().maximize();
     // enter a valid email address
        driver.findElement(By.name("identifier")).sendKeys("TestSelenium1607@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/content/span")).click();  
        Thread.sleep(2000);
        // enter a valid password
        driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("TestSelenium");
        
        // click on sign in button
        driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/content/span")).click();
        driver.close();
        //Thread.sleep(30000);

       /* // click on compose button
        driver.findElement(By.xpath("//div[@class='z0']//div[contains(text(),'COMPOSE')]")).click();

        // click on attach files icon
        driver.findElement(By.xpath("//div[contains(@command,'Files')]//div[contains(@class,'aaA')]")).click();

        // creating instance of Robot class (A java based utility)
        Robot rb =new Robot();

        // pressing keys with the help of keyPress and keyRelease events
        rb.keyPress(KeyEvent.VK_D);
        rb.keyRelease(KeyEvent.VK_D);
        Thread.sleep(2000);

        rb.keyPress(KeyEvent.VK_SHIFT);
        rb.keyPress(KeyEvent.VK_SEMICOLON);
        rb.keyRelease(KeyEvent.VK_SEMICOLON);
        rb.keyRelease(KeyEvent.VK_SHIFT);

        rb.keyPress(KeyEvent.VK_BACK_SLASH);
        rb.keyRelease(KeyEvent.VK_BACK_SLASH);
        Thread.sleep(2000);

        rb.keyPress(KeyEvent.VK_P);
        rb.keyRelease(KeyEvent.VK_P);

        rb.keyPress(KeyEvent.VK_I);
        rb.keyRelease(KeyEvent.VK_I);

        rb.keyPress(KeyEvent.VK_C);
        rb.keyRelease(KeyEvent.VK_C);
        Thread.sleep(2000);

        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(2000);*/
        
	}

}
