package framework.webelements;

import framework.logger.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import framework.utilities.WebDriverUtil;
import framework.utilities.WebDriverWaitUtil;

public abstract class BaseElement {
    protected final By locator;
    protected final String name;

    public BaseElement(By locator, String name) {
        this.locator = locator;
        this.name = name;
    }

    private WebElement getElement() {
        return WebDriverUtil.getInstance().getDriver().findElement(locator);
    }

    public void click(){
        Log.logInfo(name + " was clicked");
        WebDriverWaitUtil.waitToBeClickable(locator);
        getElement().click();
    }

    public String getText(){
        Log.logInfo("Text from " + name + " was taken");
        WebDriverWaitUtil.waitPresenceOfElementLocated(locator);
        return getElement().getText();
    }

    public String getAttributeValue(String attribute){
        Log.logInfo("value of"+ attribute+" was taken");
        WebDriverWaitUtil.waitPresenceOfElementLocated(locator);
        return getElement().getAttribute(attribute);
    }
}
