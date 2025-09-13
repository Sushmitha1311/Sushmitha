package UploadResume;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class uploadResume_SendKeys {
    public static void main(String[] args) {
        uploadResumeInNaukri();
    }
    public static void uploadResumeInNaukri(){
        WebDriver oBrowser = null;
        try{
            //1. Open browser and navigate to "https://www.naukri.com/"
            oBrowser = new ChromeDriver();
            oBrowser.manage().window().maximize();
            oBrowser.navigate().to("https://www.naukri.com/");
            Thread.sleep(2000);

            //2. click on "Register" link.
            oBrowser.findElement(By.xpath("//a[@id='register_Layer']")).click();
            Thread.sleep(2000);

            //3. Enter the required details viz., Full Name, Email ID, Password, Mobile number (Optional)
            oBrowser.findElement(By.xpath("//input[@id='name']")).sendKeys("sgTesting");
            oBrowser.findElement(By.xpath("//input[@id='email']")).sendKeys("sgTesting2003@sg.com");
            oBrowser.findElement(By.xpath("//input[@id='password']")).sendKeys("Admin@123");
            oBrowser.findElement(By.xpath("//input[@id='mobile']")).sendKeys("9988556622");

            //4. Select the work status as "I'm Experienced"
            oBrowser.findElement(By.xpath("//p[contains(text(), 'work experience')]")).click();

            //6. Handle the Upload window component using sendKeys
            oBrowser.findElement(By.xpath("//input[@id='resumeUpload']")).sendKeys("C:\\Users\\windows 10\\Desktop\\Resume\\Sushmitha_Resume(1).docx");

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            oBrowser = null;
        }
    }
}
