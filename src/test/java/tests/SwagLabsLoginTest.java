package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import utils.ExcelReader;

public class SwagLabsLoginTest extends BaseTest {

    String excelPath = System.getProperty("user.dir") + "/src/test/resources/testdata/testdata.xlsx";
    String sheetName = "Sheet1";

    @DataProvider(name = "LoginData")
    public Object[][] getLoginData() throws IOException {

        int rows = ExcelReader.getRowCount(excelPath, sheetName);

        Object[][] data = new Object[rows][6];

        for (int i = 1; i <= rows; i++) {

            data[i - 1][0] = ExcelReader.getCellData(excelPath, sheetName, i, 0); // Test Case ID
            data[i - 1][1] = ExcelReader.getCellData(excelPath, sheetName, i, 1); // Type
            data[i - 1][2] = ExcelReader.getCellData(excelPath, sheetName, i, 2); // Username
            data[i - 1][3] = ExcelReader.getCellData(excelPath, sheetName, i, 3); // Password
            data[i - 1][4] = ExcelReader.getCellData(excelPath, sheetName, i, 4); // Expected Result
            data[i - 1][4] = ExcelReader.getCellData(excelPath, sheetName, i, 5); // Pass/Fail
        }

        return data;
    }

    @Test(dataProvider = "LoginData")
    public void loginTest(String testCaseID,
                          String type,
                          String username,
                          String password,
                          String expectedResult,
                          String passfail) {

        System.out.println("========================================");
        System.out.println("Executing Test Case : " + testCaseID);
        System.out.println("Scenario            : " + type);

        // Login
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        // Validation
        if (expectedResult.equalsIgnoreCase("Products")) {

            String actualResult = shoppingPage.getProductsTitle();
            Assert.assertEquals(actualResult, expectedResult);

        } else {

            String actualResult = loginPage.getErrorMessage();
            Assert.assertEquals(actualResult, expectedResult);

        }

        System.out.println(testCaseID + " Passed");
    }

}