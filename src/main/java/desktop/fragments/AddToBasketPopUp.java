package desktop.fragments;

import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;

import abstractClasses.fragments.AbstractFragment;
import com.codeborne.selenide.SelenideElement;

public class AddToBasketPopUp extends AbstractFragment {

    private SelenideElement rootElement = $("div.modal-content");

    public void addToBasketConfirmation(String button){
        rootElement.$(format("a[data-default-localized-pattern='%s']",
                button.replace("/", " / "))).click();
    }

}
