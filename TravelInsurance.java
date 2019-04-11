package com.citi.banking.exercises;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.citi.banking.models.Traveller;

public class TravelInsurance {
private static final String FILE_NAME = "G:\\Local disk\\selenium\\apr2019\\TravelInsurance.xlsx";
	
	public static List<Traveller> getPhoneNumbers()
	{
		 List<Traveller> travellerList=new ArrayList<Traveller>();
		 Traveller traveller=null;
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
	
	
}
