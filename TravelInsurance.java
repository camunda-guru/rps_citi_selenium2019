package com.citi.banking.exercises;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.citi.banking.models.Traveller;

public class TravelInsurance {
private static final String FILE_NAME = "G:\\Local disk\\selenium\\apr2019\\TravelInsurance.xlsx";
	
	public static List<Traveller> getTravllers()
	{
		 List<Traveller> travellerList=new ArrayList<Traveller>();
		 Traveller traveller=null;
		try {
			FileInputStream fin =new FileInputStream(new File(FILE_NAME));
			Workbook workbook =new XSSFWorkbook(fin);
			Sheet datatypeSheet = workbook.getSheetAt(0);
	        Iterator<Row> iterator = datatypeSheet.iterator();
	        //iterator.next();
	         
	        while(iterator.hasNext())
	        {
	           Row row=	iterator.next();
	           Iterator<Cell> cellIterator=row.cellIterator();   
	           traveller=new Traveller();
	           while(cellIterator.hasNext())
	           {
	        	   
	        	 Cell currentCell =  cellIterator.next();
	        	 if(currentCell.getCellType()==CellType.STRING)
				 {
					traveller.setEmail(currentCell.getStringCellValue());
				 }
	        	 
	        	 if(currentCell.getCellType()==CellType.NUMERIC)
				 {
					 if (DateUtil.isCellDateFormatted(currentCell)) {
		                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");	                    
		                   	                    		
		                    traveller.setDob(currentCell.getDateCellValue());
		                    //System.out.print(dateFormat.format(currentCell.getDateCellValue()) + "\t\t");
		                } 
				 }
	        	 
	           }
	           travellerList.add(traveller);
	           
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
		  return travellerList;
	}
	
	
	public static void main(String[] args)
	{
		for(Traveller traveller : getTravllers())
		{
			System.out.println(traveller.getDob().toString());
			System.out.println(traveller.getEmail());
		}
		 System.setProperty("webdriver.chrome.driver","E:\\software\\A08\\file\\chromedriver_win32\\chromedriver.exe");
		   WebDriver driver=new ChromeDriver();
		   JavascriptExecutor js = (JavascriptExecutor) driver;
		   driver.get("https://www.travelsupermarket.com/travel-insurance/enquiry/");
		   driver.manage().window().maximize();
	   	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		   WebElement element=driver.findElement(By.id("policytype_100label"));
		   element.click();
		   int count=1;
		   while(count<4)
		   {
		   element=driver.findElement(By.xpath("//*[@id=\"Quote_Country_Wrap\"]/div["+count+"]/label"));
		   element.click();
		   js.executeScript("window.scrollBy(0,1000)");
		   count=count+2;
		   }
		   element=driver.findElement(By.xpath("//*[@id=\"startDate_1daysTime_Label\"]"));
		   element.click();
		   element=driver.findElement(By.xpath("//*[@id=\"endDate_10daysTime_Label\"]"));
		   element.click();
		 
		   //policy features
		   Select feature = new Select(driver.findElement(By.id("Quote.Value.OptionType.101")));
			feature.selectByVisibleText("At least £1,000");
		   //gadget covers
			  js.executeScript("window.scrollBy(0,1000)");
			 element=driver.findElement(By.xpath("//*[@id=\"qs_extras\"]/div[2]/ul/li[1]/label"));
			   element.click();
			   element=driver.findElement(By.xpath("//*[@id=\"qs_extras\"]/div[2]/ul/li[2]/label"));
			   element.click();
			 
			   //count++;
		
		
			element=driver.findElement(By.xpath("//*[@id=\"grouptype_100label\"]"));
			   element.click();		
			//dob   
			element=driver.findElement(By.id("qs_dob_t1_Day"));   			   
			element.sendKeys(String.valueOf(getTravllers().get(0).getDob().getDay()));	
			element=driver.findElement(By.id("qs_dob_t1_Month"));   			   
			element.sendKeys(String.valueOf(getTravllers().get(0).getDob().getMonth()));	
			element=driver.findElement(By.id("qs_dob_t1_Year"));   			   
			element.sendKeys(String.valueOf(getTravllers().get(0).getDob().getYear()));	
			js.executeScript("window.scrollBy(0,1000)");
			//medical condition
			element=driver.findElement(By.xpath("//*[@id=\"preex_no_label\"]"));
			element.click();
			//email
			element=driver.findElement(By.id("EmailAddress")); 
			element.sendKeys(getTravllers().get(0).getEmail());
			js.executeScript("window.scrollBy(0,1000)");
			element=driver.findElement(By.id("ConfirmEmail")); 
			element.sendKeys(getTravllers().get(0).getEmail());
			element=driver.findElement(By.xpath("//*[@id=\"yourcontactperferenceemailupdatelabel\"]"));
			element.click();
			//consent
			element=driver.findElement(By.xpath("//*[@id=\"qs_confirm\"]/div/div/label"));
			element.click();
			//proceed
			element=driver.findElement(By.id("getQuotes"));
			element.click();
			
	}
	
	
	
}
