package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import tests.BaseTest;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class TestListener extends TestListenerAdapter {


    @Override
    public void onTestFailure(ITestResult tr) {
        super.onTestFailure(tr);
        File screenShot = ((TakesScreenshot) BaseTest.getDriver()).getScreenshotAs(OutputType.FILE);
        File output = new File(tr.getName() + ".png");
        try {
            if (output.exists()) {
                output.delete();
            }
            Files.move(screenShot.toPath(), output.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Reporter.log("SCREENSHOT: file://" + output.getAbsolutePath(), true);

    }
}
