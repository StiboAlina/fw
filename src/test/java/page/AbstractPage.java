package page;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Listeners;
import util.TestListener;
import java.time.Duration;

@Listeners({TestListener.class})

public abstract class AbstractPage {

    protected WebDriver driver;

    protected AbstractPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected static WebElement fluentWaitForElementLocatedBy(WebDriver driver, WebElement by) {
        return new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(70))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class).until((ExpectedConditions.visibilityOf(by)));
    }
    protected static WebElement fluentWaitForElementToBeClickable(WebDriver driver, WebElement by) {
        return new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(70))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class).until((ExpectedConditions.elementToBeClickable(by)));
    }
}
