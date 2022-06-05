package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.BaseTest;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public abstract class BasePage<T extends BasePage<T>> {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(tagName = "body")
    protected WebElement bodyElement;

    public BasePage() {
        driver = BaseTest.getDriver();
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected void waitPageIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(bodyElement));
    }

    public T assertMainElementsAreVisible() {
        new ArrayList<Integer>();
        wait.until(ExpectedConditions.visibilityOfAllElements(getMainFieldsForPage()));
        return (T) this;
    }

    protected abstract List<WebElement> getMainFieldsForPage();
}
