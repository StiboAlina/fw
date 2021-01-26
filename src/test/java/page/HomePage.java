package page;

import model.User;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy (xpath = "//button[@class='close icon-close-white js-close']")
    private WebElement closeCookieLocator;

    @FindBy (xpath = "//form[@class='menu__search']/input")
    private WebElement searchInputLocator;

    @FindBy (xpath = "//button[@class='menu__search_submit']")
    private WebElement searchButtonLocator;

    @FindBy(xpath = "//ul[@class='menu__primary']/li[2]/a")
    private WebElement womenLocator;

    @FindBy(xpath = "/html/body/header/nav/ul[1]/li[1]/div/a[1]")
    private WebElement signInLocator;

    @FindBy(xpath = "//input[@id='modal-txt-signin-email']")
    private WebElement inputEmailLocator;

    @FindBy(xpath = "//input[@id='modal-txt-signin-password']")
    private WebElement inputPasswordLocator;

    @FindBy(xpath = "//*[@id='modal-theLoginForm']/button")
    private WebElement signInButtonLocator;

    @FindBy(xpath = "//*[@id='modal-txt-signin-email-email-format-error']")
    private WebElement messageErrorSignInLocator;

   @FindBy(xpath = "//a[@class='menu__myhm' and @data-signin-state='signedin']")
    private WebElement profileLocator;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage openPage() {
        driver.get("https://www2.hm.com/ru_ru/index.html");
        return this;
    }
    public HomePage closeCookie(){
        WebElement close = fluentWaitForElementToBeClickable(driver, closeCookieLocator);
        close.click();
        return this;
    }

    public SearchPage findSearchInput(String inputRequest){
        searchInputLocator.click();
        searchInputLocator.sendKeys(inputRequest);
        searchInputLocator.sendKeys(Keys.ENTER);
        return new SearchPage(driver);
    }


    public WomenPage findWomenUnit(){
        WebElement unit = fluentWaitForElementToBeClickable(driver, womenLocator);
        unit.click();
        return new WomenPage(driver);
    }

   public HomePage logIntoAccount(User testData){
        fluentWaitForElementToBeClickable(driver,signInLocator).click();
        fluentWaitForElementToBeClickable(driver,inputEmailLocator).sendKeys(testData.getLogin());
        fluentWaitForElementToBeClickable(driver, inputPasswordLocator).sendKeys(testData.getPassword());
        fluentWaitForElementToBeClickable(driver, signInButtonLocator).click();
        return this;
   }

    public boolean invalidDataSignIn(){
        WebElement message = fluentWaitForElementLocatedBy(driver, messageErrorSignInLocator);
        return message.isDisplayed();
    }

    public boolean profileIsEnable(){
        WebElement profile = fluentWaitForElementLocatedBy(driver, profileLocator);
        return  profile.isDisplayed();
    }




}
