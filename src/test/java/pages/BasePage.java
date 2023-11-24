package pages;

import config.TestConfigFactory;
import elements.Footer;
import elements.Header;
import elements.NavBar;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;

@Slf4j
public abstract class BasePage {
    protected TestConfigFactory config = TestConfigFactory.getInstance();
    protected static WebDriverWait wait;
    protected final WebDriver driver;

    NavBar navBar;
    Header header;
    Footer footer;

    public BasePage(final WebDriver webDriver) {
        try {
            PageFactory.initElements(webDriver, this);
            this.driver = webDriver;
        } catch (IllegalStateException e) {
            throw new RuntimeException(e);
        }
        wait = new WebDriverWait(driver, ofSeconds(config.getWebConfig().getExplicitWait()));
        header = new Header(driver);
        navBar = new NavBar(driver);
        footer = new Footer(driver);
    }
}
