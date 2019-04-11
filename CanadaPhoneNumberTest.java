package com.citi.banking.exercises;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class CanadaPhoneNumberTest {
	private static final String FILE_NAME = "E:\\AAPractise\\Input\\Canada411Input.xlsx";
	
	public List<String> getPhoneNumbers()
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

		
		
		
		
	}

}
