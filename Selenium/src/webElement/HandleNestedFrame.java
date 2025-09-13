package webElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HandleNestedFrame {
    public static void main(String[] args) {
        handleNestedFrameTestcase1();
    }
    public static void handleNestedFrameTestcase1(){
        WebDriver oBrowser = null;
        try{
            //1. open the sample nested frame application
            oBrowser = new ChromeDriver();
            oBrowser.manage().window().maximize();
            oBrowser.navigate().to("file:///C:/Users/windows%2010/Desktop/Javaclass/Testing/Testingclass/Selenium/src/automationAndHtml/NestedFrames/main.html");
            Thread.sleep(2000);


            //2. Read the main page header.
            System.out.println(oBrowser.findElement(By.tagName("h1")).getText());


            //3. using index switch to Page1 frame (parent frame) and select all the checkboxes
            oBrowser.switchTo().frame(0);
            List<WebElement> chkBoxes = oBrowser.findElements(By.xpath("//input[@type='checkbox']"));
            for(int i=0; i<chkBoxes.size(); i++){
                chkBoxes.get(i).click();
            }
            Thread.sleep(2000);


            //4. using name/id attribute switch to Page2 frame (Child frame)
            //5. Enter username and password.
            oBrowser.switchTo().frame("page2");
            oBrowser.findElement(By.xpath("//input[@id='frm1_un_id']")).sendKeys("sgadmin");
            oBrowser.findElement(By.xpath("//input[@id='frm1_pwd_id']")).sendKeys("sgadmin");
            Thread.sleep(2000);


            //6. go back to parent frame page1 (parent frame) using WebElement
            //7. uncheck all the checkboxes
            oBrowser.switchTo().parentFrame();
            chkBoxes = oBrowser.findElements(By.xpath("//input[@type='checkbox']"));
            for(int i=0; i<chkBoxes.size(); i++){
                chkBoxes.get(i).click();
            }
            Thread.sleep(2000);


            //8. go back to main page.
            oBrowser.switchTo().defaultContent();

            //9. close the main page
            oBrowser.close();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            oBrowser = null;
        }
    }
}
