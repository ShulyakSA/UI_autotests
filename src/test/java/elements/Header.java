package elements;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static helpers.Waits.waitElementIsVisible;
import static steps.MainSteps.scrollToElement;

@Slf4j
public class Header {
    WebDriver driver;
    private final String FIRST_WHATSAPP_NUMBER = "+919711-111-558";
    private final String SECOND_WHATSAPP_NUMBER = "+919711-191-558";
    private final String PRONE_NUMBER = "+1 646-480-0603";
    private final String SKYPE_CONTACT = "seleniumcoaching";
    private final String EMAIL = "trainer@way2automation.com";

    @FindBy(id = "ast-desktop-header")
    WebElement headerRoot;

    public Header(final WebDriver webDriver) {
        try {
            PageFactory.initElements(webDriver, this);
            this.driver = webDriver;
        } catch (IllegalStateException e) {
            throw new RuntimeException(e);
        }
    }

    @Step("Поиск элемента '{text}'")
    private WebElement findHeaderElementByText(String text) throws NoSuchElementException {
        try {
            waitElementIsVisible(driver, headerRoot);
            return headerRoot.findElement(By.xpath(String.format(".//*[text()='%s']", text)));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            log.error("'" + text + "' ELEMENT IS NOT FOUND");
            return null;
        }
    }

    public WebElement getFirstWhatsAppNumber() {
        return findHeaderElementByText(FIRST_WHATSAPP_NUMBER);
    }

    public WebElement getSecondWhatsAppNumber() {
        return findHeaderElementByText(SECOND_WHATSAPP_NUMBER);
    }

    public WebElement getPhoneNumber() {
        return findHeaderElementByText(PRONE_NUMBER);
    }

    public WebElement getSkypeContact() {
        return findHeaderElementByText(SKYPE_CONTACT);
    }

    public WebElement getEmail() {
        return findHeaderElementByText(EMAIL);
    }

    @Step("Переход к хедеру")
    public Header scrollToHeader() {
        scrollToElement(driver, headerRoot);
        return this;
    }
}
