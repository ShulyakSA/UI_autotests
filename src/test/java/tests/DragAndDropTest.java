package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.qameta.allure.SeverityLevel.CRITICAL;

@Epic(value = "Форма Droppable")
@Feature(value = "Drag n Drop")
public class DragAndDropTest extends BaseTest {
    @BeforeClass
    public void openPage() {
        droppablePage.openDroppablePage();
    }

    @Story(value = "Проверка Drag n Drop элементов во фрейме")
    @Severity(CRITICAL)
    @Test(description = "Проверка изменения текста принимающего элемента")
    public void checkDragAndDrop() {
        droppablePage.switchToDroppableDefaultFrame()
                .dragElementToDroppable();
        Assert.assertEquals(droppablePage.getTextDroppable(), droppablePage.DROP_SUCCESS_TEXT);
    }
}
