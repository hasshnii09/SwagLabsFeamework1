package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

    public static Object[][] getExcelData(String filePath, String sheetName) throws IOException {

        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fis);

        Sheet sheet = workbook.getSheet(sheetName);

        DataFormatter formatter = new DataFormatter();

        int lastRow = sheet.getLastRowNum();
        int lastCol = sheet.getRow(0).getLastCellNum();

        int actualRows = 0;

        // Count only rows having data in first column
        for (int i = 1; i <= lastRow; i++) {

            Row row = sheet.getRow(i);

            if (row != null) {

                Cell cell = row.getCell(0);

                if (cell != null &&
                        !formatter.formatCellValue(cell).trim().isEmpty()) {

                    actualRows++;
                }
            }
        }

        Object[][] data = new Object[actualRows][lastCol];

        int dataRow = 0;

        for (int i = 1; i <= lastRow; i++) {

            Row row = sheet.getRow(i);

            if (row == null)
                continue;

            Cell firstCell = row.getCell(0);

            if (firstCell == null ||
                    formatter.formatCellValue(firstCell).trim().isEmpty())
                continue;

            for (int j = 0; j < lastCol; j++) {

                Cell cell = row.getCell(j);

                if (cell == null)
                    data[dataRow][j] = "";
                else
                    data[dataRow][j] = formatter.formatCellValue(cell);

            }

            dataRow++;
        }

        workbook.close();
        fis.close();

        return data;
    }
}