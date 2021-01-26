package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AbstractPage {

    protected CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//button[@class='CTA-module--action__3hGPH CTA-module--medium__dV8ar CTA-module--primary__3hPd- CartSidebar--continueButton__3ds9k']")
    private WebElement checkoutLocator;

    @FindBy (xpath = "//button[@class='CTA-module--action__3hGPH CTA-module--medium__dV8ar CTA-module--iconPosition-start__1pCld CartItem-module--removeButton__1F0Mo IconButton-module--iconButton__1fB0_']")
    private WebElement deleteProductInCart;

    public boolean isEnableCheck(){
        WebElement checkButton = fluentWaitForElementLocatedBy(driver, checkoutLocator);
        return checkButton.isEnabled();
    }

    public CartPage deleteProduct(){
        WebElement deleteProd = fluentWaitForElementToBeClickable(driver, deleteProductInCart);
        deleteProd.click();
        return this;
    }

}
