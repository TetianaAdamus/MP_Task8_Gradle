package desktop.fragments;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;
import static constants.Constants.TIME_TO_WAIT;

import abstractClasses.fragments.AbstractFragment;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegistrationForm extends AbstractFragment {

    private SelenideElement rootElement = $("div[class$='delivery-address']");

    public Map<String, String> registrationFormErrorMessages() {
        Map<String, String> map = new HashMap<>();
        map.put("Email address", getEmailErrorMessage().getText().trim());
        map.put("Full name", getNameErrorMessage().getText().trim());
        map.put("Address line 1", getAdressErrorMessage().getText().trim());
        map.put("Town/City", getCityErrorMessage().getText().trim());
        map.put("Postcode/ZIP", getPostcodeErrorMessage().getText().trim());
        return map;
    }

    public List<SelenideElement> errorMessagesElements() {
        List<SelenideElement> list = new ArrayList<>();
        list.add(getEmailErrorMessage());
        list.add(getNameErrorMessage());
        list.add(getAdressErrorMessage());
        list.add(getCityErrorMessage());
        list.add(getPostcodeErrorMessage());
        return list;
    }

    public void clickOutside() {
        actions().pause(TIME_TO_WAIT).moveByOffset(10, 10).click().build().perform();
    }

    public void inputEmail(String email) {
        actions().moveToElement(emailAddressInputElement()).click(emailAddressInputElement()).sendKeys(email).build()
                .perform();
    }

    public void selectCountry(String country) {
        Select select = new Select(deliveryCountryElement());
        select.selectByVisibleText(country);
    }

    public SelenideElement fullNameElement() {
        return rootElement.$("input[id='delivery-fullName']");
    }

    public SelenideElement deliveryCountryElement() {
        return rootElement.$("[name='deliveryCountry']");
    }

    public SelenideElement addressLineOneElement() {
        return rootElement.$("input[id='delivery-addressLine1']");
    }

    public SelenideElement addressLineTwoElement() {
        return rootElement.$("input[id='delivery-addressLine2']");
    }

    public SelenideElement cityElement() {
        return rootElement.$("input[id='delivery-city']");
    }

    public SelenideElement countryElement() {
        return rootElement.$("input[id='delivery-county']");
    }

    public SelenideElement postcodeElement() {
        return rootElement.$("input[id='delivery-postCode']");
    }

    private SelenideElement getEmailErrorMessage() {
        return rootElement.$("div[id='email-errors']");
    }

    private SelenideElement getNameErrorMessage() {
        return rootElement.$("div[id='delivery-fullName-errors']");
    }

    private SelenideElement getAdressErrorMessage() {
        return rootElement.$("div[id='delivery-addressLine1-errors']");
    }

    private SelenideElement getCityErrorMessage() {
        return rootElement.$("div[id='delivery-city-errors']");
    }

    private SelenideElement getPostcodeErrorMessage() {
        return rootElement.$("div[id='delivery-postCode-errors']");
    }

    private SelenideElement emailAddressInputElement() {
        return rootElement.$("[name=emailAddress]");
    }

    private SelenideElement phoneCodeElement() {
        return rootElement.$("[id='phonePrefix'] .hidden-select");
    }

    private SelenideElement phoneNumberElement() {
        return rootElement.$("[name='delivery-telephone']");
    }

}
