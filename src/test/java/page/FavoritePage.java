package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FavoritePage extends AbstractPage {

    protected FavoritePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//p[@class='BodyText-module--general__2yKZb FavouritesItemList--favouritesItemsLength__1BSyM FavouritesItemList--mobilePadding__2MrIb']/span")
    private WebElement favoriteProductLocator;

    @FindBy(xpath = "//button[@class='CTA-module--action__3hGPH CTA-module--medium__dV8ar CTA-module--iconPosition-start__1pCld RemoveButton-module--removeButton__3duRC IconButton-module--iconButton__1fB0_']")
    private WebElement deleteFavoriteProductLocator;

    @FindBy(xpath = "//div[@class='Container-module--container__1un4y FavouritesEmpty--buttonContainer__1Q5nJ']/button")
    private WebElement findFavoriteProductLocator;

    public boolean isDisplayedProduct(){
        WebElement product = fluentWaitForElementLocatedBy(driver,favoriteProductLocator);
        return product.isDisplayed();

    }

    public FavoritePage deleteProduct(){
        WebElement delete = fluentWaitForElementToBeClickable(driver, deleteFavoriteProductLocator);
        delete.click();
        return this;
    }

    public boolean isDisplayedButton(){
        WebElement button = fluentWaitForElementLocatedBy(driver,findFavoriteProductLocator);
        return button.isDisplayed();
    }
}
