package com.crm.qa.util;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {

    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WEIGHT = 10;
    public static String frameName;

    //public static String TESTDATA_SHEET_PATH = "C:\\Users\\rohit.mehta\\IdeaProjects\\" +
    // "FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCrmTestData.xlsx";



/*


    public static Object[][] getTestData(String sheetName) {
        FileInputStream file = null;
        try {
            file = new FileInputStream(TESTDATA_SHEET_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


 */


    public void switchToFrame() {

        driver.switchTo().frame(frameName);
    }

}
