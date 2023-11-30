package pages;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.Waits.waitElementIsVisible;
import static steps.MainSteps.scrollToElement;
import static steps.MainSteps.switchToWindow;

@Slf4j
public class PracticeSiteTwoPage extends BasePage {
    @FindBy(xpath = "*//h2[text()='Registration']")
    WebElement registrationFormLink;

    public PracticeSiteTwoPage(final WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Нажатие на ссылку формы регистрации в блоке 'AngularJS Elements'")
    public PracticeSiteTwoPage clickRegistrationFormLink() {
        waitElementIsVisible(driver, registrationFormLink);
        registrationFormLink.click();
        return this;
    }

    @Step("Переход к блоку 'Registration'")
    public PracticeSiteTwoPage scrollToRegistrationFormLink() {
        scrollToElement(driver, registrationFormLink);
        return this;
    }

    @Step("Переключение на следующее окно")
    public PracticeSiteTwoPage switchToNextWindow(){
        String currentHandle=driver.getWindowHandle();
        switchToWindow(driver, currentHandle);
        return this;
    }
}
