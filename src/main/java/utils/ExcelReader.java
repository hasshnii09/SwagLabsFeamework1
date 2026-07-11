package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

    public static String getCellData(String filePath, String sheetName, int rowNum, int colNum) throws IOException {

        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fis);

        Sheet sheet = workbook.getSheet(sheetName);
        Row row = sheet.getRow(rowNum);
        Cell cell = row.getCell(colNum);

        DataFormatter formatter = new DataFormatter();
        String cellValue = formatter.formatCellValue(cell);

        workbook.close();
        fis.close();

        return cellValue;
    }

    // Get Total Number of Rows
    public static int getRowCount(String filePath, String sheetName) throws IOException {

        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fis);

        Sheet sheet = workbook.getSheet(sheetName);
        int rowCount = sheet.getLastRowNum();

        workbook.close();
        fis.close();

        return rowCount;
    }

    // Get Complete Row Data
    public static String[] getRowData(String filePath, String sheetName, int rowNum) throws IOException {

        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fis);

        Sheet sheet = workbook.getSheet(sheetName);
        Row row = sheet.getRow(rowNum);

        int cellCount = row.getLastCellNum();

        String[] data = new String[cellCount];

        DataFormatter formatter = new DataFormatter();

        for (int i = 0; i < cellCount; i++) {
            data[i] = formatter.formatCellValue(row.getCell(i));
        }

        workbook.close();
        fis.close();

        return data;
    }
}