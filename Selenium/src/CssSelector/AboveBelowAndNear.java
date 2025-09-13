package CssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class AboveBelowAndNear {
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
            //above
            //chrome.findElement(RelativeLocator.with(By.tagName("input")).above(By.xpath("//input[@id='frm1_ok_id']"))).sendKeys("aaaaaaaaa");
            //below
            //chrome.findElement(RelativeLocator.with(By.xpath("//input[1]")).below(By.xpath("//pre/b[contains(text(), 'Four')]"))).sendKeys("aaaaaaaaa");
            //near
            chrome.findElement(RelativeLocator.
                    with(By.xpath("//input[1]")).
                    near(By.xpath("//pre/b[contains(text(), 'Four')]"))).sendKeys("aaaaaaaaa");
            Thread.sleep(2000);

            chrome.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            chrome = null;
        }
    }
}
