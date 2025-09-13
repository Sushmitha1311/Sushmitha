package Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class following {
    public static void main(String[] args) {
        followingS();
    }

    public static void followingS() {
        ChromeDriver chrome = null;
        try {
            chrome = new ChromeDriver();
            chrome.manage().window().maximize();

            //chrome.get("file:///E:/MorningBatch_Combined/HTML/Webpage/SampleWebPage.html");
            chrome.navigate().to("file:///C:/Users/windows%2010/Desktop/Javaclass/Testing/Testingclass/Selenium/src/automation/samplewebpage.html");
            //using xpath enter userName and password
            //chrome.findElement(By.xpath("//td[text()='Abdul Kalam']/following::tr[1]/td[1]")).getText(); //webtable
            //chrome.findElement(By.xpath("//td[text()='Indian Scientist']/preceding-sibling::td[1]")).getText();
            //String id=chrome.findElement(By.xpath("//td[text()='Smruthi Irani']/ancestor::table")).getDomAttribute("id");
            String id=chrome.findElement(By.xpath("//body/descendant::td[text()='Abdul Kalam']")).getText();
            System.out.println(id);
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            chrome = null;
        }
    }
}


