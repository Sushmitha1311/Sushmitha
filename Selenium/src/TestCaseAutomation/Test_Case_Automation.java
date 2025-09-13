package TestCaseAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test_Case_Automation {
    public static void main(String[] args) {
        testScript();
    }

    public static void testScript() {
        WebDriver oBrowser = null;
        try {
            //1. open the browser
            oBrowser = new EdgeDriver();
            oBrowser.manage().window().maximize();

            //2. navigate the URL
            oBrowser.navigate().to("http://localhost/login.do");
            Thread.sleep(2000);

            //3. Login with valid credentials & click on "Login" button
            oBrowser.findElement(By.id("username")).sendKeys("Punya");
            oBrowser.findElement(By.name("pwd")).sendKeys("punya123");
            oBrowser.findElement(By.id("loginButton")).click();
            Thread.sleep(2000);

            //4. verify login is successful
            String strText = oBrowser.findElement(By.xpath("//td[@class='pagetitle']")).getText();
            if (strText.equalsIgnoreCase("Enter Time-Track")) {
                System.out.println("Login to actiTime was successful");
                if(oBrowser.findElements(By.xpath("//div[@style='display: block;']")).size()>0){
                    oBrowser.findElement(By.id("gettingStartedShortcutsMenuCloseId")).click();
                }
            } else {
                System.out.println("Failed to login to ActiTime");
                return;
            }
            //5. click USERS menu & click on 'Add user' button
            oBrowser.findElement(By.xpath("//div[text()='USERS']")).click();
            Thread.sleep(2000);
            oBrowser.findElement(By.xpath("//div[text()='Add User']")).click();
            Thread.sleep(2000);


            //6. Enter all the required details and click on "Create User" button
            oBrowser.findElement(By.xpath("//input[@name='firstName']")).sendKeys("test");
            oBrowser.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Demo");
            oBrowser.findElement(By.xpath("//input[@name='email']")).sendKeys("test.demo@sg.com");
            oBrowser.findElement(By.xpath("//input[@name='username']")).sendKeys("testdemo");
            oBrowser.findElement(By.xpath("//input[@name='password']")).sendKeys("mercury");
            oBrowser.findElement(By.xpath("//input[@name='passwordCopy']")).sendKeys("mercury");
            oBrowser.findElement(By.xpath("//span[text()='Create User']")).click();
            Thread.sleep(2000);



            //7. verify user created successful
            if(oBrowser.findElement(By.xpath("//div[@class='name']/span[text()='Demo, test']")).isDisplayed()){
                System.out.println("The new user is created successful");
            }else{
                System.out.println("Failed to create the new user");
                return;
            }


            //8. open the required user and click on 'Delete user" button
            //9. accept the alert and delete the user
            oBrowser.findElement(By.xpath("//div[@class='name']/span[text()='Demo, test']")).click();
            Thread.sleep(2000);
            oBrowser.findElement(By.id("userDataLightBox_deleteBtn")).click();
            Thread.sleep(2000);
            oBrowser.switchTo().alert().accept();
            Thread.sleep(2000);


            //10. Verify user deleted succesful
            if(oBrowser.findElements(By.xpath("//div[@class='name']/span[text()='Demo, test']")).size()> 0){
                System.out.println("Failed to delete the user");
            }else{
                System.out.println("The user deleted successful");
            }


            //11. Click on "logout" link and verify logout is successful
            oBrowser.findElement(By.xpath("//a[@id='logoutLink']")).click();
            Thread.sleep(2000);
            if(oBrowser.getTitle().equalsIgnoreCase("actiTIME - Login")){
                System.out.println("Logout from actiTime was successful");
            }else{
                System.out.println("Failed to lgout from actiTime");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            oBrowser.close();
            oBrowser = null;

        }
    }
}
