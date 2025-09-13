package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginLogout_Chrome {
    public static void main(String[] args) {
        loginTestCase();
    }

    public static void loginTestCase() {
        ChromeDriver chrome = null;
        try {
            //1. Open Chrome browser
            chrome = new ChromeDriver();
            chrome.manage().window().maximize();


            //2. navigate the actiTime URL (wait for page to load)
            chrome.get("http://localhost/login.do");
            Thread.sleep(2000);


            //3. enter username
            chrome.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");


            //4. enter password
            chrome.findElement(By.name("pwd")).sendKeys("manager");


            //5. click on Login button (wait for page to load)
            chrome.findElement(By.cssSelector("a[id='loginButton'] div")).click();
            Thread.sleep(2000);


            //6. Verify login is successful
            String text = chrome.findElement(By.xpath("//td[@class='page title']")).getText();
            if(text.equalsIgnoreCase("Enter Time-Track")) {
                System.out.println("Login to ActiTime is successful");
            }else {
                System.out.println("Failed to login to actiTime");
                return;
            }


            //7. Logout from actiTime (wait for page to load)
            chrome.findElement(By.xpath("//a[@id='logoutLink']")).click();
            Thread.sleep(2000);


            //8. Verify logout successful
            if(chrome.findElement(By.xpath("//tbody/tr/td[@id='logoContainer']/div/img[1]")).isDisplayed()) {
                System.out.println("Logout from actiTime is successful");
            }else {
                System.out.println("Failed to logout from actiTime");
                return;
            }


            //9. close the browser
            chrome.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            chrome = null;
        }
    }
}

