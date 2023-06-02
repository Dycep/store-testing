package framework.utilities;

import org.openqa.selenium.JavascriptExecutor;

public class JSUtil {


    public static void executeScript(String script){
        JavascriptExecutor executor = (JavascriptExecutor) WebDriverUtil.getInstance().getDriver();
        executor.executeScript(script);
    }

    public static void scrollToTheBottom(){
        executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public static void scrollToTheTop(){
        executeScript("window.scrollBy(0,-document.body.scrollHeight)");
    }
}
