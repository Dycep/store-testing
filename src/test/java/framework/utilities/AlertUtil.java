package framework.utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;

import static logger.Log.logInfo;

public class AlertUtil {

    public static boolean isAlertPresent(){
        try {
            WebDriverUtil.getInstance().getDriver().switchTo().alert();
        } catch (NoAlertPresentException exception){
            return false;
        }

        return true;
    }

    public static Alert switchToAlert(){
        logInfo("Switch to alert");
        WebDriverWaitUtil.waitAlertPresence();
        return WebDriverUtil.getInstance().getDriver().switchTo().alert();
    }

    public static void acceptAlert(Alert alert){
        logInfo("Accept alert");
        alert.accept();
    }
}
