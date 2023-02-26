package framework.utilities;
import org.openqa.selenium.WebDriver;

import java.util.Set;

import static framework.logger.Log.logInfo;


public class WebDriverUtil {
    private static WebDriverUtil instance;
    private WebDriver driver;

    private WebDriverUtil() {
        driver = new BrowserFactory().createBrowser();
    }

    public static WebDriverUtil getInstance(){
        if(instance == null){
                instance = new WebDriverUtil();
            }

        return instance;
    }

    public void destroyWebDriverInstance(){
        instance = null;
        driver.quit();
    }

    public WebDriver getDriver(){
        return driver;
    }

    public void maximizeWindow(){
        logInfo("maximize windows");
        driver.manage().window().maximize();
    }

    public void openUrl(String url){
        logInfo("open url " + url);
        driver.get(url);
    }

    public static void leaveFrame(){
        logInfo("leave frame");
        WebDriverUtil.getInstance().getDriver().switchTo().defaultContent();
    }

    public static String getCurrentUrl(){
        return WebDriverUtil.getInstance().getDriver().getCurrentUrl();
    }

    public static int numOfCurrentlyOpenedTabs(){
        return getWindowHandles().size();
    }

    public static void closeCurrentTab(){
        logInfo("close current tab");
        WebDriverUtil.getInstance().getDriver().close();
    }

    public static String getWindowHandle(){
        return WebDriverUtil.getInstance().getDriver().getWindowHandle();
    }

    public static Set<String> getWindowHandles(){
        return WebDriverUtil.getInstance().getDriver().getWindowHandles();
    }

    public static void switchToWindowAfterWindow(String afterWindow){
        logInfo("switch to next tab");
        for (String windowHandle : getWindowHandles()) {
            if(!afterWindow.contentEquals(windowHandle)) {
                WebDriverUtil.getInstance().getDriver().switchTo().window(windowHandle);
                break;
            }
        }
    }

    public static void switchToWindow(String window){
        logInfo("switch to window " + window);
        WebDriverUtil.getInstance().getDriver().switchTo().window(window);
    }
}
