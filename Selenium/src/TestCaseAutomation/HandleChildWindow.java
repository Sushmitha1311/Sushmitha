package TestCaseAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class HandleChildWindow {
    public static void main(String[] args) {
        handleChildWindow();
    }
    public static void handleChildWindow(){
        WebDriver oBrowser = null;
        String sParent = null;
        Set<String> oChild = null;
        try{
            oBrowser = new ChromeDriver();
            oBrowser.manage().window().maximize();

            oBrowser.navigate().to("file:///C:/Users/windows%2010/Desktop/Javaclass/Testing/Testingclass/Selenium/src/automation%20and%20Html/Creatinglink.html");
            Thread.sleep(2000);
            sParent = oBrowser.getWindowHandle();
            System.out.println("Parent Window ID: "+sParent);

            oBrowser.findElement(By.linkText("ActiTime")).click();
            Thread.sleep(2000);

            oChild = oBrowser.getWindowHandles();
            for(String childWnd : oChild){
                if (!childWnd.equals(sParent)) {
                    oBrowser.switchTo().window(childWnd);
                    System.out.println(oBrowser.getTitle());
                    System.out.println(oBrowser.getCurrentUrl());

                    oBrowser.findElement(By.id("username")).sendKeys("aaaaaaaaaaaaaa");
                    Thread.sleep(2000);
                    oBrowser.close();
                    break;
                }
            }

            oBrowser.switchTo().window(sParent);

            Thread.sleep(2000);
            oBrowser.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            oBrowser = null;
        }
    }
}
