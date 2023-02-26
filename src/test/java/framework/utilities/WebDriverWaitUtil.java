package framework.utilities;

import config.Config;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;

public class WebDriverWaitUtil {


    public static void waitToBeClickable(By by){
        new WebDriverWait(WebDriverUtil.getInstance().getDriver(), Duration.ofMillis(Config.getInstance().getMillisToWait()))
                .until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void waitVisibilityOfElementsLocated(By by){
        new WebDriverWait(WebDriverUtil.getInstance().getDriver(), Duration.ofMillis(Config.getInstance().getMillisToWait()))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public static void waitVisibilityOfElementLocated(By by){
        new WebDriverWait(WebDriverUtil.getInstance().getDriver(), Duration.ofMillis(Config.getInstance().getMillisToWait()))
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitPresenceOfElementLocated(By by){
        new WebDriverWait(WebDriverUtil.getInstance().getDriver(), Duration.ofMillis(Config.getInstance().getMillisToWait()))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static void waitPresenceOfElementsLocated(By by){
        new WebDriverWait(WebDriverUtil.getInstance().getDriver(), Duration.ofMillis(Config.getInstance().getMillisToWait()))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public static Alert waitAlertPresence(){
        return new WebDriverWait(WebDriverUtil.getInstance().getDriver(), Duration.ofMillis(Config.getInstance().getMillisToWait()))
                .until(ExpectedConditions.alertIsPresent());
    }

    public static void waitAttributeContains(By by, String attribute, String value){
        new WebDriverWait(WebDriverUtil.getInstance().getDriver(), Duration.ofMillis(Config.getInstance().getMillisToWait()))
                .until(ExpectedConditions.attributeContains(by, attribute, value));
    }

    public static void waitStalenessOf(By by){
        new WebDriverWait(WebDriverUtil.getInstance().getDriver(), Duration.ofMillis(Config.getInstance().getMillisToWait()))
                .until(ExpectedConditions.stalenessOf(WebDriverUtil.getInstance().getDriver().findElement(by)));
    }

    public static void waitInvisibilityOf(By by){
        new WebDriverWait(WebDriverUtil.getInstance().getDriver(), Duration.ofMillis(Config.getInstance().getMillisToWait()))
                .until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public static void waitAttributeToBe(By locator, String attribute, String value){
        new WebDriverWait(WebDriverUtil.getInstance().getDriver(), Duration.ofMillis(Config.getInstance().getMillisToWait()))
                .pollingEvery(Duration.ofMillis(Config.getInstance().getMillisToPoll()))
                .until(ExpectedConditions.attributeToBe(locator, attribute, value));
    }

    public static void waitFileExists(String expectedFilePath){
        FluentWait<WebDriver> wait = new WebDriverWait(WebDriverUtil.getInstance().getDriver(), Duration.ofMillis(Config.getInstance().getMillisToWait()))
                .pollingEvery(Duration.ofMillis(Config.getInstance().getMillisToPoll()));

        wait.until((WebDriver wd)->Files.exists(Path.of(expectedFilePath)));
    }
}
