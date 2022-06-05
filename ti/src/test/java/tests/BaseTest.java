package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import utils.TestListener;

import java.io.IOException;
import java.util.Optional;

@Listeners({TestListener.class})
public abstract class BaseTest {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void setUp() {
        boolean isSilent = Optional.ofNullable(System.getProperty("silent")).isPresent();
        ChromeOptions c = new ChromeOptions();
        c.setHeadless(isSilent);
        driver = new ChromeDriver(c);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws InterruptedException, IOException {
        if (driver != null) {
            driver.quit();
        }
    }
}
