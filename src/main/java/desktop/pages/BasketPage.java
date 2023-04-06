package desktop.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;
import static utils.WebDriverWaiter.waitForPageLoadComplete;

import abstractClasses.page.AbstractPage;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class BasketPage extends AbstractPage {

    private SelenideElement rootElement = $("[class=' js'] div.page-slide").shouldBe(visible);

    public String getDeliveryCostAmount(){
        return rootElement.$(".delivery-text dd").getText();
    }

    public String getTotalAmount(){
        return rootElement.findElement(By.cssSelector(".total dd")).getText();
    }

    public void checkoutButtonClick(){
        SelenideElement checkoutButton = rootElement.$("div.basket-checkout-btn-wrap "
                + "a[class*='checkout']");
        actions().moveToElement(checkoutButton).click(checkoutButton).build().perform();
        waitForPageLoadComplete();
    }

}


