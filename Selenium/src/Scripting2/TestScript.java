package Scripting2;

import org.openqa.selenium.WebDriver;

public class TestScript extends ReusableMethod{
    public static void main(String[] args) {
        TS_LoginLogout();
        //TS_CreateAndDeleteUser();
    }
    public static void TS_LoginLogout(){
        WebDriver oBrowser = null;
        try{
            oBrowser=launchBrowser("Edge");
            boolean binRes=navigateURL(oBrowser,"http://localhost/login.do");
            binRes=loginToApplication(oBrowser,"admin","manager");
            binRes=logoutFromActiTime(oBrowser);
        } catch (Exception e) {
            System.out.println("Exception in 'TS_LoginLogout()' test script");
        }
        finally {
            oBrowser.close();
            oBrowser=null;
        }
    }
    public static void TS_CreateAndDeleteUser() {
        WebDriver oBrowser = null;
        try {
            oBrowser = launchBrowser("Edge");
            boolean binRes = navigateURL(oBrowser, "http://localhost/login.do");
            binRes = loginToApplication(oBrowser, "admin", "manager");

            // Create user (no extra parameters needed)
            String createdUser = createUser(oBrowser);

            // Delete the created user
            if (createdUser != null) {
                binRes = deleteUser(oBrowser, createdUser);
            }

            binRes = logoutFromActiTime(oBrowser);
        } catch (Exception e) {
            System.out.println("Exception in 'TS_CreateAndDeleteUser()' test script: " + e);
        } finally {
            if (oBrowser != null) {
                oBrowser.close();
                oBrowser = null;
            }
        }
    }
}




