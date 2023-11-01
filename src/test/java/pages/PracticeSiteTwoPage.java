package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.Waits.waitElementIsVisible;

@Slf4j
public class PracticeSiteTwoPage extends BasePage {
    @FindBy(linkText = "Registration")
    WebElement registrationFormLink;

    public PracticeSiteTwoPage(WebDriver webDriver) {
        super(webDriver);
    }

    public PracticeSiteTwoPage clickRegistrationFormLink() {
        waitElementIsVisible(driver, registrationFormLink);
        registrationFormLink.click();
        return this;
    }
}
