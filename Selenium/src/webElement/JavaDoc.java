package webElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaDoc {
    public static void main(String[] args) {
        javaDoc();
    }
    public static void javaDoc(){
        WebDriver oBrowser = null;
        try{
            //1. open the sample independent frame application
            oBrowser = new ChromeDriver();
            oBrowser.manage().window().maximize();
            oBrowser.navigate().to("https://docs.oracle.com/javase/8/docs/api/");
            Thread.sleep(2000);

            //2.Read the main page title and URL.

            System.out.println("Main Page Title: " + oBrowser.getTitle());
            System.out.println("Main Page URL: " + oBrowser.getCurrentUrl());

            //3. using index switch to 'Packages' frame and click on the "java.awt" link
            oBrowser.switchTo().frame(0);
            oBrowser.findElement(By.linkText("java.awt")).click();
            oBrowser.switchTo().defaultContent();

            oBrowser.switchTo().frame("packageFrame");
            oBrowser.findElement(By.linkText("ActiveEvent")).click();
            Thread.sleep(2000);
            oBrowser.switchTo().defaultContent(); // back to main page

            WebElement classFrame = oBrowser.findElement(By.name("classFrame"));
            oBrowser.switchTo().frame(classFrame);

            String header = oBrowser.findElement(By.cssSelector("h2.title")).getText();
            System.out.println("Header: " + header);

            // 10. Go back to main page
            oBrowser.switchTo().defaultContent();
            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 11. Close the main page
            if (oBrowser != null) {
                oBrowser.quit();
            }
        }
    }
}
