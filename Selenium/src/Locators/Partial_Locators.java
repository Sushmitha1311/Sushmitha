package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Partial_Locators {

public static void main(String[] args) {
    partialMatches();
}

public static void partialMatches() {
    ChromeDriver chrome = null;
    try {
        chrome = new ChromeDriver();
        chrome.manage().window().maximize();

        //chrome.get("file:///E:/MorningBatch_Combined/HTML/Webpage/SampleWebPage.html");
        chrome.navigate().to("file:///C:/Users/windows%2010/Desktop/Javaclass/Testing/Testingclass/Selenium/src/automation/form.html");
        //using xpath enter userName and password
        chrome.findElement(By.xpath("//input[ends-with(@id,'frm1_un_i')]")).sendKeys("aaaaaaaaaaa"); //ends with doesn't work only starts with works
        Thread.sleep(2000);

        chrome.close();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        chrome = null;
    }
}
}