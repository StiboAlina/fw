package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends AbstractPage {

    protected ProductPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@id='favourite_']")
    private WebElement addToFavoriteLocator;

    @FindBy (xpath = "//a[@class='menu__favorites']")
    private WebElement favoritePageLocator;

    @FindBy (xpath = "//div[@id='picker-1']")
    private WebElement selectSizeListLocator;

    @FindBy (xpath = "//div[@id='picker-1']//li[2]//span")
    private WebElement selectSizeLocator;

    @FindBy (xpath = "//button[@class='item button fluid button-big button-buy js-open-size-selector']")
    private WebElement addToCartLocator;

    @FindBy(xpath = "//a[@class='menu__bag goto-shopping-bag rollover-toggle']")
    private WebElement goToCartLocator;

    public ProductPage addToFavorite(){
        WebElement addFavorite = fluentWaitForElementToBeClickable(driver, addToFavoriteLocator);
        addFavorite.click();
        return this;
    }

    public FavoritePage openFavoritePage(){
        WebElement openFavorite = fluentWaitForElementToBeClickable(driver, favoritePageLocator);
        openFavorite.click();
        return new FavoritePage(driver);
    }

    public ProductPage openSizeList(){
        WebElement openList = fluentWaitForElementToBeClickable(driver, selectSizeListLocator);
        openList.click();
        return this;
    }

    public ProductPage selectSize(){
        WebElement size = fluentWaitForElementToBeClickable(driver, selectSizeLocator);
        size.click();
        return this;
    }

    public ProductPage addToCart(){
        WebElement add = fluentWaitForElementToBeClickable(driver, addToCartLocator);
        add.click();
        return this;
    }

    public CartPage goToCart(){
        WebElement go = fluentWaitForElementToBeClickable(driver, goToCartLocator);
        go.click();
        return new CartPage(driver);
    }
}
