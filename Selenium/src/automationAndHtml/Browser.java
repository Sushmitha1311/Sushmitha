package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {
    public static void main(String[] args) {
        loginTestCase("firefox");
    }

    public static void loginTestCase(String browseName) {
        WebDriver oBrowser = null;
        try {
            //1. Open selected browser
            switch (browseName.toLowerCase()) {
                case "chrome":
                    oBrowser = new ChromeDriver();
                    break;
                case "edge":
                    oBrowser = new EdgeDriver();
                    break;
                case "firefox":
                    oBrowser = new FirefoxDriver();
                    break;
                default:
                    System.out.println("Invalid browser name!");
                    return;
            }

            oBrowser.manage().window().maximize();

            //2. navigate the actiTime URL (wait for page to load)
            oBrowser.get("http://localhost/login.do");
            Thread.sleep(2000);

            //3. enter username
            oBrowser.findElement(By.id("username")).sendKeys("admin");

            //4. enter password
            oBrowser.findElement(By.name("pwd")).sendKeys("manager");

            //5. click on Login button (wait for page to load)
            oBrowser.findElement(By.cssSelector("a[id='loginButton'] div")).click();
            Thread.sleep(2000);

            // Close welcome popup if displayed
            if (oBrowser.findElement(By.id("gettingStartedShortcutsMenuCloseId")).isDisplayed()) {
                oBrowser.findElement(By.id("gettingStartedShortcutsMenuCloseId")).click();
            }

            //6. Verify login is successful
            String text = oBrowser.findElement(By.xpath("//td[@class='pagetitle']")).getText();
            if (text.equalsIgnoreCase("Enter Time-Track")) {
                System.out.println("Login to ActiTime is successful");
            } else {
                System.out.println("Failed to login to ActiTime");
                return;
            }

            //7. Logout from actiTime (wait for page to load)
            oBrowser.findElement(By.id("logoutLink")).click();
            Thread.sleep(2000);

            //8. Verify logout successful
            if (oBrowser.findElement(By.xpath("//tbody/tr/td[@id='logoContainer']/div/img[1]")).isDisplayed()) {
                System.out.println("Logout from ActiTime is successful");
            } else {
                System.out.println("Failed to logout from ActiTime");
                return;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (oBrowser != null) {
                oBrowser.quit(); // better than close()
            }
        }
    }
}
