package framework.webelements;

import framework.logger.Log;
import framework.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import framework.utilities.WebDriverUtil;

public class Input extends BaseElement{


    public Input(By locator, String name) {
        super(locator, name);
    }

    public void sendText(String text){
        Log.logInfo("'"+ text +"' value"+ " was sent to " + name);
        WebDriverUtil.getInstance().getDriver().findElement(locator).sendKeys(text);
    }
}
