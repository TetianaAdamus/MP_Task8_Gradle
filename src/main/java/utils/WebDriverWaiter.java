package utils;

import static com.codeborne.selenide.Selenide.Wait;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.webdriver;
import static constants.Constants.INTERVAL;
import static constants.Constants.TIME_TO_WAIT;
import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.impl.Waiter;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverWaiter {

    private static final String COMPLETE = "complete";
    private static final long TIMEOUT = 1000;


    public static void waitForPageLoadComplete() {
        new WebDriverWait(webdriver().object(), ofSeconds(TIME_TO_WAIT)).until(webDriver -> (COMPLETE.equals(
                executeJavaScript(
                        "return document.readyState"))));
    }

    public static void waitForPageLoadCompleteViaWaiter() {
        new Waiter().wait(TIME_TO_WAIT, INTERVAL, () -> COMPLETE.equals(
                executeJavaScript(
                        "return document.readyState")));
    }

    public static void waitForPageLoadCompleteViaWaiterAndObjectCondition() {
        new Waiter().wait(WebDriverRunner.driver(), WebDriverRunner.getAndCheckWebDriver(),
                new MyCondition());
        }

    public static void waitUntilElementDisplayed(SelenideElement element) {
        Wait().until(visibilityOf(element));
    }

    public static void waitUntilElementDisappear(SelenideElement element) {
        Wait().until(invisibilityOf(element));
    }


}
