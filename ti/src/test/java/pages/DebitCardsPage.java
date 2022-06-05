package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DebitCardsPage extends BasePage<DebitCardsPage> {

    @FindBy(css = "a[href='/cards/credit-cards/premium/']")
    WebElement allCardsLink;

    @FindBy(css = "h1[data-schema-path=\"title\"]")
    WebElement header;

    @FindBy(xpath = "//h2[@data-schema-path=\"title\"][text()=\"Дебетовые карты\"]")
    WebElement debitCardTitle;

    @FindBy(css = "a[href=\"/cards/debit-cards/games\"]")
    WebElement gamerLink;

    @Override
    protected List<WebElement> getMainFieldsForPage() {
        return Arrays.asList(debitCardTitle, gamerLink);
    }

    public DebitCardsPage assertThatDebitCardsPageIsCorrect() {
        String linkText = wait.until(ExpectedConditions.visibilityOf(allCardsLink)).getText();
        assertThat(linkText)
                .isEqualTo("Кредитные карты");
        return this;
    }

    @Override
    protected void waitPageIsLoaded() {
        super.waitPageIsLoaded();
        wait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOf(header),
                ExpectedConditions.textToBePresentInElement(header, "Кредитные карты")
        ));
    }
}
