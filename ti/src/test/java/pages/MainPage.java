package pages;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Arrays;
import java.util.List;

public class MainPage extends BasePage<MainPage> {

    @FindBy(css = "a[href='/invest/")
    protected WebElement investLink;

    @FindBy(css = "a[href='/cards/debit-cards/']")
    protected WebElement debitCardsPageLink;

    @FindBy(css = "a[href=\"/login/\"]")
    protected WebElement loginLink;

    @FindBy(xpath = "//div[@data-schema-path=\"title\"][text()=\"Рекомендуемые продукты\"]")
    protected WebElement recomendedTitle;

    @Override
    protected List<WebElement> getMainFieldsForPage() {
        return Arrays.asList(loginLink, recomendedTitle);
    }

    public DebitCardsPage openDebitCardsPage() {
        wait.until(ExpectedConditions.elementToBeClickable(debitCardsPageLink)).click();
        return new DebitCardsPage();
    }

    @Override
    protected void waitPageIsLoaded() {
        wait.until(ExpectedConditions.titleIs("Тинькофф — Кредитные и дебетовые карты, кредиты для бизнеса и физических лиц"));
    }

    public MainPage open() {
        driver.get("https://tinkoff.ru");
        return this;
    }

    public void doSomethingWhichMakeFail() {
        String result = (String) ((JavascriptExecutor) driver).executeScript(
                "return eval(arguments[0]);",
                "(![]+[])[+[]]+(![]+[])[+!+[]]+([![]]+[][[]])[+!+[]+[+[]]]+(![]+[])[!+[]+!+[]]"
        );
        Assertions.assertThat(result)
                .as("JS is wierd :)")
                .isNotEmpty()
                .isEqualTo("success");
    }
}
