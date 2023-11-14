package pages;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.Waits.waitElementIsVisible;
import static steps.MainSteps.*;

@Slf4j
public class PracticeSiteOnePage extends BasePage {
    public final String TITLE_LOAD_FORM = "DUMMY REGISTRATION FORM";
    @FindBy(xpath = "//*[@id='load_form']/h3[text()='Dummy Registration Form']")
    WebElement titleLoadForm;
    @FindBy(xpath = "//*[@id='load_form']//input[@name='name']")
    WebElement nameInput;
    @FindBy(xpath = "//div[@class='fancybox-skin']//a[text()='ENTER TO THE TESTING WEBSITE']")
    WebElement testLink;

    public PracticeSiteOnePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Получение текста заголовка страницы")
    public String getTitleLoadForm() {
        return getText(driver, titleLoadForm);
    }

    @Step("Ввод значения '{text}' в текстовое поле 'Name'")
    public PracticeSiteOnePage inputName(String text) {
        waitElementIsVisible(driver, nameInput);
        clearAndType(nameInput, text);
        return this;
    }

    @Step("Снятие фокуса с поля 'Name'")
    public void unFocusNameInput() {
        unFocus(driver, nameInput, "поле Name");
    }

    @Step("Нажатие на ссылку 'ENTER TO THE TESTING WEBSITE'")
    public PracticeSiteOnePage clickTestLink() {
        clickButton(driver, testLink);
        return this;
    }
}
