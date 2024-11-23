package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readexceldata {
	public static String readparticulardata(String sheetName,int rows,int columns) throws InvalidFormatException, IOException {
		File file = new File("C:\\Users\\Yuvan_New\\Documents\\datadriven1.xlsx");
		Workbook book = new XSSFWorkbook(file);
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rows);// index based numbering
		Cell cell = row.getCell(columns);
		//String value = cell.getStringCellValue();
		//System.out.println(value);
		//Row row1 = sheet.getRow(2);// index based numbering
		//Cell cell1 = row.getCell(2);
		//Double value1 = cell1.getNumericCellValue();
		//System.out.println(value1);
		DataFormatter dataformat = new DataFormatter();
		String data = dataformat.formatCellValue(cell);
		System.out.println(data);// just formats into string
		return data;
	}

	private static void readallcelldata(String sheetName) throws InvalidFormatException, IOException {
		File file = new File("C:\\Users\\Yuvan_New\\Documents\\datadriven1.xlsx");
		Workbook book = new XSSFWorkbook(file);
		Sheet sheet = book.getSheet(sheetName);
		int lastrowno = sheet.getLastRowNum();
		int getallphysicalno = sheet.getPhysicalNumberOfRows();
		short lastcellno = sheet.getRow(0).getLastCellNum();
		System.out.println(lastrowno);
		System.out.println(lastcellno);
		System.out.println(getallphysicalno);
		Row row2 = sheet.getRow(1);// index based numbering
		for (int i = 0; i < lastcellno; i++) {
			Cell cell2 = row2.getCell(i);
			//String data = cell2.getStringCellValue();
			// System.out.println(value);
			DataFormatter dataformat = new DataFormatter();
			String data = dataformat.formatCellValue(cell2);
			System.out.println(data);

		}

	}

	private static void readalldata() throws InvalidFormatException, IOException {
		File file = new File("C:\\Users\\Yuvan_New\\Documents\\datadriven1.xlsx");
		Workbook book = new XSSFWorkbook(file);
		Sheet sheet = book.getSheet("Sheet1");
		int lastrowno = sheet.getLastRowNum();
		short lastcellno = sheet.getRow(0).getLastCellNum();
		System.out.println(lastrowno);
		System.out.println(lastcellno);
		for (int i = 0; i <= lastrowno; i++) {
			Row row3 = sheet.getRow(i);// index based numbering

			for (int j = 0; j <=lastcellno; j++) {
				Cell cell3 = row3.getCell(j);
				// String value=cell2.getStringCellValue();
				// System.out.println(value);
				DataFormatter dataformat = new DataFormatter();
				String data3 = dataformat.formatCellValue(cell3);
				System.out.println(data3);
			}
		}

	}
	private static void writedata() throws IOException {
		File file = new File("C:\\Users\\Yuvan_New\\Documents\\datadriven1.xlsx");
		FileInputStream fis=new FileInputStream(file);
		Workbook book=new XSSFWorkbook(fis);
		book.getSheet("yuvan").createRow(1).createCell(0).setCellValue("yuvan3");
		FileOutputStream fos=new FileOutputStream(file);
		book.write(fos);
		book.close();
		System.out.println("success");
	}

	public static void main(String[] args) throws InvalidFormatException, IOException {
		// readparticulardata();
		//readallcelldata("Sheet1");
		//readalldata();
		writedata();
		

	}

}
