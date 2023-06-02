package framework.utilities;

import framework.config.Config;
import io.github.bonigarcia.wdm.WebDriverManager;
import framework.logger.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;


public class BrowserFactory {


    public WebDriver createBrowser(){
        String browserName = Config.getInstance().getBrowserName();
        switch (browserName.toLowerCase()){
            case ("chrome"):
                return createChromeDriver();
            case ("firefox"):
                return createFirefoxDriver();
            case ("edge"):
                return createEdgeDriver();
        }
        Log.logError("None of declared drivers were created");
        throw new RuntimeException("None of declared drivers were created");
    }

    private WebDriver createChromeDriver() {
        Log.logInfo("Chrome Driver was created");
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions().addArguments(Config.getInstance().getBrowserArguments());
        return new ChromeDriver(chromeOptions);
    }

    private WebDriver createFirefoxDriver() {
        Log.logInfo("Firefox Driver was created");
        WebDriverManager.firefoxdriver().setup();
        FirefoxProfile profile = new FirefoxProfile();
        FirefoxOptions firefoxOptions = new FirefoxOptions().addArguments(Config.getInstance().getBrowserArguments());
        firefoxOptions.setProfile(profile);
        return new FirefoxDriver(firefoxOptions);
    }

    private WebDriver createEdgeDriver() {
        Log.logInfo("Edge Driver was created");
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver(new EdgeOptions().addArguments(Config.getInstance().getBrowserArguments()));
    }
}
