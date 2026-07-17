package utils;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    private static final String excelPath =
            System.getProperty("user.dir")
            + "/src/test/resources/testdata/testdata.xlsx";

    @DataProvider(name = "LoginData")
    public static Object[][] getLoginData() throws IOException {

        System.out.println("Loading LoginData...");

        return ExcelReader.getExcelData(excelPath, "Sheet1");
    }

    @DataProvider(name = "CheckoutData")
    public static Object[][] getCheckoutData() throws IOException {

        System.out.println("Loading CheckoutData...");

        return ExcelReader.getExcelData(excelPath, "Sheet2");
    }
}