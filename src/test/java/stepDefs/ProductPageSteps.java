package stepDefs;

import static com.codeborne.selenide.Selenide.open;
import static constants.Constants.BOOK_PRODUCT_URL;
import static org.assertj.core.api.Assertions.assertThat;

import desktop.pages.ProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ProductPageSteps {

    ProductPage productPage = new ProductPage();

    @Given("I open Thinking in Java product")
    public void openProduct() {
        open(BOOK_PRODUCT_URL);
    }

    @Then("I am on the {string} product page")
    public void verifyProductPage(String productName) {
        assertThat(productPage.productName()).isEqualTo(productName);
    }

}
