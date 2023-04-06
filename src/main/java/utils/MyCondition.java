package utils;

import static constants.Constants.BOOK_DEPOSITORY;

import com.codeborne.selenide.ObjectCondition;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.openqa.selenium.WebDriver;

public class MyCondition implements ObjectCondition<WebDriver> {


    @Nonnull
    @Override
    public String description() {
        return "should have a description";
    }

    @Nonnull
    @Override
    public String negativeDescription() {
        return "should doesn't have a description";
    }

    @Override
    public boolean test(WebDriver webDriver) {
        return !webDriver.getCurrentUrl().isEmpty();
    }

    @Nullable
    @Override
    public String actualValue(WebDriver webDriver) {
        return webDriver.getTitle();
    }


    @Nullable
    @Override
    public String expectedValue() {
        return BOOK_DEPOSITORY;
    }

    @Override
    public String describe(WebDriver object) {
        return "WebDriver";
    }
}
