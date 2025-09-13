package TestCaseAutomation;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleStaticAlert {
    public static void main(String[] args) {
        //handleStaticAlert();
        //handleStaticConfirmAlert();
        handleStaticPromptAlert();
    }
    public static void handleStaticAlert(){
        WebDriver oBrowser = null;
        try{
            oBrowser = new ChromeDriver();
            oBrowser.manage().window().maximize();

            oBrowser.navigate().to("file:///C:/Users/windows%2010/Desktop/Javaclass/Testing/Testingclass/Selenium/src/automation%20and%20Html/Alert.html");
            Thread.sleep(2000);

            //Click the 'alertBtn'
            oBrowser.findElement(By.xpath("//input[@id='btn_id1']")).click();
            Thread.sleep(1000);
            Alert oAlert = oBrowser.switchTo().alert();
            System.out.println(oAlert.getText());
            oAlert.accept();

            Thread.sleep(2000);
            oBrowser.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            oBrowser = null;
        }
    }


    //Static confirm alert handling
    public static void handleStaticConfirmAlert(){
        WebDriver oBrowser = null;
        try{
            oBrowser = new ChromeDriver();
            oBrowser.manage().window().maximize();

            oBrowser.navigate().to("file:///C:/Users/windows%2010/Desktop/Javaclass/Testing/Testingclass/Selenium/src/automation%20and%20Html/Alert.html");
            Thread.sleep(2000);

            //Click the 'confirmBtn'
            oBrowser.findElement(By.xpath("//input[@id='btn_id2']")).click();
            Thread.sleep(1000);
            Alert oAlert = oBrowser.switchTo().alert();
            System.out.println(oAlert.getText());
            oAlert.accept();
            Thread.sleep(2000);

            if(oBrowser.findElement(By.xpath("//body")).getText().equals("User clicked OK button")){
                System.out.println("User clicked 'OK' button");
            }else{
                System.out.println("Failed to click 'OK' button");
            }


            oBrowser.navigate().refresh();
            Thread.sleep(2000);

            oBrowser.findElement(By.xpath("//input[@id='btn_id2']")).click();
            Thread.sleep(1000);
            oAlert = oBrowser.switchTo().alert();
            oAlert.dismiss();
            Thread.sleep(2000);

            if(oBrowser.findElement(By.xpath("//body")).getText().equals("User clicked cancel button")){
                System.out.println("User clicked 'Cancel' button");
            }else{
                System.out.println("Failed to click 'Cancel' button");
            }

            Thread.sleep(2000);
            oBrowser.quit();
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            oBrowser = null;
        }
    }


    //Static prompt alert handling
    public static void handleStaticPromptAlert(){
        WebDriver oBrowser = null;
        String userName[] = {"Arjun", "Bhima", "Chanakya", "Dhrona"};
        try{
            oBrowser = new ChromeDriver();
            oBrowser.manage().window().maximize();

            oBrowser.navigate().to("file:///C:/Users/windows%2010/Desktop/Javaclass/Testing/Testingclass/Selenium/src/automation%20and%20Html/Alert.html");
            Thread.sleep(2000);

            //Click the 'confirmBtn'
            for(int i=0; i< userName.length; i++){
                oBrowser.findElement(By.xpath("//input[@id='btn_id3']")).click();
                Thread.sleep(1000);
                Alert oAlert = oBrowser.switchTo().alert();
                System.out.println(oAlert.getText());
                oAlert.sendKeys(userName[i]);
                Thread.sleep(2000);
                oAlert.accept();
                Thread.sleep(2000);
                if(oBrowser.findElement(By.xpath("//body")).getText().trim().equals("User Name is: "+userName[i].trim())){
                    System.out.println("User name entered and clicked 'OK' button");
                }else{
                    System.out.println("Failed to enter the user name & click 'OK' button");
                }

                oBrowser.navigate().refresh();
                Thread.sleep(2000);
            }

            oBrowser.quit();
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            oBrowser = null;
        }
    }
}