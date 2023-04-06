package desktop.pages;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static java.lang.String.format;
import static org.apache.commons.lang3.math.NumberUtils.INTEGER_ZERO;
import static utils.WebDriverWaiter.waitForPageLoadComplete;
import static utils.WebDriverWaiter.waitForPageLoadCompleteViaWaiterAndObjectCondition;

import abstractClasses.page.AbstractPage;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import desktop.fragments.AddToBasketPopUp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class SearchPage extends AbstractPage {

   private SelenideElement rootElement = $("[class='js'] div.page-slide");

    public List<String> searchResultBooksListText() {
        List<String> searchResultTextList = getSearchResultBooksTitlesList().texts();
        return searchResultTextList;
    }

    public boolean isProductsOnSearchPage(List<String> products) {
        return new HashSet<>(searchResultBooksListText()).containsAll(products);
    }

    public void selectFilter(Map<String, String> filter) {
        for (Map.Entry<String, String> entry : filter.entrySet()) {
            (facetMap().get(entry.getKey())).selectOptionContainingText(entry.getValue());
        }
        refineResultsButtonElement().click();
        waitForPageLoadComplete();
    }

    public void getAddProductToBasketButton(String buttonName, String productName) {
        getSearchResultBooksList()
                .filter(matchText(productName))
                .get(INTEGER_ZERO)
                .$(format("a[class*='%s']", buttonName.toLowerCase().replace(" ", "-")))
                .click();
        waitForPageLoadCompleteViaWaiterAndObjectCondition();
    }

    public AddToBasketPopUp getAddToBasketPopUp() {
        return new AddToBasketPopUp();
    }

    private Map<String, SelenideElement> facetMap() {
        Map<String, SelenideElement> facetMap = new HashMap<>();
        facetMap.put("Price range", rootElement.$("div.form-group select[name='price']"));
        facetMap.put("Availability", rootElement.$("div.form-group select[name='availability']"));
        facetMap.put("Language", rootElement.$("div.form-group select[name='searchLang']"));
        facetMap.put("Format", rootElement.$("div.form-group select[name='format']"));
        return facetMap;
    }

    private SelenideElement refineResultsButtonElement(){
        return $(".filter-menu button");
    }

    private ElementsCollection getSearchResultBooksTitlesList() {
        return $$(".book-item h3.title");
    }

    private ElementsCollection getSearchResultBooksList() {
        return $$(".book-item");
    }

}
