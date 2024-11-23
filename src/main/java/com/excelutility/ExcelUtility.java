package com.excelutility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

    static FileInputStream fis;
    static Workbook wb;

    public static String getCellValue(String sheetName, String id, String colName) {

        File f = new File(".\\Excel\\Excel.xlsx");
        String val = "";
        try {
            fis = new FileInputStream(f);
            wb = new XSSFWorkbook(fis);

            int col_Num = -1;
            Sheet sheet = wb.getSheet(sheetName);
            Row row = sheet.getRow(0);

            for (int i = 0; i < row.getLastCellNum(); i++) {
                if (row.getCell(i).getStringCellValue().trim().equalsIgnoreCase(colName.trim())) {
                    col_Num = i;
                    break;
                }
            }

            if (col_Num == -1) {
                throw new Exception("Column not found: " + colName);
            }

            DataFormatter dataFormatter = new DataFormatter();

            int numberOfRows = sheet.getPhysicalNumberOfRows();
            for (int i = 1; i < numberOfRows; i++) {
                Row currentRow = sheet.getRow(i);
                if (currentRow != null && currentRow.getCell(0).getStringCellValue().equals(id)) {
                    Cell cell = currentRow.getCell(col_Num);
                    val = dataFormatter.formatCellValue(cell);  
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        return val;
    }
}
