package framework.webelements;

import framework.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import framework.utilities.WebDriverUtil;

import static framework.logger.Log.logInfo;

public class IFrame extends BaseElement{


    public IFrame(By locator, String name) {
        super(locator, name);
    }

    public void switchTo(){
        logInfo("Switch to "+name);
        WebDriverUtil.getInstance().getDriver().switchTo().frame(WebDriverUtil.getInstance().getDriver().findElement(locator));
    }
}
