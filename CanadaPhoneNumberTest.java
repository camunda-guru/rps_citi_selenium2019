package com.citi.banking.exercises;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
public class CanadaPhoneNumberTest {
	private static final String FILE_NAME = "E:\\AAPractise\\Input\\Canada411Input.xlsx";
	
	public static List<String> getPhoneNumbers()
	{
		 List<String> phoneNumberList=new ArrayList<String>();
		try {
			FileInputStream fin =new FileInputStream(new File(FILE_NAME));
			Workbook workbook =new XSSFWorkbook(fin);
			Sheet datatypeSheet = workbook.getSheetAt(0);
	        Iterator<Row> iterator = datatypeSheet.iterator();
	        iterator.next();
	       
	        while(iterator.hasNext())
	        {
	           Row row=	iterator.next();
	           Iterator<Cell> cellIterator=row.cellIterator();   
	           
	           while(cellIterator.hasNext())
	           {
	        	   
	        	 Cell currentCell =  cellIterator.next();
	        	 if(currentCell.getCellType()==CellType.STRING)
				 {
					 phoneNumberList.add(currentCell.getStringCellValue());
				 }
	           }
	           
	        }
	        //for(String phoneNumber:phoneNumberList)
	        	//System.out.println(phoneNumber);
	        
	      
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return phoneNumberList;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	   //List<String> phoneList=getPhoneNumbers();
	   //System.out.println(phoneList.get(0));
	   //System.setProperty("webdriver.ie.driver","E:\\software\\A08\\file\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
	   System.setProperty("webdriver.chrome.driver","E:\\software\\A08\\file\\chromedriver_win32\\chromedriver.exe");
	   WebDriver driver=new ChromeDriver();
   	   driver.get("http://www.canada411.ca/");
   	   driver.manage().window().maximize();
   	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   	   WebElement element=null;
   	   
   	   //for(String phoneNumber :getPhoneNumbers())
   	   //{
   		   element=driver.findElement(By.id("c411PeopleReverseWhat"));
   		  element.clear();
   		   element.sendKeys(getPhoneNumbers().get(0));
   		   element =driver.findElement(By.id("c411PeopleReverseFind"));
   		   element.click();
   		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
   		 
   
   		 
   		 element = driver.findElement(By.xpath("//*[@id=\"ypgBody\"]/div[2]/div[1]/div[3]/div/div/div[1]/h1/span"));
   		 if(element!=null)
   		 {
   			 System.out.println(element.getText());
   		 }
   		 
   		 int count=1;
   while(count<4)
   {
   		element = driver.findElement(By.xpath("//*[@id=\"ypgBody\"]/div[2]/div[2]/div/div/div[1]/div[1]/div[2]/div/span["+count+"]"));
   	 if(element!=null)
		 {
			 System.out.println(element.getText());
		 }
   	 count++;
   } 
   		 //element=driver.findElement(By.cssSelector("close newsletter-modal__close"));
   		 //element.click();
   		 
   		  // driver.navigate().to("http://www.canada411.ca/");
   	   //}
   	   driver.close();
	   
   	
	}

}
