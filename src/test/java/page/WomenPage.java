package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WomenPage extends AbstractPage {

    protected WomenPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//ul[@id='menu-links']/li[1]//a[@href='/ru_ru/zhenshchiny/novye-postupleniya/view-all.html']")
    private WebElement selectProductsPageLocator;

    public AllProductsPage selectProductsPage(){
        WebElement products = fluentWaitForElementToBeClickable(driver, selectProductsPageLocator);
        products.click();
        return new AllProductsPage(driver);
    }


}
