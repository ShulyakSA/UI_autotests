package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static steps.MainSteps.*;

public class DroppablePage extends BasePage {
    public final String DROP_SUCCESS_TEXT = "Dropped!";

    @FindBy(xpath = "//iframe[@src='droppable/default.html']")
    WebElement frame;
    @FindBy(id = "draggable")
    WebElement draggable;
    @FindBy(id = "droppable")
    WebElement droppable;

    public DroppablePage(final WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Открытие страницы https://way2automation.com/way2auto_jquery/droppable.php")
    public DroppablePage openDroppablePage() {
        driver.get(config.getWebConfig().getW2aDropPageUrl());
        return this;
    }

    @Step("Перенос элемента в принимающий")
    public void dragElementToDroppable() {
        dragAndDrop(driver, draggable, droppable);
    }

    @Step("Переключение на фрейм 'droppable/default'")
    public DroppablePage switchToDroppableDefaultFrame() {
        switchToFrame(driver, frame);
        return this;
    }

    @Step("Получение текста принимающего элемента")
    public String getTextDroppable() {
        return getText(driver, droppable);
    }
}
