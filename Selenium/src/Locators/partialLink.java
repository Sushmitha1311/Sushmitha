package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class partialLink
{
    public static void main(String[] args){
    partialLinkTextLocator();
}
public static void partialLinkTextLocator() {
    ChromeDriver chrome = null;
    try {
        chrome = new ChromeDriver();
        chrome.manage().window().maximize();

        //chrome.get("file:///E:/MorningBatch_Combined/HTML/Webpage/SampleWebPage.html");
        chrome.navigate().to("file:///C:/Users/windows%2010/Desktop/Javaclass/Testing/Testingclass/Selenium/src/automation/NestedFrames/main.html");

        //using linkText enter userName and password
        chrome.findElement(By.partialLinkText("gle In")).click();
        Thread.sleep(2000);

        //Click on back navigation
        chrome.navigate().back();

        chrome.findElement(By.partialLinkText("Facebook")).click();
        Thread.sleep(2000);

        //Click on back navigation
        chrome.navigate().back();


        chrome.close();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        chrome = null;
    }
}
}
