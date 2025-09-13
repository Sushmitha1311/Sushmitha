package webElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HandleIndependentFrame {
    public static void main(String[] args) {
        handleFrameTestcase1();
    }
    public static void handleFrameTestcase1(){
        WebDriver oBrowser = null;
        try{
            //1. open the sample independent frame application
            oBrowser = new ChromeDriver();
            oBrowser.manage().window().maximize();
            oBrowser.navigate().to("file:///C:/Users/windows%2010/Desktop/Javaclass/Testing/Testingclass/Selenium/src/automationAndHtml/mainpage.html");
            Thread.sleep(2000);

            //2. REad the main page header.
            System.out.println(oBrowser.findElement(By.tagName("h1")).getText());


            //3. using index switch to Page1 frame and select all the checkboxes
            oBrowser.switchTo().frame(0);

            List<WebElement> chkBoxes = oBrowser.findElements(By.xpath("//input[@type='checkbox']"));
            for(int i=0; i<chkBoxes.size(); i++){
                chkBoxes.get(i).click();
            }
            Thread.sleep(2000);


            //4. go back to main page.
            oBrowser.switchTo().defaultContent();


            //5. using name/id attribute switch to Page2 frame.
            //6. Enter username and password.
            oBrowser.switchTo().frame("page2");
            oBrowser.findElement(By.xpath("//input[@id='frm1_un_id']")).sendKeys("sgadmin");
            oBrowser.findElement(By.xpath("//input[@id='frm1_pwd_id']")).sendKeys("sgadmin");
            Thread.sleep(2000);

            //7. go back to main page.
            oBrowser.switchTo().defaultContent();


            //8. using WebElement switch to Page1 frame & uncheck all the checkboxes
            WebElement oFrame = oBrowser.findElement(By.xpath("//iframe[@name='page1']"));
            oBrowser.switchTo().frame(oFrame);
            chkBoxes = oBrowser.findElements(By.xpath("//input[@type='checkbox']"));
            for(int i=0; i<chkBoxes.size(); i++){
                chkBoxes.get(i).click();
            }
            Thread.sleep(2000);

            //9. go back to main page.
            oBrowser.switchTo().defaultContent();

            //10. close the main page
            oBrowser.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            oBrowser = null;
        }
    }
}
