package pages;

import helpers.Waits;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import static steps.MainSteps.*;

public class HttpAuthenticationPage extends BasePage {

    @FindBy(id = "displayImage")
    WebElement displayImageButton;
    @FindBy(id = "downloadImg")
    WebElement downloadImg;

    public HttpAuthenticationPage(final WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Открытие страницы https://www.httpwatch.com/httpgallery/authentication/#showExample10")
    public HttpAuthenticationPage openHttpAuthPage() {
        driver.get("https://" + config.getTestConfig().getUsernameHttpWatch() + ":" + config.getTestConfig().getPassHttpWatch() + "@" + config.getWebConfig().getHttpWatchUrl());
        return this;
    }

    @Step("Нажатие на кнопку 'Display Image'")
    public HttpAuthenticationPage clickDisplayImageButton() {
        clickButton(driver, displayImageButton);
        return this;
    }

    public WebElement getDownloadImg() {
        Waits.waitElementIsClickable(driver, downloadImg);
        return downloadImg;
    }
}
