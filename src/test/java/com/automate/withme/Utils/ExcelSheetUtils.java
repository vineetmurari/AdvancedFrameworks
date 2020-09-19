package com.automate.withme.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelSheetUtils {
   private static final String FILE_NAME = "src\\test\\resources\\TestData.xlsx";
	   
	   @SuppressWarnings("deprecation")
	public static List<String> Read(){
		   List<String> res = new ArrayList<String>();
	        try {

	            FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
	            Workbook workbook = new XSSFWorkbook(excelFile);
	            Sheet datatypeSheet = workbook.getSheetAt(0);
	            Iterator<Row> iterator = datatypeSheet.iterator();

	            while (iterator.hasNext()) {

	                Row currentRow = iterator.next();
	                Iterator<Cell> cellIterator = currentRow.iterator();

	                while (cellIterator.hasNext()) {

	                    Cell currentCell = cellIterator.next();
	                    //getCellTypeEnum shown as deprecated for version 3.15
	                    //getCellTypeEnum ill be renamed to getCellType starting from version 4.0
	                    if (currentCell.getCellTypeEnum() == CellType.STRING) {
	                       // System.out.print(currentCell.getStringCellValue() + "   ");
	                    	
	                    	res.add(currentCell.getStringCellValue());
	                    } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
	                       // System.out.print(currentCell.getNumericCellValue() + "   ");
	                    	res.add(currentCell.getStringCellValue());
	                    }

	                }
	                System.out.println();

	            }
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return res;
	   }
	   
	   
	   public static void Write(){
		   XSSFWorkbook workbook = new XSSFWorkbook();
	        XSSFSheet sheet = workbook.createSheet("Datatypes in Java");
	        Object[][] datatypes = {
	                {"Datatype", "Type", "Size(in bytes)"},
	                {"int", "Primitive", 2},
	                {"float", "Primitive", 4},
	                {"double", "Primitive", 8},
	                {"char", "Primitive", 1},
	                {"String", "Non-Primitive", "No fixed size"}
	        };

	        int rowNum = 0;
	        System.out.println("Creating excel");

	        for (Object[] datatype : datatypes) {
	            Row row = sheet.createRow(rowNum++);
	            int colNum = 0;
	            for (Object field : datatype) {
	                Cell cell = row.createCell(colNum++);
	                if (field instanceof String) {
	                    cell.setCellValue((String) field);
	                } else if (field instanceof Integer) {
	                    cell.setCellValue((Integer) field);
	                }
	            }
	        }

	        try {
	            FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
	            workbook.write(outputStream);
	            workbook.close();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        System.out.println("Done");
	    }
	   
	   
	   public static void read_and_write(){
		   try {

	            FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
	            Workbook workbook = new XSSFWorkbook(excelFile);
	            Sheet datatypeSheet = workbook.getSheetAt(0);
	            Iterator<Row> iterator = datatypeSheet.iterator();

	            while (iterator.hasNext()) {

	                Row currentRow = iterator.next();
	                Iterator<Cell> cellIterator = currentRow.iterator();

	                while (cellIterator.hasNext()) {

	                    Cell currentCell = cellIterator.next();
	                    if (currentCell.getCellTypeEnum() == CellType.STRING ) {
	                    	if(currentCell.getStringCellValue().equals(new String("Y"))){
	                        currentCell.setCellValue("N");
	                        try {
	    	    	            FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
	    	    	            workbook.write(outputStream);
	    	    	            workbook.close();
	    	    	        } catch (FileNotFoundException e) {
	    	    	            e.printStackTrace();
	    	    	        } catch (IOException e) {
	    	    	            e.printStackTrace();
	    	    	        }
	                    	}
	                    	else{
	                    		System.out.print(currentCell.getStringCellValue() + "   ");
	                    	}
	                        
	                    } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
	                        System.out.print(currentCell.getNumericCellValue() + "   ");
	                    }

	                }
	                System.out.println();
	               
	            }
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	   }
}
