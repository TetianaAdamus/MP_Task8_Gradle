package desktop.pages;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

import abstractClasses.page.AbstractPage;
import com.codeborne.selenide.SelenideElement;
import desktop.fragments.PaymentForm;
import desktop.fragments.RegistrationForm;

public class CheckoutPage extends AbstractPage {

    private SelenideElement rootElement = $("div[id='root']");

    public void buyNowButtonClick(){
        rootElement.$("div[id='root'] button[id='buyNowButton']").should(exist).click();
    }

    public RegistrationForm getRegistrationForm(){
        return new RegistrationForm();
    }

    public PaymentForm getPaymentForm(){
        return new PaymentForm();
    }

    public String getSubTotalValue(){
        return rootElement.$("div[aria-label^='Sub-total'] .text-right").getText().trim();
    }

    public String getDeliveryValue(){
        return rootElement.$("div[aria-label^='Delivery'] .text-right").getText().trim();
    }

    public String getVatValue(){
        return rootElement.$("div[aria-label^='VAT'] .text-right").getText().trim();
    }

    public String getTotalValue(){
        return rootElement.$("div[aria-label^='Total'] .text-right").getText().trim();
    }


}
