package com.citi.banking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String baseUrl = "https://www.mapsofindia.com/education/exam/tamil-nadu-board-hsc-time-table.html";
		System.setProperty("webdriver.chrome.driver","E:\\software\\A08\\file\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get(baseUrl);
		String innerText = driver.findElement(By
			.xpath("//table[1]/tbody/tr[4]/td[3]"))
			.getText(); 		
		System.out.println(innerText); 
		driver.quit();
	}
	
}
