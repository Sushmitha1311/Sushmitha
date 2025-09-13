package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

public class LoginLogout_Edge {
    public static void main(String[] args) {
        loginTestCase();
    }

    public static void loginTestCase() {
        EdgeDriver edge = null;
        try {
            //1. Open Edge browser
            edge = new EdgeDriver();
            edge.manage().window().maximize();


            //2. navigate the actiTime URL (wait for page to load)
            edge.get("http://localhost/login.do");
            Thread.sleep(2000);


            //3. enter user name
            edge.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");


            //4. enter password
            edge.findElement(By.name("pwd")).sendKeys("manager");


            //5. click on Login button (wait for page to load)
            edge.findElement(By.cssSelector("a[id='loginButton'] div")).click();
            Thread.sleep(2000);


            //6. Verify login is successful
            String text = edge.findElement(By.xpath("//td[@class='pagetitle']")).getText();
            if (text.equalsIgnoreCase("Enter Time-Track")) {
                System.out.println("Login to ActiTime is successful");
            } else {
                System.out.println("Failed to login to actiTime");
                return;
            }


            //7. Logout from actiTime (wait for page to load)
            edge.findElement(By.xpath("//a[@id='logoutLink']")).click();
            Thread.sleep(2000);


            //8. Verify logout successful
            if (edge.findElement(By.xpath("//tbody/tr/td[@id='logoContainer']/div/img[1]")).isDisplayed()) {
                System.out.println("Logout from actiTime is succesful");
            } else {
                System.out.println("FAiled to logout from actiTime");
                return;
            }


            //9. close the browser
            edge.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            edge = null;
        }
    }
}



