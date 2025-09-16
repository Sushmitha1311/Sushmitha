package validation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.util.List;

public class WebTableToExcel_Validation {
    public static void main(String[] args) {
        webTableToExcel();
    }

    public static void webTableToExcel() {
        WebDriver oBrowser = null;
        Workbook wb = null;
        Sheet sh = null;
        Row row = null;
        Cell cell = null;
        List<WebElement> oRows = null;
        List<WebElement> oColumns = null;
        WebElement oEle = null;
        FileOutputStream fout = null;

        try {
            oBrowser = new ChromeDriver();
            oBrowser.manage().window().maximize();
            oBrowser.navigate().to("file:///C:/Users/windows%2010/SeleniumProj/Eclipse-workspace/Selenium/src/automationAndHtml/samplewebpage.html");
            Thread.sleep(2000);

            // Create new excel workbook
            wb = new XSSFWorkbook();
            sh = wb.createSheet("STUDENT");

            // Find rows
            oRows = oBrowser.findElements(By.xpath("//table[@id='table1']//tr"));
            for (int r = 0; r < oRows.size(); r++) {
                row = sh.createRow(r);

                // Find columns in each row
                oColumns = oBrowser.findElements(By.xpath("//table[@id='table1']//tr[" + (r + 1) + "]/*"));
                for (int c = 0; c < oColumns.size(); c++) {
                    cell = row.createCell(c);
                    oEle = oBrowser.findElement(By.xpath("//table[@id='table1']//tr[" + (r + 1) + "]/*[" + (c + 1) + "]"));
                    cell.setCellValue(oEle.getText());
                }
            }

            fout = new FileOutputStream("C:\\Users\\windows 10\\SeleniumProj\\Eclipse-workspace\\StudentDetails.xlsx");
            wb.write(fout);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fout != null) {
                    fout.flush();
                    fout.close();
                }
                if (wb != null) {
                    wb.close();
                }
                if (oBrowser != null) {
                    oBrowser.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
