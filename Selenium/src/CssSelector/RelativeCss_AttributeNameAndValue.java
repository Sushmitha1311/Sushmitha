package CssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class RelativeCss_AttributeNameAndValue {
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
            //chrome.findElement(By.cssSelector("input[id='frm1_un_id']\n")).sendKeys("aaaaaaaaa");
            chrome.findElement(By.cssSelector("input[id='frm1_un_id'][type='text'")).sendKeys("aaaaaaaaa");//More Than One Attribute Name And Value
            Thread.sleep(2000);

            chrome.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            chrome = null;
        }
    }
}
