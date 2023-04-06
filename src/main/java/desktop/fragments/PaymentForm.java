package desktop.fragments;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

import abstractClasses.fragments.AbstractFragment;
import com.codeborne.selenide.SelenideElement;

public class PaymentForm extends AbstractFragment {

    private SelenideElement rootElement = $("div[class$='card-form variant']");

    public String getPaymentErrorMessage(){
        return rootElement.$("div[class='buynow-error-msg']").getText().trim();
    }

    public void inputCardNumber(String number){
        switchTo().frame("braintree-hosted-field-number");
        cardNumberField().setValue(number);
        switchTo().defaultContent();
    }

    public void inputCardDate(String month, String year){
       switchTo().frame("braintree-hosted-field-expirationDate");
        cardDateField().setValue(month).setValue(year);
        switchTo().defaultContent();
    }

    public void inputCvv(String cvv){
        switchTo().frame("braintree-hosted-field-cvv");
        cvvField().setValue(cvv);
        switchTo().defaultContent();
    }

    private SelenideElement cardNumberField(){
        return $("input[id='credit-card-number']");
    }

    private SelenideElement cardDateField(){
        return $("input[id='expiration']");
    }

    private SelenideElement cvvField(){
        return $("input[id='cvv']");
    }

}
