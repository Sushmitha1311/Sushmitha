package CssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChildConcept {
    public static void main(String[] args) {
        xpathLocator();
    }

    public static void xpathLocator() {
        ChromeDriver chrome = null;
        try {
            chrome = new ChromeDriver();
            chrome.manage().window().maximize();

            //chrome.get("file:///E:/MorningBatch_Combined/HTML/Webpage/SampleWebPage.html");
            chrome.navigate().to("file:///C:/Users/windows%2010/Desktop/Javaclass/Testing/Testingclass/Selenium/src/automation/form.html");

            //using cssSelector enter userName and password
            //first Child
            //chrome.findElement(By.cssSelector("form[id='frm1']>:first-child")).sendKeys("aaaaaaaaa");
            //Last child
            //chrome.findElement(By.cssSelector("form[id='frm1']>:last-child")).sendKeys("aaaaaaaaa");
            //nth child
            chrome.findElement(By.cssSelector("form[id='frm1']>:nth-child(5)")).sendKeys("aaaaaaaaa");
            Thread.sleep(2000);

            chrome.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            chrome = null;
        }
    }
}

