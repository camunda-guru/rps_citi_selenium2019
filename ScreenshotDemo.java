package com.citi.banking;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ScreenshotDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.ie.driver","E:\\software\\A08\\file\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
		WebDriver webDriver=new InternetExplorerDriver();
		webDriver.manage().window().maximize();
		String baseUrl="http://newtours.demoaut.com/";
		webDriver.get(baseUrl);	
		TakesScreenshot takeScreenshot = (TakesScreenshot) webDriver;

		File file = takeScreenshot.getScreenshotAs(OutputType.FILE);

		FileInputStream fis=null;
		FileOutputStream fos=null; 
		try {
			fis = new FileInputStream(file);
			fos = new FileOutputStream(new File("./file12042019.jpg"));

			int cursor;
			while((cursor=fis.read())!=-1) {
				fos.write(cursor);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
		
		fos.close();
		fis.close();
		}
		webDriver.close();
	
	}

}
