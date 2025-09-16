package Scripting3_prop;

import org.openqa.selenium.WebDriver;

import java.util.Map;
public class TestScript extends ReusableMethod {
    public static void main(String[] args) {
        TS_LoginLogout();
        TS_createAndDeleteUser();
    }
    public static void TS_LoginLogout() {
        WebDriver oBrowser = null;
        Map<String, String> data = null;
        try {
            data = getPropData("TestData");
            oBrowser = launchBrowser(data.get("browserName"));
            boolean blnRes = navigateURL(oBrowser, data.get("url"));
            blnRes = loginToApplication(oBrowser, data.get("userName"), data.get("password"));
            blnRes = logoutFromActiTime(oBrowser);
        } catch (Exception e) {
            System.out.println("Exception in 'TS_LoginLogout' test script");

        } finally {
            oBrowser.close();
            oBrowser = null;
        }
    }

    public static void TS_createAndDeleteUser() {
        WebDriver oBrowser = null;
        Map<String, String> data = null;
        try {
            data = getPropData("TestData");
            oBrowser = launchBrowser(data.get("browserName"));
            boolean blnRes = navigateURL(oBrowser, data.get("url"));
            blnRes = loginToApplication(oBrowser, data.get("userName"), data.get("password"));
            String create = createUser(oBrowser, data);
            boolean delete = deleteUser(oBrowser, create);
            blnRes = logoutFromActiTime(oBrowser);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            oBrowser.close();
            oBrowser = null;
        }
    }
}





