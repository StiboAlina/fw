package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllProductsPage extends AbstractPage {

    protected AllProductsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//div[@class='image-container']/a[@href='/ru_ru/productpage.0949792001.html']")
    private WebElement productPageLocator;


    public ProductPage selectProduct(){
        WebElement selectProd = fluentWaitForElementToBeClickable(driver, productPageLocator);
        selectProd.click();
        return new ProductPage(driver);
    }

}
