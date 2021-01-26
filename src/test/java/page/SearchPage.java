package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends AbstractPage {

    @FindBy(xpath = "//h1[@class='heading']")
    private WebElement noResultLocator;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public String noCorrectRequestResult(){
        WebElement result = fluentWaitForElementLocatedBy(driver,noResultLocator);
        return result.getText();
    }

    public boolean notFoundProduct(){
        WebElement result = fluentWaitForElementLocatedBy(driver,noResultLocator);
        return result.isDisplayed();
    }


}
