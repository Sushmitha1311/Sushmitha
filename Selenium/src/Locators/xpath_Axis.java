package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class xpath_Axis {
    public static void main(String[] args) {
        xpathAxis();
    }

    public static void xpathAxis() {
        ChromeDriver chrome = null;
        try {
            chrome = new ChromeDriver();
            chrome.manage().window().maximize();

            //chrome.get("file:///E:/MorningBatch_Combined/HTML/Webpage/SampleWebPage.html");
            chrome.navigate().to("file:///C:/Users/windows%2010/Desktop/Javaclass/Testing/Testingclass/Selenium/src/automation/samplewebpage.html");
            //using xpath enter userName and password
            chrome.findElement(By.xpath("//td[text()='Abdul Kalam']/following-sibling::td[1]")).getText();
            Thread.sleep(2000);

            chrome.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            chrome = null;
        }
    }
}
