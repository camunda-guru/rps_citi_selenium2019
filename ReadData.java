package com.citi.banking;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadData {
	private static final String FILE_NAME = "G:\\Local disk\\selenium\\apr2019\\customerdata.xlsx";
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			FileInputStream fin =new FileInputStream(new File(FILE_NAME));
			Workbook workbook =new XSSFWorkbook(fin);
			Sheet sheet= workbook.getSheetAt(0);
			Iterator<Row> rows=sheet.iterator();
			rows.next();
			while(rows.hasNext())
			{
			//currentrow
			 Row currentRow=rows.next();
			 //all the cells
			 Iterator<Cell> cells =  currentRow.cellIterator();			 
			 while(cells.hasNext())
			 {
				 Cell currentCell=cells.next();
				 if(currentCell.getCellType()==CellType.STRING)
					 System.out.println(currentCell.getStringCellValue());
				 if(currentCell.getCellType()==CellType.NUMERIC)
				 {
					 if (DateUtil.isCellDateFormatted(currentCell)) {
		                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		                    System.out.print(dateFormat.format(currentCell.getDateCellValue()) + "\t\t");
		                } else {
		                    System.out.print(currentCell.getNumericCellValue() + "\t\t");
		                }
				 }
				 
			 }
			 
			  
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
