package pages;

import lombok.extern.slf4j.Slf4j;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static steps.MainSteps.getText;

@Slf4j
public class PracticeSiteOnePage extends BasePage {
    public final String TITLE_LOAD_FORM_ = "DUMMY REGISTRATION FORM";
    @FindBy(xpath = "//*[@id='load_form']/h3[text()='Dummy Registration Form']")
    WebElement titleLoadForm;

    public PracticeSiteOnePage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getTitleLoadForm() {
        return getText(driver, titleLoadForm);
    }
}
