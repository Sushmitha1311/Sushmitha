package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginLogout_Firefox {
    public static void main(String[] args) {
        loginTestCase();
    }
    public static void loginTestCase() {
        FirefoxDriver ff= null;
        try {
            //1. Open FireFox browser
            ff = new FirefoxDriver();
            ff.manage().window().maximize();


            //2. navigate the actiTime URL (wait for page to load)
            ff.get("http://localhost/login.do");
            Thread.sleep(2000);


            //3. enter username
            ff.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");


            //4. enter password
            ff.findElement(By.name("pwd")).sendKeys("manager");


            //5. click on Login button (wait for page to load)
            ff.findElement(By.cssSelector("a[id='loginButton'] div")).click();
            Thread.sleep(2000);


            //6. Verify login is successful
            String text =ff.findElement(By.xpath("//td[@class='pagetitle']")).getText();
            if (text.equalsIgnoreCase("Enter Time-Track")) {
                System.out.println("Login to ActiTime is successful");
            } else {
                System.out.println("Failed to login to actiTime");
                return;
            }


            //7. Logout from actiTime (wait for page to load)
            ff.findElement(By.xpath("//a[@id='logoutLink']")).click();
            Thread.sleep(2000);


            //8. Verify logout successful
            if (ff.findElement(By.xpath("//tbody/tr/td[@id='logoContainer']/div/img[1]")).isDisplayed()) {
                System.out.println("Logout from actiTime is succesful");
            } else {
                System.out.println("FAiled to logout from actiTime");
                return;
            }


            //9. close the browser
            ff.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ff = null;
        }
    }
}

