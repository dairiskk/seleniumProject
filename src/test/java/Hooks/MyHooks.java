package Hooks;

import Constants.ConfigConstants;
import Helpers.ConfigReader;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;
import cucumber.api.java.BeforeStep;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MyHooks {
    private final String PAGE = ConfigReader.getInstance().getValue(ConfigConstants.PAGE_URL);
    private final String BROWSER = ConfigReader.getInstance().getValue(ConfigConstants.SELENIUM_BROWSER);
    private WebDriver driver;

    @Before()
    public void beforeAll() throws Exception {
        if (BROWSER.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/test/java/Driver/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            driver = new ChromeDriver(options);
            driver.get(PAGE);
        } else {
            throw new Exception("BROWSER: " + BROWSER + " NOT FOUND");
        }
    }

    @After
    public void afterAll() {
        driver.quit();
    }
}
