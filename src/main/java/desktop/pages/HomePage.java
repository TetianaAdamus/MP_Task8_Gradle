package desktop.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static utils.WebDriverWaiter.waitForPageLoadComplete;

import abstractClasses.page.AbstractPage;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.stream.Collectors;

public class HomePage extends AbstractPage {

    private SelenideElement rootElement = $(".page-type-home");
    private ElementsCollection categories = $$(".secondary-header-wrap li[class='mob-nav-shop'] a");


    public void search(String keyword) {
        rootElement.$(".text-input").setValue(keyword).pressEnter();
        waitForPageLoadComplete();
    }

    public void openCategory(String name){
        categories.stream().filter(category ->category.getText().equals(name)).collect(Collectors.toList()).get(0).click();
    }

}
