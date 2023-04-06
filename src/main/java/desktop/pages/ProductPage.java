package desktop.pages;

import static com.codeborne.selenide.Selenide.$;

import abstractClasses.page.AbstractPage;
import com.codeborne.selenide.SelenideElement;

public class ProductPage extends AbstractPage {

    public String productName(){
        return productTitle().getText().trim();
    }

    private SelenideElement productTitle(){
        return $("h1[itemprop='name']");
    }


}
