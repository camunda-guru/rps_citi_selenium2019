package com.citi.banking;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.citi.banking.entities.Customer;

public class ReadData {
	private static final String FILE_NAME = "G:\\Local disk\\selenium\\apr2019\\customerdata.xlsx";
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			FileInputStream fin =new FileInputStream(new File(FILE_NAME));
			Workbook workbook =new XSSFWorkbook(fin);
			Sheet sheet= workbook.getSheetAt(1);
			Iterator<Row> rows=sheet.iterator();
			int count=0;
			while(rows.hasNext())
			{
				count++;
				rows.next();
			}
			System.out.println(count);
			Customer[] customerArray=new Customer[count-1];
			rows=sheet.iterator();
			rows.next();
			int i=0;
			while(rows.hasNext())
			{
			//currentrow
			 Row currentRow=rows.next();
			 customerArray[i]=new Customer();
			 //all the cells
			 Iterator<Cell> cells =  currentRow.cellIterator();	
			 ArrayList list =new ArrayList();
			 while(cells.hasNext())
			 {
				 Cell currentCell=cells.next();
				 if(currentCell.getCellType()==CellType.STRING)
				 {
					 System.out.println(currentCell.getStringCellValue());
					 list.add(currentCell.getStringCellValue());
				 }
				 if(currentCell.getCellType()==CellType.NUMERIC)
				 {
					 if (DateUtil.isCellDateFormatted(currentCell)) {
		                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		                    list.add(dateFormat.format(currentCell.getDateCellValue()));
		                    System.out.print(dateFormat.format(currentCell.getDateCellValue()) + "\t\t");
		                } else {
		                    System.out.print(currentCell.getNumericCellValue() + "\t\t");
		                    list.add(currentCell.getNumericCellValue());
		                }
				 }
			
			 }
			 System.out.println(list);
			 customerArray[i].setFirstName(list.get(0).toString());
			 customerArray[i].setLastName(list.get(1).toString());
			 System.out.println(customerArray[i].getFirstName());
			 i++;
			  
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
