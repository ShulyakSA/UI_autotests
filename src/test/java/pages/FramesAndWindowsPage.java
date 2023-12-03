package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static steps.MainSteps.*;

public class FramesAndWindowsPage extends BasePage{

    @FindBy(xpath = "//iframe[@src='frames-windows/defult1.html']")
    WebElement frame;
    @FindBy(linkText = "New Browser Tab")
    WebElement newBrowserTabLink;

    public FramesAndWindowsPage(final WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Открытие страницы https://way2automation.com/way2auto_jquery/frames-and-windows.php")
    public FramesAndWindowsPage openFramesAndWindowsPage() {
        driver.get(config.getWebConfig().getW2aFramesAndWindowsUrl());
        return this;
    }


    @Step("Переключение на фрейм 'frames-windows/default1'")
    public FramesAndWindowsPage switchToWindowsFrame() {
        switchToFrame(driver, frame);
        return this;
    }

    @Step("Нажатие на ссылку 'New Browser Tab'")
    public FramesAndWindowsPage clickNewBrowserTabLink() {
        clickButton(driver, newBrowserTabLink);
        return this;
    }

    @Step("Переключение на следующее окно")
    public FramesAndWindowsPage switchToNextWindow(String currentHandle){
        switchToWindow(driver, currentHandle);
        return this;
    }
}
