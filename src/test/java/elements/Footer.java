package elements;

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
public class Footer {
    WebDriver driver;
    private final String IMPORTANT_LINKS = "Important Links ";
    private final String COURSES = "Courses";
    private final String ABOUT_US = "ABOUT US ";

    @FindBy(xpath = "//div[@data-elementor-id='25361']")
    WebElement footerRoot;

    public Footer(final WebDriver webDriver) {
        try {
            PageFactory.initElements(webDriver, this);
            this.driver = webDriver;
        } catch (IllegalStateException e) {
            throw new RuntimeException(e);
        }
    }

    private WebElement findFooterElementByText(String text) throws NoSuchElementException {
        try {
            waitElementIsVisible(driver, footerRoot);
            return footerRoot.findElement(By.xpath(String.format(".//*[text()='%s']", text)));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            log.error("'" + text + "' ELEMENT IS NOT FOUND");
            return null;
        }
    }

    public WebElement getImportantLinks() {
        return findFooterElementByText(IMPORTANT_LINKS);
    }

    public WebElement getCourses() {
        return findFooterElementByText(COURSES);
    }

    public WebElement getAboutUs() {
        return findFooterElementByText(ABOUT_US);
    }

    public Footer scrollToFooter() {
        scrollToElement(driver, footerRoot);
        return this;
    }
}
