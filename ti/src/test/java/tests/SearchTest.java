package tests;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.MainPage;


public class SearchTest extends BaseTest {

    @DataProvider
    public Object[][] dataProviderSearchStrings() {
        return new Object[][]{{"Sample data"}};
    }


    @Test(dataProvider = "dataProviderSearchStrings")
    public void simpleSuccessTest(String sampleData) throws InterruptedException {
        Reporter.log("Do something interesting with parameter " + sampleData, true);
        new MainPage()
                .open()
                .assertMainElementsAreVisible()
                .openDebitCardsPage()
                .assertMainElementsAreVisible();
    }

    @Test
    public void simpleFailedTest() throws InterruptedException {
        new MainPage()
                .open()
                .doSomethingWhichMakeFail();
    }

}
