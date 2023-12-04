package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static steps.MainSteps.*;

public class AlertPage extends BasePage {

    @FindBy(xpath = "//a[@href='#example-1-tab-2']")
    WebElement inputAlertLink;

    @FindBy(xpath = "//iframe[@src='alert/input-alert.html']")
    WebElement frame;
    @FindBy(xpath = "//button[@onclick='myFunction()']")
    WebElement demoButton;

    @FindBy(id = "demo")
    WebElement demoText;

    public AlertPage(final WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Открытие страницы https://way2automation.com/way2auto_jquery/alert.php")
    public AlertPage openAlertPage() {
        driver.get(config.getWebConfig().getW2aAlertUrl());
        return this;
    }

    @Step("Переключение на фрейм 'alert/input-alert'")
    public AlertPage switchToAlertFrame() {
        switchToFrame(driver, frame);
        return this;
    }

    @Step("Нажатие на ссылку 'Input Alert'")
    public AlertPage clickInputAlertLink() {
        clickButton(driver, inputAlertLink);
        return this;
    }

    @Step("Нажатие на кнопку 'Click the button to demonstrate the Input box.'")
    public AlertPage clickDemoButton() {
        clickButton(driver, demoButton);
        return this;
    }
    @Step("Получение текста сообщения")
    public String getDemoText() {
        return getText(driver,demoText);
    }

    @Step("Ввод текста и подтверждение Алерта")
    public AlertPage inputAndAcceptAlert(String text) {
        Alert alert = switchToAlert(driver);
        inputTextAlert(alert, text);
        acceptAlert(alert);
        return this;
    }
}
